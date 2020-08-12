
// QUESTAO DO TST EDA DE BST
// http://tst-eda.splab.ufcg.edu.br/#!/app/activity/valor_mais_proximo_bst


import java.util.Scanner;

public class BST {

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
			return this.root;
		} else {
			return add(this.root, value);
		}

	}

	private Node add(Node node, int value) {
		Node aux = node;
		Node novoNode = new Node(value);

		if (value < aux.getValue()) {
			if (aux.getLeft() == null) {
				aux.setLeft(novoNode);
				return novoNode;
			} else {
				aux = aux.getLeft();
			}

		} else if (value > aux.getValue()) {

			if (aux.getRight() == null) {
				aux.setRight(novoNode);
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

		if (node != null) {
			this.preOrder += Integer.toString(node.getValue());
			this.preOrder += ", ";
			preOrder(node.getLeft());
			preOrder(node.getRight());

		} else {

			return;
		}
	}

	public int search(int element) {

		Node aux2 = this.root;
		if (isEmpty()) {
			return -1;
		}

		else {
			return search(this.root, aux2 , element);
		}
	}

	private int search(Node root2, Node node, int element) {
		 
		
		Node aux = root2;
		Node aux2 = node;
		
		if(aux.getLeft() ==  null || aux.getRight() == null) {
			if(Math.abs(aux.getValue()- element) < (Math.abs(aux2.getValue() - element))){
				return aux.getValue();
			}else {
				return aux2.getValue();
			}
		}

		if (aux.getValue() == element) {
			
			return aux.getValue();
		} else {

			if (element < aux.getValue()) {
				aux2 = aux;
				aux = aux.getLeft();
				return search(aux, aux2, element);
			} else if ((element > aux.getValue())) {
				aux2 = aux;
				aux = aux.getRight();
				return search(aux, aux2, element);
			}

		}
		return aux.getValue();
	}


	  Node {

	private Node left;
	private Node right;
	private int value;
	
	
	
	public Node() {}
	
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

		nova.preOrder();
		System.out.println(nova.getPreOrder());
		System.out.println(nova.search(entrada2));

	}
}

