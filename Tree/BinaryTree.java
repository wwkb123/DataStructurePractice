package practice;
import java.util.*;

public class BinaryTree {
	Node root;
	
	public BinaryTree() {
		root = null;
	}

	public BinaryTree(int data){
		root = new Node(data);
	}
	
	public Node search(int data){
		return searchRec(root, data);
	}
	
	public Node searchRec(Node node, int data){
		if(node==null || node.data == data) return node;
		if(data > node.data){
			return searchRec(node.right,data);
		}else{
			return searchRec(node.left,data);
		}
	}
	
	public void insert(int data){
		if(root==null) root = new Node(data);
		insertRec(root,data);
	}
	
	public void insertRec(Node node,int data){
		if(data>node.data){
			if(node.right!=null){
				insertRec(node.right,data);
			}else{
				node.right = new Node(data);
			}
			
		}else if(data < node.data){
			if(node.left!=null){
				insertRec(node.left,data);
			}else{
				node.left = new Node(data);
			}
		}
	}
		
	public void printInOrder(){
		if(root==null) return;
		printInOrderRec(root);
	}
	
	public void printInOrderRec(Node node){
		if (node.left!=null){
			printInOrderRec(node.left);
		}
		
		System.out.println(node.data);
		
		if (node.right!=null){
			printInOrderRec(node.right);
		}
	}
	public void printPreOrder(){
		if(root==null) return;
		printPreOrderRec(root);
	}

	public void printPreOrderRec(Node node){
		System.out.println(node.data);
		if(node.left!=null){
			printPreOrderRec(node.left);
		}
		if(node.right!=null){
			printPreOrderRec(node.right);
		}
		
	}
	
	public void printPostOrder(){
		if(root==null) return;
		printPostOrderRec(root);
	}
	
	public void printPostOrderRec(Node node){
		if(node.left!=null){
			printPostOrderRec(node.left);
		}
		if(node.right!=null){
			printPostOrderRec(node.right);
		}
		
		System.out.println(node.data);
	}
	
	public void breadthFirstOrder(){
		if(root == null) return;
		Queue q = new Queue();
		q.push(root);
		while(q.size() > 0){
			Node node = q.pop();
			System.out.println(node.data);
			q.push(node.left);
			q.push(node.right);
		}
	}
	
	public void printTree(int height){
			if(root == null) return;
			Queue<Node> q = new LinkedList<Node>();
			Node curr = root;
			q.add(curr);
			int nodeCount = 0;
			int level = 0;
	

			while(q.size() > 0 && level <= height){
				Node n = q.remove();
				nodeCount++;
				
				printSpace(height*(height-level)); //
				
				if(n != null){
					
					System.out.print(n.data);
					printSpace(height);   //
					q.add(n.left);
					q.add(n.right);
					
				}
				else{
					
					System.out.print("*");
					
				}
				if(nodeCount % 2 == 0) printSpace(height); //
				
				if(nodeCount == (int)Math.pow(2, level)){
					nodeCount = 0;
					System.out.println("");
					level++;
				}
			}
		}
		
		public void printSpace(int number){
			while(number > 0){
				System.out.print(" ");
				number--;
			}
		}

	
}
