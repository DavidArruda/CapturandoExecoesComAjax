<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datas</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>

	<form action="calcularDataFinal" method="post">
		
		<label>Data inicial</label>
		<input id="data" name="data">
		
		<label>Tempo em horas</label>
		<input type="text" id="tempo" name="tempo">
		
		<input type="submit" value="Calcular">
		
	</form>
	
	<br>
	<br>
	
	<label>Data final</label>	
	<input type="text" id="dataFinal" name="dataFinal" value="${dataFinal}" readonly="readonly"> 
	
	<label>Total de Dias</label>	
	<input type="text" id="dias" name="dias" value="${dias}" readonly="readonly"> 
	
</body>

<script type="text/javascript">
	$(function(){
		$('#data').datepicker({dateFormat: 'dd/mm/yy'});
	});

</script>


</html>