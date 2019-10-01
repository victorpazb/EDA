public class DoubleLinkedList<T> {
	DNode<T> head;
	DNode<T> tail;
	
	public DoubleLinkedList() {
		this.head = new DNode<T>();
		this.tail = new DNode<T>();
	}
	
	public boolean isEmpty() {
		return this.head.isNil();
	}
	
	public void insertFirst(T element) {
		if(isEmpty()) {
			head.setValue(element);
			tail.setPrevious(head);
			head.setNext(tail);
		} else {
			DNode<T> newHead = new DNode<T>();
			newHead.setValue(element);
			DNode<T> aux = this.head;
			newHead.setNext(aux);
			aux.setPrevious(newHead);
			this.head = newHead;
		}
	}
	public void insert(T element) {
		if(isEmpty()) {
			insertFirst(element);
			
		} else {
			DNode<T> newTail = new DNode<T>();
			DNode<T> aux = this.tail;
			aux.setValue(element);
			aux.setNext(newTail);
			newTail.setPrevious(aux);
			this.tail = newTail;
		}
	}
	
	public void removeFirst() {
		if(!isEmpty()) {
			this.head = this.head.getNext();
			this.head.setPrevious(new DNode<T>());
		}
	}
	
	public T remove(T element) {
		T removed = null;
		if(!isEmpty()) {
			boolean remove = false;
			DNode<T> aux = this.head;
			
			if(element.equals(aux.getValue())) {
				removed = aux.getValue();
				removeFirst();
			} else {
				aux = aux.getNext();
				while(!aux.isNil() && !remove) {
					if(aux.getValue().equals(element)) {
						remove = true;
						removed = aux.getValue();
						DNode<T> auxR = aux.getNext();
						auxR.setPrevious(aux.getPrevious());
						aux.getPrevious().setNext(auxR);
					} else {
						aux = aux.getNext();
					}
				}
			}
 		}
		
		return removed;
	}
	
	@Override
	public String toString() {
		String saida = "";
		if(isEmpty()) {
			saida += "Empty";
		} else {
			DNode<T> aux = this.head;
			
			while(!aux.isNil()) {
				
				if(aux.getPrevious() == null) {
					saida += "Previous : empty";
				} else {
					saida += "Previous: " + aux.getPrevious().getValue();
				}
				saida += " <- " + aux.getValue() + " -> ";
				if(aux.getNext() == null) {
					saida += "Next: empty";
				} else {
					saida += "Next: " + aux.getNext().getValue();
				}
				saida += " | ";
				aux = aux.getNext();
			}
		}
		
		return saida;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> dll = new DoubleLinkedList<Integer>();
		dll.insert(4);
		dll.insert(5);
		dll.insert(9);
		System.out.println(dll.toString());
		dll.remove(5);
		System.out.println(dll.toString());
		dll.remove(4);
		System.out.println(dll.toString());
	}
}

class DNode<T> {
	private T value;
	private DNode<T> next;
	private DNode<T> previous;
	
	public DNode(T value, DNode<T> next, DNode<T> previous) {
		this.value = value;
		this.setNext(next);
		this.setPrevious(previous);
	}
	
	public DNode() {}
	
	public boolean isNil() {
		return this.value == null;
	}

	public DNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DNode<T> previous) {
		this.previous = previous;
	}

	public DNode<T> getNext() {
		return next;
	}

	public void setNext(DNode<T> next) {
		this.next = next;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		String saida = "";
		if(this.isNil()) {
			saida += "null";
		} else {
			saida += this.value;
		}
		
		return saida;
	}
	
}
