
import java.util.Scanner;

public class Fila {

	private int[] array;
	private int head, tail;

	public Fila(int size) {
		
		this.array = new int[size];
		this.head = -1;
		this.tail = -1;
	}

	public boolean isEmpty() {
		return this.tail == -1;
	}

	private boolean isFull() {
		return this.tail + 1 == this.array.length;
	}

	public void add(int element) {
		if (!isFull() && this.tail == -1) {
			this.head += 1;
			this.tail += 1;
			this.array[this.tail] = element;
		} else if (!isFull()) {
			this.tail += 1;
			this.array[this.tail] = element;
		}
	}

	public String print() {

		if (isEmpty()) {
			return "empty";
		}

		String montantdoLista = "";
		for (int i = 0; i <= this.tail; i++) {
			if (i < this.tail) {
				montantdoLista += this.array[i] + " ";
			} else {
				montantdoLista += this.array[i];
			}

		}
		return montantdoLista;
	}

	public void remove() {
		for (int i = 0; i < this.tail; i++) {
			int aux = this.array[i + 1];
			this.array[i] = aux;
		}
		this.tail -= 1;

	}
	
	public int element() {
		return this.array[this.head];
	}

	public int getHead() {
		return this.head;
	}

	public int getTail() {
		return this.tail;
	}

	public int getCapacidade() {
		return this.array.length;
	}

	// MAIN DA CLASSE FILA PARA O TST
	public static void main(String[] args) {

		int tamFila;

		Scanner s1 = new Scanner(System.in);

		tamFila = s1.nextInt();
		Fila novaFila = new Fila(tamFila);

		String entrada = s1.nextLine();
		while (!entrada.equals("end")) {

			String entradaQuebrada = entrada.split(" ")[0];
			switch (entradaQuebrada) {

			case "add":

				String[] entradaString = entrada.split(" ");
				int valorAdd = Integer.parseInt(entradaString[1]);
				if (novaFila.getTail() + 1 == novaFila.getCapacidade()) {
					System.out.println("full");
				}
				novaFila.add(valorAdd);
				break;

			case "print":
				System.out.println(novaFila.print());
				break;

			case "remove":
				if (novaFila.isEmpty()) {
					System.out.println("empty");
				}
				novaFila.remove();
				break;

			case "element":
				System.out.println(novaFila.element());
				break;

			default:
				break;
			}

			entrada = s1.nextLine();
		}
	}

}
