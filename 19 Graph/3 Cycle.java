/*****************************************************************

Given a graph with N vertices (numbered from 0 to N-1) and M 
undirected edges, then count the distinct 3-cycles in the graph.
A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are 
connected by an edge.


Sample Input 1:
3 3
0 1
1 2
2 0
Sample Output 1:
1

Sample Input2:
6 9
4 3
4 0
0 3
3 1
5 1
5 3
0 5
0 2
5 2

Sample Output 2;
4


*****************************************************************/

import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int solve(boolean[][] graph, int n) {
		/*
		 * Your class should be named Solution 
		 * You may write your code here
		 */
        
        int count = 0;
        HashMap<Integer,ArrayList<Integer>> list = new HashMap<Integer,ArrayList<Integer>>();
        
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                
                if(graph[i][j] == true){
                    temp.add(j);
                }
            }
            
            list.put(i,temp);
            
        }
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp = list.get(i);
            int t = temp.size();
            for(int j=0;j<t;j++){
                for(int k=0;k<t;k++){
                    int num1 = temp.get(j);
                    int num2 = temp.get(k);
                    
                    if(graph[num1][num2] == true){
                        count++;
                    }
                }
            }
            
            
        }
        
        return count/6;
        
        
        
        
    
	}

	public static boolean[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int m = Integer.parseInt(strNums[1]);

		boolean[][] graphs = new boolean[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < m; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			graphs[firstvertex][secondvertex] = true;
			graphs[secondvertex][firstvertex] = true;
		}
		return graphs;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] graphs = takeInput();

		int ans = solve(graphs, graphs.length);
		System.out.println(ans);

	}
}
