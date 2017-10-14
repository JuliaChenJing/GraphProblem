package lunch_submit.app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.tools.StandardLocation;

import lunch_submit.domain.Graph;
import lunch_submit.domain.Node;
import lunch_submit.service.GraphService;
import lunch_submit.service.impl.GraphServiceImpl;

public class IO {

	public static Scanner in; // for standard input
	static GraphService graphService;
	static Graph graph;
	static Set<Node> avoidLocation;
	static Set<Node> peggyStartLocation;
	static Set<Node> samStartLocation;

	public static void main(String[] args) {

		graph = new Graph();
		in = new Scanner(System.in);
		graphService = new GraphServiceImpl();
		avoidLocation = new HashSet<Node>();
		peggyStartLocation = new HashSet<Node>();
		samStartLocation = new HashSet<Node>();
		String line = "";

		// Input the graph:
		System.out.println("Please input the sample input in the pdf:");
		System.out.println("Map:");
		while (!line.equalsIgnoreCase("avoid") || !line.equalsIgnoreCase("avoid:")) {
			line = in.nextLine();
			saveMap(line);
		}

		System.out.println(graph);

		System.out.println("\nPlease input the avoid location:");

		while (!line.equalsIgnoreCase("peggy") || !line.equalsIgnoreCase("peggy:")) {
			line = in.nextLine();
			saveAvoidLocation(line);
		}

		System.out.println("Avoid Location: " + samStartLocation);

		System.out.println("Please input Peggy's start locations:");
		while (!line.equalsIgnoreCase("sam") || !line.equalsIgnoreCase("sam:")) {
			line = in.nextLine();
			savePeggyLocation(line);

		}
		System.out.println("Peggy Start Location: " + samStartLocation);

		System.out.println("Please input Sam's start locations(if finish, type 0)");
		while (!line.equalsIgnoreCase("end") || !line.equalsIgnoreCase("end:")) {
			line = in.nextLine();
			saveSamLocation(line);
		}
		System.out.println("Sam Start Location: " + samStartLocation);
	}

	private static void saveMap(String string) {
		String[] parts = string.split(" ");
		if (parts.length == 2) {
			String part1 = parts[0];
			String part2 = parts[1];
			Set<Node> graphNodes = graph.getNodes();
			Node node1 = new Node(part1);
			graphNodes.add(node1);
			Node node2 = new Node(part2);
			graphNodes.add(node2);
			node1.getAdjacent().add(node2);
			System.out.println("mapping saved : " + part1 + "-->" + part2);

		} else if (string.equalsIgnoreCase("avoid") || string.equalsIgnoreCase("avoid:"))
			return;
		else
			System.out.println("please input a right format mapping, or input Avoid");

	}

	private static void saveAvoidLocation(String string) {
		String[] parts = string.split(" ");

		if (parts.length == 1) {
			String part1 = parts[0];
			if (string.equalsIgnoreCase("peggy") || string.equalsIgnoreCase("peggy:"))
				return;

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
		String[] parts = string.split(" ");

		if (parts.length == 1) {
			String part1 = parts[0];
			if (string.equalsIgnoreCase("sam") || string.equalsIgnoreCase("sam:"))
				return;

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

		String[] parts = string.split(" ");

		if (parts.length == 1) {
			String part1 = parts[0];
			if (string.equalsIgnoreCase("end") || string.equalsIgnoreCase("end:"))
				return;

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
