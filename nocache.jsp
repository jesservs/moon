<%

	response.setHeader("pragma","no-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires",0);
	response.setDateHeader("max-age",0);

	response.sendRedirect("index.jsp");
	
%>