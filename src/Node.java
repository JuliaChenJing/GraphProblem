
class Node {

	Node(String name) {
		this.name = name;
	}

	private State state;
	private String name;

	Node[] adjacent;

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

	public Node[] getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(Node[] adjacent) {
		this.adjacent = adjacent;
	}

	@Override
	public String toString() {
		return  name;
	}

}
