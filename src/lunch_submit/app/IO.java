package lunch_submit.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lunch_submit.domain.Graph;
import lunch_submit.domain.Node;
import lunch_submit.service.GraphService;
import lunch_submit.service.impl.GraphServiceImpl;

public class IO {

	public static Scanner in; // for standard input
	static GraphService graphService;
	static Set<Node> avoidLocation;
	static Set<Node> peggyStartLocation;
	static Set<Node> samStartLocation;
	static Graph graph;

	public static void main(String[] args) {

		graphService = new GraphServiceImpl();
		graph = graphService.getGraph();
		avoidLocation = new HashSet<Node>();
		peggyStartLocation = new HashSet<Node>();
		samStartLocation = new HashSet<Node>();
		inputData();

		outputResult();
	}

	private static void outputResult() {

		List<Set<Node>> nodes = new ArrayList<Set<Node>>();
		for (Node peggyNode : peggyStartLocation)
			for (Node samNode : samStartLocation) {
				System.out.println("Avoid Location: " + avoidLocation);
				System.out.println("Peggy: " + peggyStartLocation);
				System.out.println("Sam: " + samStartLocation);

				System.out.println("peggy node adjacent: " + peggyNode.getAdjacent());
				Set<Node> set = graphService.lunchLocationWithoutTrap(graph, peggyNode, samNode, avoidLocation);
				System.out.println("part of the result: " + set);
				nodes.add(set);
			}

		Set<Node> result = graphService.combineLunchLocation(nodes);
		System.out.println("sample output: " + result);
	}

	private static void inputData() {
		in = new Scanner(System.in);
		String line = "";

		// Input the graph:
		System.out.println("Please input the sample input in the pdf:");
		System.out.println("Map:");
		while (!(line.equalsIgnoreCase("avoid") || line.equalsIgnoreCase("avoid:"))) {
			line = in.nextLine();
			saveMap(line);
		}

		System.out.println(graph);
		for (Node node : graph.getNodes()) {
			System.out.println(node + "'s adjacents are :" + node.getAdjacent());
		}

		System.out.println("\nPlease input the avoid location:");

		while (!(line.equalsIgnoreCase("peggy") || line.equalsIgnoreCase("peggy:"))) {
			line = in.nextLine();
			saveAvoidLocation(line);
		}

		System.out.println("Avoid Location: " + avoidLocation);

		System.out.println("Please input Peggy's start locations:");
		while (!(line.equalsIgnoreCase("sam") || line.equalsIgnoreCase("sam:"))) {
			line = in.nextLine();
			savePeggyLocation(line);

		}
		System.out.println("Peggy Start Location: " + peggyStartLocation);

		System.out.println("Please input Sam's start locations(if finish, type end)");
		while (!(line.equalsIgnoreCase("end") || line.equalsIgnoreCase("end:"))) {
			line = in.nextLine();
			saveSamLocation(line);
		}
		System.out.println("Sam Start Location: " + samStartLocation);
	}

	private static void saveMap(String string) {

		if (string.equalsIgnoreCase("avoid") || string.equalsIgnoreCase("avoid:"))
			return;
		String[] parts = string.split(" ");

		if (parts.length == 2) {
			String part1 = parts[0];
			String part2 = parts[1];
			Set<Node> graphNodes = graph.getNodes();
			System.out.println("previous nodes inside :"+graphNodes);
			
			Node node1;
			if (graphService.getNodeByName(part1) == null) {
				node1 = new Node(part1);
				graphNodes.add(node1);
			}

			else
				node1 = graphService.getNodeByName(part1);

			Node node2;
			if (graphService.getNodeByName(part2) == null) {
			
				node2 = new Node(part2);
				graphNodes.add(node2);

			} else
				node2 = graphService.getNodeByName(part2);
			Set<Node> adjacent = node1.getAdjacent();
			adjacent.add(node2);
		
		}
		
	}

	private static void saveAvoidLocation(String string) {

		if (string.equalsIgnoreCase("peggy") || string.equalsIgnoreCase("peggy:"))
			return;
		String[] parts = string.split(" ");
		if (parts.length == 1) {
			String part1 = parts[0];

			Node node1 = new Node(part1);
			Set<Node> graphNodes = graph.getNodes();
			if (graphNodes.contains(node1)) {
				avoidLocation.add(node1);
				System.out.println("avoid location saved : " + part1);
			} else

				System.out.println("this location is not in previous mapping, please input another location");
		} else
			System.out.println("please input a right format location, or input Peggy");

	}

	private static void savePeggyLocation(String string) {
		if (string.equalsIgnoreCase("sam") || string.equalsIgnoreCase("sam:"))
			return;
		String[] parts = string.split(" ");

		if (parts.length == 1) {
			String part1 = parts[0];

			Node node1 = new Node(part1);
			Set<Node> graphNodes = graph.getNodes();
			if (graphNodes.contains(node1)) {
				peggyStartLocation.add(node1);
				System.out.println("Peggy's location saved : " + part1);
			} else
				System.out.println("this location is not in previous mapping, please input another location");
		} else
			System.out.println("please input a right format location, or input Sam");
	}

	private static void saveSamLocation(String string) {
		if (string.equalsIgnoreCase("end") || string.equalsIgnoreCase("end:"))
			return;

		String[] parts = string.split(" ");

		if (parts.length == 1) {
			String part1 = parts[0];

			Node node1 = new Node(part1);
			Set<Node> graphNodes = graph.getNodes();
			if (graphNodes.contains(node1)) {
				samStartLocation.add(node1);
				System.out.println("Sam's  location saved : " + part1);
			} else
				System.out.println("this location is not in previous mapping, please input another location");
		} else
			System.out.println("please input a right format location, or input End");
	}
}
