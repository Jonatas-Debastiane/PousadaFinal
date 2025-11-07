<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Pousada Azul do Mar - Registro</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<%@ include file="_header.jsp"%>

	<main class="container" style="padding: 40px 0;">
		<h2>Criar Conta</h2>

		<%-- Exibir mensagem de erro ou sucesso do HospedeServlet --%>
		<% String msg = (String) request.getAttribute("mensagem");
           if (msg != null) { %>
		<p style="color: green; font-weight: bold;"><%= msg %></p>
		<% } %>

		<form action="HospedeServlet" method="post">
			<label for="nome">Nome Completo:</label> <input type="text" id="nome"
				name="nome" required> <label for="telefone">Telefone:</label>
			<input type="tel" id="telefone" name="telefone" required> <label
				for="email">E-mail:</label> <input type="email" id="email"
				name="email" required> <label for="senha">Senha:</label> <input
				type="password" id="senha" name="senha" required>

			<button type="submit" class="btn btn-primary">Registrar</button>
		</form>
	</main>

	<%@ include file="_footer.jsp"%>
</body>
</html>
