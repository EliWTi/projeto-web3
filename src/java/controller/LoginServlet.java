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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login-servlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Verificando se o e-mail e a senha foram informados
        if (email != null && senha != null) {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario userLogged = dao.getOneUserByEmail(email); // Verificando no banco de dados se o usuário existe

            // Verifica se o usuário foi encontrado e se a senha corresponde
            if (userLogged != null && userLogged.getSenha().equals(senha)) {
                // Se o login for bem-sucedido, cria uma sessão e redireciona
                HttpSession session = request.getSession();
                session.setAttribute("autenticado", true);
                session.setAttribute("userLogged", userLogged);

                // Redirecionando o usuário para a página inicial ou para a página de administração (caso seja admin)
                if (userLogged.getEmail().equals("adm@dulcepaladar.com")) {
                    response.sendRedirect("listarProdutos.jsp"); // Página de administração
                } else {
                    response.sendRedirect("index.html"); // Página inicial do usuário
                }
            } else {
                // Caso o login falhe (usuário ou senha incorretos)
                response.sendRedirect("index.html?erro=1"); // Redireciona para o login com um erro (opcional)
            }
        } else {
            // Caso o e-mail ou senha não sejam informados
            response.sendRedirect("index.html?erro=1");
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
        return "Servlet para login de usuários";
    }
}
