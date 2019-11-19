<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

	<input type="file" id="file" name="file" onchange="uploadFile();">
	<img alt="" src="" id="target" width="200px" height="200px">

</body>

<script type="text/javascript">
	function uploadFile() {

		var target = document.querySelector("img");
		var file = document.querySelector("input[type=file]").files[0];

		var reader = new FileReader();

		reader.onloadend = function() {
			target.src = reader.result;
		};

		if (file) {
			reader.readAsDataURL(file);
			
			//Upload Ajax
			$.ajax({
				method: "POST",
				url: "fileUpload", //para qual servlet
				data: { fileUpload: target.src } 
			})
			.done(function(response) { //ok nenhum erro
				alert("Sucesso: " + response);
				//Fazer algo
			})
			.fail(function(xhr,status, errorThrow) { //resposta erro algum problema ocorreu
				alert("Erro: " + xhr.responseText);
				//Fazer algo se der errado
			});
			
		} else {
			target.src = "";
		}

	}
</script>


</html>