import java.util.LinkedList;

class Graph {

	Node[] nodes;

	Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

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

}
