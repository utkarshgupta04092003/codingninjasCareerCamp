
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		
		ll.insert();
		
		ll.print();
		
		ll.insert();
		ll.print();
		
		
		System.out.println(ll.length());
		ll.add(2,10);
		
		ll.print();
		
		ll.remove(3);
		ll.print();
	}
}
