<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>


 <%@ page isELIgnored="false" %>
    
    
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Connexion - Bibliothèque</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
  <style>
    body {
      background: linear-gradient(135deg, #e3f2fd, #ffffff);
      height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
    }
    .login-box {
      max-width: 420px;
      width: 100%;
      background-color: #fff;
      padding: 30px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
    }
    .login-box h2 {
      font-weight: 600;
      margin-bottom: 20px;
    }
  </style>
</head>
<body>

  <div class="login-box text-center">
    <h2><i class="fas fa-lock me-2 text-primary"></i>Connexion</h2>
    <form action="Verif2" method="POST">
      <div class="form-floating mb-3">
        <input type="text" class="form-control" name="login" placeholder="Login" required>
        <label><i class="fas fa-envelope me-2"></i>Login</label>
      </div>

      <div class="form-floating mb-3">
        <input type="password" class="form-control" name="password" placeholder="Mot de passe" required>
        <label><i class="fas fa-key me-2"></i>Mot de passe</label>
      </div>

      <button type="submit" class="btn btn-primary w-100"><i class="fas fa-sign-in-alt me-2"></i>Se connecter</button>
    </form>
    
   <c:if test="${not empty erreurl}">
    <div class="mt-2 alert alert-warning">
        Veuillez vérifier vos données de connexion, s'il vous plaît.
    </div>
</c:if>

<c:if test="${not empty erreur2}">
    <div class="mt-2 alert alert-danger">
        Veuillez vous connecter avant d'accéder à cette page.
    </div>
</c:if>




    <div class="mt-3">
      <small>Pas encore inscrit ? <a href="inscription.jsp">Créer un compte</a></small>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>