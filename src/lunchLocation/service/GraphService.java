package lunchLocation.service;

import lunchLocation.domain.Graph;
import lunchLocation.domain.Node;

public interface GraphService {
	public void findAllPaths(Graph G, Node s, Node t);

	public boolean visitable(Graph graph, Node from, Node to);
}
