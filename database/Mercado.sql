CREATE DATABASE Mercado;

USE Mercado;

CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

CREATE TABLE Venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dataVenda DATE,
    quantidade INT NOT NULL,
    idProduto INT,
    FOREIGN KEY (idProduto) REFERENCES Produto(id)
);
