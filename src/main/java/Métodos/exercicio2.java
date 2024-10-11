package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//2- Crie um método para inserir Categorias. Se preferir crie um objeto, com as
//características encontradas na tabela, e insira esse objeto no banco.

public class exercicio2 {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";


    public void inserirCategoria(exercicio2 categoria) {
        String sql = "INSERT INTO categoria(nome) VALUES('Romance', 'Comédia')";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, categoria.getNome());
            pstmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir categoria: " + e.getMessage());
        }
    }

    private String getNome() {
        return "";
    }
}

