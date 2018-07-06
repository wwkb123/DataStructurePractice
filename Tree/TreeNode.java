
public class TreeNode {

	TreeNode left,right;
	int data;
	
	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
	public void insert(int input){
		if(input<=data){
			if(left!=null){
				left.insert(input);
			}else{
				left = new TreeNode(input);
			}
		}else{
			if(right!=null){
				right.insert(input);
			}else{
				right = new TreeNode(input);
			}
		}
	}
	
	public boolean contains(int input){
		if(input==data){
			return true;
		}else if(input < data){
			if(left==null){
				return false;
			}else{
				return left.contains(input);
			}
		}else{
			if(right == null){
				return false;
			}else{
				return right.contains(input);
			}
		}
	}
	
	public void printInOrder(){
		if(left!=null){
			left.printInOrder();
		}
		System.out.println(data);
		if(right!=null){
			right.printInOrder();
		}
	}
	
	public void printPreOrder(){
		System.out.println(data);
		if(left!=null){
			left.printPreOrder();
		}
		if(right!=null){
			right.printPreOrder();
		}
	}
	
	public void printPostOrder(){
		if(left!=null){
			left.printPostOrder();
		}
		if(right!=null){
			right.printPostOrder();
		}
		System.out.println(data);
	}

}
