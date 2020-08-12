public class DoubleLinkedList {

	DNode head;
	DNode tail;

	/**
	 * preciso aprender o basico de double linked
	 */
	public DoubleLinkedList() {
		this.head = new DNode();
		this.tail = new DNode();
	}

	public boolean isEmpty() {
		return this.head.isNIL();
	}

	public void addLast(int element) {
		addLast(this.head, element);
	}

	private void addLast(DNode node, int element) {

		if (node.isNIL()) {
			node.setData(element);
			DNode auxNode = new DNode();
			node.setNext(auxNode);
			auxNode.setPrevious(node);
			this.tail = auxNode;
		} else {
			addLast(node.next, element);
		}
	}

	public boolean isSorted() {
		if (isEmpty()) {
			return true;
		} else {
			boolean resultadoAscendente = isSorted(this.head, false);
			boolean resultadoDescendente = isSorted(this.head, true);

			return (resultadoAscendente || resultadoDescendente);
		}
	}

	// OBSERVAR BEM ESSA FUNCAO
	private boolean isSorted(DNode node, boolean asc) {
		if (!node.isNIL()) {
			if (!node.getNext().isNIL()) {
				if (asc) {
					if (((int) head.getData()) >= ((int) head.getNext().getData()) && asc) {
						return isSorted(node.getNext(), asc);
					} else {
						return false;
					}
				} else {
					if (((int) head.getData()) <= ((int) head.getNext().getData()) && !asc) {
						return isSorted(node.getNext(), asc);
					} else {
						return false;
					}
				}

			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	public int soma() {
		return soma(this.head);
	}

	private int soma(DNode node) {

		if (node.isNIL()) {
			return 0;
		} else {
			return node.next.getData() + soma(node.next);
		}

	}

	public int size() {
		return size(this.head);
	}

	private int size(DNode node) {

		if (node.isNIL()) {
			return 0;
		} else {
			return 1 + size(node.getNext());
		}

	}

	public void add(int elemento) { // preciso aprender como inserir com um indice
		if (isEmpty()) {
			this.head.setData(elemento);
			this.tail.setPrevious(head);
			this.head.setNext(tail);
		}
	}

	// METODOS ITERATIVOS

	public void add(int element, int index) {
		DNode aux = this.head;
		int i = index - 1;
		while (i > 0) {
			aux = aux.getNext();
			i--;
		}

		DNode novo = new DNode();
		novo.setData(element);
		aux.setNext(novo);
		novo.setNext(aux.getNext());
		novo.setPrevious(aux);

		if (!aux.getNext().isNIL()) {
			aux.getNext().setPrevious(novo);
		}
	}

	public void remove(int index) {
		DNode aux = this.head;
		int i = index;
		while (i > 0) {
			aux = aux.getNext();
			i--;
		}

		DNode next = aux.getNext();
		aux.getPrevious().setNext(next);
		next.setPrevious(aux.getPrevious());
	}

	// CLASSE DNODE

	class DNode {

		private DNode next;
		private DNode prev;
		private int data;

		public DNode() {
		}

		public DNode(int value, DNode next, DNode prev) {
			this.next = next;
			this.prev = prev;
			this.data = value;
		}

		public boolean isNIL() {
			return this.data == Integer.MAX_VALUE;

		}

		public void setData(int value) {
			this.data = value;
		}

		public void setPrevious(DNode prev) {
			this.prev = prev;
		}

		public DNode getPrevious() {
			return this.prev;
		}

		public void setNext(DNode next) {
			this.next = next;
		}

		public int getData() {
			return this.data;
		}

		public DNode getNext() {
			return this.next;
		}

	}

}
