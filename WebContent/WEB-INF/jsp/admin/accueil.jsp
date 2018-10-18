<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="fr">
	<head>
		<title>Accueil Administrateur</title>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="author" content="sebeez">
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
		<link rel="stylesheet" href="css/main.css">
		<link rel="stylesheet" href="css/admin/accueil.css">
	</head>

	<body>
		<header>
			<div class="logo-container"></div>
			<nav></nav>
			<div class="profile-container">
			</div>
		</header>
		<div class="main-container" style="text-align:center">
			<div class="tiles">
				<a href="administrateur/candidats" class="tile">
					<div class="tile-icon">
						<i class="fas fa-user-graduate"></i>
					</div>
					<div class="tile-title">
						<h2>Candidats</h2>
					</div>
				</a>
				<a href="administrateur/collaborateurs" class="tile">
					<div class="tile-icon">
						<i class="fas fa-user-tie"></i>
					</div>
					<div class="tile-title">
						<h2>Collaborateurs</h2>
					</div>
				</a>
			</div>
		</div>
		<footer>
			<div class="copyright-container">
				<p>&copy; 2018 Copyright: <a href="https://www.eni-ecole.fr"> ENI Ecole</a></p>
			</div>
		</footer>
	</body>
</html>