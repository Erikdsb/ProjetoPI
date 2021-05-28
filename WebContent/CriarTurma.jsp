<%@ page language="java" contentType="text/html; charset = UTF8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Cadastro de Turmas</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<!-- Barra superior com os menus de navegacao -->
	<c:import url="Menu.jsp" />
	<!-- Container principal -->
	<div id="main" class="container">
		<h3 class="page-header">Cadastro de Turmas</h3>
		<!-- formulario criacao de turma -->
		<form action="controller.do" method="get">
			<div class="row">
				<div class="form-group col-md-6">
					<label for="semestre">Semestre Letivo:</label> <input type="text"
						class="form-control" id="semestre" name="semestre" required>
				</div>
				<div class="form-group col-md-6">
					<label for="tema">Tema:</label>
					<select class="form-control" name="tema" id="tema">
						<c:forEach var="tema" items="${lista}">
							<option>${tema.titulo}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="ano">Ano Letivo:</label> <input type="text"
						class="form-control" id="ano" name="ano" required>
				</div>
			</div>
			<div class="form-group">
				<label for="sigla">Sigla</label> <input type="text"
					class="form-control" id="sigla" name="sigla" required>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="md-12">
					<button type="submit" class="btn btn-primary" name="command"
						value="CriarTurma">Enviar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>