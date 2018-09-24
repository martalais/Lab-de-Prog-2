package lab2;

/**
 * Representacao da conta na cantina.
 * 
 * @author Marta Laís de Macedo Dantas 
 */

public class ContaCantina {

	private String nomeCantina;
	private int conta;
	private int quantidadeItens;
	
	/**
     * Constroi uma conta pelo nome da cantina.
     * 
     * @param nomeCantina representa o nome da cantina.
     */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
		
	/**
	 * Cadastra o valor e a quantidade de itens da compra de um lanche.
	 * 
	 * @param quantidadeItens representa a quantidade de itens do lanche.
	 * @param centavos representa o valor total dos itens do lanche.
	 */
	public void cadastraLanche(int quantidadeItens, int centavos) {
		this.conta += centavos;
		this.quantidadeItens += quantidadeItens;
	}
	
	/**
	 * Efetua um pagamento subtraindo um valor em centavos da conta original.
	 * 
	 * @param centavos representa o valor a ser subtraido em centavos.
	 */
	public void pagaConta(int centavos) {
		this.conta -= centavos;
	}

	/**
	 * Representacao textual da conta da cantina.
	 */
	@Override
	public String toString() {
		return this.nomeCantina + " " + this.quantidadeItens + " " + this.conta;
	}	
}

