/*************************************************************************************

Given a generic tree, print the input tree in level wise order. That is, print the
elements at same level in one line (separated by space). Print different levels in 
differnet lines.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Level wise print
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50

************************************************************************************/


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
	
	
	
// 	public static void takeInputLevelWise(TreeNode<Integer> root){
// 		Scanner s = new Scanner(System.in);
//         int rootData = s.nextInt();
        
//         if(rootData == -1)
//             return null;
        
//         TreeNode<Integer> root = new TreeNode<Integer>(rootData);
//         Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        
//         queue.add(root);
        
//         while(!q.isEmpty()){
            
//             int childSize = s.nextInt();
//             TreeNode<Integer> front = queue.poll();
            
//             for(int i=0;i<childSize;i++){
//                 int childData = s.nextInt();
//                 TreeNode<Integer> childNode = new TreeNode<Integer>(childData);
                
//                 front.children.add(childNode);
//                 queue.add(childNode);
//             }
           
//         }

// 	}
    
    public static void printLevelWise(TreeNode<Integer> root){
        if(root == null)
            return;
        
        
    
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        
        queue.add(root);
        
			System.out.println(root.data);
        while(!queue.isEmpty()){

            int queueSize = queue.size();
            while(queueSize > 0){
                TreeNode<Integer> front = queue.poll();
                int childSize = front.children.size();

                for(int i=0;i<childSize;i++){

                    System.out.print(front.children.get(i).data+" ");

                    // front.children.add(childNode);
                    queue.add(front.children.get(i));
                }
                queueSize--;
           
            }
			System.out.println();

        }

    }
		
}


