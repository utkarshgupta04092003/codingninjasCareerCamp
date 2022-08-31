/************************************************************************************************

Check whether a given String S is a palindrome using recursion. Return true or false.
Input Format :
String S
Output Format :
'true' or 'false'
Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.
Sample Input 1 :
racecar
Sample Output 1:
true
Sample Input 2 :
ninja
Sample Output 2:
false


*************************************************************************************************/


public class solution {

	public static boolean isStringPalindrome(String input) {
		// Write your code here
        int n = input.length();
        
        if(n == 1 || n == 0)
            return true;
        if(input.charAt(0) != input.charAt(n-1))
            return false;
        
        boolean smallOutput = isStringPalindrome(input.substring(1,n-1));
        return smallOutput;

	}
}



