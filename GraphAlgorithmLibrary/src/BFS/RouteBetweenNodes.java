package bfs;

import java.util.LinkedList;

/*
 *  Given a directed graph, design an algorithm to find out whether 
 *  there is a route between two nodes.
 */
public class RouteBetweenNodes {

	public enum State {
		Unvisited, Visited, Visiting;
	}

	/*
	 * 
	 * This problem can be solved by just simple graph traversal, such as depth
	 * first search or breadth first search. We start with one of the two nodes
	 * and, during traversal, check if the other node is found. We should mark
	 * any node found in the course of the algorithm as "already visited" to
	 * avoid cycles and repetition of the nodes.
	 */

	public static boolean search(Graph graph, Node from, Node to) {

		LinkedList<Node> returnlist = new LinkedList<Node>(); // operates as
																// Stack

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

	class Graph {
		Node[] nodes;

		Node[] getNodes() {
			return nodes;
		}
	}

	class Node {
		private State state;

		public Node[] getAdjacent() {
			// TODO Auto-generated method stub
			return null;
		}

		public State getState() {
			// TODO Auto-generated method stub
			return state;
		}

		public void setState(State visited) {

			state = visited;

		}

	}
}
