/**********************************************************************************

Implement the BST class which includes following functions -
1. insert -
Given an element, insert that element in the BST at the correct position. If
element is equal to the data of the node, insert it in the left subtree.
2. search
Given an element, find if that is present in BST or not. Return true or false.
3. delete -
Given an element, remove that element from the BST. If the element which is to 
be deleted has both children, replace that with the minimum element from right
sub-tree.
4. printTree (recursive) -
Print the BST in in the following format -
For printing a node with data N, you need to follow the exact format -
N:L:x,R:y
where, N is data of any node present in the binary tree. x and y are the values
of left and right child of node N. Print the children only if it is not null.
There is no space in between.
You need to print all nodes in the recursive format in different lines.

**********************************************************************************/

/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *			case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree {
    
    private BinaryTreeNode<Integer> root;
    
    
    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node,int x){
        if(node == null){
        	BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(x);
            return newNode;
        }
        if(x <= node.data){
            node.left = insertHelper(node.left,x);
        }
        else{
            node.right = insertHelper(node.right,x);
        }
        return node;
        
    }	
    public void insert(int data) {
		//Implement the insert() function
        root = insertHelper(root,data);
	}
    
    
    
    
    
    
    
    
    
    private int findRightMinimum(BinaryTreeNode<Integer> node){
        
        while(node.left != null){
            node = node.left;
        }
        return node.data;
        
    }
    
    private BinaryTreeNode<Integer> removeHelper(BinaryTreeNode<Integer> node, int x){
        if(node == null)
            return null;
        
        
        
        if(x > node.data){
            node.right = removeHelper(node.right,x);
        }
        else if(x < node.data){
            node.left = removeHelper(node.left,x);
        }
        
    	else{
            if(node.left == null && node.right == null){
                return null;
            }
            else if(node.left == null && node.right != null){
                return node.right;
            }
            else if(node.right == null && node.left != null){
                return node.left;
            }
            
            int rightMinimum = findRightMinimum(node.right);
            node.data = rightMinimum;
            node.right = removeHelper(node.right,rightMinimum);
            // return node;
            
            
        }
        return node;
    }
	
	public void remove(int data) {
		//Implement the remove() function
        // if(search(data))
        root = removeHelper(root,data);
	}
    
    
    
    
    
    
    
    
    
    
    
    private void printTreeHelper(BinaryTreeNode<Integer> node){
        if(node == null)
            return;
        
    	System.out.print(node.data+":");
        if(node.left != null){
            System.out.print("L:" + node.left.data+",");
        }
        if(node.right != null){
            System.out.print("R:" + node.right.data);
        }
        System.out.println();
        printTreeHelper(node.left);
        printTreeHelper(node.right);
        
    }
	public void printTree() {
        printTreeHelper(root);
	}
	
    
    
    
    private boolean serachHelper(BinaryTreeNode<Integer> node, int data){
        if(node == null)
            return false;
        if(node.data == data)
            return true;
        
        if(data < node.data){
            return serachHelper(node.left,data);
        }
        return serachHelper(node.right,data);
        
        
    }
	public boolean search(int data) {
		return serachHelper(root,data);
	}
	

}




