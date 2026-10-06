package dao;

import beans.Professores;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessoresDAO {


    private Conexao conexao;
    private Connection conn;

    public ProfessoresDAO() {
        this.conexao = new  Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Professores p){
        String sql = "INSERT INTO professores(nome,idade,disciplina) VALUES (?,?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,p.getNome());
            stmt.setInt(2, p.getIdade());
            stmt.setString(3,p.getDisciplina());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir professores: " + ex.getMessage());
        }   
    }
     public Professores getProfessores(int id) {
        String sql = "SELECT * FROM PROFESSORES WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Professores p = new Professores();

            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setIdade((rs.getInt("idade")));
            p.setDisciplina((rs.getString("disciplina")));
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar professor: " + ex.getMessage());
            return null;
        }
    }

    public void editar(Professores professor) {
        try {
            
            String sql = "UPDATE PROFESSORES SET nome = ?, idade = ?, disciplina = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, professor.getNome());
            stmt.setInt(2, professor.getIdade());
            stmt.setString(3, professor.getDisciplina());
            stmt.setInt(4,professor.getId());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM MATRICULAS WHERE id_professor = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
            sql = "DELETE FROM PROFESSORES WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir professor: " + ex.getMessage());
        }
    }
}


