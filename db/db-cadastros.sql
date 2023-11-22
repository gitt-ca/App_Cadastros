create database db_cadastros;

show databases;

use db_cadastros;

show tables;
desc produto;
desc usuario;

select * from produto;

select * from produto where id=8;

delete  from produto;

INSERT INTO produto(nome,qtde_estoque,valor_unitario) VALUES ("cafe",88,5);

desc venda;

INSERT INTO venda(qtde,valor_total) VALUES (8,5);

select * from venda;

update venda set qtde=5 where id=1;


drop table vendendor;

SET FOREIGN_KEY_CHECKS=0;
SET FOREIGN_KEY_CHECKS=1;


delete from usuario;
select * from usuario;
INSERT INTO usuario(nome,sobrenome,senha,habilitado) VALUES ("Caio","Giaretton","123",1);

INSERT INTO vendedor(nome,sobrenome,habilitado) VALUES ("Caio","Giaretton",1);

select * from vendedor;


CREATE TABLE usuario(
	id INT auto_increment  NOT NULL,
    nome varchar(30) not null,
    sobrenome varchar(30) not null,
    senha varchar(30) not null,
    data_cadastro TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    habilitado BOOLEAN not null,
    
    primary key (id)
    
);

CREATE TABLE vendedor(
	id INT auto_increment  NOT NULL,
    nome varchar(30) not null,
    sobrenome varchar(30) not null,
    data_entrada TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
    habilitado BOOLEAN not null,
    
    primary key (id)
    
);

CREATE TABLE venda(
	id INT auto_increment  NOT NULL,
    qtde INT NOT NULL,
    data_venda TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
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



select * from venda;
select * from produto;
select * from venda_produto;

INSERT INTO venda_produto(qtde,valor_unitario,valor_total_produto,id_venda,id_produto) VALUES (6,2,12,1,15);

INSERT INTO venda_produto(qtde,valor_unitario,valor_total_produto,id_venda,id_produto) VALUES (5,12,152,1,15);

select * from venda_produto;

desc venda_produto;
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

