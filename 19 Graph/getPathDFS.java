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
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {

    static ArrayList<Integer> getPathHelper(int adjMat[][],int s,int d,boolean visited[]){
        

        if(s == d){
            ArrayList<Integer> res = new ArrayList<Integer>();

            // res.add(s);
            return res;
        }
        
        visited[s] = true;
        
        // boolean res = false;
    	for(int i=0;i<adjMat.length;i++){
            if(adjMat[s][i] == 1 && visited[i] == false){
                ArrayList<Integer> smallRes = getPathHelper(adjMat,i,d,visited);
                if(smallRes != null){

                    smallRes.add(i);
                    return smallRes;

                }
            }
        }
        
        return null;
     
    }
    public static void getPath(int adjMat[][],int  source,int des){
        boolean visited[] = new boolean[adjMat.length];
        
        
        
        ArrayList<Integer> res = getPathHelper(adjMat,source,des,visited);
        
        if(res != null){
            res.add(source);
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i)+" ");
            }
        }
        
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
        
		getPath(adjMat,source,des);

	}

}
