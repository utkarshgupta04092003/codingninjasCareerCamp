/**************************************************************************************

You are given a 2D array of integers of size N * M. Each of the cell contains either 
of these 3 integers: 0, 1, 2. The integer 2 denotes a rotten orange, 1 denotes a fresh
orange and 0 denotes an empty cell.
Each rotten orange can rot fresh oranges in 4 adjacent cells in 1 unit of time. The 
4 cells are left, right, top and bottom cell.
For a given matrix, find the minimum units of time in which all oranges become rot. 
Return -1, if it is not possible.
Input Format:
The first line of input contains 2 space separated integers, N and M, that denotes 
size of given 2D array.
The following N lines contains M space separated integers, that denotes the value 
of cells of given 2D array.
Constraints:
Value of N and M lies in the range: [1, 10000].
Value of each cell in 2D array can be either 0, 1 or 2.
Output Format:
Print the required integer, as described in the problem description.   
Sample Input 1:
3 5
2 1 0 2 1
1 0 1 2 1
1 0 0 2 1
Sample Output 1:
2
Explanation:
 In the first unit of time, fresh oranges at coordinates: (0, 1), (0, 4), (1, 0), 
 (1, 2), (1, 4), (2, 4).
 In the second unit of time, fresh orange at coordinate: (2, 0) gets rot. Hence,
 in 2 units of time, all the fresh oranges become rot.
Sample Input 2:
3 5
2 1 0 2 1
1 0 1 0 1
1 0 0 0 2
Sample Output 2:
-1
Explanation:
It is impossible to rot the fresh orange at (1, 2).   
***************************************************************************************/


//Java program to find minimum time required to make all
//oranges rotten

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main
{
	public final static int R = 3;
	public final static int C = 5;
	
	// structure for storing coordinates of the cell
	static class Ele
	{
		int x = 0;
		int y = 0;
		Ele(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	// function to check whether a cell is valid / invalid
	static boolean isValid(int i, int j)
	{
		return (i >= 0 && j >= 0 && i < R && j < C);
	}
	

	// Function to check whether the cell is delimiter
	// which is (-1, -1)
	static boolean isDelim(Ele temp)
	{
		return (temp.x == -1 && temp.y == -1);
	}
	
	// Function to check whether there is still a fresh
	// orange remaining
	static boolean checkAll(int arr[][])
	{
		for (int i=0; i<R; i++)
			for (int j=0; j<C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}
	
	// This function finds if it is possible to rot all oranges or not.
	// If possible, then it returns minimum time required to rot all,
	// otherwise returns -1
	static int rotOranges(int arr[][])
	{
		// Create a queue of cells
		Queue<Ele> Q=new LinkedList<>();
		Ele temp;
		int ans = 0;
		// Store all the cells having rotten orange in first time frame
		for (int i=0; i < R; i++)
		for (int j=0; j < C; j++)
			if (arr[i][j] == 2)
				Q.add(new Ele(i,j));
				
		// Separate these rotten oranges from the oranges which will rotten
		// due the oranges in first time frame using delimiter which is (-1, -1)
		Q.add(new Ele(-1,-1));
		
		// Process the grid while there are rotten oranges in the Queue
		while(!Q.isEmpty())
		{
			// This flag is used to determine whether even a single fresh
			// orange gets rotten due to rotten oranges in the current time
			// frame so we can increase the count of the required time.
			boolean flag = false;
			
			// Process all the rotten oranges in current time frame.
			while(!isDelim(Q.peek()))
			{
				temp = Q.peek();
				
				// Check right adjacent cell that if it can be rotten
				if(isValid(temp.x+1, temp.y) && arr[temp.x+1][temp.y] == 1)
				{
					if(!flag)
					{
						// if this is the first orange to get rotten, increase
						// count and set the flag.
						ans++;
						flag = true;
					}
					// Make the orange rotten
					arr[temp.x+1][temp.y] = 2;
					
					// push the adjacent orange to Queue
					temp.x++;
					Q.add(new Ele(temp.x,temp.y));
					
					// Move back to current cell
					temp.x--;
				}
				
				// Check left adjacent cell that if it can be rotten
				if (isValid(temp.x-1, temp.y) && arr[temp.x-1][temp.y] == 1)
				{
						if (!flag)
						{
							ans++;
							flag = true;
						}
						arr[temp.x-1][temp.y] = 2;
						temp.x--;
						Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
						temp.x++;
				}
				
				// Check top adjacent cell that if it can be rotten
				if (isValid(temp.x, temp.y+1) && arr[temp.x][temp.y+1] == 1) {
						if(!flag)
						{
							ans++;
							flag = true;
						}
						arr[temp.x][temp.y+1] = 2;
						temp.y++;
						Q.add(new Ele(temp.x,temp.y)); // Push this cell to Queue
						temp.y--;
					}
				
				// Check bottom adjacent cell if it can be rotten
				if (isValid(temp.x, temp.y-1) && arr[temp.x][temp.y-1] == 1)
				{
						if (!flag)
						{
							ans++;
							flag = true;
						}
						arr[temp.x][temp.y-1] = 2;
						temp.y--;
						Q.add(new Ele(temp.x,temp.y)); // push this cell to Queue
				}
				Q.remove();
				
			}
			// Pop the delimiter
			Q.remove();
			
			// If oranges were rotten in current frame than separate the
			// rotten oranges using delimiter for the next frame for processing.
			if (!Q.isEmpty())
			{
				Q.add(new Ele(-1,-1));
			}
			
			// If Queue was empty than no rotten oranges left to process so exit
		}
		
		// Return -1 if all arranges could not rot, otherwise ans
		return (checkAll(arr))? -1: ans;
		
	}
	
	// Driver program
	public static void main(String[] args)
	{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        
        
		int arr[][] = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = s.nextInt();
            }
        }
        
		int ans = rotOranges(arr);
		System.out.println(ans);
        
 
	}

}
//This code is contributed by Sumit Ghosh
