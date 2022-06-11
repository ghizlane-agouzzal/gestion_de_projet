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
<h2>les donnes des etudiants a inscrire</h2>

<f:form action="${pageContext.request.contextPath}/addStudent" method="POST" >
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
			</div>


			<div class="row">
				<div class="col">
					<label>Prénom</label>
					<f:input path="prenom" type="text" class="form-control"
						placeholder="prenom" />
					<f:errors path="prenom" class="text-danger" />
				</div>




			<div style="text-align: right">
				<button type="submit" class="btn btn-primary">Ajouter</button>
				
			</div>

		</f:form>
	</div>




































<table class="table">
			<thead>
				<tr>
				    <th scope="col">id utilisateur</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">CNE</th>
					<th> Action</th>
				</tr>
			</thead>

		<c:forEach items="${listStudentInsc}" var="pc">
		<tr>
		            <td><c:out value="${pc.getIdUtilisateur()}" /></td>
		            <td><c:out value="${pc.nom}" /></td>
					<td><c:out value="${pc.prenom}" /></td>
					<td><c:out value="${pc.getCne()} " /></td>
					<td><<a href="/cadreadmin/addEtudiant.jsp/${pc.idUtilisateur}" class="btn btn-primary">ajouter</a></li>
					
				</tr>
			</c:forEach>

</table>
</body>
</html>