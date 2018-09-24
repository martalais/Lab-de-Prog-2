package lab2;

/**
 * Representacao de uma disciplina.
 * Toda disciplina tem um nome e e possivel cadastrar notas e horas.
 * 
 * @author Marta Lais de Macedo Dantas
 */
public class Disciplina {
	
	private String nomeDisciplina;
	private int horas;
	private double nota[] = new double[4];
	
	
	/**
	 * Constroi uma nova disciplina a partir de um nome.
	 * 
	 * @param nomeDisciplina representa o nome da disciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	/**
	 * Cadastra uma quantidade de horas na disciplina.
	 * 
	 * @param horas representa a quantidade de horas a ser cadastrada.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}	
	
	/**
	 * Cadastra uma nota a uma disciplina.
	 * Toda disciplina tem quatro notas.
	 * 
	 * @param nota representa nota a ser cadastrada.
	 * @param valorNota representa valor obtido da nota pelo aluno.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.nota[nota-1] = valorNota;
	}
	
	/**
	 * Retorna a media das notas cadastradas.
	 * 
	 * @return media das notas cadastradas.
	 */
	private double media() {
		double total = 0;
		for(int i = 0; i < nota.length; i++) {
			total += nota[i];
		}
		return total/nota.length;
	}
	
	/**
	 * Retorna um boolean que representa a aprovacao do aluno na disciplina. 
	 * 
	 * @return true ou false.
	 */
	public boolean aprovado() {
		if(media() >= 7.0 ) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
 	public String toString() {
		String retorno = this.nomeDisciplina + " " + this.horas + " " + this.media() + " [" + nota[0];
		for(int i = 1; i < nota.length; i++) retorno += ", " + nota[i]; retorno += "]";
		return retorno;
	}
}
