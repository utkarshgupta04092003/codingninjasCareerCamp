/**********************************************************************************

Given an undirected graph G(V,E), check if the graph G is connected graph or not.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.


Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
true

Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
false 

**********************************************************************************/




import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    
    private static void dfTraversal(int adjMat[][],int currVer,boolean visited[]){
        
        // println(currVer);
        
        visited[currVer] = true;
        
        for(int i=0;i<adjMat.length;i++){
            if(adjMat[currVer][i] == 1 && visited[i] == false){
                dfTraversal(adjMat,i,visited);
            }
        }
        
        
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
       
      
        Scanner s = new  Scanner(System.in);
        
        int n = s.nextInt();
        
        if(n == 0){
            System.out.println("true");
            return;
        }
        int e = s.nextInt();
     
        int adjMat[][] = new int[n][n];
        
        for(int i=0;i<e;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            
            adjMat[a][b] = 1;
            adjMat[b][a] = 1;
            
        }
        
    	boolean visited[] = new boolean[n];
         
        dfTraversal(adjMat,0,visited);
        
        boolean isConnect= true;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                isConnect = false;
            }
            
        }
        
        System.out.println(isConnect);
        

	}

}
