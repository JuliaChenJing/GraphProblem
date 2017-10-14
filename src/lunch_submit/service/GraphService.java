package lunch_submit.service;

import java.util.List;
import java.util.Set;
import java.util.Stack;
import lunch_submit.domain.*;


public interface GraphService {
	

	public Set<Node> lunchLocationWithoutTrap(Graph G, Node s,Node t, List <Node> nodes);
}
