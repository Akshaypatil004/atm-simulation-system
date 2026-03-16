<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Transfer Money</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<style>

body{
font-family:'Poppins',sans-serif;
background:#F4F6F9;
}

.navbar{
background:#1E293B;
padding:12px 25px;
}

.page-header{
margin-top:40px;
text-align:center;
margin-bottom:25px;
}

.transaction-card{
max-width:450px;
margin:auto;
padding:30px;
border-radius:16px;
background:white;
box-shadow:0 12px 30px rgba(0,0,0,0.08);
transition:.25s;
}

.transaction-card:hover{
transform:translateY(-5px);
box-shadow:0 18px 40px rgba(0,0,0,0.15);
}

.icon{
font-size:36px;
color:#2563EB;
text-align:center;
margin-bottom:10px;
}

.form-control{
border-radius:10px;
padding:10px;
}

.transfer-btn{
border-radius:10px;
padding:10px;
font-weight:500;
transition:.25s;
}

.transfer-btn:hover{
transform:scale(1.02);
}

.footer{
margin-top:50px;
text-align:center;
color:#666;
font-size:14px;
}

</style>

</head>

<body>

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

<h2>Transfer Money</h2>

<p class="text-muted">Send money to another account</p>

</div>

<%

String status = request.getParameter("status");

if("success".equals(status)){
%>

<div class="alert alert-success text-center">
<i class="bi bi-check-circle"></i>
Transfer successful
</div>

<%
}else if("fail".equals(status)){
%>

<div class="alert alert-danger text-center">
<i class="bi bi-exclamation-triangle"></i>
Transfer failed. Check receiver account or balance.
</div>

<%
}else if("invalid".equals(status)){
%>

<div class="alert alert-warning text-center">
<i class="bi bi-exclamation-circle"></i>
Invalid input provided
</div>

<%
}else if("same".equals(status)){
%>

<div class="alert alert-warning text-center">
<i class="bi bi-exclamation-circle"></i>
Cannot transfer to same account
</div>

<%
}
%>

<div class="transaction-card">

<div class="icon">
<i class="bi bi-arrow-left-right"></i>
</div>

<form action="<%=request.getContextPath()%>/transfer" method="post">

<label class="mb-2">Receiver Account</label>

<div class="input-group mb-3">

<span class="input-group-text">
<i class="bi bi-person"></i>
</span>

<input
type="text"
name="targetAccount"
class="form-control"
placeholder="Enter receiver account number"
required
>

</div>

<label class="mb-2">Amount</label>

<div class="input-group mb-4">

<span class="input-group-text">₹</span>

<input
type="number"
name="amount"
class="form-control"
placeholder="Enter amount"
required
min="1"
>

</div>

<button class="btn btn-primary transfer-btn w-100">
<i class="bi bi-send"></i> Transfer Money
</button>

</form>

<div class="text-center mt-3">

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