package dao;

import beans.Matriculas;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author yasmi
 */
public class MatriculasDAO {
    private Conexao conexao;
    private Connection conn;

    public MatriculasDAO() {
        this.conexao = new  Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Matriculas m){
        String sql = "INSERT INTO matriculas(data_matricula) VALUES (?,?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setDate(1, (Date) m.getData_matricula());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir professores: " + ex.getMessage());
        }   
    }
}




