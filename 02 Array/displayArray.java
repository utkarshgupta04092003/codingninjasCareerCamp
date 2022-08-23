import java.util.*;

public class Main
{
  
      
    // print the arrays element
    public static void printArray(int arr[]){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
  
  
  	public static void main(String[] args) {
	
   		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
      printArray(arr);
	  }
}

