package service;

import java.util.List;
import java.util.Set;
import domain.*;

public interface GraphService {
	

	public Set<Node> lunchLocationWithoutTrap(Graph G, Node s,Node t, Set <Node> nodes);
	public Set<Node> combineLunchLocation(List<Set <Node>> nodes);
	public Node getNodeByName(String string);
	public Graph getGraph();
}
