package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//1 – Crie um método para inserir registros na tabela Endereço. Se preferir crie um objeto,
//com as características encontradas na tabela, e insira esse objeto no banco.

public class exercicio1 {

        private final String url = "jdbc:postgresql://localhost:5432/postgres";

        public void inserirEndereco(exercicio1 endereco) {

            String sql = "INSERT INTO endereco(rua, cidade, estado, cep) VALUES('Rua das Flores', 'Londrina', 'PR', '85090580')";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, endereco.getRua());
                pstmt.setString(2, endereco.getCidade());
                pstmt.setString(3, endereco.getEstado());
                pstmt.setString(4, endereco.getCep());


                pstmt.executeUpdate();
                System.out.println("Endereço inserido com sucesso.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        private String getCidade() {
            return "";
        }

        private String getRua() {
            return "";
        }

        private String getEstado() {
            return "";
        }

        private String getCep() {
            return "";
        }
    }




