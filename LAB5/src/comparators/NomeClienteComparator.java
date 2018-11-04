package comparators;

import java.util.Comparator;

import classes.Cliente;

/**
 * Classe que compara o Cliente pelo atributo nome.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class NomeClienteComparator implements Comparator<Cliente> {
	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		return cliente1.getnomeCliente().toLowerCase().compareTo(cliente2.getnomeCliente().toLowerCase());
	}
}

