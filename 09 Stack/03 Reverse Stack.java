/**********************************************************************************

You have been given two stacks that can store integers as the data. Out of the
two given stacks, one is populated and the other one is empty. You are required 
to write a function that reverses the populated stack using the one which is empty.
For Example:
Alt txt

Input Format :
The first line of input contains an integer N, denoting the total number of 
elements in the stack.

The second line of input contains N integers separated by a single space, 
representing the order in which the elements are pushed into the stack.
Output Format:
The only line of output prints the order in which the stack elements are popped,
all of them separated by a single space. 
Note:
You are not required to print the expected output explicitly, it has already
been taken care of. Just make the changes in the input stack itself.
Constraints:
1 <= N <= 10^3
-2^31 <= data <= 2^31 - 1

Time Limit: 1sec 
Sample Input 1:
6
1 2 3 4 5 10
Note:
Here, 10 is at the top of the stack.
Sample Output 1:
1 2 3 4 5 10
Note:
Here, 1 is at the top of the stack.
Sample Input 2:
5
2 8 15 1 10
Sample Output 2:
2 8 15 1 10

***********************************************************************************/



// using extra stack

import java.util.Stack;
public class Solution {
    
    private static void transfer(Stack<Integer> s1,Stack<Integer>s2,int n){
        
        for(int i=0;i<n;i++){
            s2.push(s1.pop());
        }
        
    }
  
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		
        
        int n = input.size();
        
        for(int i=0;i<n;i++){
            
            int peak = input.pop();
            
            transfer(input,extra,n-i-1);
            input.push(peak);
            transfer(extra,input,n-i-1);
        }
	}
}
// time complexity - O(n^2)
// space complexity - O(n) 


// without using extra stack

import java.util.Stack;
public class Solution {
    
	public static void insert_at_bottom(int x, Stack<Integer> st) {
   		
        if(st.isEmpty()) {
                st.push(x);
        }
        else {
            int a = st.pop();
            insert_at_bottom(x,st);
            st.push(a);
        }
    }
	public static void reverseStack(Stack<Integer> input) {
		
        
        if(!input.isEmpty()) {
            
            int x = input.pop();
            reverseStack(input);
            insert_at_bottom(x, input);
            
        }
	}

}


// time complexity - O(n^2)
// space complexity - O(n) used in recursion
