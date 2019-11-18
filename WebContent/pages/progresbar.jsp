<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Barra de Progresso</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css">
/*Fundo da barra de progresso-->*/
#myProgress{ 
	width: 100%;
	background-color: #ddd;
}

/*Cor da barra de progresso-->*/
#myBar{
	width: 1%;
	height: 30px; 
	background-color: #4CAF50;
}

.ui-progressbar{
	position: : relative;
}

.progress-label{
	position: relative;
	left: 50%;
	top: 4px;
	font-weight: bold;
	text-shadow:  1px 1px 0  #fff;
}

</style>

</head>
<body>
	<h3>Exemplo com javaScrip</h3>
	
	<div id="myProgress"> <!--fundo da barra de progresso-->
	
		<div id="myBar"> <!-- barra de progresso-->
		
		</div>
	</div>	
	<br/>
	<button onclick="exibirBarra();">Iniciar a Barra de progresso</button>
	
	<br/>
	
	<h1>Progressbar com jQuery</h1>
	
	<div id="progressbar">
		<div class="progress-label" >
			Carregando...
		</div>
	</div>
	
	<script type="text/javascript"> 	
	
	$(function() {
		var progressbar = $("#progressbar"), progresslabel = $(".progress-label");
		
		progressbar.progressbar ({
			value : false,
			change : function () {
				progresslabel.text (progressbar.progressbar('value') + "%");
			},
			complete  : function() {
				progresslabel.text('Completo!');
			}
		});
		
		function progress() {
			var val = progressbar.progressbar("value") || 0;
			
			progressbar.progressbar("value", val + 2);
			
			if (val < 99) {
				setTimeout(progress, 80);
			}
		}
		
		setTimeout(progress, 2000);
		
	});
	
	
	// barra de progresso com javaScript
		function exibirBarra() {
			var elem = document.getElementById("myBar");
			var width = 1;
			var id = setInterval(frame, 10);
			
			function frame() {
				if(width >=100) {
					clearInterval(id);
				}else{
					width++;
					elem.style.width = width + "%";
				}
			}
		}
	
	</script>
	
	
	
	
	
	
	
</body>
</html>