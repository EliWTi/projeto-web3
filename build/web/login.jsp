<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login - Dulce Paladar</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="icon" href="img/logotipo.png">
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
            </ul>

            <div>
                <img class="icon-perfil invert-icon" src="img/perfil.png" alt="alt"/>
                <a class="botao-reservar" href="url">Reservar Mesa</a>
            </div>


        </nav>
        
        <div class="login-container">
            <h1>Login</h1>

           
            <c:if test="${not empty mensagemErro}">
                <div class="alert alert-danger" role="alert">
                    ${mensagemErro}
                </div>
            </c:if>

            <form action="usuario-controller" method="post" class="needs-validation" novalidate>
                <input type="hidden" name="pagina" value="login">

                <div class="form-floating mt-3 mb-3">
                    <input 
                        type="email" 
                        id="email" 
                        name="email" 
                        class="form-control" 
                        placeholder="email@exemplo.com" 
                        required>
                    <label for="email">Email</label>
                    <div class="invalid-feedback text-start">
                        Por favor, insira seu email.
                    </div>
                </div>

                
                <div class="form-floating">
                    <input 
                        type="password" 
                        id="senha" 
                        name="senha" 
                        class="form-control" 
                        placeholder="Senha" 
                        required 
                        minlength="6">
                    <label for="senha">Senha</label>
                    <div class="invalid-feedback text-start">
                        A senha deve conter pelo menos 6 caracteres.
                    </div>
                </div>

                <div class="d-grid mt-4">
                    <button type="submit" class="btn btn-success">Entrar</button>
                    <a href="cadastro.html" class="btn btn-link mt-3">Cadastre-se</a>
                </div>
            </form>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
        <script>
            (function () {
                'use strict';
                var forms = document.querySelectorAll('.needs-validation');
                Array.prototype.slice.call(forms).forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            })();
        </script>
    </body>
</html>
