/***********************************************************************************

Given a number N, figure out if it is a member of fibonacci series or not. Return true if the number is member of fibonacci series else false.
Fibonacci Series is defined by the recurrence
    F(n) = F(n-1) + F(n-2)
where F(0) = 0 and F(1) = 1


Input Format :
Integer N
Output Format :
true or false
Constraints :
0 <= n <= 10^4
Sample Input 1 :
5
Sample Output 1 :
true
Sample Input 2 :
14
Sample Output 2 :
false    

*************************************************************************************/




public class Solution {
	
	public static boolean checkMember(int n){
				
	
        int a=1;
        int b=1;
        int z=0;
        
        int test1 = (5*n*n)+4;
        int test2 = (5*n*n)-4;
        
        int sqrt1 = (int)Math.sqrt(test1);
        int sqrt2 = (int)Math.sqrt(test2);
        
        if(n == 0)
            return true;
        if((sqrt1*sqrt1 == test1) || (sqrt2*sqrt2 == test2))
        	return true;
        
        return false;
	}
	

}




