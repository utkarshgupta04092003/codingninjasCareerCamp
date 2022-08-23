/*********************************************************

Problem link - https://practice.geeksforgeeks.org/problems/positive-and-negative-elements4613/1?page=1&difficulty[]=-1&category[]=Arrays&sortBy=latest



Given an array arr[ ] containing equal number of positive 
and negative elements, arrange the array such that every 
positive element is followed by a negative element.
Note- The relative order of positive and negative numbers 
should be maintained.

Example 1:

Input:
N = 6
arr[] = {-1, 2, -3, 4, -5, 6}
Output:  
2 -1 4 -3 6 -5
Explanation: Positive numbers in order 
are 2, 4 and 6. Negative numbers in order 
are -1, -3 and -5. So the arrangement we 
get is 2, -1, 4, -3, 6 and -5.
Example 2:

Input:
N = 4
arr[] = {-3, 2, -4, 1}
Output:  
2 -3 1 -4 
Your Task:
This is a function problem. You don't need to take any input,
as it is already accomplished by the driver code. You just
need to complete the function arranged() that takes array 
arr[ ] and its size integer N as parameters and returns
the required array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


*********************************************************/

import java.io.*;
import java.util.*;

class Solution
{
    ArrayList<Long> arranged(long a[], int n)
    {

        ArrayList<Long>pos = new ArrayList<Long>();
        ArrayList<Long>neg = new ArrayList<Long>();
        
        ArrayList<Long>arranged = new ArrayList<Long>();
        
        for(int i=0;i<n;i++){
            if(a[i] < 0)
                neg.add(a[i]);
            else
                pos.add(a[i]);
        }
        
        for(int i=0;i<n/2;i++){
            arranged.add(pos.get(i));
            arranged.add(neg.get(i));
        }
        
        return arranged;
    }
}



