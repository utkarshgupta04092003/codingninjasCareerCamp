/****************************************************************************************

Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.
Input format :
Line 1 : Integer n i.e. Array size
Line 2 : Array elements (separated by space)
Output format :
Array elements in increasing order (separated by space)
Constraints :
1 <= n <= 10^3
Sample Input 1 :
6 
2 6 8 5 4 3
Sample Output 1 :
2 3 4 5 6 8
Sample Input 2 :
5
2 1 5 2 3
Sample Output 2 :
1 2 2 3 5 


*****************************************************************************************/



public class solution {
    
    public static void mergeTwoArrays(int arr3[],int arr1[],int arr2[]){
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        int n3 = n1+n2;
        
        
        int i=0,j=0,k=0;
        while(i<n1 && j<n2){
            if(arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k] = arr2[j];
                k++;
                j++;
            }
            
        }
        
        while(i<n1){
            arr3[k] = arr1[i];
            i++;k++;
        }
        while(j<n2){
            arr3[k] = arr2[j];
            j++;k++;
        }
        
        
        
    }
    
	public static void mergeSort(int[] input){
		// Write your code here
        
        int n = input.length;
        
        if(n <= 1)
            return;
        
        int firstHalf = n/2;
        int secondHalf = n-firstHalf;
     
            
        int arr1[] = new int[firstHalf];
        int arr2[] = new int[secondHalf];

        int k=0;
        for(int i=0;i<firstHalf;i++){

            arr1[i] = input[k];
            k++;
        }
        k = firstHalf;
        for(int j=0;j<secondHalf;j++){
            arr2[j] = input[k];
            k++;
        }

        mergeSort(arr1);
        mergeSort(arr2);


    	mergeTwoArrays(input,arr1,arr2);
		
		
	}
}


