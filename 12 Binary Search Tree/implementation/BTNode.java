/***********************************************
Generic Binary serach Node structure is defined
as below.
**********************************************/

public class BTNode<T>{
    T data;
    BTNode left;
    BTNode right;
    
    public BTNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
