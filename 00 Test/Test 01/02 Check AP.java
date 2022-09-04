/**********************************************************************************************

Given input consists of n numbers. Check whether those n numbers form an arithmetic 
progression or not. Print true or false.
Input format :
Line 1 : n
Line 2 : n numbers
Sample Input 1 :
6
2 6 10 14 18 22
Sample Output 1 :
true
Sample Input 2 :
6
2 6 10 15 19 23
Sample Output 2 :
false

************************************************************************************************/


import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = s.nextInt();
        
        int d = arr[1]-arr[0];
        int res = 0;
        for(int i=0;i<n-1;i++){
            if((arr[i+1]-arr[i]) != d){
                res++;
                break;
            }
        }
        
        if(res == 0){
            System.out.print("true");
        }
        else
            System.out.print("false");
        
        
        
	}
}




