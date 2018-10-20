package the.bhushan.core;

import java.util.ArrayList;
import java.util.List;

import the.bhushan.models.Edge;
import the.bhushan.models.Vertex;

public class EdgeBuilder {

	public static List<Edge> build(Vertex src, Vertex dest, List<Edge> ladders) {
		List<Edge> allEdges = new ArrayList<>();
		// src to dest edge
//		Edge directPath = new Edge(src, dest);
//		allEdges.add(directPath);
		// src to nearest ladder path
		for (Edge ladder : ladders) {
			if (Utils.findDist(src, ladder.getSource()) < Utils.findDist(src, ladder.getDestination())) {
				allEdges.add(new Edge(src, ladder.getSource()));
			} else {
				allEdges.add(new Edge(src, ladder.getDestination()));
			}
		}
		// ladder's both endpoints to destination
		for (Edge ladder : ladders) {
			allEdges.add(new Edge(ladder.getSource(), dest));
			allEdges.add(new Edge(ladder.getDestination(), dest));
		}
		// ladder's both endpoints to other ladder's endpoint
		for (Edge ladderOuter : ladders) {
			for (Edge ladderInner : ladders) {
				if (!ladderOuter.equals(ladderInner)) {
					allEdges.add(new Edge(ladderOuter.getSource(), ladderInner.getSource()));
					allEdges.add(new Edge(ladderOuter.getDestination(), ladderInner.getSource()));
					allEdges.add(new Edge(ladderOuter.getSource(), ladderInner.getDestination()));
					allEdges.add(new Edge(ladderOuter.getDestination(), ladderInner.getDestination()));
				}
			}
		}
		// finally add all ladder as edges
		allEdges.addAll(ladders);
		System.out.println("Size of all edges: " + allEdges.size());
		return allEdges;
	}
}
