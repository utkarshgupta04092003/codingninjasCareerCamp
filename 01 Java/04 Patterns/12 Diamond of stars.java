/******************************************************************************

Print the following pattern for the given number of rows.
Note: N is always odd.


Pattern for N = 5

Image link - https://ninjasfiles.s3.amazonaws.com/0000000000003726.png

The dots represent spaces.



Input format :
N (Total no. of rows and can only be odd)
Output format :
Pattern in N lines
Constraints :
1 <= N <= 49

Sample Input 1:
5
Sample Output 1:
  *
 ***
*****
 ***
  *
  
Sample Input 2:
3
Sample Output 2:
  *
 ***
  *
******************************************************************************/



import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        // Write your code here
        Scanner s = new Scanner(System.in);
	    
	    int n = s.nextInt();
	    
	    n=n/2+1;
	    int space=0,inc=0,dec=0;
        
        // for upper side
	    for(int i=1;i<=(n);i++){
	        for(space=1;space<=(n-i);space++){
	            System.out.print(" ");
	        }
	        
	        for(inc=1;inc<=i;inc++){
	            System.out.print("*");
	        }
	        for(dec=i-1;dec>=1;dec--){
	            System.out.print("*");
	        }
	        
	        System.out.println();
	        
	    }
	    
	    
        // for lower side
	    for(int i=n-1;i>=1;i--){
	        for(space=1;space<=(n-i);space++){
	            System.out.print(" ");
	        }
	        
	        for(inc=1;inc<=i;inc++){
	            System.out.print("*");
	        }
	        for(dec=i-1;dec>=1;dec--){
	            System.out.print("*");
	        }
	        
	        System.out.println();

	    }
	    
    }
}



