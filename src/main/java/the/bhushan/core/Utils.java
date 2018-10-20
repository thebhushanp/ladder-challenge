package the.bhushan.core;

import the.bhushan.models.Vertex;

public class Utils {

	public static Integer findDist(Vertex v1, Vertex v2) {
		Integer x = v1.x - v2.x;
		Integer y = v1.y - v2.y;
		return Math.abs(x) + Math.abs(y);
	}

}
