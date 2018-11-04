package classes;

import java.util.Objects;

/**
 * 
 * @author Marta Lais de Macedo Dantas
 *
 */
public class IDProduto {
	private String nomeProduto;
    private String descricao;

    public IDProduto(String nomeProduto, String descricao) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IDProduto IDProduto = (IDProduto) o;
        return Objects.equals(nomeProduto, IDProduto.nomeProduto) &&
                Objects.equals(descricao, IDProduto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeProduto, descricao);
    }

}
