<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
	<title>Paamelding</title>
	<script>
		function validateForm() {
			var fornavn = document.forms["pamelding"]["fornavn"].value;
			var etternavn = document.forms["pamelding"]["etternavn"].value;
			var mobil = document.forms["pamelding"]["mobil"].value;
			var passord = document.forms["pamelding"]["passord"].value;
			var passordRepetert = document.forms["pamelding"]["passordRepetert"].value;
			var kjonn = document.querySelector('input[name="kjonn"]:checked');

			// Enkel validering
			if (fornavn === "" || etternavn === "" || mobil.length !== 8 || passord === "" || passordRepetert === "" || kjonn === null) {
				alert("Vennligst fyll ut alle feltene korrekt.");
				return false;
			}

			// Sjekk om passordene samsvarer
			if (passord !== passordRepetert) {
				alert("Passordene stemmer ikke overens.");
				return false;
			}
		}
	</script>
</head>
<body>
	<h2>Påmelding</h2>
	<form:form method="post" modelAttribute="paameldingForm"
		name="pamelding" onsubmit="return validateForm()">
		<fieldset>
			<form:errors path="*" cssStyle="color:red" element="p" />

			<label for="fornavn">Fornamn</label>
			<form:input path="fornavn" id="fornavn" maxlength="20" />
			<form:errors path="fornavn" cssStyle="color:red" />

			<label for="etternavn">Etternamn</label>
			<form:input path="etternavn" id="etternavn" maxlength="20" />
			<form:errors path="etternavn" cssStyle="color:red" />

			<label for="mobil">Mobil (8 siffer)</label>
			<form:input path="mobil" id="mobil" inputmode="numeric" maxlength="8" />
			<form:errors path="mobil" cssStyle="color:red" />

			<label for="passord">Passord (minst 8 teikn)</label>
			<form:password path="passord" id="passord" />
			<form:errors path="passord" cssStyle="color:red" />

			<label for="passordRepetert">Gjenta passord</label>
			<form:password path="passordRepetert" id="passordRepetert" />
			<form:errors path="passordRepetert" cssStyle="color:red" />

			<label>Kjønn</label>
			<form:radiobutton path="kjonn" value="mann" /> mann
			<form:radiobutton path="kjonn" value="kvinne" /> kvinne
			<form:errors path="kjonn" cssStyle="color:red" />

			<br><button type="submit">Meld meg på</button>
		</fieldset>
	</form:form>
	<p>Allereie registrert? <a href="innlogging">Logg inn</a>.</p>
</body>
</html>
