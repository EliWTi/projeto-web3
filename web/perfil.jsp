<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<% 
    // Verificando se o usuário está logado
    if (session.getAttribute("usuario") == null) {
        // Caso não esteja logado, redireciona para a página de login
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil - Dulce Paladar</title>
</head>
<body>
    <!-- Conteúdo da página de perfil vai aqui -->

    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #c5c4c3;">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.html">
                <img src="img/logo.png" alt="Logo" style="width: 40px; height: auto;"> Dulce Paladar
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Início</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cadastro.html">Cadastro</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="menu.html">Menu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="sobre.html">Sobre</a>
                    </li>
                </ul>

                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="pedidos.jsp">
                            <img src="img/carrinho.png" alt="Carrinho" style="width: 30px; height: auto;">
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="perfil.jsp">
                            <img src="img/perfil.png" alt="Perfil" style="width: 30px; height: auto;">
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>
