package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//6 – Crie um método para exibir no console, todos os Gêneros, cadastrados na tabela de
//mesmo nome. Se preferir, retorne uma lista de objetos, e imprima-a na console;

public class exercicio6 {

        public List<String> listarGeneros() {
            List<String> generos = new ArrayList<>();

            try {

                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");

                Statement stmt = conn.createStatement();

                String query = "SELECT nome FROM genero";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String nomeGenero = rs.getString("nome");
                    generos.add(nomeGenero);
                }

                rs.close();
                stmt.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return generos;
        }

        public static void main(String[] args) {
            exercicio6 exercicio6 = new exercicio6();

            List<String> listaDeGeneros = exercicio6.listarGeneros();

            for (String genero : listaDeGeneros) {
                System.out.println(genero);
            }
        }
    }


