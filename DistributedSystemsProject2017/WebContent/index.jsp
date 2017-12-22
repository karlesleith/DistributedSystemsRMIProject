<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dictionary Service</title>
</head>
<body class="b">
	<div class="center">
		<form action="DictionaryServletPath" method="post">
			<h1>Dictionary Service:</h1>
		
			<input type="text" name="query" size="20px"> 
			<input class="btn" type="submit" value="Submit"><br>
		</form>
		<form action="DictionaryServletPath" method="post">
			<div class="def">
				<h3><%= request.getParameter("def") %></h3>
			</div>
		</form>
	</div>
</body>
</html>