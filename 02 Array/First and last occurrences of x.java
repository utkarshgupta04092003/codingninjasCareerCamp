/*****************************************************************
Given a sorted array arr containing n elements with possibly 
duplicate elements, the task is to find indexes of first and
last occurrences of an element x in the given array.

Example 1:

Input:
n=9, x=5
arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
Output:  2 5
Explanation: First occurrence of 5 is at index 2 and last
             occurrence of 5 is at index 5. 
 

Example 2:

Input:
n=9, x=7
arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
Output:  6 6 

Your Task:
Since, this is a function problem. You don't need to take any input,
as it is already accomplished by the driver code. You just need to
complete the function find() that takes array arr, integer n and 
integer x as parameters and returns the required answer.
Note: If the number x is not found in the array just return both 
index as -1.

 

Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1).

*****************************************************************/


// Solution class

class GFG
{
    ArrayList<Long> find(long arr[], int n, int x)
    {
        // code here
        long first = -1;
        long last = -1;
        
        for(int i = 0;i<n;i++){
            if(arr[i] == x){
                first = i;
                break;
            }
        }
        for(int i = n-1;i>=0;i--){
            if(arr[i] == x){
                last = i;
                break;
            }
        }
        ArrayList<Long> res = new ArrayList<>();
        res.add(first);
        res.add(last);
        return res;
    }
}
