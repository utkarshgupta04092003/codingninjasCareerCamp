/*********************************************
All important BST function is implement below.
*********************************************/


import java.util.*;

public class BST {
    
    
    BTNode <Integer> root;
    public BST(){
        this.root = null;
    }
    
    
    // Insert an element in BST such that it follow all condition of  BST
    private BTNode<Integer> insertHelper(BTNode<Integer> root,int x){
        if(root == null){
            BTNode<Integer> newNode = new BTNode<Integer>(x);
            return newNode;
        }
        
        if(root.data < x){
            root.right = insertHelper(root.right,x);
        }else{
            root.left = insertHelper(root.left,x);
        }
        return root;
        
    }
    public void insert(int x){
        root = insertHelper(root,x);
    }
    
       
    //  Search an element in BST.
    // Return true if it is present in tree otherwise return false
 
    private boolean isPresentHelper(BTNode<Integer> root,int x){
        if(root == null)
            return false;
            
        if(root.data == x)
            return true;
            
        if(root.data < x)
            return isPresentHelper(root.right,x);
            
        return isPresentHelper(root.left,x);
    }
    public boolean isPresent(int x){
        return isPresentHelper(root,x);
    }
    
    
    //  Print BST in a way that 
    //  first print root data and its child then go for left child and  then for right child
    private void printTreeHelper(BTNode<Integer> root){
        
        if(root == null)
            return;
        
        System.out.print(root.data);
        
        if(root.left !=null){
            System.out.print(": L "+root.left.data);
        }
        if(root.right != null){
            System.out.print(",R "+root.right.data);
        }
        
        System.out.println();
        printTreeHelper(root.left);
        printTreeHelper(root.right);
        
        
    }
    public void printTree(){
        printTreeHelper(root);
    }



    //  Delete a node from BST such that it follows all BST conditions
    private int getMin(BTNode<Integer> root){
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    private BTNode<Integer> deleteHelper(BTNode<Integer>root,int x){
        if(root == null){
            return null;
        }
        if(root.data < x){
            root.right = deleteHelper(root.right,x);
        }
        if(root.data > x){
            root.left = deleteHelper(root.left,x);
        }
        if(root.data == x){
            
            // if there are no child 
            if(root.left == null && root.right == null)
                return null;
            
            // only right child is present 
            if(root.left == null && root.right != null){
                return root.right;
            }
            // only left child exist
            if(root.left != null && root.right == null){
                return root.left;
            }
            // if both child present
            else{
                
                int temp = getMin(root.right);
                root.data = temp;
                deleteHelper(root.right,temp);
                
            }
        }
        
        return root;
    }
    public void delete(int x){
        root = deleteHelper(root,x);
    }
    
    
    // print the path from number to root
    private ArrayList<Integer> pathRootToHelper(BTNode<Integer> root,int x){
        if(root == null)
            return null;
            
        if(root.data == x){
            ArrayList<Integer> res = new ArrayList<Integer>();
            res.add(root.data);
            return res;
        }
        
        
        ArrayList<Integer> rightList = pathRootToHelper(root.right,x);

        if(rightList != null){
            rightList.add(root.data);
            return rightList;
        }
           
        ArrayList<Integer> leftList = pathRootToHelper(root.left,x);
        if(leftList != null){
            leftList.add(root.data);
            return leftList;
        }
        
        return null;
    }
    public void pathRootTo(int x){
        ArrayList<Integer> path = pathRootToHelper(root,x);
        
        for(int num : path){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    
}
