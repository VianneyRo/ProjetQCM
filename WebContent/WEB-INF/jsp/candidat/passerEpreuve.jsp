<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="sebeez">
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
  <title>Projet QCM : Accueil Candidat</title>

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/functions.js"></script>

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
      </style>

<div class="container center" style="text-align:center">
	<div class="col-md-12">
		<div class="liste-questions-container">
			<c:forEach items="${questionsTirage}" var="questionTirage">
				<div class="question-container">
					<form method="get" action="candidat/passerEpreuve">
						<input type="number" name="epreuveId" value="${epreuve.id}"/>
						<input type="number" name="questionId" value="${questionTirage.id}"/>
						<a class="btn bt-small
							${questionTirage.marquee ? 'qestion-marquee' : ''}
							${questionId == currentQuestionTirage.id ? 'question-current' : ''}"
							type="submit">${question.num}</a>
					</form>
				</div>
			</c:forEach>
		</div>
	
        <h1 class="mt-5">Vous avez 1h pour répondre aux questions</h1>
		<c:forEach items="${questions}" var="question">
					<a href="#"><span id="lib">${question.enonce}</span></a>
				<br><br>
		
		</c:forEach>
		
		
		
		
		
		
    </div>
</div>

<footer class="page-footer font-small">
    <div class="footer-copyright text-center py-3">&copy; 2018 Copyright:
      <a href="https://www.eni-ecole.fr"> ENI Ecole</a>
    </div>
  </footer>

</body>