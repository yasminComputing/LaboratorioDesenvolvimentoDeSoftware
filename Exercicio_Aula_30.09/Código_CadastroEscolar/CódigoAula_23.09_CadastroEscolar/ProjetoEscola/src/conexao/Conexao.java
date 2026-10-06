package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    public Connection getConexao() {
        Connection conn;

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC",
                    "root",
                    "INSIRA_SUA_SENHA_DO_BD"
            );

            System.out.println("Conexão efetuada!");
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar no banco: " + e.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }
}