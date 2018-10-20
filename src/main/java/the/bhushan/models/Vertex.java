package the.bhushan.models;

public class Vertex {
	public final Integer x;
	public final Integer y;

	public Vertex(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Vertex other = (Vertex) obj;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		return true;
//	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}