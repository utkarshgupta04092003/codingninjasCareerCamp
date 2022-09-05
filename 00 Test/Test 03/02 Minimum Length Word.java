/**************************************************************************************

Given a string S (that can contain multiple words), you need to find the word which 
has minimum length.
Note : If multiple words are of same length, then answer will be first minimum 
length word in the string.
Words are seperated by single space only.
Input Format :
String S
Output Format :
Minimum length word
Constraints :
1 <= Length of String S <= 10^5
Sample Input 1 :
this is test string
Sample Output 1 :
is
Sample Input 2 :
abc de ghihjk a uvw h j
Sample Output 2 :
a

**************************************************************************************/



public class Solution {
	
	public static String minLengthWord(String str){
		
		// Write your code here
        int n = str.length();
        int len = Integer.MAX_VALUE;
        String result = "";
        String word = "";
        for(int i=0;i<n;i++){
            if(str.charAt(i) == ' '){
                if(word.length() < len){
                    result = word;
                	// System.out.println(result);
                    len = word.length();
                    // System.out.println("-"+word);
                }
                word = "";

            }
            else{
                word += str.charAt(i);
            }
            
            // System.out.println("-"+word);

        }
        
         if(word.length() < len){
                result = word;
                len = word.length();
                // System.out.println(result);

                word = "";
        }
        
		return result;
	}
}



