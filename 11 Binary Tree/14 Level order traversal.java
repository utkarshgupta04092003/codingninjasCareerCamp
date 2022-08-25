/*****************************************************************************************

For a given a Binary Tree of type integer, print it in a level order fashion where each
level will be printed on a new line. Elements on every level will be printed in a linear 
fashion and a single space will separate them.
Example:
Image Link - https://files.codingninjas.in/seventypercent-4796.png
alt txt

For the above-depicted tree, when printed in a level order fashion, the output would look like:

10
20 30 
40 50 60
Where each new line denotes the level in the tree.
Input Format:
The first and the only line of input will contain the node data, all separated by a single
space. Since -1 is used as an indication whether the left or right node data exist for root,

it will not be a part of the node data.
Output Format
The given input tree will be printed in a level order fashion where each level will be 
printed on a new line. 
Elements on every level will be printed in a linear fashion. A single space will separate
them.
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
10 20 30 40 50 -1 60 -1 -1 -1 -1 -1 -1 
Sample Output 1:
10 
20 30 
40 50 60 
Sample Input 2:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 2:
8 
3 10 
1 6 14 
4 7 13 


******************************************************************************************/




import java.util.*;
public class Solution {
    

	public static void printLevelWise(BinaryTreeNode<Integer> root) {

        // Base Case
        if(root == null)
            return;
         
        // Create an empty queue for level order traversal
        Queue<BinaryTreeNode<Integer>> q =new LinkedList<BinaryTreeNode<Integer>>();
         
        // Enqueue Root and initialize height
        q.add(root);
         
        while(!q.isEmpty()){
            
            // number of element for each level
            int count = q.size();
            
            while(count > 0){
                            
                BinaryTreeNode<Integer> front = q.poll();

                System.out.print(front.data+" ");
                if(front.left != null)
                    q.add(front.left);
                if(front.right != null)
                    q.add(front.right);
                count--;
            }
            
            System.out.println();
        }
    
 	}
	
}

