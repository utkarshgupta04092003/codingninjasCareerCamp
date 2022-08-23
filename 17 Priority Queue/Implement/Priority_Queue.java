/*************************************************************
This is priority queue class. here all priority queue 
functions is defined.


*************************************************************/

// min heap
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;

public class Priority_Queue<K>{
    private ArrayList<Element<K>> heap;
    
    public Priority_Queue(){
        heap = new ArrayList<Element<K>>();
    }
    
    public int size(){
        return heap.size();
    }
    public boolean isEmpty(){
        if(size()== 0)
            return true;
        return false;
    }
    public K getMin() throw PriorityQueueException{
        
       if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
         if(isEmpty()){
            System.out.print("Empty Queue Exception");
        }
        
        return heap.get(0).value;
        
    }
    
    
    public void insert(K value,int priority){
        heap.add(new Element(value,priority));
        
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;
        
        while(childIndex > 0){
            
            if(heap.get(childIndex).priority < heap.get(parentIndex).priority){
                Element<K> temp = heap.get(childIndex);
                heap.set(childIndex,heap.get(parentIndex));
                heap.set(parentIndex,temp);
            }
            
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
    
            
        }
    }
    
    public K removeMin() throw PriorityQueueException{
        
        
        // if(isEmpty()){
        //     System.out.print("Empty Queue Exception");
        // }
        if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
        
        K remove = heap.get(0).value;
        Element<K> last = heap.get(heap.size()-1);
        heap.set(0,last);
        
        heap.remove(heap.size()-1);
        
        
        int parentIndex = 0;
        int leftChild = (2*parentIndex)+1;
        int rightChild = (2*parentIndex)+2;
        
        while(leftChild < heap.size()){
            
        
            int minIndex = parentIndex;
            if(heap.get(leftChild).priority < heap.get(minIndex).priority){
                minIndex = leftChild;
            }
            
            if(rightChild< heap.size() && heap.get(rightChild).priority < heap.get(minIndex).priority){
                minIndex = rightChild;
            }
            
            if(minIndex == parentIndex)
                break;
            
            Element<K> temp = heap.get(minIndex);
            heap.set(minIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);
            
            parentIndex = minIndex;
            leftChild = (2*parentIndex)+1;
            rightChild = (2*parentIndex)+2;
            
            
            
            
        }
        
        return remove;
        
    }
    
    public void printQueue(){
        
        
        for(int i=0;i<heap.size();i++){
            System.out.println(heap.get(i).value + " " + heap.get(i).priority);
        }
        
        
    }
}





class PriorityQueueException extends Exception {

}
