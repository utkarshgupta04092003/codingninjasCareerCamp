/********************************************************************************

Given a generic tree, find and return the node with second largest value in
given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40
*********************************************************************************/

import java.util.*;

public class Solution {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
	static ArrayList<TreeNode<Integer>> arr = new ArrayList<TreeNode<Integer>>();
	
	public static void store(TreeNode<Integer> root){
		
		// Write your code here
		if(root == null)
            return;
        
        arr.add(root);
        for(int i=0;i<root.children.size();i++){
            arr.add(root.children.get(i));
            store(root.children.get(i));
    	}
    }
        	
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){


		// Write your code here
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;
        store(root);
        
        for(int i=0;i<arr.size();i++){
            if(largest < arr.get(i).data){
                largest = arr.get(i).data;
            }
        }
        for(int i=0;i<arr.size();i++){
            if(slargest < arr.get(i).data && largest != arr.get(i).data){
                slargest = arr.get(i).data;
            }
        }
        return new TreeNode<Integer>(slargest);
        

	}
	
	
}



