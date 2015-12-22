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
	
	<h1 style="text-transform:capitalize;">NEW Hotel</h1>
	
	<table class="table-new">
	<tr>
		<th>Nombre:</th>
		<td><input type="text" name="form_name" id="form_name" value=""></td>
	</tr>
	<tr class="table-new">
		<th></th>
		<td class="td-new-unique"><div id="button_send" class="idioma">Guardar</div></td>
	</tr>
	</table>
		
	<script type="text/javascript">
	
	$('#button_send').click(function(){
		if($('#form_name').val() === ''){
			alert("No has escrito ningún nombre de hotel");
		} else {
			var url_new = "<s:url value='/backend/hoteles/add'/>";
			$.ajax({
				  method: "POST",
				  url: url_new,
				  data: { 
					  	  	form_name: $('#form_name').val()
					  	}
				})
				  .done(function( msg ) {
				    if (msg.status === "ok"){
				    	alert("Se ha añadido correctamente los datos");
				    	window.location.href = "list";
				    }
				  });
		}
	});
	</script>
</body>
</html>