package controller;

import database.UsuarioDAO;
import model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastroUsuarioServlet", urlPatterns = {"/CadastroUsuarioServlet"})
public class CadastroUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Recuperando os dados do formulário
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("nascimento");
            String senha = request.getParameter("senha");
            String celular = request.getParameter("celular");
            String cep = request.getParameter("cep");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");


            Usuario novoUsuario = new Usuario(nome, email, nascimento, senha, celular, cep, rua, numero, bairro, cidade);

            try {
                // Criando a instância do UsuarioDAO
                UsuarioDAO usuarioDAO = new UsuarioDAO();

                // Salvando o novo usuário no banco de dados
                usuarioDAO.setNewUser(novoUsuario);

                // Exibindo mensagem de sucesso
                out.println("<html>");
                out.println("<head><title>Cadastro de Usuário</title></head>");
                out.println("<body>");
                out.println("<h1>Usuário cadastrado com sucesso!</h1>");
                out.println("<a href='cadastroUsuario.jsp'>Cadastrar outro usuário</a>");
                out.println("</body>");
                out.println("</html>");

            } catch (Exception e) {
                // Caso ocorra um erro, exibe uma mensagem de erro
                out.println("<html>");
                out.println("<head><title>Erro no Cadastro</title></head>");
                out.println("<body>");
                out.println("<h1>Erro ao cadastrar o usuário. Tente novamente mais tarde.</h1>");
                out.println("<a href='cadastroUsuario.jsp'>Voltar</a>");
                out.println("</body>");
                out.println("</html>");
                e.printStackTrace();
            }
        }
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
        return "Cadastro de Usuário";
    }
}
