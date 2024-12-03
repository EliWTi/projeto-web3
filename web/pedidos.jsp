<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos - Dulce Paladar</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="icon" href="img/iconf.png"/>
    <style>
        body {
            background-image: url('img/fundo.jpg');
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            margin: 0;
            height: 100vh;
        }

        .navbar {
            background-color: rgb(176, 154, 143);
        }

        .navbar-brand, .nav-link {
            color: white !important;
        }

        .content {
            background-color: rgba(227, 201, 187, 0.9); /* Tom mais próximo da barra de navegação */
            color: #333;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
            margin: 50px auto;
            max-width: 600px;
        }

        h1, p {
            margin: 0 0 20px;
            font-weight: bold;
        }

        .product {
            border: 1px solid #ccc;
            padding: 15px;
            margin: 10px;
            border-radius: 8px;
            background-color: rgba(227, 201, 187, 0.8); /* Ajustado para tom próximo da navbar */
            color: #333;
        }

        .product img {
            width: 100%;
            height: auto;
            border-radius: 5px;
        }

        .btn-add-to-cart {
            background-color: #c5c4c3;
            border: none;
            color: white;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }

        .cart-container {
            background-color: rgba(227, 201, 187, 0.8); /* Ajuste do fundo */
            padding: 20px;
            margin-top: 30px;
            border-radius: 8px;
        }

        .cart-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }

        .cart-total {
            font-size: 18px;
            font-weight: bold;
            margin-top: 20px;
            color: #333;
        }

        .btn-remove {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 5px;
            border-radius: 5px;
            cursor: pointer;
        }

        .container {
            padding: 40px;
        }

        .cart-item p {
            color: #555;
        }

        .cart-total {
            color: #28a745;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light">
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

<div class="container mt-5">
    <h1 class="text-center">Seu Pedido</h1>

    <div class="row">
        <div class="col-md-3 product">
            <img src="img/chocolate-quente.png" alt="Produto 1">
            <h4>Chocolate Quente</h4>
            <p>Chocolate quente, preparado com leite, chocolate belga e chantily.</p>
            <button class="btn-add-to-cart" onclick="addToCart('Produto 1', 10)">Adicionar ao Carrinho - R$ 10,00</button>
        </div>
        <div class="col-md-3 product">
            <img src="img/capuccino.jpg" alt="Produto 2">
            <h4>Capuccino</h4>
            <p>Leite e Café</p>
            <button class="btn-add-to-cart" onclick="addToCart('Produto 2', 15)">Adicionar ao Carrinho - R$ 6,00</button>
        </div>
          <div class="col-md-3 product">
            <img src="img/coffe.JPG" alt="Produto 2">
            <h4>Café</h4>
            <p>Café preto, com os melhores grãos</p>
            <button class="btn-add-to-cart" onclick="addToCart('Produto 2', 15)">Adicionar ao Carrinho - R$ 4,00</button>
        </div>
    </div>

    <div class="cart-container">
        <h3>Itens no Carrinho:</h3>
        <div id="cart-items"></div>
        <p class="cart-total" id="total">Total: R$ 0</p>
        <button class="btn-add-to-cart" onclick="finalizarCompra()">Finalizar Compra</button>
    </div>
</div>

<script>
    let cart = [];
    let total = 0;

    function addToCart(product, price) {
        cart.push({ product, price });
        total += price;
        updateCart();
    }

    function removeFromCart(index) {
        total -= cart[index].price;
        cart.splice(index, 1); // Remove o item da lista
        updateCart(); // Atualiza o carrinho
    }

    function updateCart() {
        const cartItemsDiv = document.getElementById("cart-items");
        cartItemsDiv.innerHTML = ""; // Limpa os itens existentes

        cart.forEach((item, index) => {
            const cartItemDiv = document.createElement("div");
            cartItemDiv.classList.add("cart-item");
            cartItemDiv.innerHTML = `${item.product} - R$ ${item.price} 
                <button class="btn-remove" onclick="removeFromCart(${index})">Remover</button>`;
            cartItemsDiv.appendChild(cartItemDiv);
        });

        const totalDiv = document.getElementById("total");
        totalDiv.textContent = `Total: R$ ${total}`;
    }

    function finalizarCompra() {
        alert("Compra finalizada!");
        cart = [];
        total = 0;
        updateCart();
    }
</script>

<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>
