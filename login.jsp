<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	
	
<div class="bs-docs-header" id="content">
      <div class="container">
        <h1>Comece agora</h1>
        <p>An overview of Bootstrap, how to download and use, basic templates and examples, and more.</p>
        <div id="carbonads-container">
		<div class="carbonad"><div id="azcarbon">
			<span class="carbonad-image"></span>
					<span class="carbonad-text"><a href="">The all-in-one solution</a>
					for your sales that your team will love to use.</span>
					<span class="carbonad-tag">ads via
					<a href="http://carbonads.com">Carbon</a></span>
					</div>
				</div>
			</div>

      </div>
    </div>
<br/><br/>
<div class="container">
<form class="form-horizontal" role="form" method="post" action="logar.logar.action">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Matricula</label>
    <div class="col-sm-10">
      <input name="login.matricula" class="form-control" id="inputEmail3" placeholder="Matricula">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name="login.senha"  class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Lembre-me
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Entrar</button>
    </div>
  </div>
</form>
</div>

</body>
</html>