package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//3-Crie um método para inserir Gêneros. Se preferir crie um objeto, com as
//características encontradas na tabela, e insira esse objeto no banco

public class exercicio3 {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";

    public exercicio3(String rua, String cidade, String estado, String cep) {
    }

    // Método para inserir um Gênero no banco de dados
    public void inserirGenero(exercicio3 genero) {
        String sql = "INSERT INTO genero(nome) VALUES('Romance', 'Comédia')";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Configurar os parâmetros do PreparedStatement
            pstmt.setString(1, genero.getNome());

            // Executar a inserção
            pstmt.executeUpdate();
            System.out.println("Gênero inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir gênero: " + e.getMessage());
        }
    }

    private String getNome() {
        return "";
    } }

