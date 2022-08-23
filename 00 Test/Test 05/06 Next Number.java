/************************************************************************************

Given a large number represented in the form of a linked list. Write code to 
increment the number by 1 in-place(i.e. without using extra space).
Note: You don't need to print the elements, just update the elements and return 
the head of updated LL.
Input Constraints:
1 <= Length of Linked List <=10^6.
Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements 
Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6
Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0 

*************************************************************************************/


public class Solution {

	static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    
	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        
        head = reverse(head);
   	   	LinkedListNode<Integer> res = head;
        LinkedListNode<Integer> temp = null, prev = null;
 
        int carry = 1, sum;
 
        while (head != null)
        {
            
            sum = carry + head.data;
 
            carry = sum/10;
             sum = sum % 10;
 
            head.data = sum;
 
            temp = head;
            head = head.next;
        }
 		LinkedListNode<Integer> faltu = new LinkedListNode<Integer>(0);
        if (carry > 0){
            faltu.data = carry;
            faltu.next = null;
            temp.next = faltu;
    	}
        return reverse(res);
    }

}
