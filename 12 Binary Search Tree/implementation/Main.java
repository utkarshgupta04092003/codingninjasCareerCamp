/*********************************************
BST (Binary search Tree):
A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties −

1.  The value of the key of the left sub-tree is less than the value of its parent (root) node's key.
2.  The value of the key of the right sub-tree is greater than or equal to the value of its parent (root) node's key.
3.  Thus, BST divides all its sub-trees into two segments; the left sub-tree and the right sub-tree.

*********************************************/


import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		
		BST root = new BST();;
		root.insert(5);
		
		System.out.println(root.isPresent(5));
		System.out.println(root.isPresent(10));
		
		root.insert(10);
		root.insert(15);
		root.insert(20);
		root.insert(25);
		root.insert(30);
		
		System.out.println(root.isPresent(5));
		System.out.println(root.isPresent(15));
		
		root.printTree();
		
		root.delete(5);
		root.delete(10);
		root.delete(15);
		root.delete(20);
		root.printTree();
		
		root.pathRootTo(30);
		
	}
	
	
}
