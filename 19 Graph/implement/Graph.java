import java.util.*;

public class Graph{
    
    // n is the number of row of Adjeceancy matrix
    private int n;
    private int adjMat[][];
    
    // initialize matrix
    public Graph(int n){
        this.n = n;
        this.adjMat = new int[n][n];
    }
    
    // create a edge between two vertex
    public void makeEdge(int i,int j){
        adjMat[i][j] = 1;
        adjMat[j][i] = 1;
    }
    
    
    // print the adjMatrix
     void printMat(){
        for(int  i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Depth first traversal 
    private void dfTraversalHelper(int currVer,boolean visited[]){
        
        System.out.print(currVer + " ");
        visited[currVer] = true;
        
        for(int i=0;i<n;i++){
            if(adjMat[currVer][i] == 1 && visited[i] == false){
                dfTraversalHelper(i,visited);
            }
        }
        
    }
    public void dfTraversal(){
        boolean visited[] = new boolean[n];
        
        dfTraversalHelper(0,visited);
    }
    
    // breadth first traversal
     private void bfTraversal(int currVer,boolean visited[]){
        Queue<Integer> q =  new LinkedList<Integer>();
        
        
        q.add(currVer);
        visited[currVer] = true;
        

        
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
                bfTraversal(i,visited);
                visited[i] = true;
            }
        }
        
        
    }
    public void bfTraversal(){
         
        boolean visited[] = new boolean[adjMat.length];

        bfTraversal(0,visited);
    }
   
    
    
}
