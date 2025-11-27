<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>


 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Inscription - Bibliothèque</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
  <style>
    body {
      background: linear-gradient(135deg, #f1f8ff, #ffffff);
      height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .register-box {
      max-width: 500px;
      width: 100%;
      background-color: #fff;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    }
    .register-box h2 {
      font-weight: 600;
      margin-bottom: 20px;
    }
  </style>
</head>
<body>

  <div class="register-box">
    <h2 class="text-center"><i class="fas fa-user-plus me-2 text-success"></i>Créer un compte</h2>
    <form action="ValidInscription" method="POST">
      <div class="form-floating mb-3">
        <input type="text" class="form-control"  name="nom" placeholder="Votre nom" required>
        <label for="nom"><i class="fas fa-user me-2"></i>Nom complet</label>
      </div>

      <div class="form-floating mb-3">
        <input type="text" class="form-control"  name="login" placeholder="login" required>
        <label ><i class="fas fa-envelope me-2"></i>Login</label>
      </div>

      <div class="form-floating mb-3">
        <input type="password" class="form-control" id="motdepasse" name="password" placeholder="Mot de passe" required>
        <label><i class="fas fa-lock me-2"></i>Mot de passe</label>
      </div>

      
      <button type="submit" class="btn btn-success w-100"><i class="fas fa-user-plus me-2"></i>S'inscrire</button>
    </form>

    <div class="mt-3 text-center">
      <small>Déjà un compte ? <a href="login.php">Se connecter</a></small>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>