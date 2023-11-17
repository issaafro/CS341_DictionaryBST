package dabney;

public class DictionaryTest {

	public static void main(String[] args) {
		
		// TEST CASES
		// Case 1: An empty BST is created
		Dictionary dictionary = new Dictionary();
		assert dictionary.isEmpty(): "Case 1 FAILED, dictionary BST is not empty.";
		
		// Case 2: A single node is added which root points to
		dictionary.addNode("ghost");
		assert dictionary.root.str.equals("ghost"): "Case 2 FAILED, root does not point "
				+ "to single node.";
		
		// Case 3: A leaf root node is deleted, the tree is now empty
		dictionary.checkWord("ghost");
		assert dictionary.isEmpty(): "Case 3 FAILED, node was not deleted.";
		
		// If everything works, populate dictionary tree with words.
		dictionary.addNode("donut");
		dictionary.addNode("apple");
		dictionary.addNode("froyo");
		dictionary.addNode("lamb");
		dictionary.addNode("icee");
		dictionary.addNode("nougat");
		
		System.out.println("Successful!");
		// Test spellcheck()
		System.out.println(dictionary.spellCheck("apple"));
		
	}

}
