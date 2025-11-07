<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pousada Azul do Mar</title>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/quartos.css">
</head>

<body>
	<%@ include file="_header.jsp"%>
	<div class="room-card" id="quarto-vista-mar">
		<div>
			<img src="imagens/QuartoVistaMar.jpg" align="left" />
		</div>
		<h3>Quarto Vista Mar</h3>
		<p>Quarto com vista panorâmica para o mar, ar-condicionado e
			varanda privativa. possui uma cama dupla e duas de solteiro com
			frigobar, acomoda 4 pessoas, café incluso</p>
		<ul class="comodidades">
			<li>Wi-Fi</li>
			<li>Ar-condicionado</li>
			<li>TV</li>
			<li>Frigobar</li>
		</ul>
		<span class="preco">R$ 280/noite</span>
		<button class="btn btn-primary open-reserva"
			data-room="Quarto Vista Mar" data-id-quarto="1">Reservar</button>
	</div>

	<hr>
	<div class="room-card" id="suite-familia">
		<div>
			<img src="imagens/QuartoSuite.jpg" alt="Suíte Família" align="left" />
		</div>
		<h3>Suíte Família</h3>
		<p>Suíte ampla com dois quartos interligados, ideal para famílias.
			Acomoda até 6 pessoas.</p>
		<ul class="comodidades">
			<li>Wi-Fi</li>
			<li>Ar-condicionado</li>
			<li>2 TVs</li>
			<li>Frigobar</li>
			<li>Varanda</li>
			<li>Vista Jardim</li>
		</ul>
		<span class="preco">R$ 450/noite</span>
		<button class="btn btn-primary open-reserva" data-room="Suíte Família"
			data-id-quarto="2">Reservar</button>
	</div>

	<hr>
	<div class="room-card" id="quarto-standard">
		<div>
			<img src="imagens/QuartoStandard.avif" alt="Quarto Standard"
				align="left" />
		</div>
		<h3>Quarto Standard</h3>
		<p>QQuarto confortável e aconchegante com uma cama de casal e uma
			de solteiro. acomoda 3 pessoas</p>
		<ul class="comodidades">
			<li>Wi-Fi</li>
			<li>Ar-condicionado</li>
			<li>TV</li>

		</ul>
		<span class="preco">R$ 180/noite</span>
		<button class="btn btn-primary open-reserva"
			data-room="Quarto Standard" data-id-quarto="3">Reservar</button>
	</div>

	<hr>

	<div class="modal" id="reservaModal">
		<div class="modal-content">
			<span class="close-btn" id="closeModal">&times;</span>
			<h2>
				Reserva <span id="roomName"></span>
			</h2>
			<form id="reservaForm" action="ReservaServlet" method="post">

				<input type="hidden" name="idQuarto" id="idQuartoInput" value="">

				<label for="dataEntrada">Data de Entrada:</label> <input type="date"
					id="dataEntrada" name="dataEntrada" required> <label
					for="dataSaida">Data de Saída:</label> <input type="date"
					id="dataSaida" name="dataSaida" required> <label
					for="hospedes">Número de Hóspedes:</label> <input type="number"
					id="hospedes" name="hospedes" min="1" max="6" required>

				<button type="submit" class="btn btn-primary">Confirmar
					Reserva</button>
			</form>
		</div>
	</div>

	<%@ include file="_footer.jsp"%>
	<script src="js/script.js"></script>
</body>
</html>
