package the.bhushan.models;

import the.bhushan.core.Utils;

public class Edge {
	private final Vertex source;
	private final Vertex destination;
	private final int weight;

	public Edge(Vertex source, Vertex destination, int weight) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	public Edge(Vertex source, Vertex destination) {
		this.source = source;
		this.destination = destination;
		this.weight = Utils.findDist(source, destination);
	}

	public Vertex getDestination() {
		return destination;
	}

	public Vertex getSource() {
		return source;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

}