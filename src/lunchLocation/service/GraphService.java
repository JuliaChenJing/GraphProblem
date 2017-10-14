package lunchLocation.service;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import lunchLocation.domain.Graph;
import lunchLocation.domain.Node;

public interface GraphService {
	

	public boolean visitable(Graph graph, Node from, Node to);
	public void printAllPaths(Graph G, Node s, Node t);
	public List<Stack<Node>> findAllPaths(Graph G, Node s, Node t);
	public List<Stack<Node>> findAllPathsWithoutTrap(Graph G, Node s, Node t, List <Node> traps);
	public Set<Node> lunchLocation(Graph G, Node s, Node t);
	public Set<Node> lunchLocationWithoutException(Graph G, Node s,Node t, List <Node> nodes);
	public Set<Node> lunchLocationWithoutTrap(Graph G, Node s,Node t, List <Node> nodes);
}
