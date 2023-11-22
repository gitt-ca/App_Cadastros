create database db_cadastros;

show databases;

use db_cadastros;

show tables;

CREATE TABLE usuario(
	id INT auto_increment  NOT NULL,
    nome varchar(30) not null,
    sobrenome varchar(30) not null,
    senha varchar(30) not null,
    data_cadastro date not null,
    habilitado BOOLEAN not null,
    
    primary key (id)
    
);

CREATE TABLE vendendor(
	id INT auto_increment  NOT NULL,
    nome varchar(30) not null,
    sobrenome varchar(30) not null,
    data_entrada DATE not null,
    habilitado BOOLEAN not null,
    
    primary key (id)
    
);

CREATE TABLE venda(
	id INT auto_increment  NOT NULL,
    qtde INT NOT NULL,
    data_venda DATE not null,
    valor_total DOUBLE not null,
    
    primary key (id)
    
);

CREATE TABLE produto(
	id INT auto_increment  NOT NULL,
    nome varchar(30) not null,
    qtde_estoque INT not null,
    valor_unitario DOUBLE not null,
    
    primary key (id)
    
);

CREATE TABLE venda_produto(
	id INT auto_increment NOT NULL PRIMARY KEY,
    qtde INT not null,
    valor_unitario DOUBLE not null,
    valor_total_produto double not null,
    id_venda INT NOT NULL,
    id_produto INT NOT NULL,
    FOREIGN KEY (id_venda) REFERENCES venda(id),
	FOREIGN KEY (id_produto) REFERENCES produto(id)

);

