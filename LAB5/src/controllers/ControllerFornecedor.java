package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import classes.Fornecedor;
import classes.IDProduto;
import comparators.NomeFornecedorComparator;

/**
 * Classe que representa o Controller da classe Fornecedor.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class ControllerFornecedor {
	private Map<String, Fornecedor> fornecedores;

    public ControllerFornecedor() {
        this.fornecedores = new HashMap<>();
    }

    public void addFornecedor(String nomeFornecedor, String email, String numero) {
        if (nomeFornecedor == null || nomeFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: nomeFornecedor nao pode ser vazio ou nulo.");
        } else if (email == null || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
        } else if (numero == null || numero.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do fornecedor: numero nao pode ser vazio ou nulo.");
        } else if (this.fornecedores.containsKey(nomeFornecedor.toLowerCase())){
            throw new IllegalArgumentException("Erro no cadastro de fornecedor: fornecedor ja existe.");
        }

        this.fornecedores.put(nomeFornecedor.toLowerCase(), new Fornecedor(nomeFornecedor,email,numero));

    }
    
    public void removeFornecedor(String nomeFornecedor) {
        if (this.fornecedores.containsKey(nomeFornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        } else if (nomeFornecedor == null || nomeFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na remocao do fornecedor: nomeFornecedor do fornecedor nao pode ser vazio.");
        }

        this.fornecedores.remove(nomeFornecedor.toLowerCase());
    }


    public String exibeFornecedores() {
        String fornecedores = "";

        List<Fornecedor> fornecedoresLista = this.ordenaFornecedorPeloNome();

        for (Fornecedor fornecedor : fornecedoresLista) {
            fornecedores += fornecedor.toString() + " | ";
        }

        return fornecedores.substring(0, fornecedores.length()- 3);
    }
    
    public String exibeFornecedor(String nomeFornecedor) {
        if (!this.fornecedores.containsKey(nomeFornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        return this.fornecedores.get(nomeFornecedor.toLowerCase()).toString();
    }

    public void editaFornecedor(String nomeFornecedor, String atributo, String novoValor) {
        final String[] atribValidos = {"email", "numero"};
        final List<String> listaAtribValidos = Arrays.asList(atribValidos);

        if (atributo.equals("nomeFornecedor")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: nomeFornecedor nao pode ser editado.");
        } else if (novoValor == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
        } else if (atributo == null || atributo.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
        } else if (!listaAtribValidos.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
        } else if (!this.fornecedores.containsKey(nomeFornecedor.toLowerCase())){
            throw new IllegalArgumentException("Erro na exibicao do fornecedor: fornecedor nao existe.");
        }

        this.fornecedores.get(nomeFornecedor.toLowerCase()).editaFornecedor(atributo, novoValor);
    }


    public void addProduto(String fornecedor, String nomeFornecedor, String descricao, double preco) {
        IDProduto produto = new IDProduto(nomeFornecedor.toLowerCase(), descricao.toLowerCase());

        if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
        } else if (nomeFornecedor == null || nomeFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nomeFornecedor nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: nomeFornecedor nao pode ser vazio ou nulo.");
        } else if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (this.fornecedores.get(fornecedor.toLowerCase()).checaProduto(produto)) {
            throw new IllegalArgumentException("Erro nos cadastro de produto: produto ja existe.");
        } else if (preco < 0) {
            throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).addProduto(produto,nomeFornecedor,descricao,preco);
    }
    
    public void removeProduto(String nomeFornecedor, String descricao, String fornecedor) {
        IDProduto produto = new IDProduto(nomeFornecedor.toLowerCase(), descricao.toLowerCase());

        if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
        } else if (nomeFornecedor == null || nomeFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na remocao de produto: nomeFornecedor nao pode ser vazio ou nulo.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
        } else if (!this.fornecedores.get(fornecedor.toLowerCase()).checaProduto(produto)) {
            throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).removeProduto(nomeFornecedor, descricao);
    }

    public String exibeProduto(String nomeFornecedor, String descricao, String fornecedor) {
        IDProduto produto = new IDProduto(nomeFornecedor.toLowerCase(), descricao.toLowerCase());

        if (nomeFornecedor == null || nomeFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: nomeFornecedor nao pode ser vazio ou nulo.");
        } else if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao existe.");
        } else if (!this.fornecedores.get(fornecedor.toLowerCase()).checaProduto(produto)) {
            throw new IllegalArgumentException("Erro na exibicao de produto: produto nao existe.");
        }

        return this.fornecedores.get(fornecedor.toLowerCase()).exibeProduto(nomeFornecedor, descricao);

    }

    public String exibeProdutos() {
        String produtos = "";
        List<Fornecedor> fornecedorList = this.ordenaFornecedorPeloNome();

        for (Fornecedor fornecedor : fornecedorList) {
            produtos += fornecedor.exibeProdutos();
        }

        return produtos.substring(0, produtos.length() - 3);
    }   

    public void editaProduto(String nomeFornecedor, String descricao, String fornecedor, double novoPreco) {
        IDProduto produto = new IDProduto(nomeFornecedor.toLowerCase(), descricao.toLowerCase());

        if (fornecedor == null || fornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
        } else if (nomeFornecedor == null || nomeFornecedor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: nomeFornecedor nao pode ser vazio ou nulo.");
        } else if (descricao == null || descricao.equals("")) {
            throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
        } else if (novoPreco < 0) {
            throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
        } else if (!this.fornecedores.containsKey(fornecedor.toLowerCase())) {
            throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
        } else if (!this.fornecedores.get(fornecedor.toLowerCase()).checaProduto(produto)) {
            throw new IllegalArgumentException("Erro na edicao de produto: produto nao existe");
        }

        this.fornecedores.get(fornecedor.toLowerCase()).editaProduto(nomeFornecedor, descricao, novoPreco);
    }  

    private List<Fornecedor> ordenaFornecedorPeloNome() {
        List<Fornecedor> listaFornecedor = new ArrayList<>(this.fornecedores.values());
        Collections.sort(listaFornecedor, new NomeFornecedorComparator());

        return listaFornecedor;
    }
}
