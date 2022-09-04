/*****************************************************************************************

Given a binary number as an integer N, convert it into decimal and print.
Input format :
An integer N in the Binary Format
Output format :
Corresponding Decimal number (as integer)
Constraints :
0 <= N <= 10^9
Sample Input 1 :
1100
Sample Output 1 :
12
Sample Input 2 :
111
Sample Output 2 :
7

*****************************************************************************************/


import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
        
        int binary = s.nextInt();
        
        int dup = binary;
        
        int decimal = 0;
        int c = 1;
        while(dup > 0){
            int last = dup%10;
            dup /= 10;
            
            decimal += last*c;
            c*=2;
            
        }
        
        System.out.print(decimal);
	}
}




