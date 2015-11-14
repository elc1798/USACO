import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Evolution {

	static BinaryTreeNode evolution(BinaryTreeNode root, String a, String b) {
		if (root == null) {
			return null;
		}
		if (root.name.equals(a) || root.name.equals(b)) {
			return root;
		}
		BinaryTreeNode left = evolution(root.left, a, b);
		BinaryTreeNode right = evolution(root.right, a, b);
		if (left != null && right != null) {
			return root;
		}
		return (left != null) ? left : right;
	}

	//Class which represents a binary tree
	static class BinaryTreeNode {
		BinaryTreeNode left;
		BinaryTreeNode right;
		String name;
		public String toString() {
			return name;
		}
	}

	//main method for reading input for text files
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("EvolutionIN.txt"));
		ArrayList<Tuple> tupleList = new ArrayList<Tuple>();
		String line = in.nextLine();
		String a = line.split(" ")[0];
		String b = line.split(" ")[1];
		while(in.hasNext()){
			line = in.nextLine();
			if (line.equals("*")) {
				callEvolutionWithList(tupleList, a, b);
				tupleList = new ArrayList<Tuple>();
				line = in.nextLine();
				a = line.split(" ")[0];
				b = line.split(" ")[1];
			}
			else {
				String[] lineArray = line.split(" ");
				tupleList.add(new Tuple(lineArray[1], Integer.parseInt(lineArray[2]), Integer.parseInt(lineArray[3])));
			}
		}
		callEvolutionWithList(tupleList, a, b);
	}
	static void callEvolutionWithList(ArrayList<Tuple> tupleList, String a, String b) {
		ArrayList<BinaryTreeNode> nodeList = new ArrayList<BinaryTreeNode>();
		for (int i = 0; i < tupleList.size(); i++) {
			BinaryTreeNode node = new BinaryTreeNode();
			nodeList.add(node);
		}
		for (int i = 0; i < tupleList.size(); i++) {
			Tuple t = tupleList.get(i);
			BinaryTreeNode node = nodeList.get(i);
			node.left = (t.left < 0) ? null : nodeList.get(t.left);
			node.right = (t.right < 0) ? null : nodeList.get(t.right);
			node.name = t.name;
		}
		System.out.println(evolution(nodeList.get(0), a, b));
	}

	//you can ignore this class
	static class Tuple { 
		final String name; 
		final Integer left; 
		final Integer right; 
		public Tuple(String name, Integer left, Integer right) { 
			this.name = name; 
			this.left = left; 
			this.right = right;
		} 
	} 
}