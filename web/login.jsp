<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Cafeteria</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

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
                        <img src="img/compras.png" alt="Carrinho" style="width: 30px; height: auto;">
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

    <div class="container mt-5 text-center col-sm-10 col-md-6">
        <h2>Login</h2>

        <c:if test="${not empty param.error}">
            <div class="alert alert-danger" role="alert">
                E-mail ou senha incorretos. Tente novamente.
            </div>
        </c:if>

        <form action="login-controller" method="post" class="validar" novalidate>
            <div class="form-floating mt-3">
                <input type="email" id="email" name="email" class="form-control" placeholder="email@exemplo.com" required>
                <label for="email">E-mail</label>
            </div>

            <div class="form-floating mt-3">
                <input type="password" id="senha" name="senha" class="form-control" placeholder="Senha" required>
                <label for="senha">Senha</label>
            </div>

            <hr>

            <div class="d-grid mt-4">
                <input type="submit" value="Entrar" class="btn btn-success">
                <input type="reset" value="Limpar campos" class="btn btn-outline-danger mt-3">
            </div>
        </form>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>
