/**********************************************************************************************

Print the following pattern for the given number of rows.
Pattern for N = 4

Image link - https://ninjasfiles.s3.amazonaws.com/0000000000003725.png

The dots represent spaces.



Input format :
Integer N (Total no. of rows)
Output format :
Pattern in N lines
Constraints :
0 <= N <= 50

Sample Input 1:
5
Sample Output 1:
           1
         232
       34543
     4567654
   567898765
   
   
Sample Input 2:
4
Sample Output 2:
           1
         232
       34543
     4567654

***********************************************************************************************/



import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	    
	    int n = s.nextInt();
	    
	    for(int i=1;i<=n;i++){
	        
	       
	        for(int space=1;space<=(n-i);space++){
	            System.out.print(" ");
	        }
	        int inc;
	        for(inc=i;inc<(i+i-1);inc++){
	            System.out.print(inc);
	        }
	        for(int dec=inc;dec>=i;dec--){
	            System.out.print(dec);
	        }
	        
	        
	        System.out.println();
	    }
	    
	
	}
}




