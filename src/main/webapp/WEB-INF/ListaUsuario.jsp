<%@page import="br.com.fabricadeprogramador.persistencia.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/foundation.css">
<script src="js/vendor/modernizr.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div>
					<% ArrayList<Usuario> lista = (ArrayList<Usuario>)request.getAttribute("lista");%>
							<table border="1" align="center" class="hover">
								<tr>
									 <th>ID</th>
									 <th>NOME</th>
									 <th>LOGIN</th> 
									 <th colspan="2">AÇÃO</th> 
								 </tr>
								<% for(Usuario u : lista){ %>
								<tr>
									<td><% out.print(u.getId());%></td>
									<td><% out.print(u.getNome()); %></td>
									<td><% out.print(u.getLogin()); %></td>
									<td><a href="usuarioController.do?acao=excluir&id=<%= u.getId() %>"> Excluir</a></td>
									<td><a href="usuarioController.do?acao=excluir&id=<%= u.getId() %>"> Editar</a></td>
								</tr>
								
							<%} %>
								<tr>
									<td><a href="FormularioUsuario.html">Adicionar novo</a></td>
								</tr>
								
							</table>
					</div>		
			</div>
	</div>
	<script src="js/vendor/jquery.js"></script>
<script src="js/foundation.min.js"></script>
<script>
$(document).foundation();
</script>
</body>
</html>