package lunch_submit.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import lunch_submit.domain.*;
import lunch_submit.service.*;
import lunch_submit.service.impl.GraphServiceImpl;

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

		List<Node> traps = new ArrayList<Node>();
		traps.add(b2);

		System.out.println();
		System.out.println("LUNCH LOCATION WITOUT TRAP: ");
		Set<Node> list1 = graphService.lunchLocationWithoutTrap(graph, a2, c2, traps);
		System.out.println(list1);
		Set<Node> list2 = graphService.lunchLocationWithoutTrap(graph, a2, c3, traps);
		System.out.println(list2);

		
		
		System.out.println("COMBINE LUNCH LOCATION WITOUT TRAP: ");
		List<Set<Node>> lunchLocationBeforeCombining = new ArrayList<Set<Node>>();
		
		lunchLocationBeforeCombining.add(list1);
		lunchLocationBeforeCombining.add(list2);
		
		Set<Node> lunchLocation = graphService.combineLunchLocation(lunchLocationBeforeCombining);
		
		System.out.println(lunchLocation);
	}
}
