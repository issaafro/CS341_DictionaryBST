package dabney;

public class Dictionary {

	// CLASS ATTRIBUTES
	public Node root;
	
	// CONSTRUCTOR
	public Dictionary() {
		root = null;
	}
	
	// ADD A NODE
	public void addNode(String word) {
		Node temp = new Node(word);
		assert (!nodeExists(root, temp)): "Node already exists.";
		
		// Scenario 1: The tree is empty.
		if(root == null)
			root = temp;
			
		// Scenario 2: Insert Node at correct spot
		else {
			insertWordNode(root, temp);
		}
		assert (nodeExists(root, temp)): "Node was not added.";
	}
	
	
	// INORDER TRAVERSAL
	public void insertWordNode(Node myRoot, Node temp) {
		while(true) {
			// Scenario 1: IGNORE DUPLICATE WORDS
			if(temp.toString().compareTo(myRoot.toString()) == 0)
				return;
			
			// Scenario 2: TRAVEL TO THE LEFT SIDE
			if(temp.toString().compareTo(myRoot.toString()) <= -1) {
				if(myRoot.left != null)
					myRoot = myRoot.left;
				else {
					myRoot.left = temp;
					break;
				}
			}
			
			// Scenario 3: TRAVEL TO THE RIGHT SIDE
			else {
				if(myRoot.right != null)
					myRoot = myRoot.right;
				else {
					myRoot.right = temp;
					break;
				}
			}
		}
	}	
	
	public void inOrder() {
		inOrderRecursive(root);
	}
	
	private void inOrderRecursive(Node myRoot) {
		if(myRoot != null) {
			inOrderRecursive(myRoot.left);
			System.out.println(myRoot.toString());
			inOrderRecursive(myRoot.right);
		}
	}
	
	// SPELLCHECK() METHOD
	public Boolean spellCheck(String word) {
		Node temp = new Node(word);
		Node myRoot = root;
		while(true) {
			if(myRoot == null)
				return false;
			if(temp.toString().compareTo(myRoot.toString()) == 0)
				return true;
			else if(temp.toString().compareTo(myRoot.toString()) <= -1)
				myRoot = myRoot.left;
			else if(temp.toString().compareTo(myRoot.toString()) >= 1)
				myRoot = myRoot.right;
		}
	}
	
	// CHECKWORD() (DELETE) METHOD
	public void checkWord(String del) {
		Node delete = new Node(del);
		assert nodeExists(root, delete): "Node does not exist.";
		root = deleteWord(root, del);
		assert !nodeExists(root, delete): "Node still exists.";
		
	}
	
	// HELPER METHOD
	private Node deleteWord(Node myRoot, String del) {
		Node toDelete = new Node(del);
		if(myRoot == null)
			return myRoot;
		if(myRoot.toString().compareTo(toDelete.toString()) >= 1)
			myRoot.left = deleteWord(myRoot.left, del);
		else if(myRoot.toString().compareTo(toDelete.toString()) <= -1)
			myRoot.right = deleteWord(myRoot.right, del);
		else {
			// Node is a leaf or has a child
			if(myRoot.left == null) 
				return myRoot.right;
			else if(myRoot.right == null)
				return myRoot.left;
			
			myRoot.str = minVal(myRoot.right);
			myRoot.right = deleteWord(myRoot.right, myRoot.str);
		}
		return myRoot;
	}
	
	public String minVal(Node myRoot) {
		String mVal = myRoot.str;
		while(myRoot.left != null) {
			mVal = myRoot.left.str;
			myRoot = myRoot.left;
		}
		return mVal;
	}
	
	// BOOLEAN METHODS
	public boolean nodeExists(Node myRoot, Node x) {
		while(true) {
			if(myRoot == null)
				return false;
			if(x.toString().compareTo(myRoot.toString()) == 0)
				return true;
			else if(x.toString().compareTo(myRoot.toString()) <= -1)
				myRoot = myRoot.left;
			else if(x.toString().compareTo(myRoot.toString()) >= 1)
				myRoot = myRoot.right;
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
}
