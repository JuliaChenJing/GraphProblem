package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchExample {

	/*
	 *http://www.java2blog.com/2015/12/breadth-first-search-in-java.html
	 *
	 * Breadth first search is graph traversal algorithm. In this algorithm,
	 * lets say we start with node i, then we will visit neighbours of i, then
	 * neighbours of neighbours of i and so on. It is very much similar to which
	 * is used in binary tree. We use queue to traverse graph. We put first node
	 * in queue . It repeatedly extracts node and put its neighbours in the
	 * queue. Only difference with respect to binary tree is that we need to
	 * track if node have been visited before or not. It can be easily done with
	 * help of boolean variable visited in the node. If node have been already
	 * visited then we won’t visit it again. Algorithm:
	 * 
	 * 
	 * Steps for Breadth first search: Create empty queue and push root node to
	 * it. Do the following when queue is not empty Pop a node from queue and
	 * print it.
	 * 
	 * Find neighbours of node with the help of adjacency matrix and check if
	 * node is already visited or not. Push neighbours of node into queue if not
	 * null
	 */
	private Queue<Node> queue;
	static ArrayList<Node> nodes = new ArrayList<Node>();

	static class Node {
		int data;
		boolean visited;

		Node(int data) {
			this.data = data;

		}
	}

	public BreadthFirstSearchExample() {
		queue = new LinkedList<Node>();
	}

	// find neighbors of node using adjacency matrix
	// if adjacency_matrix[i][j]==1, then nodes at index i and index j are
	// connected
	public ArrayList<Node> findNeighbours(int adjacency_matrix[][], Node x) {
		int nodeIndex = -1;

		ArrayList<Node> neighbours = new ArrayList<Node>();
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).equals(x)) {
				nodeIndex = i;
				break;
			}
		}

		if (nodeIndex != -1) {
			for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
				if (adjacency_matrix[nodeIndex][j] == 1) {
					neighbours.add(nodes.get(j));
				}
			}
		}
		return neighbours;
	}

	public void bfs(int adjacency_matrix[][], Node node) {
		queue.add(node);
		node.visited = true;
		while (!queue.isEmpty()) {

			Node element = queue.remove();
			System.out.print(element.data + "\t");
			ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if (n != null && !n.visited) {
					queue.add(n);
					n.visited = true;

				}
			}

		}
	}

	public static void main(String arg[]) {

		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		int adjacency_matrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};
		System.out.println("The BFS traversal of the graph is ");
		BreadthFirstSearchExample bfsExample = new BreadthFirstSearchExample();
		bfsExample.bfs(adjacency_matrix, node40);

	}
}