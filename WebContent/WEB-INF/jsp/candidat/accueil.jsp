<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="fr">
	<head>
		<title>Projet QCM : Accueil Candidat</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="sebeez">
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
		<link rel="stylesheet" href="css/main.css">
	</head>

	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="#" >Questionnaire à  choix multiple</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
				</div>
			</div>
		</nav>

		<style>
			img {
				cursor: pointer;
			}
			.center {
				float: none; 
				margin-left: auto;
				margin-right: auto;
			}
			
			.text-center {
				text-align: center;
			}
			
			.page-footer {
				position: absolute;
				bottom: 0;
				text-align: center;
				width: 100%;
			}
			
			.epreuves-container {
				display: flex;
				flex-flow: column nowrap;
			}
			
			.epreuve-container {
				flex: 0 0;
				display: flex;
				flex-flow: row nowrap;
				padding: 5px;
				margin: 5px 2px;
			}
			
			.epreuve-libelle {
				flex: 0 0 75%;
				display: flex;
				justify-content: flex-start;
				padding: 2px;
			}
			.epreuve-duree {
				flex: 0 0 25%;
				display: flex;
				justify-content: flex-duree;
			}
			.epreuve-libelle, .epreuve-duree {
				align-items: center;
			}
		</style>
	
		<div class="container center">
			<div class="col-md-12">
			    
				<h1 class="mt-5">Épreuves</h1>
				<div class="epreuves-container">
					<c:forEach items="${epreuves}" var="epreuve">
						<div class="epreuve-container">
							<div class="epreuve-libelle"><a href="${epreuve.id}">${epreuve.libelle}</a></div>
							<div class="epreuve-duree">${epreuve.duree}</div>
						</div>
					</c:forEach>
				</div>
		
		    </div>
		</div>
		
		<footer class="page-footer font-small">
			<div class="footer-copyright text-center py-3">&copy; 2018 Copyright:
				<a href="https://www.eni-ecole.fr"> ENI Ecole</a>
			</div>
		</footer>
	
	</body>
</html>