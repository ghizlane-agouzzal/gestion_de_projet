<%@page import="com.ensah.core.web.models.PersonModel"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<li class="nav-item"><form
				action="${pageContext.request.contextPath}/cadreadmin/serachPerson"
				class="d-flex" method="GET">
				<input name="id" class="form-control me-2" type="search"
					placeholder="Saisir id" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form></li>
<jsp:include page="../fragments/adminHeader.jsp" />
<h2>Les donnes de Fichier Exceel</h2>
	<table class="table">
			<thead>
				<tr>
				  <th scope="col">id Etudiant</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">CNE</th>
					<th scope="col">id niveau actuel</th>
					<th scope="col">type</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>

		<c:forEach items="${listStudent}" var="p">
		           <tr> 
		           <c:if test="${p.getType()=='INSC'}" var="v">
		            <td><c:out value="${p.getId()}" /></td>
					<td><c:out value="${p.getNom()}" /></td>
					<td><c:out value="${p.getPrénom()} " /></td>
					<td><c:out value="${p.getCNE()}" /></td>
					<td><c:out value="${p.getId_niveau_actuel()}" /></td>
					<td><c:out value="${p.getType()}" /></td>
					
					<td>
					
								<a
								href="${pageContext.request.contextPath}/cadreadmin/createStudentForm/${p.getId()}/${p.getCNE()}">Create Student</a>

						
					</td>
					</c:if> 
				</tr>
			</c:forEach>

</table>
<h2>les donnes de base de donnes</h2>
<table class="table">
			<thead>
				<tr>
				    <th scope="col">id utilisateur</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">CNE</th>
				</tr>
			</thead>

		<c:forEach items="${users}" var="pc">
		<tr>
		            <td><c:out value="${pc.getIdUtilisateur()}" /></td>
		            <td><c:out value="${pc.nom}" /></td>
					<td><c:out value="${pc.prenom}" /></td>
					<td><c:out value="${pc.getCne()} " /></td>
					
				</tr>
			</c:forEach>

</table>
<!--   <a href="${pageContext.request.contextPath}/cadreadmin/Inscription.jsp" class="btn btn-primary">Inscription Operation</a>
<a href="${pageContext.request.contextPath}/cadreadmin/Reinscription.jsp" class="btn btn-primary">ReInscription Operation</a>
-->
<h2>l'etudiant chercher</h2>
<table class="table">
			<thead>
				<tr>
				    <th scope="col">id utilisateur</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">CNE</th>
				    <th scope="col">Action</th>
					
				</tr>
			</thead>

		<c:forEach items="${personList}" var="pc">
		<tr>
		            <td><c:out value="${pc.getIdUtilisateur()}" /></td>
		            <td><c:out value="${pc.nom}" /></td>
					<td><c:out value="${pc.prenom}" /></td>
					<td><c:out value="${pc.getCne()} " /></td>
					<td>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/admin/updateStudentForm/${p.idUtilisateur}">Update</a></li>


						</ul>
					</td>
				</tr>
			</c:forEach>

</table>
		<jsp:include page="../fragments/adminfooter.jsp" />	
</body>
</html>