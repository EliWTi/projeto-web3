<%@page import="model.Usuario"%>
<%@ page import="model.Produto" %>
<%@ page import="database.ProdutoDAO" %>
<%@ page import="java.util.List" %>

<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("autenticado") == null || !(boolean) session.getAttribute("autenticado")) {
        response.sendRedirect("index.html"); // Se não estiver logado, redireciona para a página inicial
        return;
    }

    Usuario user = (Usuario) session.getAttribute("userLogged");
    if (user == null || !user.getEmail().equals("adm@dulcepaladar.com")) {
        response.sendRedirect("index.html"); // Se não for o admin, redireciona para a página inicial
        return;
    }
%>

<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <nav class="bg-padrao">
            <div class="nav-logo">
                <img src="img/logo.png" alt="alt"/>
            </div>

            <ul class="nav-menu">
                <li><a href="index.html">Home</a></li>
                <li><a href="cadastro.html">Cadastro</a></li>
                <li><a href="menu.jsp">Menu</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="produtos.jsp">Adicionar Produtos</a></li>
            </ul>

            <div>
                <img class="icon-perfil invert-icon" src="img/perfil.png" alt="alt"/>
                <a class="botao-reservar" href="url">Reservar Mesa</a>
            </div>
        </nav>

        <div class="container">
            <h1 class="text-center">Lista de Produtos</h1>
            <table class="table table-striped mt-4">
                <thead class="table-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Preço</th>
                        <th scope="col">Estoque</th>
                        <th scope="col">Categoria</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <%
                        ProdutoDAO produtoDAO = new ProdutoDAO();
                        List<Produto> produtos = produtoDAO.listarProdutos();

                        for (Produto produto : produtos) {
                    %>
                    <tr>
                        <td><%= produto.getIdproduto() %></td>
                        <td><%= produto.getNome() %></td>
                        <td><%= produto.getDescricao() %></td>
                        <td>R$ <%= produto.getPreco() %></td>
                        <td><%= produto.getEstoque() %></td>
                        <td><%= produto.getCategoria() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>

            <div class="text-center mt-4">
                <a href="cadastroProduto.jsp" class="btn btn-primary">Cadastrar Novo Produto</a>
            </div>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
