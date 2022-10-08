/***************************************************************************************************

You have been given a head to a singly linked list of integers. Write a function check to whether 
the list given is a 'Palindrome' or not.
 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. 
Then the test cases follow.

First and the only line of each test case or query contains the the elements of the singly 
linked list separated by a single space.
 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list 
and hence, would never be a list element.
 Output format :
For each test case, the only line of output that print 'true' if the list is Palindrome or 
'false' otherwise.
 Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Time Limit: 1sec

Where 'M' is the size of the singly linked list.
Sample Input 1 :
1
9 2 3 3 2 9 -1
Sample Output 1 :
true
Sample Input 2 :
2
0 2 3 2 5 -1
-1
Sample Output 2 :
false
true
Explanation for the Sample Input 2 :
For the first query, it is pretty intuitive that the the given list is not a palindrome, 
hence the output is 'false'.

For the second query, the list is empty. An empty list is always a palindrome ,
hence the output is 'true'.
***************************************************************************************************/



/*

	Following is the Node class already written for the Linked List

	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;
    
    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*/

public class Solution {

    static class NodeWrapper
    {
        public LinkedListNode<Integer> node;
 
        NodeWrapper(LinkedListNode<Integer> node) {
            this.node = node;
        }
    }
 
   
 
    public static void display(LinkedListNode<Integer> head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    
    
    public static boolean checkPalindrome(NodeWrapper left, LinkedListNode<Integer> right)
    {
        // base case
        if (right == null) {
            return true;
        }
 
        boolean result = checkPalindrome(left, right.next) &&(left.node.data == right.data);
        left.node = left.node.next;
 
        return result;
    }
 
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
        return checkPalindrome( new NodeWrapper(head), head);
    }
}


// using reverse second half part

public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
        
        if(head == null || head.next == null)
            return true;
        
        boolean res=true;
        
        
        
       	LinkedListNode<Integer> second_half=null;  
        
        LinkedListNode<Integer>fast_ptr = head;
        LinkedListNode<Integer>slow_ptr = head;
        LinkedListNode<Integer>prev_of_slow_ptr = head;
        LinkedListNode<Integer>midnode = null;
        
        while (fast_ptr != null&& fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
 
                
                prev_of_slow_ptr = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
 
            if (fast_ptr != null) {
                midnode = slow_ptr;
                slow_ptr = slow_ptr.next;
            }
            second_half = slow_ptr;
			prev_of_slow_ptr.next= null; 
      
        // printList(second_half);
        second_half =  reverse(second_half); 					
        
        // printList(second_half);

        res=compareList(head,second_half);		
       
        return res;
        }
    
    
        
//reversing second half of the list
    
    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head3){
        LinkedListNode<Integer> prev=null;
        LinkedListNode<Integer> temp=head3;
        LinkedListNode<Integer> next=null;
        
        while(temp!=null){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head3=prev;
        return head3;
}
    
    
   public static boolean compareList(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
       LinkedListNode<Integer> temp1=head1;
       LinkedListNode<Integer> temp2=head2;
       while(temp1!=null && temp2!=null){
           if(temp1.data==temp2.data){
               temp1=temp1.next;
               temp2=temp2.next;
           }
           else{
               return false;
           }
       }
          if(temp1==null && temp2==null){
               return true;
           }
      		   return false;
       }
    
    
    public static void printList(LinkedListNode<Integer> head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
       
   } 
