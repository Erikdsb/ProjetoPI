<%@page language = "java" contentType = "text/html; charset=UTF-8"
	pageEncoding = "UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" id="nave">
	<div class = "container-fluid">
		<div class = "navbar-header">
			<button type = "button" class = "navbar-toggle collapsed"
				data-toggle = "collapse" data-target = "#navbar" aria-expanded = "false"
				aria-controls = "navbar">
				<span class = "sr-only">Toggle navigation</span> <span
					class = "icon-bar"></span> <span class="icon-bar"></span> <span
					class = "icon-bar"></span>
			</button>
			<a class = "navbar-brand" href = "index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a>
		</div>
		<div id = "navbar" class = "navbar-collapse collapse">
			<ul class = "nav navbar-nav navbar-right">
				<li><a href = "controller.do?command=ListarTurmaReiniciar">Turmas</a></li>
				<li><a href = "controller.do?command=ListarTemaReiniciar">Temas</a>
			</ul>
		</div>
	</div>
</nav>