package lunch_draft.domain;

import java.util.Arrays;
import java.util.List;

public class Graph {

	List<Node> nodes;

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes2) {
		this.nodes = nodes2;
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + "]";
	}


	

}
