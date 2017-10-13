package allpaths;

import java.util.Arrays;

public class Node {
	
	Node(String name){
		this.name=name;
	}

	private String name;

	Node[] adjacent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node[] getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(Node[] adjacent) {
		this.adjacent = adjacent;
	}

	@Override
	public String toString() {
		return name;
	}
}
