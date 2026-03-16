<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>ATM Banking Portal</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<style>

body{
font-family:'Poppins',sans-serif;
background:linear-gradient(135deg,#1E3A8A,#2563EB);
height:100vh;
display:flex;
align-items:center;
justify-content:center;
}

.login-card{

background:rgba(255,255,255,0.92);

backdrop-filter:blur(10px);

border-radius:16px;

padding:35px;

width:420px;

box-shadow:0 20px 45px rgba(0,0,0,.25);

transition:.3s;
}

.login-card:hover{
transform:translateY(-4px);
}

.form-control{

border-radius:10px;

padding:10px;
}

.login-btn{

border-radius:10px;

font-weight:500;

padding:10px;

transition:.25s;
}

.login-btn:hover{

transform:scale(1.02);
}

.portal-icon{

font-size:38px;

color:#1E3A8A;
}

.footer{

font-size:13px;

color:#666;

margin-top:15px;
}

/* Loading spinner hidden initially */

.loading{

display:none;
}

</style>

</head>

<body>

<div class="login-card text-center">

<div class="portal-icon mb-2">

<i class="bi bi-bank"></i>

</div>

<h4 class="mb-1">ATM Banking Portal</h4>

<p class="text-muted mb-4">Secure Account Login</p>


<!-- ERROR MESSAGE BLOCK -->

<%
String error = (String) request.getAttribute("error");

if(error != null){
%>

<div class="alert alert-danger text-center">

<i class="bi bi-exclamation-triangle"></i>
<%=error%>

</div>

<%
}
%>


<form id="loginForm" action="<%=request.getContextPath()%>/login" method="post">

<div class="input-group mb-3">

<span class="input-group-text">

<i class="bi bi-person"></i>

</span>

<input type="text"

name="accountNumber"

class="form-control"

placeholder="Enter Account Number"

required>

</div>

<div class="input-group mb-4">

<span class="input-group-text">

<i class="bi bi-lock"></i>

</span>

<input type="password"

name="pin"

class="form-control"

placeholder="Enter PIN"

required>

</div>


<!-- LOGIN BUTTON WITH LOADING -->

<button class="btn btn-primary login-btn w-100" id="loginButton">

<span id="loginText">

<i class="bi bi-box-arrow-in-right"></i> Login

</span>

<span id="loginLoading" class="loading">

<span class="spinner-border spinner-border-sm"></span>

Logging in...

</span>

</button>

</form>

<div class="footer">

ATM Simulation System • Java Servlet Project

</div>

</div>


<!-- LOGIN LOADING SCRIPT -->

<script>

document.getElementById("loginForm").addEventListener("submit", function(){

document.getElementById("loginText").style.display="none";

document.getElementById("loginLoading").style.display="inline";

});

</script>


</body>

</html>