package lunchLocation.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import lunchLocation.domain.*;
import lunchLocation.service.GraphService;

public class GraphServiceImpl implements GraphService {

	public boolean visitable(Graph graph, Node from, Node to) {

		LinkedList<Node> returnlist = new LinkedList<Node>();

		// set all nodes in graph Unvisited
		for (Node u : graph.getNodes()) {
			u.setState(State.Unvisited);
		}

		from.setState(State.Visiting);
		returnlist.add(from);// add the first node to the returnlist

		Node u;
		while (!returnlist.isEmpty()) {
			u = returnlist.removeFirst(); // remove the first element of the
											// linkedlist
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.getState() == State.Unvisited) {
						if (v == to) {
							return true;
						} else {
							v.setState(State.Visiting);
							returnlist.add(v);
						}
					}
				}

				u.setState(State.Visited);
			}
		}
		return false;
	}

	private static Stack<Node> path = new Stack<Node>(); // the current path
	private static Set<Node> onPath = new HashSet<Node>(); // the set of
															// vertices on the
															// path
	private static List<Stack<Node>> pathList;

	public List<Stack<Node>> findAllPaths(Graph G, Node s, Node t) {
		pathList = new ArrayList<Stack<Node>>();

		return enumerate(G, s, t);

	}

	// use DFS
	private static List<Stack<Node>> enumerate(Graph G, Node v, Node t) {

		// add node v to current path from s
		path.push(v);
		onPath.add(v);

		// found path from s to t - currently prints in reverse order because of
		// stack
		if (v.equals(t)) {
			@SuppressWarnings("unchecked")
			Stack<Node> tempPath = (Stack<Node>) path.clone();
			pathList.add(tempPath);
		}
		// consider all neighbors that would continue path with repeating a node
		else {
			for (Node w : v.getAdjacent()) {
				if (!onPath.contains(w))
					enumerate(G, w, t);
			}
		}

		// done exploring from v, so remove from path
		path.pop();
		onPath.remove(v);
		return pathList;
	}

	private static Stack<Node> pathForPrint = new Stack<Node>(); // the current
																	// path
	private static Set<Node> onPathForPrint = new HashSet<Node>(); // the set of
																	// vertices
																	// on the
																	// path

	public void printAllPaths(Graph G, Node s, Node t) {
		enumerateHelper(G, s, t);
	}

	// use DFS
	private static void enumerateHelper(Graph G, Node v, Node t) {

		// add node v to current pathForPrint from s
		pathForPrint.push(v);
		onPathForPrint.add(v);

		// found pathForPrint from s to t - currently prints in reverse order
		// because of stack
		if (v.equals(t))
			System.out.println(pathForPrint);

		// consider all neighbors that would continue pathForPrint with
		// repeating a node
		else {
			for (Node w : v.getAdjacent()) {
				if (!onPathForPrint.contains(w))
					enumerateHelper(G, w, t);
			}
		}

		// done exploring from v, so remove from pathForPrint
		pathForPrint.pop();
		onPathForPrint.remove(v);
	}

	@Override
	public Set<Node> lunchLocation(Graph G, Node s, Node t) {

		List<Stack<Node>> pathForLunch = findAllPaths(G, s, t);

		Set<Node> lunchLocation = new HashSet<Node>();
		for (Stack<Node> stack : pathForLunch) {
			while (!stack.isEmpty())
				lunchLocation.add((Node) stack.pop());
		}
		return lunchLocation;
	}

	@Override
	public Set<Node> lunchLocationWithoutException(Graph G, Node s, Node t, Node[] nodes) {

		Set<Node> lunchLocation = lunchLocation(G, s, t);
		for (Node n : nodes)
			lunchLocation.remove(n);
		return lunchLocation;

	}

	private static List<Stack<Node>> pathListWitoutTrap;

	public List<Stack<Node>> findAllPathsWithoutTrap(Graph G, Node s, Node t, List<Node> traps) {
		pathListWitoutTrap = new ArrayList<Stack<Node>>();

		return enumerateWitoutTrap(G, s, t, traps);
	}

	// use DFS
	private static List<Stack<Node>> enumerateWitoutTrap(Graph G, Node v, Node t, List<Node> traps) {

		// add node v to current path from s
		path.push(v);
		onPath.add(v);

		// found path from s to t - currently prints in reverse order because of
		// stack
		if (v.equals(t)) {
			boolean hasTrap = false;
			for (Node node : traps) {
				if (path.contains(node)) {
					hasTrap = true;
					break;
				}

			}
			if (!hasTrap) {
				@SuppressWarnings("unchecked")
				Stack<Node> tempPath = (Stack<Node>) path.clone();

				pathList.add(tempPath);
			}

		}
		// consider all neighbors that would continue path with repeating a node
		else {
			for (Node w : v.getAdjacent()) {
				if (!onPath.contains(w))
					enumerateWitoutTrap(G, w, t, traps);
			}
		}

		// done exploring from v, so remove from path
		path.pop();
		onPath.remove(v);
		return pathList;
	}

}
