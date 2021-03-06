package lunch_draft.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import lunch_draft.domain.*;
import lunch_draft.service.GraphService;
import lunch_draft.service.impl.GraphServiceImpl;



public class GraphApp {

	public static void main(String[] args) {
		Node a1 = new Node("a1");
		Node a2 = new Node("a2");
		Node b1 = new Node("b1");
		Node b2 = new Node("b2");
		Node b3 = new Node("b3");
		Node c1 = new Node("c1");
		Node c2 = new Node("c2");
		Node c3 = new Node("c3");

		List<Node> a1Adjacent = new ArrayList<Node>();
		a1Adjacent.add(b1);
		a1.setAdjacent(a1Adjacent);

		List<Node> a2Adjacent = new ArrayList<Node>();
		a2Adjacent.add(b1);
		a2Adjacent.add(b2);
		a2Adjacent.add(b3);
		a2.setAdjacent(a2Adjacent);

		List<Node> b1Adjacent = new ArrayList<Node>();
		b1Adjacent.add(c1);
		b1.setAdjacent(b1Adjacent);

		List<Node> b2Adjacent = new ArrayList<Node>();
		b2Adjacent.add(c2);
		b2Adjacent.add(c3);
		b2.setAdjacent(b2Adjacent);

		List<Node> b3Adjacent = new ArrayList<Node>();
		b3Adjacent.add(c3);
		b3.setAdjacent(b3Adjacent);

		List<Node> noAdjacent = new ArrayList<Node>();

		c1.setAdjacent(noAdjacent);
		c2.setAdjacent(noAdjacent);
		c3.setAdjacent(noAdjacent);

		List<Node> nodes = new ArrayList<Node>();
		nodes.add(a1);
		nodes.add(a2);
		nodes.add(b1);
		nodes.add(b2);
		nodes.add(b3);
		nodes.add(c1);
		nodes.add(c2);
		nodes.add(c3);
		Graph graph = new Graph();
		graph.setNodes(nodes);

		System.out.println(graph);
		GraphService graphService = new GraphServiceImpl();
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

		List<Node> traps = new ArrayList<Node>();
		traps.add(b2);

		System.out.println();
		System.out.println("LUNCH LOCATION WITOUT EXCEPTION: ");
		System.out.println(graphService.lunchLocationWithoutException(graph, a2, c2, traps));
		System.out.println(graphService.lunchLocationWithoutException(graph, a2, c3, traps));

		System.out.println();
		System.out.println("FIND ALL PATH Witout Trap: ");

		List<Stack<Node>> list3 = graphService.findAllPathsWithoutTrap(graph, a2, c2, traps);
		System.out.println(list3);
		System.out.println();
		List<Stack<Node>> list4 = graphService.findAllPathsWithoutTrap(graph, a2, c3, traps);
		System.out.println(list4);
		
		
		System.out.println();
		System.out.println("LUNCH LOCATION WITOUT TRAP: ");
		System.out.println(graphService.lunchLocationWithoutTrap(graph, a2, c2, traps));
		System.out.println(graphService.lunchLocationWithoutTrap(graph, a2, c3, traps));
		
		


	}
}
