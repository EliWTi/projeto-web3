<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="styles.css"> <!-- Adicione o caminho para o arquivo CSS -->
</head>
<body>
    <nav class="bg-padrao">
        <div class="nav-logo">
            <img src="img/logo.png" alt="Logo" />
        </div>

        <ul class="nav-menu">
            <li><a href="index.html">Home</a></li>
            <li><a href="cadastro.html">Cadastro</a></li>
            <li><a href="menu.html">Menu</a></li>
            <li><a href="login.jsp">Login</a></li>
        </ul>

        <div>
            <img class="icon-perfil invert-icon" src="img/perfil.png" alt="Perfil" />
            <a class="botao-reservar" href="url">Reservar Mesa</a>
        </div>
    </nav>

    <header class="header">
        <h1>Menu</h1>
    </header>

    <div class="menu-container">
        <%@ include file="listarProdutos.jsp" %>
    </div>
</body>
</html>
