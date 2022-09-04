/***********************************************************************************************

Print the following pattern
Pattern for N = 4

Imagen link -https://ninjasfiles.s3.amazonaws.com/0000000000003724.png

The dots represent spaces.



Input Format :
N (Total no. of rows)
Output Format :
Pattern in N lines
Constraints :
0 <= N <= 50


Sample Input 1 :
3
Sample Output 1 :
   *
  *** 
 *****
 
 
Sample Input 2 :
4
Sample Output 2 :
    *
   *** 
  *****
 *******

************************************************************************************************/



import java.util.Scanner;
public class Solution
{
	public static void main(String[] args) {
	    Scanner s = new Scanner(System.in);
	    
	    int n = s.nextInt();
	    for(int i=1;i<=n;i++){
	        
	        for(int space=1;space<=(n-i);space++){
	            System.out.print(" ");
	        }
	        
	        for(int inc=1;inc<=i;inc++){
	            System.out.print("*");
	        }
	        
	        for(int dec=i-1;dec>=1;dec--){
	            System.out.print("*");
	        }
	        
	        System.out.println();
	    }
	    
	}
}





