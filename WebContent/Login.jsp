<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Controle de PIS</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<style>
          body{
             background-image: url("img/tela_cadastro.jpg");
             background-size: cover;
             background-repeat: no-repeat;
			 background-attachment: fixed;
          }
   </style>
</head>
<body>
	<!-- Barra superior menu -->
	<c:import url="Menu.jsp"/>
	
	<!-- Container principal -->
	<div id="main" class="container">
		<h3 class="page-header">Login</h3>
		<!-- Form de Login -->
		<form action="controller.do" method="post">
			<div class="row col-md-12">
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="input-group-text" id="basic-addon1" aria-hidden="true">@</span></div> 
					   <input type="email" name="username" id="username" class="form-control" maxlength="60" placeholder="E-mail" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group col-md-4">
					   <div class="input-group-addon"><span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span></div> 
					   <input type="password" name="passwd" id="passwd" class="form-control" placeholder="Senha" required/>
					</div>
				</div>
				</div>
				<div class="row col-md-12">
					<button type="submit" class="btn btn-primary btn-lg" name="command" value="FazerLogin"><span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span> Entrar</button>
				</div>
		</form>
	</div>
</body>
</html>