package service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import domain.*;
import service.GraphService;

public class GraphServiceImpl implements GraphService {

	Graph graph;

	private static Stack<Node> path; // the current path
	private static Set<Node> onPath; // the set of
										// vertices on the
										// path

	public Graph getGraph() {
		return graph;
	}


	public GraphServiceImpl() {
		path = new Stack<Node>();
		onPath = new HashSet<Node>();
		graph = new Graph();
	}

	private static List<Stack<Node>> pathListWitoutTrap;

	public List<Stack<Node>> findAllPathsWithoutTrap(Graph G, Node s, Node t, Set<Node> traps) {
		pathListWitoutTrap = new ArrayList<Stack<Node>>();

		return enumerateWitoutTrap(G, s, t, traps);
	}

	// use DFS
	private static List<Stack<Node>> enumerateWitoutTrap(Graph G, Node v, Node t, Set<Node> traps) {

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

				pathListWitoutTrap.add(tempPath);
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
		return pathListWitoutTrap;
	}

	public Set<Node> lunchLocationWithoutTrap(Graph G, Node s, Node t, Set<Node> nodes) {
		List<Stack<Node>> pathForLunch = findAllPathsWithoutTrap(G, s, t, nodes);

		Set<Node> lunchLocation = new HashSet<Node>();

		for (Stack<Node> stack : pathForLunch) {
			while (!stack.isEmpty())
				lunchLocation.add((Node) stack.pop());
		}
		return lunchLocation;
	}

	@Override
	public Set<Node> combineLunchLocation(List<Set<Node>> nodes) {

		Set<Node> lunchLocation = new HashSet<Node>();

		for (Set<Node> list : nodes) {
			if (!list.isEmpty())
				lunchLocation.addAll(list);
		}
		return lunchLocation;
	}

	@Override
	public Node getNodeByName(String string) {
		Set<Node> nodes = graph.getNodes();
		for(Node node:nodes){
			if(node.equalsByName(string))
				return node;
		}
		return null;
	}

}
