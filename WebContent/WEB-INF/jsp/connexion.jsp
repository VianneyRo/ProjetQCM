<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="sebeez">
  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
  <title>Projet QCM : Page de Connexion</title>

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery-3.2.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/functions.js"></script>

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#" >Questionnaire � choix multiple</a>
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
    
        <h1 class="mt-5"><u>Authentifiez-vous</u></h1>

        <div class="alert alert-danger" id="alert-message" style="visibility: hidden"></div>
        <div class="alert alert-info" id="info-message" role="alert" style="visibility: hidden"> </div>

                <form method="POST" action="ConnexionController">
            <fieldset>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="" />
                <br />

                <label for="motdepasse">Mot de passe <span class="re	quis">*</span></label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
              
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
            </fieldset>
        </form>
    </div>
</div>

<footer class="page-footer font-small">
    <div class="footer-copyright text-center py-3">&copy; 2018 Copyright:
      <a href="https://www.eni-ecole.fr"> ENI Ecole</a>
    </div>
</footer>

</body>
