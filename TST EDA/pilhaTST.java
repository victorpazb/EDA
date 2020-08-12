import java.util.Arrays;

import javax.lang.model.type.NullType;

public class Pilha {

	private int[] array;
	private int topo = -1;

	

	public Pilha(int size) {
		this.array = new int[size];
	}

	public boolean isEmpty() {
		return this.topo == -1;
	}

	private boolean isFull() {
		return this.topo + 1 == this.array.length;
	}

	public void push(int element) {
		if (!isFull()) {
			this.topo++;
			this.array[this.topo] = element;
		}
	}

	public int size() {
		return this.topo + 1;
	}

	public int peek() {
		if(isEmpty()){
			throw new NullPointerException("pilha vazia");
		}else {
			return this.array[this.topo];
		}
		

	}

	public String print() {
		
		if(isEmpty()) {
			return "empty";
		}

		String montantdoLista = "[";
		for (int i = 0; i <= this.topo; i++) {
			if (i < this.topo) {
				montantdoLista += this.array[i] + ", ";
			} else {
				montantdoLista += this.array[i];
			}

		}
		return montantdoLista + "]";
	}

	public void remove() {
		if (!isEmpty()) {
			this.topo--;
		}else {
			print();
		}
	}
	
	public int search(int elemento) {
		
		
		for(int i = 0; i <= this.topo; i++) {
			if(this.array[i] == elemento) {
				return i;
			}
		}
		return -1;
	}

}

