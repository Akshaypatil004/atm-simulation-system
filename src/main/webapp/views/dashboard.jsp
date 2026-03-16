<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>ATM Dashboard</title>

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

.navbar-brand{
font-weight:500;
font-size:18px;
}

/* USER INFO */

.user-info{
margin-top:25px;
padding:15px 20px;
background:white;
border-radius:10px;
box-shadow:0 8px 18px rgba(0,0,0,0.08);
}

/* PAGE HEADER */

.page-header{
margin-top:35px;
margin-bottom:30px;
text-align:center;
}

/* DASHBOARD STATS */

.stats-card{
border:none;
border-radius:12px;
padding:20px;
background:white;
box-shadow:0 8px 18px rgba(0,0,0,0.08);
text-align:center;
}

.stats-number{
font-size:22px;
font-weight:600;
color:#2563EB;
}

/* OPERATION CARDS */

.operation-card{
border:none;
border-radius:14px;
padding:28px;
background:white;
box-shadow:0 10px 25px rgba(0,0,0,0.08);
transition:all .25s ease;
}

.operation-card:hover{
transform:translateY(-6px);
box-shadow:0 18px 35px rgba(0,0,0,0.15);
}

.operation-icon{
font-size:34px;
color:#2563EB;
}

.operation-title{
font-weight:500;
margin-top:12px;
}

/* FOOTER */

.footer{
margin-top:60px;
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

<!-- USER INFO SECTION -->

<div class="user-info d-flex justify-content-between align-items-center">

<div>

<h5 class="mb-1">
Welcome, Account 
<%= session.getAttribute("accountNumber") != null ? session.getAttribute("accountNumber") : "" %>
</h5>

<p class="text-muted mb-0">
Today: <%= java.time.LocalDate.now() %>
</p>

</div>

<div>

<i class="bi bi-person-circle" style="font-size:40px;color:#2563EB;"></i>

</div>

</div>

<!-- HEADER -->

<div class="page-header">

<h2>ATM Dashboard</h2>

<p class="text-muted">Choose an operation</p>

</div>

<!-- DASHBOARD STATS -->

<div class="row mb-4">

<div class="col-md-4">

<div class="stats-card">

<i class="bi bi-wallet2"></i>

<div class="stats-number">5</div>

<div class="text-muted">Bank Services</div>

</div>

</div>

<div class="col-md-4">

<div class="stats-card">

<i class="bi bi-shield-check"></i>

<div class="stats-number">Secure</div>

<div class="text-muted">Transactions</div>

</div>

</div>

<div class="col-md-4">

<div class="stats-card">

<i class="bi bi-clock-history"></i>

<div class="stats-number">24/7</div>

<div class="text-muted">Access</div>

</div>

</div>

</div>

<!-- OPERATION CARDS -->

<div class="row g-4">

<div class="col-md-4">

<a href="<%=request.getContextPath()%>/views/deposit.jsp" class="text-decoration-none text-dark">

<div class="operation-card text-center">

<i class="bi bi-cash-stack operation-icon"></i>

<div class="operation-title">Deposit</div>

<p class="text-muted">Add money to your account</p>

</div>

</a>

</div>

<div class="col-md-4">

<a href="<%=request.getContextPath()%>/views/withdraw.jsp" class="text-decoration-none text-dark">

<div class="operation-card text-center">

<i class="bi bi-credit-card operation-icon"></i>

<div class="operation-title">Withdraw</div>

<p class="text-muted">Withdraw cash</p>

</div>

</a>

</div>

<div class="col-md-4">

<a href="<%=request.getContextPath()%>/views/transfer.jsp" class="text-decoration-none text-dark">

<div class="operation-card text-center">

<i class="bi bi-arrow-left-right operation-icon"></i>

<div class="operation-title">Transfer</div>

<p class="text-muted">Send money to another account</p>

</div>

</a>

</div>

<div class="col-md-6">

<a href="<%=request.getContextPath()%>/balance" class="text-decoration-none text-dark">

<div class="operation-card text-center">

<i class="bi bi-bar-chart operation-icon"></i>

<div class="operation-title">Check Balance</div>

<p class="text-muted">View account balance</p>

</div>

</a>

</div>

<div class="col-md-6">

<a href="<%=request.getContextPath()%>/statement" class="text-decoration-none text-dark">

<div class="operation-card text-center">

<i class="bi bi-receipt operation-icon"></i>

<div class="operation-title">Mini Statement</div>

<p class="text-muted">View recent transactions</p>

</div>

</a>

</div>

</div>

<!-- FOOTER -->

<div class="footer">

ATM Simulation System • Java Servlet Project Built using Java, JSP, JDBC, Maven

</div>

</div>

</body>

</html>