package lab2;


/**
 * Representacao da conta em um laboratorio. 
 * 
 * Deve ser associado a cada laboratorio um nome e uma cota de uso.
 * Caso a cota nao seja definida, automaticamento de 2000MB.
 * 
 * @author Marta Lais de Macedo Dantas
 */
public class ContaLaboratorio {

	private String nomeLaboratorio;
	private int cota = 2000;
	private int espacoOcupado = 0;

	/**
	 * Constroi uma conta em um laboratorio pelo seu nome.
	 * 
	 * @param nomeLaboratorio representa o nome do laboratório.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
	}
	
	/**
	 * Constroi uma conta em um laboratorio pelo seu nome e sua cota.
	 * 
	 * @param nomeLaboratorio representa o nome do laboratório.
	 * @param cota representa a cota de uso.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cota = cota;
	}
	
	/**
	 * Consome uma determinada quantidade de espaço ocupado
	 * sem interferir no valor da cota.
	 * 
	 * @param mbytes representa o valor a ser consumido em mega bytes (MB).
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}
	
	/**
	 * Libera uma determinada quantidade de espaco ocupado
	 * sem interferir no valor da cota.
	 * 
	 * @param mbytes valor a ser libereado, em MB.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}
	
	/**
	 * Retorna um booleano que representa se o espaço ocupado
	 * atingiu o limite de cota.
	 * 
	 * @return um booleano true ou false.
	 */
	public boolean atingiuCota() {
		return (this.espacoOcupado >= this.cota);
	}
	
	
	@Override
	public String toString() {
		return this.nomeLaboratorio + " " + this.espacoOcupado + "/" + this.cota;
	}
	
}
