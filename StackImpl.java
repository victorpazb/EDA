package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
	}

	@Override
	public T top() {
		T aux = null;
		if (!this.isEmpty())
			aux = this.array[top];
		return aux;
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true;
		if (this.top > -1)
			empty = false;
		return empty;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if (this.top == this.array.length - 1)
			full = true;
		return full;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		} else {
			this.array[++this.top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		} else {
			return this.array[this.top--];
		}
	}

	public static void main(String[] args) {
		StackImpl<Integer> si = new StackImpl<Integer>(5);
		try {
			si.push(new Integer(5));
		} catch (StackOverflowException e) {
			System.out.println("Deu ruim");
		}

		System.out.println(si.top());
	}
}