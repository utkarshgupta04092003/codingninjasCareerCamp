/**************************************************************************

Given a Linked List, which has nodes in alternating ascending and 
descending orders. Sort the list efficiently and space complexity should
be O(1).
You just need to return the head of sorted linked list, don't print the 
elements.
Input format :
Line 1 : Linked list elements of length L (separated by space and 
terminated by -1)
Line 2 : Integer n
Output format :
Updated list elements (separated by space)
Sample Input 1 :
10 40 53 30 67 12 89 -1
Sample Output 1 :
10 12 30 40 53 67 89


**************************************************************************/

public class Solution {

	
    	public static LinkedListNode<Integer> merge(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        //Your code goes here
        
       
        
        LinkedListNode<Integer>t1 = head1,t2 = head2,head = null,tail = null;
         if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        if(t1 == null && t2 == null)
            return null;
        
        
        if(t1.data <= t2.data){
            head = t1;
            tail = t1;
            t1 = t1.next;
        }
        else{
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        
        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }
            else{
                tail.next = t2;
                tail = t2;
                t2 = t2.next;
            }
        }
        
        if(t1 == null)
            tail.next = t2;
    	if(t2 == null)
            tail.next = t1;
        
        return head;
        
    }

    
    public static LinkedListNode<Integer> mid(LinkedListNode<Integer>head){
        if(head  == null || head.next == null)
            return head;
        
        LinkedListNode<Integer> slow = head,fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
	
    
    public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		//Your code goes here
        
        if(head == null || head.next == null)
            return head;
        
        LinkedListNode<Integer> mid = mid(head);
        LinkedListNode<Integer> second = mid.next;
        mid.next = null;
        LinkedListNode<Integer> first = head;
        
        LinkedListNode<Integer> firstSmall = mergeSort(first);
        LinkedListNode<Integer> secondSmall = mergeSort(second);
        
        head = merge(firstSmall,secondSmall);
        
        return head;
	}
    
    public static LinkedListNode<Integer> sort(LinkedListNode<Integer> head) {
		//Your code goes here
        return mergeSort(head);
        
	}
    


}
