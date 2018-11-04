package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.Cliente;
import comparators.NomeClienteComparator;

/**
 * Classe que representa o Controller da classe Cliente.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class ControllerCliente {

	 private Map<String, Cliente> clientes;

	 public ControllerCliente() {
		 this.clientes = new HashMap<>();
	 }
	 
	 public void addCliente(String nomeCliente, String cpf, String email, String localizacao) {
		 if (nomeCliente.equals(null) || nomeCliente.equals("")) {
			 throw new IllegalArgumentException("Erro no cadastro do cliente: nomeCliente nao pode ser vazio ou nulo.");
		 } else if (cpf.length() != 11) {
			 throw  new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		 } else if (email.equals(null) || email.equals("")) {
			 throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		 } else if (localizacao.equals(null) || localizacao.equals("")) {
			 throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		 } else if (this.clientes.containsKey(cpf)) {
			 throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		 }

	        this.clientes.put(cpf, new Cliente(nomeCliente, cpf, email, localizacao));
     }
	 
	 public void removeCliente(String cpf) {
	        if (!this.clientes.containsKey(cpf)) {
	            throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
	        } else if (cpf == null || cpf.equals("")) {
	            throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo");
	        }

	        this.clientes.remove(cpf);
	 }
	 
	 public String exibeCliente(String cpf) {
		 if (!this.clientes.containsKey(cpf)) {
			 throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
         }
         return this.clientes.get(cpf).toString();
     }
	 
	 public String exibeListaCliente() {
        String clientes = "";
        
        List<Cliente> listaClientes = new ArrayList<>(this.clientes.values());
        
        Collections.sort(listaClientes, new NomeClienteComparator());

        for (Cliente cliente : listaClientes) {
            clientes += cliente.toString() + " | ";
        }

        return clientes.substring(0, clientes.length() - 3);
     }
	    
	 public void editaCliente(String cpf, String atributo, String novoValor) {
	        final String[] atribValidos = new String[] {"nome", "email", "localizacao"};
	        final List<String> listaAtribValidos = Arrays.asList(atribValidos);

	        if (atributo == null || atributo.equals("")) {
	            throw  new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
	        } else if (novoValor == null || novoValor.equals("")) {
	            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
	        } else if (!listaAtribValidos.contains(atributo)) {
	            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
	        } else if (!this.clientes.containsKey(cpf)) {
	            throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
	        }

	        this.clientes.get(cpf).editaCliente(atributo, novoValor);
	    }
	       
}
