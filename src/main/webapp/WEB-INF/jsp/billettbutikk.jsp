<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Billettbutikk</title>
</head>
<body>
	<h2>Billettbutikk</h2>
	<p>Vel billett til arrangementet. Dette er ein demo utan ekte betaling.</p>
	<p style="color:red"><c:out value="${feilmelding}" /></p>

	<c:choose>
		<c:when test="${not empty eksisterandeKjop}">
			<p>Du har allereie kjøpt <strong><c:out value="${eksisterandeKjop.billettype.namn}" /></strong>
				for ${eksisterandeKjop.pris} kr.</p>
			<a href="deltagerliste">Gå til deltakarlista</a>
		</c:when>
		<c:otherwise>
			<table>
				<thead><tr><th>Billett</th><th>Pris</th><th></th></tr></thead>
				<tbody>
				<c:forEach var="type" items="${billettypar}">
					<tr>
						<td><c:out value="${type.namn}" /></td>
						<td>${type.pris} kr</td>
						<td>
							<form action="butikk/kjop" method="post">
								<input type="hidden" name="billettype" value="${type.kode}">
								<button type="submit">Kjøp billett</button>
							</form>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>

	<form action="utlogging" method="post"><button type="submit">Logg ut</button></form>
</body>
</html>
