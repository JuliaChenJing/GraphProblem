package lunch_submit.domain;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	
	public Graph(){
		nodes=new HashSet<Node>();
	}

	Set <Node> nodes;

	public Set <Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes2) {
		this.nodes = nodes2;
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + "]";
	}


	

}
