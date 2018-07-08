
public class TrieApp {

	public static void main(String[] args) {
		Trie t = new Trie();
		
		t.insert("Hello");
		t.insert("Tommy");
		t.insert("Eva");
		t.insert("Hal");
		
		System.out.println(t.startsWith("Ha"));
		t.printAllTrie();
	}

}
