package lunch_submit.app;

import java.util.Scanner;
import java.util.Set;

import lunch_submit.domain.Graph;
import lunch_submit.domain.Node;
import lunch_submit.service.GraphService;
import lunch_submit.service.impl.GraphServiceImpl;

public class IO {

	public static Scanner in; // for standard input
	static GraphService  graphService = new GraphServiceImpl();
	static Graph graph=new Graph();

	public static void main(String[] args) {
		
		saveSamLocation("a1 b1");
		in = new Scanner(System.in);
		String line = "";

		// Input the graph:
		System.out.println("Please input the sample input in the pdf:");
		System.out.println("Map:");
		while (!line.equals("Avoid:")) {
			line = in.nextLine();
			System.out.println(line);
		}
		
		System.out.println("Please input the avoid location:");

		while (!line.equals("Peggy:")) {
			line = in.nextLine();
			saveMap(line);
			System.out.println(line);
		}
		System.out.println("Please input Peggy's start locations:");
		while (!line.equals("Sam:")) {
			line = in.nextLine();
			savePeggyLocation(line);
			System.out.println(line);
		}
		
		System.out.println("Please input Sam's start locations(if finish, type 0)");
		while (line != "0") {
			line = in.nextLine();
			saveSamLocation(line);
			System.out.println(line);
		}
	}

	private static void saveSamLocation(String string) {
		String[] parts = string.split(" ");
		String part1 = parts[0]; 
		String part2 = parts[1];
		Set<Node> graphNodes = graph.getNodes();
		graph.getNodes().add(new Node(part1));
		
		
		
	}

	private static void savePeggyLocation(String string) {
		String[] parts = string.split(" ");
		String part1 = parts[0]; 
		String part2 = parts[1];
		
	}

	private static void saveMap(String string) {
		String[] parts = string.split(" ");
		String part1 = parts[0]; 
		String part2 = parts[1];
		
	}

}
