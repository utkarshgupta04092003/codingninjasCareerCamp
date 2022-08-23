// Implement stack using ArrayList


public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Stack<Integer> st =  new Stack<Integer>();
		
		System.out.println(st.isEmpty());
		System.out.println(st.size());
        System.out.println();
        
        
		st.push(5);
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.top());
		System.out.println();
		
		st.push(10);
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.top());
		System.out.println();

		
		System.out.println(st.pop());
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.top());
		System.out.println();
		
		System.out.println(st.pop());
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		System.out.println(st.top());
		System.out.println();

		// stack is empty till here
		

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		st.push(10);
        st.push(11);


	    while(!st.isEmpty()){
		    System.out.print(st.pop()+" ");
		}
		System.out.println();
		
		
	}
}
