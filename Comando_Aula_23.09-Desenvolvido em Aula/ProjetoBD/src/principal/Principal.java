
package principal;

import beans.Pessoa;
import conexao.Conexao;
import dao.PessoaDAO;


public class Principal {
    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.getConexao();
        
        Pessoa p = new Pessoa();
        
        //dados que vai ser adicionado em pessoas
        p.setNome("Vitor Bortoluzzi");
        p.setIdioma("Português");
        p.setSexo("M");
        
        //chamando o pessodao para inserir os dados
        PessoaDAO pdao = new PessoaDAO();
        
        pdao.inserir(p);
           
    }
    
}
