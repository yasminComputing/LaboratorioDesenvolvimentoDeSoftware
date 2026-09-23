package dao;

import beans.Pessoa;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO {
    private Conexao conexao;
    private Connection conn;
    
    public PessoaDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Pessoa pessoa){
        try{
            String sql = "INSERT INTO PESSOA (nome,sexo,idioma) VALUES (?,?,?);";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,pessoa.getNome());
            stmt.setString(2,pessoa.getSexo());
            stmt.setString(3,pessoa.getIdioma());
               
               stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage()); 
        }    
    }
 }   

