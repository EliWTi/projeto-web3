package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {
    private static Connection conn;

    // Construtor que inicializa a conexão com o banco de dados
    public ProdutoDAO() throws ClassNotFoundException, SQLException {
        conn = Conexao.getConn();
    }

    // Método para listar todos os produtos
    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM produtos";
        PreparedStatement prep = conn.prepareStatement(query);
        ResultSet rs = prep.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdproduto(rs.getInt("idproduto"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setEstoque(rs.getInt("estoque"));
            produto.setImagem(rs.getString("imagem"));
            produto.setCategoria(rs.getString("categoria"));

            produtos.add(produto);
        }

        prep.close();
        return produtos;
    }

    // Método para adicionar um novo produto ao banco de dados
    public void adicionarProduto(Produto produto) throws SQLException {
        String query = "INSERT INTO produtos (nome, descricao, preco, estoque, imagem, categoria) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prep = conn.prepareStatement(query);

        prep.setString(1, produto.getNome());
        prep.setString(2, produto.getDescricao());
        prep.setDouble(3, produto.getPreco());
        prep.setInt(4, produto.getEstoque());
        prep.setString(5, produto.getImagem());
        prep.setString(6, produto.getCategoria());

        prep.execute();
        prep.close();
    }

    // Método para buscar um produto pelo ID
    public Produto buscarProdutoPorId(int idProduto) throws SQLException {
        String query = "SELECT * FROM produtos WHERE idproduto = ?";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setInt(1, idProduto);
        ResultSet rs = prep.executeQuery();

        Produto produto = null;
        if (rs.next()) {
            produto = new Produto();
            produto.setIdproduto(rs.getInt("idproduto"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setEstoque(rs.getInt("estoque"));
            produto.setImagem(rs.getString("imagem"));
            produto.setCategoria(rs.getString("categoria"));
        }

        prep.close();
        return produto;
    }

    // Método para excluir um produto pelo ID
    public void excluirProduto(int idProduto) throws SQLException {
        String query = "DELETE FROM produtos WHERE idproduto = ?";
        PreparedStatement prep = conn.prepareStatement(query);
        prep.setInt(1, idProduto);
        prep.execute();
        prep.close();
    }
}
