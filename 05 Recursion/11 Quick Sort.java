/**********************************************************************************************

Sort an array A using Quick Sort.
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
1 5 2 7 3
Sample Output 2 :
1 2 3 5 7 
************************************************************************************************/


/*
	To apply the method explained in the hint video, we have to add two more parameters in the function call. This can be done by calling a helper function from given function. The helper function can have three parameters: array, start index, end index.  
	
	Skeleton code to achieve this:
	public class Solution {
		public static void quickSort(int[] input, int startIndex, int endInedx) {
			// your code goes here
		}
	
		public static void quickSort(int[] input) {
			quickSort(input, 0, input.length - 1);
		}
	
	}
	
*/


public class Solution {
	
    
    private static int partition(int arr[],int si,int ei){
        
        int pivot = arr[si];
        int smallCount = 0;
        for(int i=si+1;i<=ei;i++){
            if(arr[i] < pivot){
                smallCount++;
            }
        }
        
        int temp = arr[si+smallCount];
        arr[si+smallCount] = pivot;
        arr[si] = temp;
        
        int i=si,j = ei;
        
        while(i < j){
            if(arr[i] < pivot){
                i++;
                
            }
            else if(arr[j] >= pivot){
                j--;
            }
            else{
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;
            }
        }
        return si+smallCount;
    }
    private static void quickSort(int arr[],int si,int ei){
        
        if(si>=ei){
            return;
        }
        
        int pivotElement = partition(arr,si,ei);
        
        quickSort(arr,si,pivotElement-1);
        quickSort(arr,pivotElement+1,ei);
            
    }
    
    
	public static void quickSort(int[] input) {
		
        quickSort(input,0,input.length-1);
	}
	
}



