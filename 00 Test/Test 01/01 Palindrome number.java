/*******************************************************************************************************

Write a program to determine if given number is palindrome or not. Print true if it is palindrome, 
false otherwise.
Palindrome are the numbers for which reverse is exactly same as the original one. For eg. 121
Sample Input 1 :
121
Sample Output 1 :
true
Sample Input 2 :
1032
Sample Output 2 :
false


*******************************************************************************************************/




import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        
        int dupNum = n;
        
        int rev = 0;
        
        while(dupNum > 0){
            rev *= 10;
            int temp = dupNum%10;
            dupNum /= 10;
            rev += temp;
        }
        
        if(n == rev){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }
	}
}





