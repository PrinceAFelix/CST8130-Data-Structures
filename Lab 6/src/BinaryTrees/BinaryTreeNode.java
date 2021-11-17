package BinaryTrees;

public class BinaryTreeNode {

	//Variables
	private int data;
	private BinaryTreeNode left; //Left Node
	private BinaryTreeNode right; //Right Node
	
	//No-arg constructor
	BinaryTreeNode(){}
	
	//Parameterized constructor
	BinaryTreeNode(int data){
		left = null;
		right = null;
		this.data = data;
	}
	
	//Getters method
	public int getData() {
		return data;
	}
	//Getters method
	public BinaryTreeNode getLeft() {
		return left;
	}
	//Getters method
	public BinaryTreeNode getRight() {
		return right;
	}
	
	//This method insert a new node into a binary tree
	public void insert(int newData) {
		if (newData < data) { //if larger than root
			if (left == null)//If left is empty
				left = new BinaryTreeNode(newData); //Initialize left as the subtree
			else //else insert left recursively
				left.insert(newData);
		}else if(newData > data) { //if larger than root
			if (right == null) //if right is empty
				right  = new BinaryTreeNode(newData); //Initialize right as the subtree
			else
				right.insert(newData);
		}else //If there's a duplicate
			System.out.println("Duplicate - Can't add " + newData);
	}

	
	
	
}
