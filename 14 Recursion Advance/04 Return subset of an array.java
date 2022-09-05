/*************************************************************************************************

Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order 
of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :

Line 1 : Size of array

Line 2 : Array elements (separated by space)

Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 
**************************************************************************************************/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 

public class solution {

	// Return a 2D array that contains all the subsets
    public static List<List<Integer>> subsetss(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        getSubsets(nums,0,ans,curr);
        return ans;
    }
    
    public static void getSubsets(int []nums,int idx,List<List<Integer>> ans,List<Integer> curr)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<Integer>(curr));
            return;
            
        }
        curr.add(nums[idx]);
        getSubsets(nums,idx+1,ans,curr);
        curr.remove(curr.size()-1);
        getSubsets(nums,idx+1,ans,curr);
        
    }



	public static int[][] subsets(int input[]) {
		// Write your code here
        
        List<List<Integer>> resss = subsetss(input);
        int[][] arr = resss.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
 
        
		return arr;
	}
}




