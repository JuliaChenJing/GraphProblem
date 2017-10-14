package lunchLocation.service;

import java.util.List;
import java.util.Stack;

import lunchLocation.domain.Graph;
import lunchLocation.domain.Node;

public interface GraphService {
	

	public boolean visitable(Graph graph, Node from, Node to);
	public void printAllPaths(Graph G, Node s, Node t);
	public List<Stack<Node>> findAllPaths(Graph G, Node s, Node t);
}
