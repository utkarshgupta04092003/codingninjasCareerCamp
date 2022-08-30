/******************************************************************************************

Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S.
You can use extra space of the order of O(log n).
Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.
Input Format :
The first line of input contains data of the nodes of the tree in level order form. 
The data of the nodes of the tree is separated by space. If any node does not have 
left or right child, take -1 in its place. Since -1 is used as an indication whether 
the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of S.
Output format:
You have to print each pair in a different line (pair elements separated by space). 
The order of different pairs, to be printed, does not matter.
Constraints:
Time Limit: 1 second   
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7

*******************************************************************************************/


import java.util.*;
public class Solution {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	private static void BSTToArray(BinaryTreeNode<Integer> root, ArrayList<Integer> arr){
        
        if(root == null)
            return;
        
        arr.add(root.data);
        
        BSTToArray(root.left,arr);
        BSTToArray(root.right,arr);
        
    }
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		// Write your code here
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        BSTToArray(root,list);
		Collections.sort(list);   

        int start = 0;
        int end = list.size()-1;
        while(start < end){
            
            if(list.get(start)+list.get(end) == s){
            	System.out.println(list.get(start)+" "+list.get(end));
                start++;
            }
            else if(list.get(start)+list.get(end) < s){
            	// System.out.println(list.get(start)+" "+list.get(end));
                start++;
            }
            if(list.get(start)+list.get(end) > s){
            	// System.out.println(list.get(start)+" "+list.get(end));
                end--;
            }
            
        }
        
        
        
	}

}




