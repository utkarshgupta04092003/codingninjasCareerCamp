/****************************************************************************

Write a code to perform different operations on matrix.
1. Addition
 You are given two matrices return the addition of these two matrices.
2. Multiplication
Given two matrices return the matrix multiplication of them.(Both the 
matrices will always be multiplicable).
3. Transpose
Given a Matrix calculate the transpose of the matrix and return it. 
(Number of rows and columns will be same)
4. Rotate by 90
Given a Matrix, rotate the matrix by 90 degree in anticlockwise direction.
Input format :
Line 1: Operation to be performed
Line 2 : No of rows(n1) & No of columns(m1) (separated by space)
Line 3 : Row 1 elements (separated by space)
Line 4 : Row 2 elements (separated by space)
Line 5 : and so on
(If needed)
Line n1+2 : No of rows(n2) & No of columns(m2)(separated by space)
Line n1+3 : Row 1 elements (separated by space)
Line n1+4 : Row 2 elements (separated by space)
Line n1+5 : and so on
Sample Input 1 :
1
2 2
1 2
1 3
2 2
4 3
1 5
Sample output 1 :
5 5
2 8
Sample Input 2 :
2
2 2
1 2
1 3
2 2
4 3
1 5
Sample output 2 :
6 13
7 18
Sample Input 3 :
3
2 2
1 2
1 3
Sample output 3 :
1 1
2 3
Sample Input 4 :
4
2 2
1 2
1 3
Sample output 4 :
2 3
1 1
Note : Partial marking is there, so implementation of each function will 
give you some marks.

****************************************************************************/



public class mat{
	int [][] matrix;
	
	mat(int [][] mat)
	{
		matrix=mat;
	}
		
	// mat(){}
	
	    public static mat add(mat a,mat b)
	    {
            int row = a.matrix.length;
            int col = a.matrix[0].length;
            
            int ans[][] = new int[row][col];
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    ans[i][j] = a.matrix[i][j] + b.matrix[i][j];
                }
            }
            return new mat(ans);
	    }
    
	    public static mat multiply(mat a,mat b)
	    {
            
           
            int R1 = a.matrix.length;
            int R2 = b.matrix.length;
            int C2 = b.matrix[0].length;
            
            int arr[][] = new int[R1][C2];
            mat res = new mat(arr);
            
            
            for (int i = 0; i < R1; i++) {
                for (int j = 0; j < C2; j++) {
                    res.matrix[i][j] = 0;

                    for (int k = 0; k < R2; k++) {
                        res.matrix[i][j] += a.matrix[i][k] * b.matrix[k][j];
                	}

                	// cout << rslt[i][j] << "\t";
                }

                // cout << endl;
            }
	       
            
            return res;
	    }
    
    
	    public static mat transpose(mat m)
	    {
            
            int row = m.matrix.length;
            int col = m.matrix[0].length;
            
            int res[][] = new int[col][row];
            
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    res[j][i] = m.matrix[i][j];
                }
            }
            
            mat result = new mat(res);
            return result;
	    }
    
 
    
        public static mat rotate(mat m)
        {
            int [][] matrix = m.matrix;
            int n = matrix.length;
            if (n == 1) {
                return null;
            }
            for (int k=0;k<3;k++){
                for (int i = 0; i < n / 2; i++) {
                    for (int j = i; j < n - 1 - i; j++) {
                        int temp = matrix[i][j];
                        matrix[i][j] = matrix[n - 1 - j][i];
                        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                        matrix[j][n - 1 - i] = temp;
                    }
                }
            }
            return new mat(matrix);
        }

    
    public void print()
    {
	for(int i=0;i<matrix.length;i++)
	{
	    for(int j=0;j<matrix[0].length;j++)
	    {
		System.out.print(matrix[i][j]+" ");
	    }
	    System.out.println();
	}
    }

}
