/***************************************************************************************************

Print the following pattern for the given N number of rows.
Pattern for N = 3
 A
 BB
 CCC
Input format :
Integer N (Total no. of rows)
Output format :
Pattern in N lines
Constraints
0 <= N <= 26

Sample Input 1:
7
Sample Output 1:
A
BB
CCC
DDDD
EEEEE
FFFFFF
GGGGGGG

Sample Input 2:
6
Sample Output 2:
A
BB
CCC
DDDD
EEEEE
FFFFFF
****************************************************************************************************/

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=i;j++){
                char ch = (char)('A'+i-1);
                System.out.print(ch);
            }
            System.out.println();
        }
		
		
	}

}



