<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Listar turmas</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir turma</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir esta turma?
				</div>
				<div class="modal-footer">
					<form action="controller.do" method="get">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="command" value="ExcluirTurma">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

<!-- Menu de navegação -->
<c:import url="Menu.jsp"/>
<!-- Container principal -->
<div id="main" class="container">
	<form action="controller.do" method="post">
		<div id="top" class="row">
			<div class="col-md-3">
				<h2>Turmas</h2>
			</div>
				
				<div class="col-md-6">
					<div class="input-group h2">
						<input name="data[search]" class="form-control" id="search" type="text" placeholder="Pesquisar turmas(Deixe vazio para buscar todos)">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="command" value="ListarTurmaBuscar">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
				
				<div class="col-md-3">
					<a href="controller.do?command=CriarTurmaPreparar" class="btn btn-primary pull-right h2" >Nova Turma</a>
				</div>
			</div>
			<!-- /#top -->

	</form>
	<hr />
	<c:if test ="${not empty lista}">
	<div id="list" class="row">
		
		<div class="table-responsive col-md-12">
			<table class="table table-hover" >
				<thead>
					<tr>
						<th>ID</th>
						<th>Semestre letivo</th>
						<th>Ano letivo</th>
						<th>Sigla</th>
						<th class="actions">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="turma" items="${lista}">
						<tr>
							<td>
								${turma.id}
							</td>
							<td>
								${turma.semestreLetivo}
							</td>
							<td>
								${turma.anoLetivo}
							</td>
							<td>
								${turma.sigla}
							</td>
							<td class="actions">
								<a class="btn btn-success btn-xs" href="controller.do?command=VisualizarTurma&id=${turma.id}&semestre=${turma.semestreLetivo}&ano=${turma.anoLetivo}&sigla=${turma.sigla}">Visualizar</a>
								<a class="btn btn-warning btn-xs" href="controller.do?command=EditarTurma&id=${turma.id}">Editar</a>
								<button id="btn${turma.id}%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-turma="${turma.id}">Excluir</button>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- #list -->
	<div id="bottom" class="row">
		<div class="col-md-12">
			<!-- paginação ainda não foi implementada -->
			<ul class="pagination">
				<li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
			</ul>
			<!-- /.pagination -->
		</div>
	</div>
	</c:if>
	<!-- /#bottom -->	
</div>
<!-- /#main -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$("#delete-modal").on('show.bs.modal', function(event) {
	    var button=$(event.relatedTarget); //botao que disparou a modal
	    var recipient=button.data('turma');
	    $("#id_excluir").val(recipient);
	});
</script>

</body>
</html>