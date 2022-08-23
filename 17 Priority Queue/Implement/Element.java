/****************************************************
This is element class that store value and priority
for any element.
And we  implement queue for this Element that stores
value as well as priority.


****************************************************/


public class Element<K>{
    K value;
    int priority;
    
    public Element(K value,int priority){
        this.value = value;
        this.priority = priority;
    }
}
