
public class Application {

	public static void main(String [] args){
		Node a1=new Node("a1");
		Node a2=new Node("a2");
		Node b1=new Node("b1");
		Node b2=new Node("b2");
		Node b3=new Node("b3");
		Node c1=new Node("c1");
		Node c2=new Node("c2");
		Node c3=new Node("c3");
		
		Node[] a1Ad={b1};
		a1.setAdjacent( a1Ad);
		
		Node[] a2Ad={b1,b2,b3};
		a1.setAdjacent( a2Ad);
		
		
		
		Node[] nodes={a1,a2,b1,b2,b3,c1,c2,c3};
		Graph graph=new Graph();
		graph.setNodes(nodes);
		System.out.println(Graph.search(graph, a2, c2));
		
		System.out.println(Graph.search(graph, a2, c3));
	}
}
