/*******************************************************
Given an array, your task is to sort this array in
descending order.


A Heap is a special Tree-based data structure in which 
the tree is a complete binary tree. Generally, Heaps
can be of two types:

Max-Heap: In a Max-Heap the key present at the 
root node must be greatest among the keys present at 
all of it’s children. The same property must be 
recursively true for all sub-trees in that Binary Tree.
Min-Heap: In a Min-Heap the key present at the root node
must be minimum among the keys present at all of it’s 
children. The same property must be recursively true for
all sub-trees in that Binary Tree.
********************************************************/
/******************************************************************************


HeapSort : using minheap
time complixity - O(nlogn)
Auxiliary space - O(1) 
*******************************************************************************/

public class Main
{
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    private static void heapify(int arr[],int n,int parent){
        
        int smallest = parent;
        int left = 2*parent+1;
        int right = 2*parent+2;
        
        if(left < n && arr[left] < arr[smallest])
            smallest = left;
            
        if(right < n && arr[right] < arr[smallest])
            smallest = right;
            
        if(smallest != parent){
            int temp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = temp;
            
            heapify(arr,n,smallest);
        }
        
    }
    public static void heapSort(int arr[]){
        int n = arr.length;
        
        // building heap
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        
        // extract one by one element from Array
        for(int i=n-1;i>=0;i--){
            
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr,i,0);
        }
        
    }
    
    
	public static void main(String[] args) {
	    
	    int arr[] = {12, 2, 5, 8, 9, 3, 4, 8, 10};
	    heapSort(arr);
	    printArray(arr);
	}
}
