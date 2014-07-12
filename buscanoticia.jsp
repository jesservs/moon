<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
  <li><a href="noticia.jsp">Cadastrar Notícias</a></li>
   <li><a href="buscanoticia.jsp">Buscar Notícias</a></li>
</ol>
	
	
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					Noticias <small>Subtext for header</small>
				</h1>
			</div>
		</div>
	</div>
</div>


	<h3>${msg}</h3>

	
		
		
		
		<div class="container">
			<s:form method="post" action="noticia.listar">
		
		
		<s:submit value="Buscar"></s:submit>
				
	</s:form>
		
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="row">
						<s:iterator value="lista">
							<div class="col-md-4">
								<div class="thumbnail">
									<img alt="300x200" src="http://lorempixel.com/600/200/people" />
									<div class="caption">
										<h3>
											<s:property value="titulo"/>
										</h3>
										<p>
											<s:property value="descricao"/>
										</p>
										<p>
											<a class="btn" href="noticia.excluir.action?idNoticia=${idNoticia}">Excluir</a>
										</p>
									</div>
								</div>
							</div>	
						</s:iterator>
						
					</div>
				</div>
			</div>
		</div>
	


</body>
</html>