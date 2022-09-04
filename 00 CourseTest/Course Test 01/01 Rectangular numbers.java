/****************************************************************************************

Print the following pattern for the given number of rows.
Pattern for N = 4
4444444
4333334
4322234
4321234
4322234
4333334  
4444444
Input format : N (Total no. of rows)

Output format : Pattern in N lines

Sample Input :
3
Sample Output :
33333
32223
32123
32223
33333
*****************************************************************************************/





public class solution {

	  public static void print(int n){
        int m = (2*n-1);
        int k = n;
        
        int i,j;
        
        
        // upper side
        for(i=1;i<=n;i++){
            int temp = n+1-i;
            
            
            // upper left 
            for(j=1;j<=n;j++){
                if((n+1-i) >= (n+1-j)){
                    System.out.print(n+1-i);
                } 
                else{
                    System.out.print(n+1-j);
                }
                
                // System.out.print(i+" "+j);
            }
            
            // upper right side
             for(j=n-1;j>0;j--){
                if((n+1-i) >= (n+1-j)){
                    System.out.print(n+1-i);
                } 
                else{
                    System.out.print(n+1-j);
                }
                
                // System.out.print(i+" "+j);
            }
           
                System.out.println();
        }
        
        // lower side
        
          for(i=n-1;i>0;i--){
                int temp = n+1-i;
                
                
                // upper left 
                for(j=1;j<=n;j++){
                    if((n+1-i) >= (n+1-j)){
                        System.out.print(n+1-i);
                    } 
                    else{
                        System.out.print(n+1-j);
                    }
                    
                    // System.out.print(i+" "+j);
                }
                
                // upper right side
                 for(j=n-1;j>0;j--){
                    if((n+1-i) >= (n+1-j)){
                        System.out.print(n+1-i);
                    } 
                    else{
                        System.out.print(n+1-j);
                    }
                    
                    // System.out.print(i+" "+j);
                }
               
                    System.out.println();
            }
            
            
        
    }

}



