

create database database_projeto;

-- Criando tabela de usuarios
CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `nascimento` date NOT NULL,
  `senha` text NOT NULL,
  `celular` char(11) NOT NULL,
  `cep` char(8) NOT NULL,
  `rua` varchar(150) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- Criando tabela de carões
CREATE TABLE `cartoes` (
  `idcartao` int NOT NULL AUTO_INCREMENT,
  `idusuario` int NOT NULL,
  `numero_cartão` char(16) NOT NULL,
  `nome_titular` varchar(100) NOT NULL,
  `validade` char(5) NOT NULL,
  `cvv` char(3) NOT NULL,
  `tipo` enum('credito','debito') NOT NULL,
  PRIMARY KEY (`idcartao`),
  KEY `fk_usuario_id_idx` (`idusuario`),
  CONSTRAINT `fk_usuario_id` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


  -- Criando tabela de podrutos
CREATE TABLE `produtos` (
  `idproduto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `descricao` text NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `estoque` int NOT NULL,
  `imagem` varchar(255) NOT NULL,
  `categoria` varchar(30) NOT NULL,
  PRIMARY KEY (`idproduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

-- Criando tabela de pedidos
CREATE TABLE `pedidos` (
  `idpedido` int NOT NULL,
  `idusuario` int NOT NULL,
  `dataPedido` datetime NOT NULL,
  `status` enum('pendente','em preparo','pronto para retirada','entregue','cancelado') NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `formaPagamento` enum('cartao_credito','cartao_debito','dinheiro') NOT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `fk_usuarioId_pedido_idx` (`idusuario`),
  CONSTRAINT `fk_usuarioId_pedido` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


-- Criando tabela de pedido x produto
CREATE TABLE `pedido_produtos` (
  `idprodutopedido` int NOT NULL AUTO_INCREMENT,
  `idpedido` int NOT NULL,
  `idproduto` int NOT NULL,
  `quantidade` int NOT NULL,
  `preco_unitario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idprodutopedido`),
  KEY `fk_pedido_id_idx` (`idpedido`),
  KEY `fk_produto_id_idx` (`idproduto`),
  CONSTRAINT `fk_pedido_id` FOREIGN KEY (`idpedido`) REFERENCES `pedidos` (`idpedido`),
  CONSTRAINT `fk_produto_id` FOREIGN KEY (`idproduto`) REFERENCES `produtos` (`idproduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
