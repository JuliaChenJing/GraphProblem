package lunchLocation;
import java.util.ArrayList;
import java.util.LinkedList;

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
		
		Node[] a1Adjacent={b1};
		a1.setAdjacent( a1Adjacent);
		
		Node[] a2Adjacent={b1,b2,b3};
		a2.setAdjacent( a2Adjacent);
		
		Node[] b1Adjacent={c1};
		b1.setAdjacent( b1Adjacent);
		
		Node[] b2Adjacent={c2,c3};
		b2.setAdjacent( b2Adjacent);
		
		Node[] b3Adjacent={c3};
		b3.setAdjacent( b3Adjacent);
		
		Node [] noAdjacent={};
		c1.setAdjacent(noAdjacent);
		c2.setAdjacent(noAdjacent);
		c3.setAdjacent(noAdjacent);
		
		
		Node[] nodes={a1,a2,b1,b2,b3,c1,c2,c3};
		Graph graph=new Graph();
		graph.setNodes(nodes);
		
		System.out.println(GraphService.visitable(graph, a2, c2));
		System.out.println(GraphService.visitable(graph, a2, c3));
	}
}
