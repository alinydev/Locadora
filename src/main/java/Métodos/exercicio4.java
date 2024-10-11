package Métodos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//4-Crie um método para exibir no console, todos os Endereços, cadastrados na tabela
//de mesmo nome. Se preferir, retorne uma lista de objetos, e imprima-a na console;


public class exercicio4 {

        private final String url = "jdbc:postgresql://localhost:5432/postgres";

        public <Endereco> List<Endereco> buscarTodosEnderecos() {
            String sql = "SELECT * FROM endereco";
            List<Endereco> listaEnderecos = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String rua = rs.getString("rua");
                    String cidade = rs.getString("cidade");
                    String estado = rs.getString("estado");
                    String cep = rs.getString("cep");


                    Endereco endereco = (Endereco) new exercicio3(rua, cidade, estado, cep);
                    endereco.wait(id); // Definir o ID do endereço


                    listaEnderecos.add(endereco);
                }

            } catch (SQLException e) {
                System.out.println("Erro ao buscar endereços: " + e.getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return listaEnderecos;
        }
    }


