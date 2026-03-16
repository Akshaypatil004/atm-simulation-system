<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

<title>Error</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container text-center mt-5">

<h2 class="text-danger">Something went wrong</h2>

<p class="text-muted">
Please try again later.
</p>

<a href="<%=request.getContextPath()%>/views/dashboard.jsp"
class="btn btn-primary">

Back to Dashboard

</a>

</div>

</body>

</html>