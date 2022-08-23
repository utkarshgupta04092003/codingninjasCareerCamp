/**************************************************************************

For a given expression in the form of a string, find if there exist any 
redundant brackets or not. It is given that the expression contains only 
rounded brackets or parenthesis and the input expression will always be
balanced.
A pair of the bracket is said to be redundant when a sub-expression is 
surrounded by unnecessary or needless brackets.
Example:
Expression: (a+b)+c
Since there are no needless brackets, hence, the output must be 'false'.

Expression: ((a+b))
The expression can be reduced to (a+b). Hence the expression has redundant 
brackets and the output will be 'true'.
Note:
You will not get a partial score for this problem. You will get marks only
if all the test cases are passed.
Input Format :
The first and the only line of input contains a string expression, without 
any spaces in between.
Output Format :
The first and the only line of output will print either 'true' or 'false'
(without the quotes) denoting whether the input expression contains 
redundant brackets or not.
Note:
You are not required to print the expected result. It has already been 
taken care of.
Constraints:
0 <= N <= 10^6
Where N is the length of the expression.

Time Limit: 1 second
Sample Input 1:
a+(b)+c 
Sample Output 1:
true
Explanation:
The expression can be reduced to a+b+c. Hence, the brackets are redundant.
Sample Input 2:
(a+b)
Sample Output 2:
false

*************************************************************************/

// ( and ) be bech agar koi  bhi operator nhi aata hai to just reutrn true

import java.util.Stack;
public class Solution {

	public static boolean checkRedundantBrackets(String s) {
		//Your code goes here// create a stack of characters
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {
 
            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();
 
                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;
 
                while (top != '(') {
 
                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }
 
                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }
 
                // If operators not found
                if (flag == true) {
                    return true;
                }
            } 
            
            else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;
	}
}
