package lunchLocation.domain;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public Node(String name) {
		this.name = name;
		adjacent=new ArrayList<Node>();
	}

	private State state;
	private String name;

	List <Node> adjacent;

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

	public List<Node>getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(List<Node> adjacent) {
		this.adjacent = adjacent;
	}

	@Override
	public String toString() {
		return  name;
	}

}
