<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="fr">
	<head>
		<title>Accueil Candidat</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="sebeez">
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/array.css">
		<link rel="stylesheet" href="css/candidat/accueil.css">
	</head>

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/functions.js"></script>

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#" >Questionnaire à choix multiple</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent"></div>
		</div>
	</nav>

	<div class="container center" style="text-align:center">
		<div class="col-md-12">
			<h1 class="mt-5">Liste des Tests à Faire</h1>
		</div>

		<table id="tableauTheme" class="table">		
			<thead class ="card-header" style="background-color: #e3f2fd;">
				<tr>
					<th scope="col">Libellé</th>
					<th scope="col">Description</th>
					<th scope="col">Durée</th>
					<th scope="col"></th>
				</tr>		
			</thead>
			<tbody>		
				<c:forEach items="${epreuves}" var="epreuve">
					<tr>
						<td>${epreuve.libelle}</td>
						<td>${epreuve.description}</td>
						<td>${epreuve.duree}</td>
						<td>
							<form>
								<input type="hidden" value="${epreuve.id}" name="idEpreuve">
								<button type="button" class="btn btn-warning">Passer le test</button>
							</form>
						</td>
					</tr>		
				</c:forEach>	
			</tbody>
		</table>
				
	</div>

<footer class="page-footer font-small">
	<div class="footer-copyright text-center py-3">&copy; 2018 Copyright:
		<a href="https://www.eni-ecole.fr"> ENI Ecole</a>
	</div>
</footer>

</body>
