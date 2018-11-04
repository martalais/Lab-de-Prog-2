package comparators;

import java.util.Comparator;

import classes.Fornecedor;

/**
 * Classe que compara o Fornecedor pelo atributo nome.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class NomeFornecedorComparator implements Comparator<Fornecedor> {
	@Override
    public int compare(Fornecedor fornecedor1, Fornecedor fornecedor2) {
        return fornecedor1.getNomeProdutoFornecedor().toLowerCase().compareTo(fornecedor2.getNomeProdutoFornecedor().toLowerCase());
    }
}
