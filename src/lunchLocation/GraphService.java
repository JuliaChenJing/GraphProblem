package lunchLocation;
import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class GraphService {

	public static boolean visitable(Graph graph, Node from, Node to) {

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

	public static ArrayList <LinkedList<Node>> visitPath(Graph graph, Node from, Node to) {

		ArrayList <LinkedList<Node>>result=new ArrayList<LinkedList<Node>>();
		
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
							result.add(returnlist);
							returnlist = new LinkedList<Node>();
						} else {
							v.setState(State.Visiting);
							returnlist.add(v);
						}
					}
				}

				u.setState(State.Visited);
			}
		}
		return result;
	}

	public static boolean lunchLocation(Graph graph, Node from, Node to) {

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
}
