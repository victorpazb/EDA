import java.util.Arrays;

public class ArrayList {

	private Aluno[] list;
	private int size;

	public ArrayList() {
		this.list = new Aluno[20];
		this.size = 0;
	}

	public ArrayList(int tamanhoInicial) {
		this.list = new Aluno[tamanhoInicial];
		this.size = 0;
	}

	public boolean isFull() {
		return this.list.length == this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	private void resize() {
		Aluno[] novaLista = new Aluno[this.list.length * 2];
		int controle = 0;
		for (Aluno aluno : this.list) {
			novaLista[controle] = aluno;
			controle++;
		}

		this.list = novaLista;
	}

	public int size() {
		return this.size;
	}

	// Metodo recebe um index e retorna o objeto correspondente
	public Aluno get(int index) {
		checaIndex(index);
		return this.list[index];
	}

	/*
	 * METODOS DE ADICAO
	 */
	public boolean add(Aluno aluno) {

		checaCapacidade(this.size + 1);
		int primeiraPosicaoVazia = this.size;

		this.list[primeiraPosicaoVazia] = aluno;
		this.size += 1;
		return true;

	}

	public void checaCapacidade(int novaCapacidade) {
		if (novaCapacidade > this.list.length) {
			resize();
		}
	}

	private void checaIndex(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("index nao existe na lista");
		}
	}

	public void set(int index, Aluno novoAluno) {
		checaIndex(index);
		this.list[index] = novoAluno;
	}

	private void shiftParaDireita(int index) {
		for (int i = this.size; i > index; i--) {
			this.list[i] = this.list[i - 1];
		}

	}

	public boolean add(int index, Aluno novoAluno) {

		checaCapacidade(this.size + 1);

		if (index < 0 || index >= this.size) {
			return false;
		} else {
			shiftParaDireita(index);

			this.list[index] = novoAluno;
			this.size += 1;
			return true;
		}

	}

	// METODOS DE REMOCAO

	public boolean remove(Aluno aluno) {
		if (aluno == null) {
			return false;
		}

		for (int i = 0; i < this.size; i++) {
			if (this.list[i].equals(aluno)) {
				this.remove(i);
				return true;
			}
		}
		return false;
	}

	// remove sem index, remove o ultimo
	public Aluno remove(int index) {
		if (index < 0 || index >= this.size) {
			return null;
		}

		shiftParaEsquerda(index);

		this.size -= 1;
		return this.list[index];

	}

	private void shiftParaEsquerda(int index) {
		for (int i = index; i < this.size - 1; i++) {
			this.list[i] = this.list[i + 1];
		}
	}

	public String toString() {

		if (isEmpty()) {
			return "empty";
		}

		String lista = "[";

		for (int i = 0; i < this.size; i++) {

			lista += this.list[i].toString() + ", ";
		}
		return lista.substring(0, lista.length() - 2) + "]";
	}

}
