/******************************************************************************************************

Print the following pattern for given number of rows.
Input format :

Line 1 : N (Total number of rows)

Sample Input :
   5
Sample Output :
1234554321
1234**4321
123****321
12******21
1********1
******************************************************************************************************/


import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {

		// Write your code here		
		 Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        
        for(int i=1;i<=n;i++){
            
            
            // first half
            for(int j=1;j<=(n-i+1);j++){
                System.out.print(j);
            }
            for(int star=1;star<=(i-1);star++){
                System.out.print("*");
            }
            
            //second half
            int k=n;
            for(int star=1;star<=(i-1);star++){
                System.out.print("*");
                k--;
            }
            for(;k>=1;k--){
                System.out.print(k);
            }
            
            
            
            
            
            System.out.println();
        }
        
        
	}
}




