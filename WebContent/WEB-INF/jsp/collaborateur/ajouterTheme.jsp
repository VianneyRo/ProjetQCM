<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="sebeez">
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
<title>Nouveau thème</title>

<link rel="stylesheet" href="../css/ajouterThemes.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/popper.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/functions.js"></script>
  
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Collaborateur : Gestion des thèmes</a>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

			</div>
		</div>
	</nav>

	<div class="container center" style="text-align:center">
		<div class="col-md-12">
			<h1 class="mt-5">Nouveau thème</h1>
			
		</div>
		<form action="ajoutThemeController" method="post">
			Libellé : <input type="text" name="libelle" id ="libelle">
			<input type="submit" value="Valider">
		</form>
	</div>


</body>
</html>