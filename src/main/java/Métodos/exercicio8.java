package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 //8-Crie um método para imprimir no console todos os Filmes e suas respectivas Categorias e Gêneros;

public class exercicio8 {

        public void imprimirFilmesComCategoriasEGeneros() {
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");

                String query = "SELECT f.titulo AS titulo_filme, g.nome AS genero, c.nome AS categoria " +
                        "FROM filmes f " +
                        "JOIN generos g ON f.genero_id = g.id " +
                        "JOIN categorias c ON f.categoria_id = c.id";

                stmt = conn.prepareStatement(query);

                rs = stmt.executeQuery();

                while (rs.next()) {
                    String tituloFilme = rs.getString("titulo_filme");
                    String genero = rs.getString("genero");
                    String categoria = rs.getString("categoria");

                    System.out.println("Filme: " + tituloFilme);
                    System.out.println("Gênero: " + genero);
                    System.out.println("Categoria: " + categoria);
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            exercicio8 filmes = new exercicio8();
            filmes.imprimirFilmesComCategoriasEGeneros();
        }
    }


