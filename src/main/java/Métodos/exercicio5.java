package Métodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//5 – Crie um método para exibir no console, todos as Categorias, cadastradas na tabela
//de mesmo nome. Se preferir, retorne uma lista de objetos, e imprima-a na console;

public class exercicio5 {

        private final String url = "jdbc:postgresql://localhost:5432/postgres";

    public exercicio5(String nome) {
    }


    public List<exercicio5> buscarTodasCategorias() {
            String sql = "SELECT * FROM categoria";
            ArrayList<exercicio5> listaCategorias = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");

                    exercicio5 categoria = new exercicio5(nome);
                    categoria.setId(id); // Definir o ID da categoria

                    listaCategorias.add(categoria);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao buscar categorias: " + e.getMessage());
            }

            return listaCategorias;
        }

    private void setId(int id) {
    }
}


