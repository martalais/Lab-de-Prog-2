package classes;

import java.util.Arrays;
import java.util.List;

/**
 * Classe que representa o Cliente.
 * @author Marta Lais de Macedo Dantas
 *
 */
public class Cliente {
	private String nomeCliente;
	private String cpf;
    private String email;
    private String localizacao;

    public Cliente(String nomeCliente, String cpf, String email, String localizacao) {
        if (nomeCliente.equals(null) || nomeCliente.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: nomeCliente nao pode ser vazio ou nulo.");
        } else if (cpf.length() != 11) {
            throw  new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
        } else if (email.equals(null) || email.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
        } else if (localizacao.equals(null) || localizacao.equals("")) {
            throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
        } 

        this.nomeCliente = nomeCliente;
        this.cpf = cpf;
        this.email = email;
        this.localizacao = localizacao;
    }

    public void editaCliente(String atributo, String novoValor) {
        final String[] atribValidos = new String[] {"nome", "email", "localizacao"};
        final List<String> listaAtribValidos = Arrays.asList(atribValidos);

        if (atributo == null || atributo.equals("")) {
            throw  new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
        } else if (novoValor == null || novoValor.equals("")) {
            throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
        } else if (!listaAtribValidos.contains(atributo)) {
            throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
        }

        switch (atributo) {
            case "nome":
                this.nomeCliente = novoValor;
                break;

            case "email":
                this.email = novoValor;
                break;

            case "localizacao":
                this.localizacao = novoValor;
                break;
        }
    }
    @Override
    public String toString() {
        return this.nomeCliente + " - " + this.localizacao + " - " + this.email;
    }
    
	public String getnomeCliente() {
		return nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getLocalizacao() {
		return localizacao;
	}

    
}
