public class Aluno {

	private int matricula;
	private String nome;

	public Aluno() {
	}

	public Aluno(int matricula, String name) {
		this.matricula = matricula;
		this.nome = name;
	}

	public String toString() {
		return this.nome + " | " + this.matricula;
	}

	public int getMatricula() {
		return this.matricula;
	}

	@Override
	public boolean equals(Object outroAluno) {
		if (outroAluno instanceof Aluno) {
			if (this.matricula == ((Aluno) (outroAluno)).getMatricula()) {
				return true;
			}
		}

		return false;

	}
}