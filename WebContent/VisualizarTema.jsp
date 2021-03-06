<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="model.Tema"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPEhtml>
<html lang="pt-br">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Tema</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/BotaoDoJapa.css" rel="stylesheet">
<link href="css/BotaoDoJapaEditar.css" rel="stylesheet">

</head>
<body>
<!-- Modal -->
                <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                                </button>
                                <h4 class="modal-title" id="modalLabel">Excluir Tema</h4>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir este tema?
                            </div>
                            <div class="modal-footer">
                                <form action="controller.do" method="post">
                                    <input type="hidden" name="id" value="${tema.id}" />
                                    <button type="submit" class="btn btn-primary" name="command" value="ExcluirTema">Sim</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->

<!-- Menu -->
	<c:import url="Menu.jsp"/>
	
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">
			Visualizar Tema #${tema.id}</h3>
		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Titulo</strong>
				</p>
				<p>
					${tema.titulo}
				</p>
			</div>
			<div class = "col-md-6">
				<p>
					<strong>requisitos</strong>
				</p>
				<p>
					${tema.requisitos}
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Data de cadastro</strong>
				</p>
				<p>
					${tema.dt_cadastro}
				</p>
			</div>
			<div class="col-md-6">
				<p>
					<strong>Introdu????o</strong>
				</p>
				<p>
					${tema.introducao}
				</p>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="controller.do?command=EditarTema&id=${tema.id}" class="btn btn-primary">Editar</a>
                <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
				<a href="ListarTema.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>