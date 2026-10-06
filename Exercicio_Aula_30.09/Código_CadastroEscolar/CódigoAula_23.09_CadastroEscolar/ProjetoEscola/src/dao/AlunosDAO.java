package dao;
import beans.Alunos;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunosDAO {
    private Conexao conexao;
    private Connection conn;

    public AlunosDAO() {
        this.conexao = new  Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Alunos a){
        String sql = "INSERT INTO ALUNOS (nome,idade,curso) VALUES (?,?,?)";
        try{
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1,a.getNome());
            stmt.setInt(2, a.getIdade());
            stmt.setString(3,a.getCurso());
            
            stmt.execute();
        }catch(SQLException ex){
            System.out.println("Erro ao inserir aluno: " + ex.getMessage());
        }   
    }
    
    public Alunos getAlunos(int id) {
        String sql = "SELECT * FROM ALUNOS WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Alunos a = new Alunos();

            rs.first();
            a.setId(id);
            a.setNome(rs.getString("nome"));
            a.setIdade((rs.getInt("idade")));
            a.setCurso((rs.getString("curso")));
            return a;
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar aluno: " + ex.getMessage());
            return null;
        }
    }

    public void editar(Alunos alunos) {
        try {
            
            String sql = "UPDATE ALUNOS SET nome = ?, idade = ?, curso = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, alunos.getNome());
            stmt.setInt(2, alunos.getIdade());
            stmt.setString(3, alunos.getCurso());
            stmt.setInt(4,alunos.getId());

            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar dados: " + ex.getMessage());
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM MATRICULAS WHERE id_aluno = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            
            sql = "DELETE FROM ALUNOS WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir aluno: " + ex.getMessage());
        }
    }
}

