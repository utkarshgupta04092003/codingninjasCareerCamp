/**************************************************************************************************

Given a binary search tree and data of two nodes, find 'LCA' (Lowest Common Ancestor) of the given
two nodes in the BST.
LCA
LCA of two nodes A and B is the lowest or deepest node which has both A and B as its descendants. 
Example:
In this example, the green coloured node is the LCA to A and B.
Image link - https://files.codingninjas.in/image2-5334.jpg
Alt Text

Note:
It is defined that each node is a descendant to itself, so, if there are two nodes X and Y and X
has a direct connection from Y, then Y is the lowest common ancestor.
Example:
Alt Text

Note:
1. If out of 2 nodes only one node is present, return that node. 
2. If both are not present, return -1.
3. all the node data will be unique.
Input format:
The first line of input contains data of the nodes of the tree in level order form. The data 
of the nodes of the tree is separated by space. If any node does not have left or right child, 
take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, 
therefore, it will not be a part of the data of any node.
The following line of input contains two integers, denoting the value of data of two nodes of
given BST.
Output Format:
The first and only line of output contains the data associated with the lowest common ancestor node.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 10
Sample Output 1:
8
Sample Input 2:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2 6
Sample Output 2:
5
Sample Input 3:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12 78
Sample Output 3:
-1

**************************************************************************************************/


public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */
 	static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> node, int n1, int n2)
    {
        if (node == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2)
            return lca(node.left, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2)
            return lca(node.right, n1, n2);
  
        return node;
    }

	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        
        if(root == null)
            return -1;
		BinaryTreeNode<Integer> res = lca(root,a,b);
        
        return res.data;
        
	}
}
