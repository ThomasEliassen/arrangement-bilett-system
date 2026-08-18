<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/simple.css">
	<title>Kjøpsstadfesting</title>
</head>
<body>
	<h2>Billetten er stadfesta</h2>
	<p>
		<c:out value="${kjop.deltager.fornavn}" /> <c:out value="${kjop.deltager.etternavn}" /><br>
		Billett: <c:out value="${kjop.billettype.namn}" /><br>
		Pris: ${kjop.pris} kr
	</p>
	<p>Du er no lagt til i deltakarlista.</p>
	<a href="../deltagerliste">Gå til deltakarlista</a>
</body>
</html>
