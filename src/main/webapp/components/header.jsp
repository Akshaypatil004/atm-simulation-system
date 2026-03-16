<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>ATM System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>

<nav class="navbar navbar-dark bg-dark">

<div class="container-fluid">

<span class="navbar-brand mb-0 h1">
ATM Simulation System
</span>

<a href="<%=request.getContextPath()%>/logout"
class="btn btn-danger">
Logout
</a>

</div>

</nav>

<div class="container mt-4">