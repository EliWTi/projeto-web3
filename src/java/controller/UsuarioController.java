package controller;

import database.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario-controller"})
public class UsuarioController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("UTF-8");

        String pagina = request.getParameter("pagina");

        // Verificando se é para fazer o login
        if ("login".equals(pagina)) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            // Criando o objeto Usuario apenas com o email
            UsuarioDAO dao = new UsuarioDAO();
            Usuario userLogged = dao.getOneUserByEmail(email); // Verificando no banco de dados se o usuário existe

            // Verifica se o usuário foi encontrado e se a senha corresponde
            if (userLogged != null && userLogged.getSenha().equals(senha)) {
                // Se o login for bem-sucedido, cria uma sessão e redireciona
                HttpSession session = request.getSession();
                session.setAttribute("autenticado", true);
                session.setAttribute("userLogged", userLogged);

                // Verificando o e-mail para redirecionar para a página de administração
                if (userLogged.getEmail().equals("adm@dulcepaladar.com")) {
                    response.sendRedirect("listarProdutos.jsp");
                } else {
                    response.sendRedirect("index.html");
                }

            } else {
                // Caso o login falhe
                response.sendRedirect("index.html");
            }
        }

        // Verificando se é para fazer o cadastro de um novo usuário
        if ("cadastro".equals(pagina)) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("nasc");
            String senha = request.getParameter("senha");
            String celular = request.getParameter("celular");
            String cep = request.getParameter("cep");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");

            // Criando o usuário com todos os dados
            Usuario u = new Usuario(nome, email, nascimento, senha, celular, cep, rua, numero, bairro, cidade);

            try {
                UsuarioDAO uDao = new UsuarioDAO();
                uDao.setNewUser(u);

                response.sendRedirect("index.html");

            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
                response.sendRedirect("erro.jsp");  // Redireciona para uma página de erro em caso de falha no cadastro
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Controller para login e cadastro de usuários";
    }
}
