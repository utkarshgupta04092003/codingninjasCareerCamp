/******************************************************************************************

Write a program to print parallelogram pattern for the given N number of rows.
For N = 4

Image link - https://ninjasfiles.s3.amazonaws.com/0000000000003728.png

The dots represent spaces.
Input Format :
 A single integer : N
Output Format :
Required Pattern
Constraints :
0 <= N <= 50
Sample Input 1 :
3
Sample Output 1 :
***
 ***
  ***
Sample Input 2 :
5
Sample Output 2 :
*****
 *****
  *****
   *****
    *****
******************************************************************************************/



import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
	    
	    int n = s.nextInt();
	    
	    for(int i=1;i<=n;i++){
	        
	        for(int space=1;space<=i-1;space++){
	            System.out.print(" ");
	        }
	        for(int star=1;star<=n;star++){
	            System.out.print("*");
	        }
	        
	        System.out.println();
	    }
	}
}




