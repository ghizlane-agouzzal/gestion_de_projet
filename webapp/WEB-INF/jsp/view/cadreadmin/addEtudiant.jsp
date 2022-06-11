<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Formulaire d'ajout d'un Etudiant</h3>

<f:form action="addPerson" method="POST" modelAttribute="personModel">

			<div class="row">
				<div class="col">
					<label>CIN</label>
					<f:input path="cin" type="text" class="form-control"
						placeholder="cin" />
					<f:errors path="cin" class="text-danger" />
				</div>

				<div class="col">
					<label>Nom</label>
					<f:input path="nom" type="text" class="form-control"
						placeholder="nom" />
					<f:errors path="nom" class="text-danger" />
				</div>
						
				
					<div class="col">
						<label>CNE</label>
						<f:input path="cne" type="text" class="form-control"
							placeholder="cne" />
						<f:errors path="cne" class="text-danger" />
			
			</div>


			<div class="row">
				<div class="col">
					<label>Prénom</label>
					<f:input path="prenom" type="text" class="form-control"
						placeholder="prenom" />
					<f:errors path="prenom" class="text-danger" />
				</div>

				<div class="col">
					<label>Télé</label>
					<f:input path="telephone" type="text" class="form-control"
						placeholder="telephone" />
					<f:errors path="telephone" class="text-danger" />
				</div>
			</div>
			<div class="row">
			
				<div class="row">
					<div class="col">
						<label>Email</label>
						<f:input path="email" class="form-control" placeholder="Email" />
						<f:errors path="email" class="text-danger" />
					</div>


				</div>



				<div class="row">
					<div class="col">
						<label>Nom Arabe</label>
						<f:input path="nomArabe" type="text" class="form-control"
							placeholder="nomArabe" />
						<f:errors path="nomArabe" class="text-danger" />
					</div>
					<div class="col">
						<label>Prénom Arabe</label>
						<f:input path="prenomArabe" type="text" class="form-control"
							placeholder="prenomArabe" />
						<f:errors path="prenomArabe" class="text-danger" />
					</div>

			
				</div>


				<div style="text-align: right">
					<button type="submit" class="btn btn-primary">Enregistrer</button>
					<button type="reset" class="btn btn-secondary">Annuler</button>
				</div>
		</f:form>
	

	<jsp:include page="../fragments/adminfooter.jsp" />

</body>
</html>