<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar tema</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/BotaoDoJapa.css" rel="stylesheet">

</head>
<body>
	<!-- Barra superior Menu -->
	<c:import url="Menu.jsp" />

	<!-- Container principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar tema#${tema.id}</h3>
		<!-- formulario de alteracao de tema -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${tema.id}"/>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="titulo">Titulo:</label>
					<input type="text" class="form-control" name="titulo" id="titulo" required maxlength="12" placeholder="Titulo do tema" value="${tema.titulo}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="requisitos">Requisitos:</label>
					<input type="text" class="form-control" name="requisitos" id="requisitos" value="${tema.requisitos}">
				</div>
				
				<div class="form-group col-md-6">
					<label for="introducao">Introdução:</label>
					<input type="text" class="form-control" name="introducao" id="introducao" value="${tema.introducao}">
				</div>
			</div>
			<hr/>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command" value="AlterarTema">Salvar</button>
					<a href="ListarTema.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
		
	</div>
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>