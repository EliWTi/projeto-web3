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
        PreparedStatement prep = conn.prepareStatement(query);
        ResultSet res = prep.executeQuery();

        while (res.next()) {
            Usuario user = new Usuario();
            user.setId(res.getInt("id"));
            user.setNome(res.getString("nome"));
            user.setEmail(res.getString("email"));
            user.setNascimento(res.getString("nascimento"));
            user.setSenha(res.getString("senha"));

            list.add(user);
            System.out.println(user);
        }

        prep.close();
        return list;
    }

    public void setNewUser(Usuario user) throws SQLException {
        String query = "INSERT INTO usuarios(nome, email, nascimento, senha) "
                     + "VALUES(?, ?, ?, SHA1(?))";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, user.getNome());
        prep.setString(2, user.getEmail());
        prep.setString(3, user.getNascimento());
        prep.setString(4, user.getSenha());
        prep.execute();
        prep.close();
    }

    public void deleteUser(int id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = ?;";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setInt(1, id);
        prep.execute();
        prep.close();
    }

    public Usuario getOneUser(int id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?;";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setInt(1, id);
        ResultSet res = prep.executeQuery();

        Usuario user = new Usuario();
        if (res.next()) {
            user.setId(res.getInt("id"));
            user.setNome(res.getString("nome"));
            user.setEmail(res.getString("email"));
            user.setNascimento(res.getString("nascimento"));
            user.setSenha(res.getString("senha"));
        }

        prep.close();
        return user;
    }

    public Usuario getOneUserByEmail(String email) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE email = ?;";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, email);
        ResultSet res = prep.executeQuery();

        Usuario user = new Usuario();
        if (res.next()) {
            user.setId(res.getInt("id"));
            user.setNome(res.getString("nome"));
            user.setEmail(res.getString("email"));
            user.setNascimento(res.getString("nascimento"));
            user.setSenha(res.getString("senha"));
        }

        prep.close();
        return user;
    }

    public void updateUser(Usuario user) throws SQLException {
        String query = "UPDATE usuarios SET nome = ?, email = ?, nascimento = ?, senha = SHA1(?) WHERE id = ?";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setString(1, user.getNome());
        prep.setString(2, user.getEmail());
        prep.setString(3, user.getNascimento());
        prep.setString(4, user.getSenha());
        prep.setInt(5, user.getId());
        prep.execute();
        prep.close();
    }
}
