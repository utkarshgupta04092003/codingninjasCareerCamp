/***********************************************

Problem : Coding Ninjas

Given a NxM matrix containing Uppercase English
Alphabets only. Your task is to tell if there 
is a path in the given matrix which makes the 
sentence “CODINGNINJA” .
There is a path from any cell to all its 
neighbouring cells. For a particular cell, 
neighbouring cells are those cells that share
an edge or a corner with the cell.



Input Format :
The first line of input contains two space 
separated integers N and M, where N is 
number of rows and M is the number of 
columns in the matrix. 
Each of the following N lines contain M 
characters. Please note that characters are
not space separated.
Output Format :
Print 1 if there is a path which makes the 
sentence “CODINGNINJA” else print 0.


Sample Input 1:
2 11
CXDXNXNXNXA
XOXIXGXIXJX
Sample Output 1:
1


Approach : first we check for C in graph, if 
anywhere we found C we start searching  for 
"ODINGNINJA" using  recursion and mark visited
index as true;
for string 0index character we search for 
eight direction if we found, again search for 
next character recursively.
And if i found "CODINGNINJA" just return true
else return false;
***********************************************/
public class Solution {
	
    boolean searchForWord(char adjMat[][],int i,int j,boolean visited[][],String str){
        
        visited[i][j] = true;
        if(str.length() == 0){
            return true;
        }
        
        
        boolean res = false;
        int  n = adjMat.length;
        int m = adjMat[0].length;
        
        
        if((i-1 >= 0) && (j-1 >= 0) && (adjMat[i-1][j-1] == str.charAt(0)) && (visited[i-1][j-1] == false)){
            res = searchForWord(adjMat,i-1,j-1,visited,str.substring(1));
            if(res)
                return true;
        }
        
        if((i-1 >= 0) && (j >= 0) && (adjMat[i-1][j] == str.charAt(0))  && (visited[i-1][j] == false)){
            res = searchForWord(adjMat,i-1,j,visited,str.substring(1));
            if(res)
                return true;
        }
        
        
        if((i-1 >= 0) && (j+1 <  m) && (adjMat[i-1][j+1] == str.charAt(0))  && (visited[i-1][j+1] == false)){
            res = searchForWord(adjMat,i-1,j+1,visited,str.substring(1));
            if(res)
                return true;
        }
        
        
        if((i >= 0) && (j-1 >= 0) && (adjMat[i][j-1] == str.charAt(0))  && (visited[i][j-1] == false)){
            res = searchForWord(adjMat,i,j-1,visited,str.substring(1));
            if(res)
                return true;
        }
        
        if((i >= 0) && (j+1 < m) && (adjMat[i][j+1] == str.charAt(0))  && (visited[i][j+1] == false)){
            res = searchForWord(adjMat,i,j+1,visited,str.substring(1));
            if(res)
                return true;
        }
        
        if((i+1 < n) && (j-1 >= 0) && (adjMat[i+1][j-1] == str.charAt(0))  && (visited[i+1][j-1] == false)){
            res = searchForWord(adjMat,i+1,j-1,visited,str.substring(1));
            if(res)
                return true;
        }
        
        
        if((i+1 < n) && (j >= 0) && (adjMat[i+1][j] == str.charAt(0))  && (visited[i+1][j] == false)){
            res = searchForWord(adjMat,i+1,j,visited,str.substring(1));
            if(res)
                return true;
        }
        
        if((i+1 < n) && (j+1 < m) && (adjMat[i+1][j+1] == str.charAt(0))  && (visited[i+1][j+1] == false)){
            res = searchForWord(adjMat,i+1,j+1,visited,str.substring(1));
            if(res)
                return true;
        }
        
        
        
        visited[i][j] = false;
        return false;
        
        
        
        
        
        
        
    }
    
    
	int solve(String[] Graph , int n, int m)
	{
		char adjMat[][] = new char[n][m];
        
        for(int i=0;i<n;i++){
            adjMat[i] = Graph[i].toCharArray();
        }
      
        
        boolean visited[][] = new boolean[n][m];
        String str = "CODINGNINJA";
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(adjMat[i][j] == 'C'){
                    visited[i][j] = true;
                    boolean res = searchForWord(adjMat,i,j,visited,str.substring(1));
                    if(res == true){
                        return 1;
                    }
                }
            }
        }
      return 0;

	}
	
}

