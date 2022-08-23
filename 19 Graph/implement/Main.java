// Graph implementation
/********************************************
A graph can be defined as group of vertices 
and edges that are used to connect these 
vertices. A graph can be seen as a cyclic 
tree, where the vertices (Nodes) maintain 
any complex relationship among them instead
of having parent child relationship.



Graph functions - 
makeEdge() - make a edge
dfTraversal()- Traverse the graph
printMat() - print the adjecency matrix

********************************************/
// Graph implementation
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		
		Graph g = new Graph(5);
		
		g.printMat();
		g.makeEdge(0,4);
		g.makeEdge(1,2);
		g.makeEdge(1,3);
		g.makeEdge(2,4);
		g.makeEdge(3,4);
		g.printMat();
		
		g.makeEdge(0,1);
		g.dfTraversal();
		g.bfTraversal();
	}
}
