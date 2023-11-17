package dabney;

public class Node {

	// CLASS ATTRIBUTES
	public String str;
	public Node left;
	public Node right;
	
	// CONSTRUCTOR
	public Node(String str) {
		this.str = str;
		left = null;
		right = null;
	}
	
	// DISPLAY THE NODE
	public String toString() {
		return str;
	}
}
