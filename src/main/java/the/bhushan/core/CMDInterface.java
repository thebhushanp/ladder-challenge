package the.bhushan.core;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import the.bhushan.models.Edge;
import the.bhushan.models.Path;
import the.bhushan.models.Vertex;

public class CMDInterface {

	public static void main(String args[]) {
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		String input = stdin.nextLine();
		List<Integer> intArr = parse(input);
		Vertex src = new Vertex(intArr.get(0), intArr.get(1));
		Vertex dest = new Vertex(intArr.get(2), intArr.get(3));

		List<Edge> ladders = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			input = stdin.nextLine();
			intArr = parse(input);
			Edge ladder = new Edge(new Vertex(intArr.get(0), intArr.get(1)), new Vertex(intArr.get(2), intArr.get(3)),
					10);
			ladders.add(ladder);
		}

		List<Edge> graph = EdgeBuilder.build(src, dest, ladders);
		PathFinder pathFinder = new PathFinder(src, dest, graph);
		pathFinder.shortestPath(src, new Path());
		System.out.println(pathFinder.getShortestPath());
		stdin.close();
	}

	private static List<Integer> parse(String input) {
		return Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
	}
}
