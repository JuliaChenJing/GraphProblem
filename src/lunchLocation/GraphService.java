package lunchLocation;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;



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
	
	
    private static Stack<Node>  path  = new Stack<Node>();   // the current path
    private static Set<Node>  onPath  = new HashSet<Node>();     // the set of vertices on the path

    public static void  findAllPaths(Graph G, Node s, Node t) {
        enumerate(G, s, t);
    }

    // use DFS
    private static void enumerate(Graph G,Node v, Node t) {

        // add node v to current path from s
        path.push(v);
        onPath.add(v);

        // found path from s to t - currently prints in reverse order because of stack
        if (v.equals(t)) 
            System.out.println(path);

        // consider all neighbors that would continue path with repeating a node
        else {
            for (Node w : v.getAdjacent()) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }

        // done exploring from v, so remove from path
        path.pop();
        onPath.remove(v);
    }

}
