package lunch_submit.domain;

import java.util.Set;

public class Graph {

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
