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
		<link href='agenda/fullcalendar.css' rel='stylesheet' />
		<link href='agenda/fullcalendar.print.css' rel='stylesheet' media='print' />
		<script src='agenda/lib/moment.min.js'></script>
		<script src='agenda/lib/jquery.min.js'></script>
		<script src='agenda/lib/jquery-ui.custom.min.js'></script>
		<script src='agenda/fullcalendar.min.js'></script>
		<script src='agenda/lang/pt-br.js'></script>
		<script>
		$(document).ready(function() {
			
			$('#calendar').fullCalendar({
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,agendaWeek,agendaDay'
				},
				editable: true,
				events: [${json}]
			});
			
		});
	</script>
</head>
<body>
   <li><a href="gerarCalendario.action">GERAR JSON</a></li>
<div id='calendar'></div>

</body>
</html>