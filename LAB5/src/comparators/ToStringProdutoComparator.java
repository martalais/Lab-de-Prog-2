package comparators;

import java.util.Comparator;

import classes.Produto;

/**
 * Classe que compara o Procuto pelo seu toString.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class ToStringProdutoComparator implements Comparator<Produto> {
	@Override
    public int compare(Produto produto1, Produto produto2) {
        return produto1.toString().toLowerCase().compareTo(produto2.toString().toLowerCase());
    }
}
