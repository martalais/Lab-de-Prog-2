package classes;

/**
 * 
 * Classe que representa o Produto.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class Produto {
	private String nomeProduto;
    private String descricao;
    private double preco;

    public Produto(String nomeProduto, String descricao, double preco) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void editaPreco(double novoPreco) {
        if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        }
        this.preco = novoPreco;
    }

    @Override
    public String toString() {
        return this.nomeProduto + " - " + this.descricao + " - R$" + String.format("%.2f",this.preco);
    }

}
