<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Innlogging</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p style="color:red">${feilmelding}</p>
	<form action="innlogging" method="post">
		<fieldset>
			<legend>Deltakarinnlogging</legend>
			<label for="mobil">Mobilnummer</label>
			<input id="mobil" type="text" name="mobil"
				inputmode="numeric" maxlength="8" required />
			<label for="passord">Passord</label>
			<input id="passord" type="password" name="passord" required />
			<br><input type="submit" value="Logg inn" />
		</fieldset>
	</form>
	<p>Ikkje registrert? <a href="paamelding">Meld deg på</a>.</p>
</body>
</html>

