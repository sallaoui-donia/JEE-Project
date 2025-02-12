<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste Table</title>
</head>
<body>
<h1 >
Liste des tables
</h1>
<table >
<tr>
<th> numero</th><th>nbCouvert</th><th>type</th><th>Suppression<th>Edition</th>
</tr>
<c:forEach items="${tabls}" var="tab">
<tr>
<td>${p.numero }</td>
<td>${p.nbCouvert }</td>
<td>${p.type }</td>
<td><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerTabl?id=${tab.numero }">Supprimer</a></td>
<td><a href="modifierTabl?numero=${tab.numero }">Edit</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>
