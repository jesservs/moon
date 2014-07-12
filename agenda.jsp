<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.*, java.util.*, control.*" %>
<jsp:useBean id="mb" class="control.UsuarioEnderecoAction" scope="request"></jsp:useBean>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Agenda</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
		<script src="js/bootstrap.js" type="text/javascript"></script>
		<script src="js/jquery-1.3.2.min.js" type="text/javascript"></script>
		
	
	<script src="js/jquery.fullscreenr.js" type="text/javascript"></script>
		<script type="text/javascript">  
		var FullscreenrOptions = {  width: 1024, height: 683, bgID: '#bgimg' };
		jQuery.fn.fullscreenr(FullscreenrOptions);
		$( document ).ready(function() {
			$("#login").hide();
			$("#btnlogin").click(function() {
				  $("#login").show(1000);
			});
		});
		
	</script>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">MooN</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="consultar.jsp">Usuarios</a></li>
		<li><a href="buscanoticia.jsp">Noticias</a></li>
		<li><a href="buscaagenda.jsp">Agenda</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search" method="post" action="usuarioendereco.consultar.action">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="usuario.matricula">
        </div>
        <button type="submit" class="btn btn-default">Pesquisa</button>
        
        <input type="button" id="btnlogin" class="btn btn-success" value="Login"/>
      </form>
      <div id="login">
	      <form class="navbar-form navbar-left" role="form" action="logar.logar.action" method="post">
			  <div class="form-group">
			    <label class="sr-only" for="exampleInputEmail2">Matricula</label>
			    <input class="form-control" id="exampleInputEmail2" name="login.matricula" placeholder="Insira sua Matricula">
			  </div>
			  <div class="form-group">
			    <label class="sr-only" for="exampleInputPassword2">Senha</label>
			    <input type="password" class="form-control" id="exampleInputPassword2" name="login.senha" placeholder="Password">
			  </div>
			  <button type="submit" class="btn btn-default">Entrar</button>
			</form>
		</div>
    </div>
  </div>
</nav>

<ol class="breadcrumb">
  <li><a href="#">Home</a></li>
  <li><a href="agenda.jsp">Cadastrar Evento</a></li>
   <li><a href="buscaagenda.jsp">Consultar Eventos</a></li>

   
</ol>



<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					Agenda<small>Subtext for header</small>
				</h1>
			</div>
		</div>
	</div>
</div>


<div class="container">
<h3><span class="label label-default">${msg}</span></h3>
	<form class="form-horizontal" role="form" method="post" action="agenda.cadastrar.action">
		<div class="form-group">
	      <label>Título</label>
	      <input class="form-control" type="text" name="agenda.titulo">
	    </div>
	    <div class="form-group">
	      <label>Data</label>
	      <input class="form-control" type="date" name="agenda.data">
	    </div>
	    <div class="form-group">
	      <label>Detalhe</label>
			<input type="text"
	       		   cols="40" 
	       		   rows="5" 
	               style="width:200px; height:50px;" 
	               name="agenda.detalhe" 
	       />
	    </div>
	 
		
		<div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">Cadastrar</button>
		    </div>
	  	</div>
		
	</form>
</div>

</body>
</html>