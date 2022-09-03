/*************************************************************************************************

For a given two-dimensional square matrix of size (N x N). Find the total sum of elements on 
both the diagonals and at all the four boundaries.
Input format:
The first line contains an Integer 't' which denotes the number of test cases or queries to
be run. Then the test cases follow.

First line of each test case or query contains a single integer value, 'N' representing the 
'rows' and 'columns' for the two-dimensional square matrix.

Second line onwards, the next 'N' lines or rows represent the ith row values.

Each of the ith row constitutes 'N' column values separated by a single space.
Output format:
For each test case, print the single integer denoting the sum.

Output for every test case will be printed in a seperate line.
Constraints:
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1sec
Sample input 1:
1
3
1 2 3
4 5 6
7 8 9
Sample Output 1:
45
Explanation for Sample Output 1:
The boundary elements are 1, 2, 3, 6, 9, 8, 7 and 4. 

The first-diagonal elements are 1, 5 and 9. 

The second-diagonal elements are 3, 5 and 7.

We just need to add all these numbers making sure that no number is added twice.
For example, '1' is both a boundary element and a first-diagonal element similarly, '5'
contributes to both the diagonals but they won't be added twice.

Hence, we add up, [1 + 2 + 3 + 6 + 9 + 8 + 7 + 4 + 5] to give 45 as the output.
Sample input 2:
2
5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
4
1 2 3 10
4 5 6 11
7 8 9 12
13 14 15 16
Sample Output 2:
273
136

**************************************************************************************************/





public class Solution {

	public static void totalSum(int[][] arr) {
		//Your code goes here
        
        int rows = arr.length;
        if(rows == 0){
        	System.out.println("0");
            return;
        }
        int col = arr[0].length;
        
        int b1=0,b2=0,b3=0,b4=0,d1=0,d2=0;
        
        // except intersection points
        for(int i=0;i<rows;i++){
            for(int j=0;j<col;j++){
                
                if(i == j){
                    d1 += arr[i][j];
                }
                if((i+j) == rows-1){
                    d2 += arr[i][j];
                }
                if(i == 0){
                    b1 += arr[i][j];
                }
                if(i == rows-1){
                    b3 += arr[i][j];
                }
                if(j == 0){
                    b2 += arr[i][j];
                }
                if(j == rows-1){
                    b4 += arr[i][j];
                }
            }
          
            
        }
        
          int multipleBar = 0;
            multipleBar += (2*arr[0][0]);
            multipleBar += (2*arr[rows-1][0]);
            multipleBar += (2*arr[0][rows-1]);
            multipleBar += (2*arr[rows-1][rows-1]);
            
            if(rows%2 != 0){
                multipleBar += arr[rows/2][rows/2];
            }
            int result = d1+d2+b1+b2+b3+b4;
            result -= multipleBar;
        
        	System.out.println(result);
	}

}





