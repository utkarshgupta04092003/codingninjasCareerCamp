/*************************************************************

Gary has a board of size NxM. Each cell in the board is a 
coloured dot. There exist only 26 colours denoted by uppercase
Latin characters (i.e. A,B,...,Z). Now Gary is getting bored and
wants to play a game. The key of this game is to find a cycle 
that contain dots of same colour. Formally, we call a sequence
of dots d1, d2, ..., dk a cycle if and only if it meets the 
following condition:
1. These k dots are different: if i ≠ j then di is different 
from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent.
Also, dk and d1 should also be adjacent. Cells x and y
are called adjacent if they share an edge.
Since Gary is colour blind, he wants your help. Your task
is to determine if there exists a cycle on the board.

Sample Input 1:
3 4
AAAA
ABCA
AAAA
Sample Output 1:
true


Sample Input 2:
7 6
AAAAAB
ABBBAB
ABAAAB
ABABBB
ABAAAB
ABBBAB
AAAAAB
Sample Output 2:
true


************************************************************/


/*import java.util.*;

public class Solution {
  int isConnected(char adjMat[][],int startI,int startJ,int i,int j,boolean visited[][],char ch){
        
      
      if(visited[i][j] == true && i == startI && j == startJ && adjMat[i][j] == ch)
          return 1;
      
      
        visited[i][j] = true;
        
        
        
        int res = 0;
        int  n = adjMat.length;
        int m = adjMat[0].length;
        
        
        
        
        if((i-1 >= 0) && (j >= 0) && (adjMat[i-1][j] == ch)  && (visited[i-1][j] == false)){
            res = isConnected(adjMat,startI,startJ,i-1,j,visited,ch);
            return res+1;
        }
        
        
        
        
        if((i >= 0) && (j-1 >= 0) && (adjMat[i][j-1] == ch)  && (visited[i][j-1] == false)){
            res = isConnected(adjMat,startI,startJ,i,j-1,visited,ch);
        	return res+1;
        }
        
        if((i >= 0) && (j+1 < m) && (adjMat[i][j+1] == ch)  && (visited[i][j+1] == false)){
            res = isConnected(adjMat,startI,startJ,i,j+1,visited,ch);
            return res+1;
        }
        
        
        
        
        if((i+1 < n) && (j >= 0) && (adjMat[i+1][j] == ch)  && (visited[i+1][j] == false)){
            res = isConnected(adjMat,startI,startJ,i+1,j,visited,ch);
            return res+1;
        }
        
        
        
        
        
        return res+1;
        
        
        
        
        
        
        
    }
    
    int solve(String[] board , int n, int m)
	{
	
        char adjMat[][] = new char[n][m];
        
        for(int i=0;i<n;i++){
            adjMat[i] = board[i].toCharArray();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean visited[][] = new  boolean[n][m];

                if(visited[i][j] == false){
                    
                    int result = isConnected(adjMat,i,j,i,j,visited,adjMat[i][j]);
                    // System.out.println(result);
                    if(result >=4 )
                        return 1;
                }
            }
        }
        
        return 0;
	}
	
	
}*/
/*
    Time complexity: O(N * M)
    Space complexity: O(N * M)

    where N and M are the rows and columns respectively of the board
*/
import java.util.*;

public class Solution {
	
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	int[][] visited;
	int findCycle = 0;
	
	void dfs(String[] board, int x, int y, int fromX, int fromY, char needColor, int n, int m)
	{
		if(x < 0 || x >= n || y < 0 || y >= m) return;
		if(board[x].charAt(y) != needColor) return;
		if(visited[x][y] == 1)
		{
			findCycle = 1;
			return;
		}
		visited[x][y] = 1;
		for(int f = 0; f < 4; f++)
		{
			int nextX = x + dx[f];	// dx and dy is used  for moving in all directions
			int nextY = y + dy[f];
			if(nextX == fromX && nextY == fromY) continue;
			dfs(board, nextX, nextY, x, y, needColor, n, m);
		}
	}

	int solve(String[] board , int n, int m)
	{
		
		visited = new int[n][m];

		for(int i = 0; i < n ; i++)
			Arrays.fill(visited[i],0);
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(visited[i][j] == 0)
					dfs(board,i, j, -1, -1, board[i].charAt(j), n, m);
		
		return findCycle;
	}
	
	
}


// Runner class with main function
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Runner {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
		String[] strNums;
        strNums = br.readLine().split("\\s");

        int N = Integer.parseInt(strNums[0]);
        int M = Integer.parseInt(strNums[1]);

		String[] Graph = new String[N];
		
        for (int i = 0; i < N; ++i) {
            Graph[i] = br.readLine();
        }

        return Graph;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        String[] Graph = takeInput();
        if (new Solution().solve(Graph,Graph.length,Graph[0].length())==1){
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }


    }
}
