import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


 class BST {

	private Node root;
	private String preOrder = "";

	public BST(int value) {
		this.root = new Node(value);
	}

	public String getPreOrder() {
		this.preOrder = this.preOrder.substring(0, this.preOrder.length() - 2);
		this.preOrder += "]";
		return this.preOrder;
	}

	public BST() {
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	public Node add(int value) {
		if (isEmpty()) {
			this.root = new Node(value);
			this.root.setLeft(new Node());
			this.root.setRight(new Node());
			return this.root;
		} else {
			return add(this.root, value);
		}

	}

	private Node add(Node node, int value) {
		Node aux = node;

		Node novoNode = new Node(value);
		novoNode.setLeft(new Node());
		novoNode.setRight(new Node());

		if (value < aux.getValue()) {
			if (aux.getLeft().isNIL()) {
				aux.setLeft(novoNode);
				aux.getLeft().setParent(aux);
				return novoNode;
			} else {
				aux = aux.getLeft();
			}

		} else if (value > aux.getValue()) {

			if (aux.getRight().isNIL()) {
				aux.setRight(novoNode);
				aux.getRight().setParent(aux);
				return novoNode;
			} else {
				aux = aux.getRight();
			}
		}

		return add(aux, value);
	}

	public void preOrder() {
		this.preOrder = "";
		this.preOrder += "[";
		if (!isEmpty()) {
			preOrder(this.root);

		}

	}

	private void preOrder(Node node) {

		if (!node.isNIL()) {
			this.preOrder += Integer.toString(node.getValue());
			this.preOrder += ", ";
			preOrder(node.getLeft());
			preOrder(node.getRight());

		} else {

			return;
		}
	}

	public int BFS(int valor) {
		int maiores = 0;

		Queue<Node> fila = new LinkedList<Node>();

		if (isEmpty()) {
			return maiores;
		} else {
			fila.add(this.root);

			while (!fila.isEmpty()) {
				Node node = (Node) fila.remove();
				
				
				if(node.getValue() > valor && node.getValue() != Integer.MAX_VALUE) {
					maiores++;
				}

				if (node.getLeft() != null) {
					fila.add(node.getLeft());
				}

				if (node.getRight() != null) {
					fila.add(node.getRight());
				}
			}
			return maiores;

		}

	}

	class Node {

		private Node parent;
		private Node left;
		private Node right;
		private int value;

		public Node() {
			this.value = Integer.MAX_VALUE;
		}

		public boolean isNIL() {
			return this.value == Integer.MAX_VALUE;
		}

		public boolean isRoot() {
			return this.parent == null;
		}

		public Node getParent() {
			return this.parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public void setLeft(Node newLeft) {
			this.left = newLeft;
		}

		public void setRight(Node newRight) {
			this.right = newRight;
		}

	}

	public static void main(String[] args) {
		BST nova = new BST();

		Scanner s1 = new Scanner(System.in);

		String entrada = s1.nextLine();
		String[] entradas = entrada.split(" ");

		for (String num : entradas) {
			int entradaInt = Integer.parseInt(num);
			nova.add(entradaInt);
		}

		int entrada2 = s1.nextInt();

		// PREORDER
		nova.preOrder();
		System.out.println(nova.getPreOrder());

		// PRINTANDO O ELEMENTO MAIS PROXIMO DO PESQUISADO
		System.out.println(nova.BFS(entrada2));

	}
}

