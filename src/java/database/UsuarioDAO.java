package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {
    private static Connection conn;

    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        conn = Conexao.getConn();
    }

    public ArrayList<Usuario> getAllUsers() throws SQLException {
        ArrayList<Usuario> list = new ArrayList<>();
        String query = "SELECT * FROM usuarios;";
        try (PreparedStatement prep = conn.prepareStatement(query)) {
            ResultSet res = prep.executeQuery();
            
            while (res.next()) {
                // Criando o usuário com todos os parâmetros do banco de dados
                Usuario user = new Usuario(
                        res.getString("nome"),
                        res.getString("email"),
                        res.getString("nascimento"),
                        res.getString("senha"),
                        res.getString("celular"),
                        res.getString("cep"),
                        res.getString("rua"),
                        res.getString("numero"),
                        res.getString("bairro"),
                        res.getString("cidade")
                );
                user.setId(res.getInt("id"));
                list.add(user);
            }
        }
        return list;
    }

    public void setNewUser(Usuario user) throws SQLException {
        String query = "INSERT INTO usuarios(nome, email, nascimento, senha, celular, cep, rua, numero, bairro, cidade) "
                     + "VALUES(?, ?, ?, SHA1(?), ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, user.getNome());
            prep.setString(2, user.getEmail());
            prep.setString(3, user.getNascimento());
            prep.setString(4, user.getSenha());
            prep.setString(5, user.getCelular());
            prep.setString(6, user.getCep());
            prep.setString(7, user.getRua());
            prep.setString(8, user.getNumero());
            prep.setString(9, user.getBairro());
            prep.setString(10, user.getCidade());
            prep.execute();
        }
    }

    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = ?;";
        try (PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setInt(1, id);
            prep.execute();
        }
    }

    public Usuario getOneUser(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?;";
        Usuario user;
        try (PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setInt(1, id);
            ResultSet res = prep.executeQuery();
            user = null;
            if (res.next()) {
                user = new Usuario(
                        res.getString("nome"),
                        res.getString("email"),
                        res.getString("nascimento"),
                        res.getString("senha"),
                        res.getString("celular"),
                        res.getString("cep"),
                        res.getString("rua"),
                        res.getString("numero"),
                        res.getString("bairro"),
                        res.getString("cidade")
                );
                user.setId(res.getInt("id"));
            }
        }
        return user;
    }

    public Usuario getOneUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE email = ?;";
        Usuario user;
        try (PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, email);
            ResultSet res = prep.executeQuery();
            user = null;
            if (res.next()) {
                user = new Usuario(
                        res.getString("nome"),
                        res.getString("email"),
                        res.getString("nascimento"),
                        res.getString("senha"),
                        res.getString("celular"),
                        res.getString("cep"),
                        res.getString("rua"),
                        res.getString("numero"),
                        res.getString("bairro"),
                        res.getString("cidade")
                );
                user.setId(res.getInt("id"));
            }
        }
        return user;
    }

    public void updateUser(Usuario user) throws SQLException {
        String query = "UPDATE usuarios SET nome = ?, email = ?, nascimento = ?, senha = SHA1(?), celular = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ? WHERE id = ?";
        try (PreparedStatement prep = conn.prepareStatement(query)) {
            prep.setString(1, user.getNome());
            prep.setString(2, user.getEmail());
            prep.setString(3, user.getNascimento());
            prep.setString(4, user.getSenha());
            prep.setString(5, user.getCelular());
            prep.setString(6, user.getCep());
            prep.setString(7, user.getRua());
            prep.setString(8, user.getNumero());
            prep.setString(9, user.getBairro());
            prep.setString(10, user.getCidade());
            prep.setInt(11, user.getId());
            prep.execute();
        }
    }
}
