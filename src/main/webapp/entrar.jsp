<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Pousada Azul do Mar</title>

<link rel="stylesheet" href="css/style.css" />
</head>
<body>


	<%@ include file="_header.jsp"%>
	<main class="container" style="padding: 40px 0;">
		<h2>Entrar</h2>

		<%-- Exibir mensagem de erro do LoginServlet --%>
		<% String erro = (String) request.getAttribute("erroLogin");
     if (erro != null) { %>
		<p style="color: red; font-weight: bold;"><%= erro %></p>
		<% } %>

		<%-- Exibir mensagem de sucesso do HospedeServlet --%>
		<% String msg = (String) request.getAttribute("mensagem");
     if (msg != null) { %>
		<p style="color: green; font-weight: bold;"><%= msg %></p>
		<% } %>

		<%-- Exibir erro de login necessário do ReservaServlet (usando parâmetro URL) --%>
		<% if ("login_necessario".equals(request.getParameter("erro"))) { %>
		<p style="color: red; font-weight: bold;">Você precisa estar
			logado para fazer uma reserva.</p>
		<% } %>

		<form id="loginForm" action="LoginServlet" method="post">
			<label for="loginEmail">E-mail:</label> <input type="email"
				**name="email" ** id="loginEmail" required> <label
				for="loginSenha">Senha:</label> <input type="password"
				**name="senha" ** id="loginSenha" required>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</main>

	<%@ include file="_footer.jsp"%>
	<script src="js/script.js"></script>
</body>