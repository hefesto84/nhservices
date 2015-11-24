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
	
	<h1 style="text-transform:capitalize;">NEW Idioma</h1>
	
	<table class="table-new">
	<tr>
		<th>Code:</th>
		<td><input type="text" name="form_idioma" id="form_idioma" value=""></td>
	</tr>
	<tr class="table-new">
		<th></th>
		<td class="td-new-unique"><div id="button_send" class="idioma">Guardar</div></td>
	</tr>
	</table>
		
	<script type="text/javascript">
	
	$('#button_send').click(function(){
		if($('#form_idioma').val() === ''){
			alert("No has escrito ningún idioma");
		} else {
			var url_new = "<s:url value='/backend/idiomas/add'/>";
			$.ajax({
				  method: "POST",
				  url: url_new,
				  data: { 
					  	  	form_idioma: $('#form_idioma').val()
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