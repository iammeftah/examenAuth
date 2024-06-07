<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Affecter un Employé</title>
</head>
<body>
<form action="/employes/affecter" method="post">
    <input type="number" name="employeId" placeholder="ID de l'employé">
    <input type="number" name="projetId" placeholder="ID du projet">
    <button type="submit">Affecter</button>
</form>
</body>
</html>