<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="com.atm.model.Transaction"%>

<!DOCTYPE html>
<html>
<head>

<title>Mini Statement</title>

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

.statement-card{
padding:30px;
border-radius:16px;
background:white;
box-shadow:0 12px 30px rgba(0,0,0,0.08);
}

.table thead{
background:#1E293B;
color:white;
}

.table tbody tr:hover{
background:#F1F5F9;
}

.deposit{
color:#16A34A;
font-weight:500;
}

.withdraw{
color:#DC2626;
font-weight:500;
}

.transfer{
color:#2563EB;
font-weight:500;
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

<h2>Mini Statement</h2>
<p class="text-muted">Recent account transactions</p>

</div>

<div class="statement-card">

<table class="table table-hover">

<thead>

<tr>
<th>Type</th>
<th>Amount</th>
<th>To Account</th>
<th>Date</th>
</tr>

</thead>

<tbody>

<%

List<Transaction> transactions =
(List<Transaction>)request.getAttribute("transactions");

if(transactions == null || transactions.isEmpty()){

%>

<tr>
<td colspan="4" class="text-center text-muted">
No transactions found
</td>
</tr>

<%

}else{

for(Transaction t : transactions){

String type = t.getTransactionType();

String css="transfer";
String icon="bi-arrow-left-right";

if("DEPOSIT".equalsIgnoreCase(type)){
css="deposit";
icon="bi-plus-circle";
}
else if("WITHDRAW".equalsIgnoreCase(type)){
css="withdraw";
icon="bi-dash-circle";
}

%>

<tr>

<td class="<%=css%>">
<i class="bi <%=icon%>"></i>
<%=t.getTransactionType()%>
</td>

<td>
₹ <%=t.getAmount()%>
</td>

<td>
<%=t.getTargetAccount()==null ? "-" : t.getTargetAccount()%>
</td>

<td>
<%=t.getTransactionDate()%>
</td>

</tr>

<%
}
}
%>

</tbody>

</table>

<div class="text-center mt-4">

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