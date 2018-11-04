package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.Produto;
import comparators.ToStringProdutoComparator;
import classes.IDProduto;

/**
 * Classe que representa o Fornecedor.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class Fornecedor {
	private String nomeProdutoFornecedor;
    private String email;
    private String numero;
    private Map<IDProduto, Produto> listaProdutos;
    
    public Fornecedor(String nomeProdutoFornecedor, String email, String numero) {
    	if (nomeProdutoFornecedor == null || nomeProdutoFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nomeProdutoFornecedor nao pode ser vazio ou nulo.");
        } else if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (numero == null || numero.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: numero nao pode ser vazio ou nulo.");
        }

        this.nomeProdutoFornecedor = nomeProdutoFornecedor;
        this.email = email;
        this.numero = numero;
        this.listaProdutos = new HashMap<>();    	    	
    }

    @Override
    public String toString() {
    	return this.nomeProdutoFornecedor + " - " + this.email + " - " + this.numero;
    }
    
    public void editaFornecedor(String atributo, String novoValor) {
        final String[] atribValidos = {"email", "numero"};
        final List<String> listaAtribValidos = Arrays.asList(atribValidos);

        if (atributo.equals("nome")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
        } else if (novoValor == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        } else if (atributo == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        } else if (!listaAtribValidos.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        }

        switch (atributo) {
        	case "numero":
            this.numero = novoValor;
            break;
        	
        	case "email":
            this.email = novoValor;
            break;  
        }
    }
    
	public String getNomeProdutoFornecedor() {
		return nomeProdutoFornecedor;
	}
	
	public void addProduto(IDProduto IDproduto, String nomeProdutoFornecedor, String descricao, double preco) {
		if (nomeProdutoFornecedor == null || nomeProdutoFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
       	} else if (descricao == null || descricao.equals("")) {
       		throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
        } else if (preco < 0) {
        	throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        } else if (this.listaProdutos.containsKey(IDproduto)) {
        	throw new IllegalArgumentException("Erro nos cadastro de produto: produto ja existe.");
        }
		
		this.listaProdutos.put(IDproduto, new Produto(nomeProdutoFornecedor, descricao, preco));
	}
	
	public boolean checaProduto(IDProduto produto) {
        if (this.listaProdutos.containsKey(produto)) {
            return true;
        } else {
            return false;
        }
    }
	
	public void removeProduto(String nomeProdutoFornecedor, String descricao) {
        IDProduto produto = new IDProduto(nomeProdutoFornecedor.toLowerCase(), descricao.toLowerCase());

        if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nomeProdutoFornecedor == null || nomeProdutoFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
        } else if (!this.checaProduto(produto)) {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }

        this.listaProdutos.remove(produto);
    }

	
	public String exibeProdutos() {
		String produtos = "";

        List<Produto> produtosList = new ArrayList<>(this.listaProdutos.values());
        Collections.sort(produtosList, new ToStringProdutoComparator());

        for (Produto produto : produtosList) {
            produtos += this.nomeProdutoFornecedor + " - " + produto.toString() + " | ";
        }

        return produtos;
    }    
    
	public String exibeProduto(String nome, String descricao) {
        IDProduto produto = new IDProduto(nomeProdutoFornecedor.toLowerCase(), descricao.toLowerCase());

        if (nomeProdutoFornecedor == null || nomeProdutoFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (!this.checaProduto(produto)){
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }

        return this.listaProdutos.get(produto).toString();
    }
	
	public void editaProduto(String nome, String descricao, double novoPreco) {
        IDProduto produto = new IDProduto(nome.toLowerCase(), descricao.toLowerCase());

        if (nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        } else if (!this.checaProduto(produto)) {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe.");
        }

        this.listaProdutos.get(produto).editaPreco(novoPreco);
    }    
}
