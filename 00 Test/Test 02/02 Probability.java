/******************************************************************************************************

An urn contains 8 balls : 4 red , 2 blue and 2 green. Now n balls are drawn out of the urn. 
Calculate the probability that out of n drawn balls exactly x balls are red.
Find your answer multiplied by 100 and return the integer part.
All required values for computation will be in integer range.
x is always less than equal to 4 and x is always less than equal to n.
Input format :
Two spaced integers : n and x
Output format :
Integer part of (Probability * 100). 
Sample Input 1 :
3 1
Sample Output 1:
42
******************************************************************************************************/



public class Solution {
    
    public static int factorial(int n){
        int fact=1;
        for(int i=1;i<=n;i++){
            fact = fact*i;
        }
        return fact;
    }
    
    public static int combination(int n,int x){
        
    }
    
    public static int probability(int n,int x){
                
      int total = (factorial(8)/((factorial(n)*factorial(8-n))));
        
        int a = ((24/(factorial(x)*factorial(4-x))));
        int a = ((24/(factorial(x)*factorial(4-x))));
        
        
    }
    

}





