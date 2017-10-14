package lunch_submit.domain;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private State state;
	private String name;

	Set<Node> adjacent;

	
	public Node(String name) {
		this.name = name;
		adjacent = new HashSet<Node>();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




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

	public Set<Node> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(Set<Node> adjacent) {
		this.adjacent = adjacent;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean equalsByName(String string) {

		if (name == string)
			return true;
		else
			return false;
	}

}
