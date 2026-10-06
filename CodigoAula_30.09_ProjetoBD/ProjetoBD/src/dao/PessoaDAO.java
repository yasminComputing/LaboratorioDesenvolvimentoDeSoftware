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
        String sql = "INSERT INTO PESSOA (nome,sexo,idioma) VALUES (?,?,?);";
        try{
           
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,pessoa.getNome());
            stmt.setString(2,pessoa.getSexo());
            stmt.setString(3,pessoa.getIdioma());
               
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir pessoa: " + ex.getMessage()); 
        }    
    }
    public Pessoa getPessoa(int id){
        String sql = "SELECT * FROM PESSOA WHERE id = ?";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            Pessoa p = new Pessoa();
            
            rs.first();//aponta para primeira posição da tabela
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo((rs.getString("sexo")));
            p.setIdioma((rs.getString("idioma")));
            return p;              
        }catch(SQLException ex){
            System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
            return null;
        }   
    }
    public void editar(Pessoa pessoa){
        try{
            String sql = "UPDATE PESSOA SET nome = ?, sexo = ?, idioma = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3,pessoa.getIdioma());
            stmt.setInt(4,pessoa.getId());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao atualizar dados: " + ex.getMessage());
        }
    }
    
    public void excluir(int id){
        try{
            String sql = "DELETE FROM PESSOA WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao excluir pessoa: " + ex.getMessage());
        }
    }
 }   

