package the.bhushan.core;

import java.util.List;

import the.bhushan.models.Edge;
import the.bhushan.models.Path;
import the.bhushan.models.Vertex;

public class PathFinder {

	private Path shortestPath = new Path();
//	private Vertex src;
	private Vertex dest;
	private List<Edge> allEdges;

	public PathFinder(Vertex src, Vertex dest, List<Edge> allEdges) {
//		this.src = src;
		this.dest = dest;
		this.allEdges = allEdges;
		Edge directPath = new Edge(src, dest);
		shortestPath.addEdge(directPath);
	}

	public void shortestPath(Vertex src, Path path) {
		// find the all edge starting 'src'
 		for (Edge edge : allEdges) {
			if (edge.getSource().equals(src)) {
				Path copyPath = Path.getClone(path);
				if (copyPath.addEdge(edge)) {
					// check if reached destination
					if (copyPath.last().equals(dest)) {
						if (copyPath.getDistance() < shortestPath.getDistance()) {
							shortestPath = copyPath;
						}
						//return;
					} else {
						shortestPath(copyPath.last(), copyPath);
					}
				}
			}
		}
	}

	public Integer getShortestPath() {
		return shortestPath.getDistance();
	}

}
