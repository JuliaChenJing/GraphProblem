package lunchLocation.app;

import java.util.Scanner;

public class IO {

	public static Scanner in; // for standard input

	public static void main(String[] args) {
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
			System.out.println(line);
		}
		System.out.println("Please input Peggy's start locations:");
		while (!line.equals("Sam:")) {
			line = in.nextLine();
			System.out.println(line);
		}
		
		System.out.println("Please input Sam's start locations(if finish, type 0)");
		while (line != "0") {
			line = in.nextLine();
			System.out.println(line);
		}
	}

}
