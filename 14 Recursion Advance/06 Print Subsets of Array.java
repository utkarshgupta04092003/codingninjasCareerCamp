/*******************************************************************************************************

Given an integer array (of length n), find and print all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order 
of elements should remain same as in the input array.
Note : The order of subsets are not important. Just print the subsets in different lines.
Input format :
Line 1 : Integer n, Size of array
Line 2 : Array elements (separated by space)
Constraints :
1 <= n <= 15
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
********************************************************************************************************/




import java.util.ArrayList;
public class solution {

    
    public static void getSubsets(int []nums,int idx,ArrayList<Integer> curr)
    {
        if(idx==nums.length)
        {
            // ans.add(new ArrayList<Integer>(curr));
            for(int i=0;i<curr.size();i++)
                System.out.print(curr.get(i)+" ");
            System.out.println();
            return;
            
        }
        curr.add(nums[idx]);
        getSubsets(nums,idx+1,curr);
        curr.remove(curr.size()-1);
        getSubsets(nums,idx+1,curr);
        
    }
	public static void printSubsets(int input[]) {
		// Write your code here
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> curr=new ArrayList<>();
        getSubsets(input,0,curr);
        // return ans;
	}
}



