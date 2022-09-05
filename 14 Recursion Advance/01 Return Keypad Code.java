/*************************************************************************************************

Given an integer n, using phone keypad find out all the possible strings that can be made
using digits of input n.
Return empty string for numbers 0 and 1.
Note : 1. The order of strings are not important.
2. Input and output has already been managed for you. You just have to populate the output
array and return the count of elements populated in the output array.
Input Format :
Integer n
Output Format :
All possible strings in different lines
Constraints :
1 <= n <= 10^6
Sample Input:
23
Sample Output:
ad
ae
af
bd
be
bf
cd
ce
cf
**************************************************************************************************/



public class solution {

	// Return a string array that contains all the possible strings
	public static String getOptions(int digit){
        if(digit == 2)
            return "abc";
        if(digit == 3)
            return "def";
        if(digit == 4)
            return "ghi";
        if(digit == 5)
            return "jkl";
        if(digit == 6)
            return "mno";
        if(digit == 7)
            return "pqrs";
        if(digit == 8)
            return "tuv";
        if(digit == 9)
            return "wxyz";
        
        
        return "";
    }
	public static String[] keypad(int n){
		// Write your code here
        
         if(n == 0){

             String output[] = new String[1];
             output[0] = "";
             return output;
         }

        String smallOutput[] = keypad(n/10);
        String singleDigitOutput = getOptions(n%10);

        String output[] = new String[smallOutput.length*singleDigitOutput.length()];

        int k=0;
        for(int i=0;i<smallOutput.length;i++){
            for(int j=0;j<singleDigitOutput.length();j++){
                output[k] = smallOutput[i]+singleDigitOutput.charAt(j);
                k++;
            }
        }
            
        return output;
    }
}



