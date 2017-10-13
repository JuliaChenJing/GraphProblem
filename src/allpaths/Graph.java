package allpaths;

import java.util.Arrays;

public class Graph {
	
	Node[] nodes;

	Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "Graph [nodes=" + Arrays.toString(nodes) + "]";
	}
	
}
