package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//7-Crie um método para inserir registros na tabela Filmes. Se preferir crie um objeto,
//com as características encontradas na tabela, e insira esse objeto no banco.

public class exercicio7 {
    
        public void inserirFilme(exercicio7 filme) {
            try {
                
                Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres");
                
                String query = "INSERT INTO filmes (titulo, diretor, ano, genero) VALUES ('A Pequena Sereia', 'John Musker', 1989, 'Infantil')";

                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString('1', filme.getTitulo());
                stmt.setString('2', filme.getDiretor());
                stmt.setInt('3', Integer.parseInt(filme.getAno()));
                stmt.setString('4', filme.getGenero());

                stmt.executeUpdate();

                stmt.close();
                conn.close();

                System.out.println("Filme inserido com sucesso!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    private String getGenero() {
        return "";
    }

    private String getAno() {
        return "";

    }

    private String getDiretor() {
        return "";
    }

    private String getTitulo() {
        return "";
    }

    }


