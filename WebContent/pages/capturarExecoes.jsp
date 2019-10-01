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
	<h3>Capturando Exeções com Jquery</h3>
	<input type="text" value="Valor informado" id="txtValor">
	<input type="button" onclick="testeExecao();" value="Testar Exececao"> 
</body>
<script type="text/javascript">
	
	function testeExecao() {
		valorInformado = $('#txtValor').val();
		
		$.ajax({
			method: "POST",
			url: "capturarExecao", //para qual servlet
			data: { valorParam: valorInformado } 
		})
		.done(function(response) { //ok nenhum erro
			alert("Sucesso: " + response);
			//Fazer algo
		})
		.fail(function(xhr,status, errorThrow) { //resposta erro algum problema ocorreu
			alert("Erro: " + xhr.responseText);
			//Fazer algo se der errado
		});
	}

</script>

</html>