import java.util.HashMap;

public class Trie {

	TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word){
		HashMap<Character,TrieNode> children = root.children;
		
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			
			TrieNode t;
			if(children.containsKey(c)){
				t = children.get(c);
			}else{
				t = new TrieNode(c);
				children.put(c, t);
			}
			
			children = t.children;
			
			if(i==word.length()-1){
				t.isWord = true;
			}
		}
	}
	
	 public boolean search(String word) {
		 TrieNode t = searchNode(word);
		 
		 if(t!=null && t.isWord){
			 return true;
		 }else{
			 return false;
		 }
		 
	 }
	 
	  
	 public boolean startsWith(String prefix) { 
		 TrieNode t = searchNode(prefix);
		 
		 if(t==null){
			 return false;
		 }else{
			 return true;
		 }
		 
	 }
	 
	 
	 public TrieNode searchNode(String str){
		 HashMap<Character,TrieNode> children = root.children;
		 TrieNode t = null;
		 
		 
		 for(int i = 0;i<str.length();i++){
			char c = str.charAt(i);
			if(children.containsKey(c)){
				t = children.get(c);
				children = t.children;
			}else{
				return null;
			}
		}
		 
		 
		 return t;
		 
	 }
	 
	 public void printAllTrie(){
		 printTrie(root);
	 }
	 
	 public void printTrie(TrieNode t){
		 HashMap<Character, TrieNode> children = t.children;
		 
		 for(char c :children.keySet()){
			 System.out.print(c);
			 if(children.get(c)!=null){
				 printTrie(children.get(c));
			 }
			 System.out.println("");
		 }
		 
		 
		 
	 }
	 
}
