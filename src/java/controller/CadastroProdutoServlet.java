package controller;

import database.ProdutoDAO;
import model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;

@WebServlet(name = "CadastroProdutoServlet", urlPatterns = {"/CadastroProdutoServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,       // 10MB
                 maxRequestSize = 1024 * 1024 * 50)    // 50MB
public class CadastroProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Recuperando os dados do formulário
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        double preco = Double.parseDouble(request.getParameter("preco"));
        int estoque = Integer.parseInt(request.getParameter("estoque"));
        String categoria = request.getParameter("categoria");

        // Processando o upload da imagem
        Part imagemPart = request.getPart("imagem");
        String imagem = saveUploadedFile(imagemPart);

        // Criando o objeto Produto
        Produto novoProduto = new Produto();
        novoProduto.setNome(nome);
        novoProduto.setDescricao(descricao);
        novoProduto.setPreco(preco);
        novoProduto.setEstoque(estoque);
        novoProduto.setCategoria(categoria);
        novoProduto.setImagem(imagem);

        // Criando a instância do ProdutoDAO
        try (PrintWriter out = response.getWriter()) {
            ProdutoDAO produtoDAO = new ProdutoDAO();  // Esse trecho pode lançar ClassNotFoundException ou SQLException

            // Salvando o novo produto no banco de dados
            produtoDAO.adicionarProduto(novoProduto);

            // Exibindo mensagem de sucesso
            out.println("<html>");
            out.println("<head><title>Cadastro de Produto</title></head>");
            out.println("<body>");
            out.println("<h1>Produto cadastrado com sucesso!</h1>");
            out.println("<a href='cadastroProduto.jsp'>Cadastrar outro produto</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException | SQLException e) {
            // Caso ocorra um erro, exibe uma mensagem de erro
            response.getWriter().println("<html><body><h1>Erro ao cadastrar o produto. Tente novamente mais tarde.</h1></body></html>");
            e.printStackTrace();
        }
    }

    private String saveUploadedFile(Part part) throws IOException {
        // Gera um nome único para o arquivo
        String fileName = UUID.randomUUID().toString() + ".jpg";
        
        // Caminho para salvar o arquivo (você pode modificar esse caminho conforme a necessidade)
        String uploadDir = getServletContext().getRealPath("/uploads");

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdir();
        }

        // Salva o arquivo
        part.write(uploadDir + File.separator + fileName);
        
        return fileName;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Cadastro de Produto";
    }
}
