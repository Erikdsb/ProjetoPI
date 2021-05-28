<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar turma</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<!-- Barra superior Menu -->
	<c:import url="Menu.jsp" />

	<!-- Container principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar turma#${turma.id}</h3>
		<!-- formulario de alteracao de turma -->
		<form action="controller.do" method="post">
			<!-- area de campos do form -->
			<input type="hidden" name="id" value="${turma.id}"/>
			<div class="row">
				<div class="form-group col-md-12">
					<label for="sigla">Sigla</label>
					<input type="text" class="form-control" name="sigla" id="sigla" required maxlength="12" placeholder="Sigla da turma" value="${turma.sigla}">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="semestre">Semestre letivo</label>
					<input type="text" class="form-control" name="semestre" id="semestre" value="${turma.semestreLetivo}">
				</div>
				
				<div class="form-group col-md-6">
					<label for="ano">Ano letivo</label>
					<input type="text" class="form-control" name="ano" id="ano" value="${turma.anoLetivo}">
				</div>
			</div>
			<hr/>
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="command" value="AlterarTurma">Salvar</button>
					<a href="ListarTurma.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</body>
</html>