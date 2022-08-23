/********************************************************************************

Given a linked list that contain some random integers from 1 to n with many
duplicates. You need to replace each duplicate element that is present in the 
linked list with the values n+1, n+2, and so on (starting from left to right 
in given LL).
For eg. if input linked list is
1 3 1 4 4 2 1 -1
updated linked list should be -
1 3 5 4 6 2 7
n in the list is 4, so I have to replace each duplicate from left to right 
with 4, 5 and so on. In that way, element 1 (which is at index 2) will be 
replaced by 5, element 4 (which is present at index 4) by 6 and element 1
(which is present at index 6) by 7.
You don't need to print the elements, just update the elements in LL.
Input format :
Linked list elements (separated by space and terminated by-1)
Output Format :
Updated LL elements (separated by space)
Sample Input 1 :
1 3 1 4 4 2 1 -1
Sample Output 1 :
1 3 5 4 6 2 7

********************************************************************************/

import java.util.*;
public class solution {

	public static void changeLL(LinkedListNode<Integer> head) {
        
        Map<Integer, Integer> mymap = new HashMap<>();
 
        LinkedListNode<Integer> temp = head;

        // variable to store the maximum number
        // in linked list
        int maxNum = 0;

        // traverse the linked list to store
        // the frequency of every number and
        // find the maximum integer
        while (temp != null)
        {
            mymap.put(temp.data,(mymap.get(temp.data) ==null?0:mymap.get(temp.data))+1);
            if (maxNum < temp.data)
                maxNum = temp.data;
            temp = temp.next;
        }

        // Traverse again the linked list
        while (head != null)
        {

            // Mark the node with frequency more
            // than 1 so that we can change the
            // 2nd occurrence of that number
            if (mymap.get(head.data) > 1)
                mymap.put(head.data, -1);

            // -1 means number has occurred
            // before change its value
            else if (mymap.get(head.data) == -1)
                head.data = ++maxNum;

            head = head.next;
        }
    }
}
