<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

<form enctype="application/x-www-form-urlencoded">
	<input type="file" id="file" name="file" onchange="uploadFile();" />
	<img alt="Imagem" id="target" width="200" height="200">
	</form>
	
	<br/>
	<br/>
	<br/>
	<br/>
	<a href="fileUpload?acao=carregar">Carregar imagens</a>

  <form action="fileUpload" method="get">	
	<table>
	<c:forEach items="${listaUserImagem}" var="user">
	   <tr>
	    <td>${user.codImagem}</td>
	    <td>${user.tipoFile}</td>
	    <td><a target="_blank" href="fileUpload?acao=download&iduser=${user.codImagem}">Download Arquivo</a> </td>
	   </tr>
	</c:forEach>
	</table>
</form>
	
	<br/>
	<br/>
	<br/>
	<br/>

</body>

<script type="text/javascript">
	function uploadFile() {

		var target = document.querySelector("img");
		var file = document.querySelector("input[type=file]").files[0];

		var reader = new FileReader();

		reader.onloadend = function() {
			target.src = reader.result;

			//Upload Ajax
			$.ajax({
				method : "POST",
				url : "fileUpload", //para qual servlet
				data : {
					fileUpload : reader.result
				}
			}).done(function(response) { //ok nenhum erro
				alert("Sucesso: " + response);
				//Fazer algo
			}).fail(function(xhr, status, errorThrow) { //resposta erro algum problema ocorreu
				alert("Erro: " + xhr.responseText);
				//Fazer algo se der errado
			});

		};

		if (file) {

			reader.readAsDataURL(file);

		} else {
			target.src = "";
		}

	}
</script>


</html>