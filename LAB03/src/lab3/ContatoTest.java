package lab3;
import junit.framework.Test;
import junit.framework.TestCase;

public class ContatoTest {
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraNomeSoEspacos() {
	        String nome = "    ";
	        String sobrenome = "Laís";
	        String telefone = "1111";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com nome feito só de espaços");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraNomeVazio() {
	        String nome = "";
	        String sobrenome = "Laís";
	        String telefone = "111431";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com nome vazio");
	    }
	      
	    @Test(expected = NullPointerException.class)
	    public void cadastraNomeNull() {
	        String nome = null;
	        String sobrenome = "Laís";
	        String telefone = "1112311";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com nome null");   
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraSobrenomeSoEspacos() {
	        String nome = "Danizinha";
	        String sobrenome = "    ";
	        String telefone = "11111";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com sobrenome feito só de espaços");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraSobrenomeVazio() {
	        String nome = "Marta";
	        String sobrenome = "";
	        String telefone = "3333";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com sobrenome vazio");
	    }
	      
	    @Test(expected = NullPointerException.class)
	    public void cadastraSobrenomeNull() {
	        String nome = "Laís";
	        String sobrenome = null;
	        String telefone = "3434";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com sobrenome null");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraTelefoneSoEspacos() {
	        String nome = "Marta";
	        String sobrenome = "Lais";
	        String telefone = "    ";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com telefone feito só de espaços");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraTelefoneVazio() {
	        String nome = "Daiany";
	        String sobrenome = "ArteMidia";
	        String telefone = "";
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com telefone vazio");
	    }
	      
	    @Test(expected = NullPointerException.class)
	    public void cadastraTelefoneNull() {
	        String nome = "Marta";
	        String sobrenome = "Lais";
	        String telefone = null;
	        int posicao = 1;
	        Contato contato = new Contato(nome, sobrenome, telefone);
	        fail("Contato foi criado com telefone null");
	    }
	     
	    @Test
	    public void equalsNomeDiferente() {
	        Contato contato1 = new Contato("Marta", "Dantas", "111122");
	        Contato contato2 = new Contato("Lais", "Dantas", "111122");
	        if (contato1.equals(contato2)) {
	            fail("Contatos considerados iguais com nomes diferentes");
	        }
	    }
	     
	    @Test
	    public void equalsSobrenomeDiferente() {
	        Contato contato1 = new Contato("Marta", "Dantas", "21212121");
	        Contato contato2 = new Contato("Marta", "Lais", "21212121");
	        if (contato1.equals(contato2)) {
	            fail("Contatos considerados iguais com sobrenomes diferentes");
	        }
	    }
}
