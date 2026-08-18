<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltakarliste</title>
</head>
<body>
	<p>Innlogga som: <c:out value="${innlogget.mobil}" /> /
		<c:out value="${innlogget.fornavn}" /> <c:out value="${innlogget.etternavn}" /></p>
	<h2>Deltakarliste</h2>
	<table>
		<thead><tr><th>Kjønn</th><th>Namn</th><th>Mobil</th><th>Billett</th></tr></thead>
		<tbody>
		<c:forEach var="kjop" items="${billettkjop}">
			<c:set var="person" value="${kjop.deltager}" />
			<tr<c:if test="${person.mobil == innlogget.mobil}"> style="background-color:#aaffaa"</c:if>>
				<td><c:choose><c:when test="${person.kjonn == 'kvinne'}">&#9792;</c:when><c:otherwise>&#9794;</c:otherwise></c:choose></td>
				<td><c:out value="${person.fornavn}" /> <c:out value="${person.etternavn}" /></td>
				<td><c:out value="${person.mobil}" /></td>
				<td><c:out value="${kjop.billettype.namn}" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<p><a href="butikk">Billettbutikk</a></p>
	<form action="utlogging" method="post"><button type="submit">Logg ut</button></form>
</body>
</html>
