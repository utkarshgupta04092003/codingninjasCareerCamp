/*****************************************************************************************

Given a Binary tree, find the largest BST subtree. That is, you need to find the BST 
with maximum height in the given binary tree. You have to return the height of largest BST.
Input format :
The first line of input contains data of the nodes of the tree in level order form. 
The data of the nodes of the tree is separated by space. If any node does not have 
left or right child, take -1 in its place. Since -1 is used as an indication whether 
the left or right nodes exist, therefore, it will not be a part of the data of any
node.
Output format:
The first and only line of output contains the height of the largest BST.
Constraints:
Time Limit: 1 second
Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2

*******************************************************************************************/


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
   
    
    private static boolean isBST(BinaryTreeNode<Integer> root,int minRange, int maxRange){
        
        if(root == null)
            return true;
        
        if(root.data<minRange || root.data > maxRange)
            return false;
        
        boolean isLeftBalanced = isBST(root.left, minRange, root.data-1);
        boolean isRightBalanced = isBST(root.right,root.data,maxRange);
        
        return isRightBalanced && isLeftBalanced;
    }
    
    public static boolean isBST(BinaryTreeNode<Integer> root){
        return isBST(root,Integer.MIN_VALUE	, Integer.MAX_VALUE);
        
    }
    
   
    
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		// Write your code here
        if(root == null)
            return 0;
        
        if(isBST(root)){
            return 1+Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }
        
        return Math.max(largestBSTSubtree(root.left),
                        largestBSTSubtree(root.right));
        
    }

}




