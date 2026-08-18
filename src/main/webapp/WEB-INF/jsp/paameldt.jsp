<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="../css/simple.css">
	<title>Kontostadfesting</title>
</head>
<body>
	<h2>Kontoen er oppretta</h2>
	<p>Du er registrert som:</p>
	<p>
		<c:out value="${deltager.fornavn}" /> <c:out value="${deltager.etternavn}" /><br>
		<c:out value="${deltager.mobil}" /><br>
		<c:out value="${deltager.kjonn}" />
	</p>
	<p>Vel ein billett for å melde deg på arrangementet.</p>
	<a href="../butikk">Gå til billettbutikken</a>
</body>
</html>
