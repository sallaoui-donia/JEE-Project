<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Créer Table</title>
</head>
<body>
<form action="saveTabl" method="post">
<pre>
nbCouvert : <input type="text" name="nbCouvert">
type : <input type="text" name="type">
supplement: <input type="text" name="supplement">
<input type="submit" value="ajouter">
</pre>
</form>
${msg}
<br/>
<br/>
<a href="listeTable">liste tables</a>
</body>
</html>
	
