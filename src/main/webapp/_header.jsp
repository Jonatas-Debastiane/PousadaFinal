<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="modelos.Hospedes"%>

<% 
    // Obtém o objeto Hospedes da sessão (armazenado pelo LoginServlet)
    Hospedes usuarioLogado = (Hospedes) session.getAttribute("usuarioLogado");
%>

<header>
	<div class="container header-content">
		<a href="index.jsp" class="logo"><img src="imagens/logo.png"
			alt="Logo"></a>
		<nav class="menu">
			<a href="index.jsp">Home</a> <a href="quartos.jsp">Quartos</a> <a
				href="sobre.jsp">Sobre</a> <a href="contato.jsp">Contato</a>
		</nav>
		<div class="header-buttons">
			<% if (usuarioLogado != null) { 
        out.print("<span class='usuario-logado'>Olá,"+ usuarioLogado.getNome()+ "!</span>"+
       " <a href='LogoutServlet'class='btn btn-secondary'>Sair</a>");
       
       } else { 
    	   out.print("<a href='entrar.jsp' class='btn btn-primary'>Entrar</a>" +
    "<a href='registro.jsp' class='btn btn-secondary'>Registrar</a>");
       } %>
		</div>
	</div>
</header>
