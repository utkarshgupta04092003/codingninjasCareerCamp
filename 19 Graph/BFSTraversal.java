/****************************************************

Given an undirected and disconnected graph G(V, E), print its BFS traversal.
Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well

Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2

****************************************************/

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {

    

    private static void bfTraversal(int adjMat[][],int currVer,boolean visited[]){
        Queue<Integer> q =  new LinkedList<Integer>();
        
        
        q.add(currVer);
        visited[currVer] = true;
        
        int  n = adjMat.length;
        
        
        while(!q.isEmpty()){
            currVer = q.poll();
            System.out.print(currVer+" ");
            
            for(int i=0;i<n;i++){
                
                if(adjMat[currVer][i] == 1 && visited[i] == false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                bfTraversal(adjMat,i,visited);
                visited[i] = true;
            }
        }
        
        
    }
    public static void bfTraversal(int adjMat[][]){
         
        boolean visited[] = new boolean[adjMat.length];

        bfTraversal(adjMat,0,visited);
    }
   
	public static void main(String[] args) throws NumberFormatException, IOException {
        
        
        
       Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n == 0)
            return;
        int e = s.nextInt();
        
		int adjMat[][] = new int[n][n];

        for(int i=0;i<e;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            
            adjMat[a][b] = 1;
            adjMat[b][a] = 1;
        }
        
        
        // printMat(adjMat);
        

        bfTraversal(adjMat);
	}

}
