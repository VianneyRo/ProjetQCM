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

	<body>
		<header>
			<div class="logo-container"></div>
			<nav></nav>
			<div class="profile-container">
			</div>
		</header>
		<div class="main-container" style="text-align:center">
			<div class="array-wrapper">
				<div class="array-container">
					<div class="titre-array">
						<h2>Mes Épreuves</h2>
					</div>
					<div class="header-array">
						<div class="e-libelle">NOM</div>
						<div class="e-duree">DUREE</div>
						<div class="e-date-debut">DATE</div>
						<div class="e-actions"></div>
					</div>
					<div class="liste-array">
						<c:forEach items="${epreuves}" var="epreuve">
							<div class="item">
								<div class="e-libelle i-display-left">${epreuve.libelle}</div>
								<div class="e-duree i-display-center">${epreuve.duree}</div>
								<div class="e-date-debut i-display-center">${epreuve.dateDebut}</div>
								<div class="e-actions i-display-right">
									<form method="GET" action="passerEpreuve">
										<input class="hidden" type="text" value="1" name="utilisateurId"/>
										<button class="action-button" type="submit">
											<i class="fas fa-arrow-right"></i>
										</button>
									</form>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- <div class="pages-array">
						<form method="GET" action="triUtilisateurs">
							<input/>
						</form>
					</div> -->
					<!-- <div class="ajout-array">
						<form method="POST" action="gestionUtilisateurs">
							<input type="text" name=""/>
						</form>
					</div> -->
				</div>
			</div>
		</div>
		<footer>
			<div class="copyright-container">
				<p>&copy; 2018 Copyright: <a href="https://www.eni-ecole.fr"> ENI Ecole</a></p>
			</div>
		</footer>
	</body>
</html>