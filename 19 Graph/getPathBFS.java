/**********************************************

Given an undirected graph G(V, E) and two
vertices v1 and v2(as integers), find and 
print the path from v1 to v2 (if exists).
Print nothing if there is no path between 
v1 and v2.
Find the path using DFS and print the first
path that you encountered.
Note:
1. V is the number of vertices present in
graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is,
print v2 first, then intermediate vertices and
v1 at last.
4. Save the input graph in Adjacency Matrix.

Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1

Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :



***********************************************/

import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {


    public static ArrayList<Integer> getPathBFS(int adjMatrix[][], int s, int e){
        
        Queue<Integer> pendingVertices = new LinkedList<>(); 
        HashMap<Integer, Integer> map = new HashMap<>(); 
        
        boolean visited[] = new boolean[adjMatrix.length]; 
        visited[s] = true; 
        pendingVertices.add(s); 
        map.put(s, -1); 
        boolean pathFound = false;

        while(!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll(); 
            for(int i = 0; i < adjMatrix.length; i++){ 
                if(adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i); 
                    visited[i] = true; 
                    map.put(i, currentVertex); 
                    if(i == e) {
                        // Path found 
                        pathFound = true; 
                        break;
                    }
                }
            }
        }
        if(pathFound){
            ArrayList<Integer> path = new ArrayList<>(); 
            int currentVertex = e; 
            while( currentVertex != -1){
                path.add(currentVertex); 
                int parent = map.get(currentVertex); 
                currentVertex = parent;
            }
            return path;
        }else{
            return null;
        }
    }

    public static void getPath(int adjMat[][],int s,int d){
        
        boolean visited[] = new boolean[adjMat.length];
        
        ArrayList<Integer> res = getPathBFS(adjMat,s,d);
        // getPathHelper(adjMat,s,d,visited,res);
        
        if(res != null){
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i)+" ");
            }
        }
        
        
    }
	public static void main(String[] args)  throws NumberFormatException, IOException{
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        
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
        
        getPath(adjMat,source,des);
        
	}
}
