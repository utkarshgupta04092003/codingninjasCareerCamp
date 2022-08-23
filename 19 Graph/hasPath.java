/***************************************************

Given an undirected graph G(V, E) and two vertices 
v1 and v2 (as integers), check if there exists any
path between them or not. Print true if the path 
exists and false otherwise.
Note:
1. V is the number of vertices present in graph 
G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.


Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true

Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false

**************************************************/


import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {

    static boolean hasPathHelper(int adjMat[][],int s,int d,boolean visited[]){
        
        if(s == d)
            return true;
        
        visited[s] = true;
        
        boolean res = false;
    	for(int i=0;i<adjMat.length;i++){
            if(adjMat[s][i] == 1 && visited[i] == false){
                if(hasPathHelper(adjMat,i,d,visited)){
                    return true;
                }
            }
        }
        
        return res;
        
        
        
        
    }
    public static boolean hasPath(int adjMat[][],int  source,int des){
        boolean visited[] = new boolean[adjMat.length];
        
        
        
        return hasPathHelper(adjMat,source,des,visited);
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
  
        Scanner s = new Scanner(System.in);
        
        
        int n = s.nextInt();
        int e = s.nextInt();
        
        int adjMat[][] = new int[n][n];
        
        for(int i=0;i<e;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            
            adjMat[a][b] = 1;
            adjMat[b][a] = 1;
        }
        int source = s.nextInt();
        int des = s.nextInt();
        
        System.out.println(hasPath(adjMat,source,des));

	}

}
