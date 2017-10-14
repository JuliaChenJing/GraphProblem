package lunchLocation.app;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lunchLocation.domain.*;
import lunchLocation.service.GraphService;
import lunchLocation.service.impl.GraphServiceImpl;

public class Application {

	public static void main(String[] args) {
		Node a1 = new Node("a1");
		Node a2 = new Node("a2");
		Node b1 = new Node("b1");
		Node b2 = new Node("b2");
		Node b3 = new Node("b3");
		Node c1 = new Node("c1");
		Node c2 = new Node("c2");
		Node c3 = new Node("c3");

		Node[] a1Adjacent = { b1 };
		a1.setAdjacent(a1Adjacent);

		Node[] a2Adjacent = { b1, b2, b3 };
		a2.setAdjacent(a2Adjacent);

		Node[] b1Adjacent = { c1 };
		b1.setAdjacent(b1Adjacent);

		Node[] b2Adjacent = { c2, c3 };
		b2.setAdjacent(b2Adjacent);

		Node[] b3Adjacent = { c3 };
		b3.setAdjacent(b3Adjacent);

		Node[] noAdjacent = {};
		c1.setAdjacent(noAdjacent);
		c2.setAdjacent(noAdjacent);
		c3.setAdjacent(noAdjacent);

		Node[] nodes = { a1, a2, b1, b2, b3, c1, c2, c3 };
		Graph graph = new Graph();
		graph.setNodes(nodes);

		

		
		System.out.println("Graph: "+graph);
		GraphService graphService=new GraphServiceImpl();
		System.out.println(graphService.visitable(graph, a2, c2));
		System.out.println(graphService.visitable(graph, a2, c3));
		
		System.out.println("PRINT ALL PATH: ");
		graphService.printAllPaths(graph, a2, c2);
		System.out.println();
		graphService.printAllPaths(graph, a2, c3);
		
		System.out.println();
		System.out.println("FIND ALL PATH: ");
		List<Stack<Node>> list1 = graphService.findAllPaths(graph, a2, c2);
		System.out.println(list1);
		
		System.out.println();
		List<Stack<Node>> list2 = graphService.findAllPaths(graph, a2, c3);
		System.out.println(list2);
		
		System.out.println();
		System.out.println("LUNCH LOCATION: ");
		System.out.println(graphService.lunchLocation(graph, a2, c2));
		System.out.println(graphService.lunchLocation(graph, a2, c3));
		
		Node[] exceptions= { b2 };
		System.out.println();
		System.out.println("LUNCH LOCATION WITOUT EXCEPTION: ");
		System.out.println(graphService.lunchLocationWithoutException(graph, a2, c2,exceptions));
		System.out.println(graphService.lunchLocationWithoutException(graph, a2, c3,exceptions));
		
		
		List<Node> traps=new ArrayList<Node>();
		traps.add(b2);
		System.out.println();
		System.out.println("FIND ALL PATH Witout Trap: ");
		
		List<Stack<Node>> list3 = graphService.findAllPathsWithoutTrap(graph, a2, c2,traps);
		System.out.println(list3);
	    
		
	
	}
}
