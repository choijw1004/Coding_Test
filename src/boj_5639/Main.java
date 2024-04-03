package boj_5639;

import java.util.Scanner;

public class Main {
	static int input;

	static class Node {
		int key;
		Node leftNode;
		Node rightNode;
	}

	Node root;

	public Main() {
		root = null;
	}

	public Node insertNode(Node root, int key) {
		if (root == null) {
			Node newNode = new Node();
			newNode.key = key;
			return newNode;
		}

		if (key < root.key) {
			root.leftNode = insertNode(root.leftNode, key);
		} else if (key > root.key) {
			root.rightNode = insertNode(root.rightNode, key);
		}

		return root;
	}

	public void postTraverse(Node tree) {
		if (tree != null) {
			postTraverse(tree.leftNode);
			postTraverse(tree.rightNode);
			System.out.println(tree.key);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Main tree = new Main();

		Node root = tree.root;


		while (sc.hasNext()) {
			input = sc.nextInt();
			if (input == 0)
				break;
			root = tree.insertNode(root, input);
		}

		tree.postTraverse(root);
		sc.close();
	}
}
