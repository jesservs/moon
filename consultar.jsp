<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="refresh" content="1;URL=usuarioendereco.consultarTodos.action"> -->
<title>Insert title here</title>
	
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	
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
  <li><a href="cadastro.jsp">Cadastrar Usuarios</a></li>
   <li><a href="consultar.jsp">Buscar Usuarios</a></li>
</ol>



<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					Usuario <small>Subtext for header</small>
				</h1>
			</div>
		</div>
	</div>
</div>
	
	<h3>${msg}</h3>

 
      
      <div class="container">
 		     <form class="navbar-form navbar-left" role="search" method="post" action="usuarioendereco.consultar.action">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="usuario.matricula">
        </div>
        <button type="submit" class="btn btn-default">Pesquisa</button>
      </form>
      <a href="usuarioendereco.consultarTodos.action" class="btn btn-success" type="button">BuscarTodos</a>
      
      <br/>
      <br/>
      <div class="row clearfix">
		<div class="col-md-12 column">
		<table class="table">
			<tr>
				<th>Nome</th>
				<th>Matricula</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Perfil</th>
				
				<th>Logradouro</th>
				<th>Número</th>
				<th>Complemento</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>Cep</th>
				
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
		
		<s:iterator value="usuario">
			<tr>
			<s:hidden value="senha"/>
				<td><s:property value="nome"/></td>
				<td><s:property value="matricula"/></td>
				<td><s:property value="cpf"/></td>
				<td><s:property value="email"/></td>
				<td><s:property value="telefone"/></td>
				<td><s:property value="perfil"/></td>
			
			
				<td><s:property value="endereco.logradouro"/></td>
				<td><s:property value="endereco.numero"/></td>
				<td><s:property value="endereco.complemento"/></td>
				<td><s:property value="endereco.bairro"/></td>
				<td><s:property value="endereco.cidade"/></td>
				<td><s:property value="endereco.estado"/></td>
				<td><s:property value="endereco.cep"/></td>
			
				<s:url id="url" action="usuarioendereco.consultarDados">
					<s:param name="matricula" value="usuario.matricula"/>
				</s:url>
				<td><s:a href="%{url}">Alterar</s:a></td>
				
				<s:url id="url2" action="usuarioendereco.excluir">
					<s:param name="codUsuario" value="usuario.codUsuario"/>
					<s:param name="codEndereco" value="endereco.codEndereco"/>					
				</s:url>
					<td><s:a href="%{url2}">Excluir</s:a></td>
			</tr>
		</s:iterator>
		<s:iterator value="lista">
			<tr>
			<s:hidden value="senha"/>
				<td><s:property value="nome"/></td>
				<td><s:property value="matricula"/></td>
				<td><s:property value="cpf"/></td>
				<td><s:property value="email"/></td>
				<td><s:property value="telefone"/></td>
				<td><s:property value="perfil"/></td>
			
			
				<td><s:property value="endereco.logradouro"/></td>
				<td><s:property value="endereco.numero"/></td>
				<td><s:property value="endereco.complemento"/></td>
				<td><s:property value="endereco.bairro"/></td>
				<td><s:property value="endereco.cidade"/></td>
				<td><s:property value="endereco.estado"/></td>
				<td><s:property value="endereco.cep"/></td>
			
				<s:url id="url" action="usuarioendereco.consultarDados">
					<s:param name="matricula" value="usuario.matricula"/>
				</s:url>
				<td><s:a href="%{url}">Alterar</s:a></td>
				
				<s:url id="url2" action="usuarioendereco.excluir">
					<s:param name="codUsuario" value="usuario.codUsuario"/>
					<s:param name="codEndereco" value="endereco.codEndereco"/>					
				</s:url>
					<td><s:a href="%{url2}">Excluir</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
	</div>
	</div>

</body>
</html>