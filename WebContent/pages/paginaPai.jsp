<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>

<body>
	<h1>Página Pai load jQuery</h1>
	<input type="button" value="Carregar Página" onclick="carregar();"> <!-- local de carregamento da página filha -->
	<div id="mostrarPaginaFilha"></div>
</body>

<script type="text/javascript">
	function carregar() {
		$("#mostrarPaginaFilha").load('paginafilha.jsp'); //Load página em jQuery
	}
</script>
</html>