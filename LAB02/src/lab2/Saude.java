package lab2;

/**
 * Representa a saude fisica e mental de um usuario.
 * 
 * @author Marta Lais de Macedo Dantas
 */
public class Saude {
	
	private String fisica;
	private String mental;	
	
	public Saude() {
		this.mental = "boa";
		this.fisica = "boa";
	}
		
	/**
	 * Define um novo estado para a saude fisica.
	 * 
	 * @param valor representa o novo estado da saude fisica.
	 */
	public void defineSaudeFisica(String valor) {
		this.fisica = valor;
	}
	
	/**
	 * Define um novo estado para a saude mental.
	 * 
	 * @param valor representa o novo estado da saude mental.
	 */
	public void defineSaudeMental(String valor) {
		this.mental = valor;
	}
	
	
	/**
	 * Retorna a informacao da saude geral do aluno. 
	 * 
	 * @return String que representa o estado da saude geral.
	 */
	public String geral(){
		if(this.mental.equals("boa")){
			if(this.fisica.equals("boa")) {
				return "boa";
			} else {
				return "ok";
			}
		} else if(this.mental.equals("fraca")) {
			if(this.fisica.equals("boa")) {
				return "ok";
			}
		}
		return "fraca";
	}
	
}
