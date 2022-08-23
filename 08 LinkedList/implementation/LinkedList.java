/*****************************************

insert() - take whole linkedlist input.
add() - add a new value at given index;
remove() - remove value from given index;
length() - return length of linked list;
print() - print the linked list


*****************************************/


import java.util.*;

public class LinkedList<T>{
    
    Node<Integer> head;
    
    
       
    private Node<Integer> insert(Node<Integer>head){
        
        Scanner s = new Scanner(System.in);
        
        int data = s.nextInt();
        Node<Integer> tail = null;
        head = null;
        
        while(data != -1){
            
            Node<Integer> currNode = new Node<Integer>(data);
            if(head == null){
                head = currNode;
                tail = currNode;
            }
            
            tail.next = currNode;
            tail = currNode;
            
            data = s.nextInt();
        }
        
        return head;
    }
    public void insert(){
        head = insert(head);
        
    }
    
    private Node<Integer> add(Node<Integer> head,int pos,int data){
        if(pos == 0){
            Node<Integer> currNode = new Node<Integer>(data);
            currNode.next = head;
            return currNode;
        }
        int i=0;
        Node<Integer> tail = head;
        while(i<pos-1 && tail != null){
            tail = tail.next;
            i++;
        }
        
        Node<Integer> currNode = new Node<Integer>(data);
        currNode.next = tail.next;
        tail.next = currNode;
        
        return head;
    }
    public void add(int pos,int data){

        // index out of size condition failed
        if(pos >= length())
            return;
            
        head = add(head,pos,data);

    }
    
    public int length(){
        Node<Integer> temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    
    private Node<Integer> remove(Node<Integer> head,int pos){
        if(pos == 0)
            return head.next;
            
        Node<Integer> temp = head;
        while(pos-1 > 0){
            temp = temp.next;
            pos--;
        }
        temp.next = temp.next.next;
        return head;
    }
    public void remove(int pos){
        if(pos > length())
            return;
        head = remove(head,pos);
        
    }
    
    private void printHelper(Node head){
        
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
    public void print(){
        printHelper(head);
    }
    
    
}
