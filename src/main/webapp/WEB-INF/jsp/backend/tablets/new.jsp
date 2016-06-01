<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
		th{
			text-align:center;
		}
		input{
			width: 100%;
		}
		#boton_actualizar{
			width: 15%;
			margin: auto;
			margin-top: 30px;
			background-color: #9d2236;
			color: #FFFFFF;
			padding: 5px;
			text-align: center;
			text-transform: uppercase;
			border-radius: 5px;
		}
		#boton_actualizar:hover{
			cursor: pointer;
		}
	</style>
	
	<table class="table table-striped table-bordered table-hover table-custom">
		<tr>
			<th> Tablet </th>
			<td><input type="text" id="tablet" value=""></td>
		</tr>
		<tr>
			<th> UUID </th>
			<td><input type="text" id="uuid" value=""></td>
		</tr>
	</table>
	<div id="boton_actualizar">Guardar</div>
	
	<script type="text/javascript">
	
		$('#boton_actualizar').click(function(){
			if($('#tablet').val() === ''){
				alert("No has introducido un nombre para la tablet");
			} else if($('#uuid').val() === ''){
				alert("No has escrito ningún UUID");
			} else {
				var url_new = "<s:url value='/backend/tablets/add'/>";
				$.ajax({
					  method: "POST",
					  url: url_new,
					  data: { 
						  	  	tablet_name: $('#tablet').val(), 
						  		identificador: $('#uuid').val()
						  	}
					})
					  .done(function( msg ) {
					    if (msg.status === "ok"){
					    	alert("Se ha añadido correctamente los datos");
					    	window.location.href = "list";
					    }
					  });
			}
		})
	
	</script>

</body>
</html>