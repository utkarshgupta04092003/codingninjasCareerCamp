/******************************************************************************************

Given an integer n, using phone keypad find out and print all the possible strings 
that can be made using digits of input n.
Note : The order of strings are not important. Just print different strings in new lines.
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
*******************************************************************************************/



public class solution {

    public static String getOption(int num){
		if( num == 2)
            return "abc";
        if(num == 3)
            return "def";
		if( num == 4)
            return "ghi";
        if(num == 5)
            return "jkl";
		if( num == 6)
            return "mno";
        if(num == 7)
            return "pqrs";
		if( num == 8)
            return "tuv";
        if(num == 9)
            return "wxyz";
        
        return "";
    }
    public static void printkeypadHelper(int input,String res){
        if(input == 0){
            System.out.println(res);
            return;
        }
        String lastDigitOption = getOption(input%10);
        
        for(int i=0;i<lastDigitOption.length();i++){
            printkeypadHelper(input/10,lastDigitOption.charAt(i)+res);
        }
        
        
        
    }
	public static void printKeypad(int input){
		// Write your code here
        
        printkeypadHelper(input,"");
		
	}
}




