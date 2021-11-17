package BinaryTrees;

public class BinaryTree {
	
	//Binary Tree Node
	BinaryTreeNode root = null;

	//This method inserts a new node in the Tree
	public void insertInTree(int newData) {
		if (root == null) //If node is empty, set the root to the first data
			root = new BinaryTreeNode(newData);
		else //Else call the insert data
			root.insert(newData);
	}
	
	//This method calls the displayHeight function to display the height
	public void displayHeight() {
		System.out.println("Tree Height\n" + displayHeight(root));
	}
	
	//This method calculate the height of the tree recursively
	public int displayHeight(BinaryTreeNode root) {
		if (root == null)
			return 0;
		else {
			
			//Calculate the height of both left and right (subroot)
			int left = displayHeight(root.getLeft());
			int right = displayHeight(root.getRight());
			
			//Calculate the largest then add 1 to it to add the root
			return Math.max(left, right) + 1;
		}
	}
	
	//This method calls displayOrder function to display the binary tree in order
	public void displayInOrder() {
		System.out.println("Tree Traversal");
		displayInOrder(root);
		System.out.println();
	}
	
	//This method recursively display the binary tree in order
	public void displayInOrder(BinaryTreeNode subRoot) {
		if (subRoot == null)
			return;
		//Left is printed first, then root, the right subtree
		displayInOrder(subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder(subRoot.getRight());
		
	}
		
}
	
	
	
	

