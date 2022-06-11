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

		<c:forEach items="${istStudentReInsc}" var="r">
		<tr>
		            <td><c:out value="${r.getID()}" /></td>
		            <td><c:out value="${r.getNom()}" /></td>
					<td><c:out value="${r.getPrénom()}" /></td>
					<td><c:out value="${r.getCNE()} " /></td>
					<td><<a href="UpdateEtudiant.jsp/${p.idUtilisateur}" class="btn btn-primary">Update</a></li>
					
				</tr>
			</c:forEach>

</table>
</body>
</html>
