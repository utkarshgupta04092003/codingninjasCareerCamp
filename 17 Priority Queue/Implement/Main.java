/*******************************************
This is main class file.
We use all priority queue function here

*******************************************/
public class Main
{
	public static void main(String[] args) {
		
		Priority_Queue<Integer> queue = new Priority_Queue<Integer>();
		
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.insert(5,5);
		queue.insert(10,2);
		
		System.out.println(queue.isEmpty());
		
		System.out.println("Min is : "+queue.getMin());
		System.out.println(queue.removeMin());
		
		queue.insert(15,3);
		queue.insert(20,4);
		System.out.println("Min is : "+queue.getMin());
		System.out.println(queue.removeMin());
		
		queue.insert(25,1);
		System.out.println("Min is : "+queue.getMin());
		System.out.println(queue.removeMin());
		System.out.println("Min is : "+queue.getMin());
		System.out.println(queue.removeMin());
		System.out.println("Min is : "+queue.getMin());
		System.out.println(queue.removeMin());
// 		System.out.println(queue.removeMin());  // give exceptions


        queue.insert(100,1);
		
		queue.printQueue();
		
	}
}
