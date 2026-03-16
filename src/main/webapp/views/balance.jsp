<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Account Balance</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<style>

body{
font-family:'Poppins',sans-serif;
background:#F4F6F9;
}

/* NAVBAR */

.navbar{
background:#1E293B;
padding:12px 25px;
}

/* HEADER */

.page-header{
margin-top:40px;
text-align:center;
margin-bottom:25px;
}

/* BALANCE CARD */

.balance-card{

max-width:420px;

margin:auto;

padding:35px;

border-radius:18px;

background:white;

box-shadow:0 12px 30px rgba(0,0,0,0.08);

transition:.25s;
}

.balance-card:hover{

transform:translateY(-5px);

box-shadow:0 18px 40px rgba(0,0,0,0.15);
}

.wallet-icon{

font-size:40px;

color:#2563EB;

text-align:center;

margin-bottom:10px;
}

/* BALANCE NUMBER */

.balance-amount{

font-size:38px;

font-weight:600;

color:#16A34A;

margin-top:5px;
}

/* BACK BUTTON */

.back-btn{

margin-top:20px;
}

/* FOOTER */

.footer{

margin-top:50px;

text-align:center;

color:#666;

font-size:14px;
}

</style>

</head>

<body>

<!-- NAVBAR -->

<nav class="navbar navbar-dark">

<div class="container-fluid">

<span class="navbar-brand">

<i class="bi bi-bank"></i> ATM Simulation System

</span>

<a href="<%=request.getContextPath()%>/logout" class="btn btn-danger">

<i class="bi bi-box-arrow-right"></i> Logout

</a>

</div>

</nav>

<div class="container">

<div class="page-header">

<h2>Account Balance</h2>

<p class="text-muted">View your current account balance</p>

</div>

<div class="balance-card text-center">

<div class="wallet-icon">

<i class="bi bi-wallet2"></i>

</div>

<h5 class="text-muted">Current Balance</h5>

<div class="balance-amount">

₹ ${balance}

</div>

<div class="back-btn">

<a href="<%=request.getContextPath()%>/views/dashboard.jsp"

class="btn btn-outline-primary">

← Back to Dashboard

</a>

</div>

</div>

<div class="footer">

ATM Simulation System • Java Servlet Project Built using Java, JSP, JDBC, Maven

</div>

</div>

</body>

</html>