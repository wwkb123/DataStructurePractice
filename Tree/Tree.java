
public class Tree {

	TreeNode root;
	
	public Tree() {
		root = null;
	}

	public void insert(int data){
		if(root == null){
			root = new TreeNode(data);
		}else{
			root.insert(data);
		}
	}
	
	public boolean contains(int data){
		if(root == null){
			return false;
		}else{
			return root.contains(data);
		}
	}
	
	public void printInOrder(){
		root.printInOrder();
	}
	
	public void printPreOrder(){
		root.printPreOrder();
	}
	
	public void printPostOrder(){
		root.printPostOrder();
	}
	
	
}
