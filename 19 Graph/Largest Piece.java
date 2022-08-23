/****************************************************

It's Gary's birthday today and he has ordered his 
favourite square cake consisting of '0's and '1's .
But Gary wants the biggest piece of '1's and no '0's . 
A piece of cake is defined as a part which consist 
of only '1's, and all '1's share an edge with each 
other on the cake. Given the size of cake N and the 
cake, can you find the count of '1's in the biggest 
piece of '1's for Gary ?


Sample Input 1:
2
1 1
0 1
Sample Output 1:
3

Sample Input 2:
3
1 0 0
0 1 0
0 1 0
Sample Output 2:
2



****************************************************/
// Solution class
public class Solution {

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    
    public static int findLargeCake(char[][] cake,int i,int j,boolean visited[][]){
        
        int n = cake.length;
        int m = cake[0].length;
        
        if(i < 0 || j< 0 || i >= n || j >= m ||  cake[i][j] == '0')
            return 0;

        visited[i][j] = true;
        int r1=0,r2=0,r3=0,r4=0;

        if( i-1>=0 && cake[i-1][j] == '1' && visited[i-1][j] == false)
            r1 = findLargeCake(cake,i-1,j,visited);

        if(j-1>=0 && cake[i][j-1] == '1' && visited[i][j-1] == false)
            r2 = findLargeCake(cake,i,j-1,visited);

        if(j+1<m && cake[i][j+1] == '1' && visited[i][j+1] == false)
            r3 = findLargeCake(cake,i,j+1,visited);

        if(i+1<n && cake[i+1][j] == '1' && visited[i+1][j] == false)
            r4 = findLargeCake(cake,i+1,j,visited);


        return r1+r2+r3+r4+1;
    }
	public static int dfs(String[] edge, int n) {
		
        int m = edge[0].length();
        int res = Integer.MIN_VALUE;
        char cake[][] = new char[n][m];
        for(int i=0;i<n;i++){
            cake[i]=edge[i].toCharArray();
        }
        
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cake[i][j] == '1'){
                    int r = findLargeCake(cake,i,j,visited);
                    res = Math.max(res,r);
                }
            }
        }
        return res;
	}


}


// Runner class
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static String[] takeInput() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        

        String[] edge = new String[n];
        for (int i = 0; i < n; i++) {
            edge[i] = br.readLine().replaceAll("\\s", "");
        }
        return edge;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        String[] edge = takeInput();
        int ans = Solution.dfs(edge,edge.length);
        System.out.println(ans);   
    }	
}
