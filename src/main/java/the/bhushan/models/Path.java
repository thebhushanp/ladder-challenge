package the.bhushan.models;

import java.util.ArrayList;
import java.util.List;

public class Path {
	private List<Edge> path = new ArrayList<>();
	private Integer distance = 0;

	public boolean addEdge(Edge edge) {
		// check cyclic reference
		for (Edge node : path) {
			if (node.getSource().equals(edge.getDestination())) {
				return false;
			}
			if (node.getDestination().equals(edge.getDestination())) {
				return false;
			}
		}
		path.add(edge);
		distance = distance + edge.getWeight();
		return true;
	}

	public Integer getDistance() {
		return distance;
	}

	public Vertex last() {
		return path.get(path.size() - 1).getDestination();
	}

	public static Path getClone(Path path) {
		Path newPath = new Path();
		newPath.distance = path.distance;
		newPath.path = new ArrayList<>(path.path);
		return newPath;
	}

	@Override
	public String toString() {
		return path.toString();
	}
}
