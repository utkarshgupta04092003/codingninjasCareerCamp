/**********************************************************************************

Given a BST, convert it into a sorted linked list. You have to return the head 
of LL.
Input format:
The first and only line of input contains data of the nodes of the tree in level
order form. The data of the nodes of the tree is separated by space. If any node 
does not have left or right child, take -1 in its place. Since -1 is used as an
indication whether the left or right nodes exist, therefore, it will not be a part 
of the data of any node.   
Output Format:
The first and only line of output prints the elements of sorted linked list.
Constraints:
Time Limit: 1 second
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2 5 6 7 8 10


***********************************************************************************/


public class Solution {


	static LinkedListNode<Integer> head;
    static LinkedListNode<Integer> tail;
    
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        
        if(root == null)
            return null;
        
        LinkedListNode<Integer> left = constructLinkedList(root.left);
        
        if(head == null){
            head = new LinkedListNode<Integer>(root.data);
            tail = head;
        }
        else{
            tail.next = new LinkedListNode<Integer>(root.data);
            tail = tail.next;
        }

        LinkedListNode<Integer> right = constructLinkedList(root.right);
        
        return head;
	}
}

