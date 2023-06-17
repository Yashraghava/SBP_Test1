<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Welcome to ${name}</h1>
	Name: ${name}
	Password: ${password}
	<br>
	<a href="list-todos">Manage</a> your Todos
</div>
<div class="container">
<a href="youtube">Youtube</a>
</div>
<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>