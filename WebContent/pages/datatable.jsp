<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Table jQuery</title>

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>


</head>
<body>

<table id="minhatabela" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Código usuário</th>
                <th>Nome</th>

            </tr>
        </thead>
    </table> 
	   
</body>

<script type="text/javascript">

$(document).ready(function() { // faz o processamento na hora que abre a tela
    $('#minhatabela').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "carregarDadosDataTable" // URL de retorno dos dados do servidor (resposta)
    } );
} );

	
</script>

</html>