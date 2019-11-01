
public class ArrayList{


    private int[] lista;
	public static final int CAPACIDADE_DEFAULT = 20;
    private int size;
    
    public ArrayList(){
        this.lista = new intp[CAPACIDADE_DEFAULT];
        this.size = 0;
    }

    public ArrayList(int capacidade){
        this.lista = new intp[capacidade];
        this.size = 0;
    }

    public void add(Aluno aluno){
        this.lista[this.size] = aluno;
        this.size += 1;
    }

    public void set(int index, Aluno aluno){
        this.lista[index] = aluno;
    }


    public boolean add(int index, Aluno aluno) {
        
        if(index >= this.size ){
            return false;
        } 
        else{
            for (int i = this.size - 1; i > index; i--) {
                this.list[i] = this.list[i-1];
                
            } 
            this.list[index] = aluno;
            return true;
        }
        
        
    }






 class Aluno{


    private Integer matricula;
    private String nome;

    public Aluno(){

    }

    public Aluno(Integer matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;    
    }

    public Integer getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }



}

}