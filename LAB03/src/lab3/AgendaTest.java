package lab3;
import junit.framework.Test;
import junit.framework.TestCase;

public class AgendaTest {
	
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraNomeSoEspacos() {
	        String nome = "    ";
	        String sobrenome = "Laís";
	        String telefone = "666666";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com nome feito só de espaços");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraNomeVazio() {
	        String nome = "";
	        String sobrenome = "Gaudencio";
	        String telefone = "1010101";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com nome vazio");
	    }
	      
	    @Test(expected = NullPointerException.class)
	    public void cadastraNomeNull() {
	        String nome = null;
	        String sobrenome = "Maria";
	        String telefone = "000000";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com nome null");   
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraSobrenomeSoEspacos() {
	        String nome = "Marta";
	        String sobrenome = " ";
	        String telefone = "1203981";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com sobrenome feito só de espaços");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraSobrenomeVazio() {
	        String nome = "Aurora";
	        String sobrenome = " ";
	        String telefone = "121211211";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com sobrenome vazio");
	    }
	      
	    @Test(expected = NullPointerException.class)
	    public void cadastraSobrenomeNull() {
	        String nome = "Periclezinho";
	        String sobrenome = null;
	        String telefone = "0000000";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com sobrenome null");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraTelefoneSoEspacos() {
	        String nome = "Juanzin";
	        String sobrenome = "Top";
	        String telefone = " ";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com telefone feito só de espaços");
	    }
	      
	    @Test(expected = IllegalArgumentException.class)
	    public void cadastraTelefoneVazio() {
	        String nome = "Martinha";
	        String sobrenome = "Top";
	        String telefone = "";
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com telefone vazio");
	    }
	      
	    @Test(expected = NullPointerException.class)
	    public void cadastraTelefoneNull() {
	        String nome = "Daiany";
	        String sobrenome = "Designer";
	        String telefone = null;
	        int posicao = 1;
	        Agenda agenda = new Agenda();
	        agenda.cadastrar(posicao, nome, sobrenome, telefone);
	        fail("Contato foi criado com telefone null");
	    }
	       
	    @Test
	    public void equalsContatosDiferentes() {
	        String nome = "danizinha";
	        String sobrenome = "psicologa";
	        String telefone = "10101";
	        int posicao = 1;
	        Agenda agenda1 = new Agenda();
	        agenda1.cadastrar(posicao, nome, sobrenome, telefone);
	        String nome2 = "psicologa";
	        String sobrenome2 = "danizinha";
	        String telefone2 = "1111";
	        int posicao2 = 2;
	        Agenda agenda2 = new Agenda();
	        agenda2.cadastrar(posicao2, nome2, sobrenome2, telefone2);
	        
	        if (agenda1.equals(agenda2)) {
	        	fail("Contatos considerados iguais sendo diferentes");
	        }    
	    }

}
