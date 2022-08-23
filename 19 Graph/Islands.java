/**********************************************

An island is a small piece of land surrounded 
by water . A group of islands is said to be 
connected if we can reach from any given island 
to any other island in the same group . Given
V islands (numbered from 1 to V) and E 
connections or edges between islands. Can you
count the number of connected groups of islands.

Sample Input 1:
5 8
0 1
0 4
1 2
2 0
2 4
3 0
3 2
4 3
Sample Output 1:
1 


Sample Input 2:
5 0
Sample Output 2:
5

**********************************************/



public class Solution {
    
    
    private static void dfTaversal(int adjMat[][],int currVer,boolean visited[]){
        
        visited[currVer] = true;
        
        for(int i=0;i<adjMat.length;i++){
            
            if(adjMat[currVer][i] == 1 && visited[i] == false){
                dfTaversal(adjMat,i,visited);
            }
            
        }
        
    }

	public static int numConnected(int[][] adjMat, int n) {
        
        
        if(n == 0)
            return 0;
        
        
		boolean visited[] = new boolean[n];
        
        
        int count = 1;
        dfTaversal(adjMat,0,visited);
        
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfTaversal(adjMat,i,visited);
                count++;
            }
        }
        
        return count;
        
        
	}


}
