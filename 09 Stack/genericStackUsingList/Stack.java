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


import java.util.*;
public class Stack<T>{

    
    private ArrayList<T>arr;

    public Stack(){
        arr = new ArrayList<T>();
    }
      
    public void push(T data){
        arr.add(data);
    }
    public T pop(){
        if(isEmpty())
            return null;
            
        T data = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return data;
    }
    public T top(){
        if(isEmpty())
            return null;
         
        return arr.get(arr.size()-1);
    }
    public int size(){
        return arr.size();
    }
    public boolean isEmpty(){
        if(arr.size() == 0)
            return true;
        return false;
    }
    

        
    
    
}
