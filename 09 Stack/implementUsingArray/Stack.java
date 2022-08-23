/***************************************************

At the time of stack creation, array will be of size
5.
push()- insert an element in stack
pop()- remove top element and return removed element
top() - return topmost value
size() - return size of stack
isempty() - return true is stack is empty, else 
return false;
resizing()- it is an internal function that double 
the array's size at the time of IndexoutofBound.
Using this function, we can overcome with stack's 
fixed length problem.

***************************************************/


public class Stack{

    
    private int arr[];
    private int topIndex;
    
    public Stack(){
        // initially for  only 5 elements
        arr = new int[5];
        topIndex = -1;
    }
      
    public void push(int data){
        if(topIndex == arr.length-1)
            reSizing();
            
        topIndex++;
        arr[topIndex] = data;
        
        //array IndexOutOfBoundsException handling
    }
    public int pop(){
        if(isEmpty())
            return -1;
            
        int data = arr[topIndex];
        topIndex--;
        return data;
    }
    public int top(){
        if(isEmpty())
            return -1;
         
        return arr[topIndex];
    }
    public int size(){
        return topIndex+1;
    }
    public boolean isEmpty(){
        if(topIndex == -1)
            return true;
        return false;
    }
    
    private void reSizing(){
        int size = arr.length;
        int temp[] = arr;
        arr = new int[size*2];
        
        for(int i=0;i<size;i++){
            arr[i] = temp[i];
        }
        
    }
    
}
