<%@page import="br.com.fabricadeprogramador.persistencia.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<Usuario> lista = (ArrayList<Usuario>)request.getAttribute("lista");%>
	<table border="1" align="center" width="60%	">
		<tr>
			 <th>ID</th>
			 <th>NOME</th>
			 <th>LOGIN</th> 
			 <th>AÇÃO</th> 
		 </tr>
		<% for(Usuario u : lista){ %>
		<tr>
			<td><% out.print(u.getId());%></td>
			<td><% out.print(u.getNome()); %></td>
			<td><% out.print(u.getLogin()); %></td>
			<td><a href="usuarioController.do?acao=excluir&id=<%= u.getId() %>"> Excluir</a></td>
		</tr>
	<%} %>
	</table>
</body>
</html>