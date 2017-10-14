package lunch_submit.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {

	public Node(String name) {
		this.name = name;
		adjacent=new HashSet<Node>();
	}

	private State state;
	private String name;

	Set <Node> adjacent;

	public State getState() {

		return state;
	}

	public void setState(State visited) {

		state = visited;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Node>getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(Set<Node> adjacent) {
		this.adjacent = adjacent;
	}

	@Override
	public String toString() {
		return  name;
	}

}
