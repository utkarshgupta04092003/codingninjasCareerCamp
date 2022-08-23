/****************************************************************************************

1. You are given two linked lists. Data of each node of these linked lists contain a 
digit from the range: [0, 9].
2. The linked lists represent two numbers.
3. You have to print the product of these two numbers.
Input Format:
Input has already been managed for cpp and java submissions. In cpp and java, you have 
to just write a function which receives head nodes of two linked lists. The sizes 
of linked lists are N and M, respectively.
For other languages, the first line of input contains list of N space separated
integers, terminated by -1. The following line of input also contains list of M 
space separated integers, terminated by -1. The integers form the data of nodes 
of two linked list.   
Constraints:
N and M lies in the range: [1, 1000].
0 <= |Node Data| <= 9
Output format:
Print the product of numbers, represented by two linked lists.
Sample Input:
1 2 3 4 5 -1
1 2 3 -1
Sample Output:
1 5 1 8 4 3 5

****************************************************************************************/


/*Linked List Node Class

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;
    
    public LinkedListNode(T data) {
        this.data = data;
        this.next = null;
    }
}

*/
import java.util.ArrayList;
public class Solution {
    
    
    public static void multiply(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        struct Node* multiplyTwoLists(struct Node* first,
                        struct Node* second)
{
    // reverse the lists to multiply from end
    // m and n lengths of linked lists to make
    // and empty list
    int m = reverse(&first), n = reverse(&second);
 
    // make a list that will contain the result
    // of multiplication.
    // m+n+1 can be max size of the list
    struct Node* result = make_empty_list(m + n + 1);
 
    // pointers for traverse linked lists and also
    // to reverse them after
    struct Node *second_ptr = second,
        *result_ptr1 = result, *result_ptr2, *first_ptr;
 
    // multiply each Node of second list with first
    while (second_ptr) {
 
        int carry = 0;
 
        // each time we start from the next of Node
        // from which we started last time
        result_ptr2 = result_ptr1;
 
        first_ptr = first;
 
        while (first_ptr) {
 
            // multiply a first list's digit with a
            // current second list's digit
            int mul = first_ptr->data * second_ptr->data
                    + carry;
 
            // Assign the product to corresponding Node
            // of result
            result_ptr2->data += mul % 10;
 
            // now resultant Node itself can have more
            // than 1 digit
            carry = mul / 10 + result_ptr2->data / 10;
            result_ptr2->data = result_ptr2->data % 10;
 
            first_ptr = first_ptr->next;
            result_ptr2 = result_ptr2->next;
        }
 
        // if carry is remaining from last multiplication
        if (carry > 0) {
            result_ptr2->data += carry;
        }
 
        result_ptr1 = result_ptr1->next;
        second_ptr = second_ptr->next;
    }
 
    // reverse the result_list as it was populated
    // from last Node
    reverse(&result);
    reverse(&first);
    reverse(&second);
 
    // remove if there are zeros at starting
    while (result->data == 0) {
        struct Node* temp = result;
        result = result->next;
        free(temp);
    }
 
    // Return head of multiplication list
    return result;
}
    }

}
