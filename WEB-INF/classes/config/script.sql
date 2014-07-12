drop database if exists projeto;
create database projeto;
use projeto;

create table endereco(
	codEndereco int primary key auto_increment,
	logradouro varchar(50),
	numero int,
	complemento varchar(60),
	bairro varchar(60),
	cidade varchar(60),
	estado varchar(60),
	cep varchar(50)
);

create table usuario(
	codUsuario int primary key auto_increment,
	matricula varchar(50),
	senha varchar(100),
	cpf varchar(30) unique,
	nome varchar(35),
	email varchar(35),
	telefone varchar(35),
	perfil varchar(50)
);



create table usuario_endereco(
	idUsuario int not null,
	idEndereco int not null,
	foreign key (idUsuario) references usuario(codUsuario) on update cascade on delete cascade,
	foreign key (idEndereco) references endereco(codEndereco)on update cascade on delete cascade
);

create table area(
	codArea int primary key auto_increment,
	nome varchar(30)
);

create table curso(
	codCurso int primary key auto_increment,
	nome varchar(30),
	idArea int,
	foreign key (idArea) references area(codArea)
);

create table pontuacao(
	codPontuacao int primary key auto_increment,
	ponto int,
	descricao varchar(255)
);

create table curso_usuario(
	idCurso int not null,
	idUsuario int not null,
	foreign key (idCurso) references curso(codCurso),
	foreign key (idUsuario) references usuario(codUsuario)
);


create table pontuacao_usuario(
	de int not null,
	para int not null,
	idPontuacao int not null,
	foreign key (de) references usuario(codUsuario),
	foreign key (para) references usuario(codUsuario),
	foreign key (idPontuacao) references pontuacao(codPontuacao)
);

create table noticia(
	idNoticia int primary key auto_increment,
	titulo varchar(30),
	descricao varchar(255),
	foto varchar(255)
	);

create table agenda(
	idAgenda int primary key auto_increment,
	titulo varchar(30),
	detalhe varchar(255),
	data varchar(25)
	);
