<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Produtos</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <nav class="bg-padrao">
        <div class="nav-logo">
            <img src="img/logo.png" alt="alt"/>
        </div>

        <ul class="nav-menu">
            <li><a href="index.html">Home</a></li>
            <li><a href="cadastro.jsp">Cadastro</a></li>
            <li><a href="menu.jsp">Menu</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="listarProdutos.jsp">Lista de Produtos</a></li>
        </ul>

        <div>
            <img class="icon-perfil invert-icon" src="img/perfil.png" alt="alt"/>
            <a class="botao-reservar" href="url">Reservar Mesa</a>
        </div>
    </nav>

    <div class="container">
        <h1 class="text-center">Cadastro de Produtos</h1>
        <p class="text-center destaque">Adicione produtos ao catálogo com facilidade.</p>
        <form action="${pageContext.request.contextPath}/CadastroProdutoServlet" method="post" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="nome" class="form-label">Nome do Produto</label>
                <input type="text" name="nome" id="nome" class="form-control" maxlength="30" required>
            </div>

            <div class="mb-3">
                <label for="descricao" class="form-label">Descrição</label>
                <textarea name="descricao" id="descricao" class="form-control" rows="3" required></textarea>
            </div>

            <div class="mb-3">
                <label for="preco" class="form-label">Preço</label>
                <input type="number" name="preco" id="preco" class="form-control" step="0.01" required>
            </div>

            <div class="mb-3">
                <label for="estoque" class="form-label">Quantidade em Estoque</label>
                <input type="number" name="estoque" id="estoque" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="categoria" class="form-label">Categoria</label>
                <select name="categoria" id="categoria" class="form-select" required>
                    <option value="bebidas">Bebidas</option>
                    <option value="salgados">Salgados</option>
                    <option value="doces">Doces</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="imagem" class="form-label">Imagem do Produto</label>
                <input type="file" name="imagem" id="imagem" class="form-control" accept="image/*" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Cadastrar Produto</button>
            </div>
        </form>
    </div>

    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
