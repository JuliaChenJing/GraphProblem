package allpaths;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class AllPaths{

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

    public static void main(String [] args) {
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
        System.out.println(graph);
        findAllPaths(graph, a2, c2);
        System.out.println();
        findAllPaths(graph, a2, c3);
    }

}