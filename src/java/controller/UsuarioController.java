package controller;

import org.apache.commons.codec.digest.DigestUtils;
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
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String pagina = request.getParameter("pagina");
        
        // Login
        if (pagina.equals("login")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Usuario u = new Usuario( email, DigestUtils.sha1Hex(senha) );
            
            try {
               if( u.login() ) {
                   UsuarioDAO dao = new UsuarioDAO();
                   Usuario userLogged = dao.getOneUserByEmail(email);
                   
                   HttpSession session = request.getSession();
                   session.setAttribute("autenticado", true);
                   session.setAttribute("userLogged", userLogged);
                   
                   if(email.equals("admin@admin")) {
                       response.sendRedirect("inicio.jsp");
                   } else {
                       response.sendRedirect("tarefas.jsp");
                   }
                   
               } else {
                   response.sendRedirect("index.html");
               }
            } catch(SQLException | ClassNotFoundException erro) {
                System.err.println( erro );
            }
        }
        
        // Cadastro
        if (pagina.equals("cadastro")) {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("nasc");
            String senha = request.getParameter("senha");

            Usuario u = new Usuario(nome, email, nascimento, senha);

            try {
                UsuarioDAO uDao = new UsuarioDAO();
                uDao.setNewUser(u);

                response.sendRedirect("index.html");

            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
            }
        }
        
        // Excluir usuário
        if(pagina.equals("excluir")) {
            int id = Integer.parseInt( request.getParameter("id") );
            
            try {
                UsuarioDAO dao = new UsuarioDAO();
                dao.deleteUser(id);
                
                response.sendRedirect("inicio.jsp");
            } catch(ClassNotFoundException | SQLException erro) {
                System.err.println( erro );
            }
        }
        
        // Editar usuário
        if(pagina.equals("editar")) {
            int id = Integer.parseInt( request.getParameter("id") );
            
            try {
                UsuarioDAO dao = new UsuarioDAO();
                Usuario u = dao.getOneUser(id);
                
                request.setAttribute("user", u);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch(ClassNotFoundException | SQLException erro) {
                System.err.println( erro );
            }
        }        
        
        // Atualizar usuário
        if (pagina.equals("atualizar")) {
            int id = Integer.parseInt( request.getParameter("id") );
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String nascimento = request.getParameter("nasc");

            Usuario u = new Usuario(id, nome, email, nascimento, "");

            try {
                UsuarioDAO uDao = new UsuarioDAO();
                uDao.updateUser(u);

                response.sendRedirect("inicio.jsp");

            } catch (SQLException | ClassNotFoundException erro) {
                System.err.println(erro);
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
        return "Pequena descrição";
    }

}
