<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>


 <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Gestion Bibliothèque</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background-color: #f8f9fa;
    }
    .sidebar {
      height: 100vh;
      background-color: #343a40;
    }
    .sidebar .nav-link {
      color: #ffffff;
    }
    .sidebar .nav-link.active {
      background-color: #0d6efd;
      color: white;
    }
    .sidebar .nav-link:hover {
      background-color: #495057;
    }
    .content {
      padding: 2rem;
    }
    .card-hover:hover {
      transform: scale(1.02);
      transition: all 0.2s;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }
  </style>
</head>
<body>

 <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm px-4">
    <a class="navbar-brand fw-bold text-primary" href="#"><i class="fas fa-book me-2"></i>Bibliothèque ESSAT</a>
    <div class="ms-auto">
       <a class="btn btn-primary" href="#"><i class="fas fa-sign-in-alt"></i> Ali Ben Salah (Déconnexion)</a>
    </div>
  </nav>

  <div class="container-fluid">
    <div class="row">
      <!-- Sidebar -->
      <nav class="col-md-2 d-none d-md-block sidebar p-3">
        <ul class="nav flex-column">
         <li class="nav-item mb-2">
            <a class="nav-link active" href="esapce_admin.jsp"><i class="fas fa-home me-2"></i>Dashboard</a>
          </li>
          <li class="nav-item mb-2">
            <a class="nav-link" href="PreLivreAdmin"><i class="fas fa-book me-2"></i>Livres disponibles</a>
          </li>
          <li class="nav-item mb-2">
            <a class="nav-link" href="PreEmpruntAdmin"><i class="fas fa-list me-2"></i>Les emprunts</a>
          </li>
         
        </ul>
      </nav>

      <!-- Main Content -->
      <main class="col-md-10 ms-sm-auto content">        

			<div class="row g-4">			 
			
			
				<div class="form-container">
				  <h2 class="text-center text-primary mb-4">Ajouter un nouveau livre</h2>

				  <form action="PostAjout" method="POST">
					<div class="mb-3">
					  <label for="titre" class="form-label">Titre du livre</label>
					  <input type="text" class="form-control" id="titre" name="titre" required>
					</div>
					
					<div class="mb-3">
					  <label for="categorie" class="form-label">Catégorie</label>
					  <select class="form-select" id="categorie" name="categorie" required>
						<option value="">-- Sélectionner une catégorie --</option>
						<option value="Roman">Roman</option>
						<c:forEach items="${liste}" var="c">
						<option value="${c.id }">${c.titre}</option>
						</c:forEach>
					  </select>
					</div>

					<div class="mb-3">
					  <label for="description" class="form-label">Description</label>
					  <textarea class="form-control" id="description" name="description" rows="3"></textarea>
					</div>
					

					<div class="text-center">
					  <button type="submit" class="btn btn-success px-5"><i class="fas fa-plus me-2"></i>Ajouter</button>
					</div>
				  </form>
				</div>
  
			
			
			
			

			</div>	
				
		
		
      </main>
    </div>
  </div>

  <!-- Footer -->
  <footer class="bg-light text-center text-muted py-3 mt-4 border-top">
    &copy; 2025 - Application Bibliothèque ESSAT
  </footer>

  <!-- Bootstrap & Icons -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>