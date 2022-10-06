/************************************************************************************************

Given an integer N, find and return the count of minimum numbers required to represent N as
a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
The output will be 1, as 1 is the minimum count of numbers required to represent N as
sum of squares.
Input format :
The first and the only line of input contains an integer value, 'N'.
 Output format :
Print the minimum count of numbers required.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1

*************************************************************************************************/


// Recursive
public class Solution {

    private static int minCountHelper(int n){
        if(n == 0 || n==1 || n==2 || n==3)
            return n;
        
        int ans = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            ans = Math.min(ans,1+minCountHelper(n-i*i));
        }
        return ans;
    }
	public static int minCount(int n) {
		//Your code goes here
        return minCountHelper(n);
	}

}



// Using DP

public class Solution {

            
    static int dp[];

    private static int minCountHelper(int n){
        if(n == 0 || n==1 || n==2 || n==3)
            return n;
        
        if(dp[n] != Integer.MAX_VALUE)
            return dp[n];
        
        for(int i=1;i*i<=n;i++){
            dp[n] = Math.min(dp[n],1+minCountHelper((n-i*i)));
        }
        return dp[n];
    }
    public static int minCount(int n) {
		//Your code goes here
    
        dp = new int[n+1];
        
        for(int i=0;i<n+1;i++)
            dp[i] = Integer.MAX_VALUE;
        

        return minCountHelper(n);
    }

}
