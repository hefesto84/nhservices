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
	
	<h1 style="text-transform:capitalize;">EDIT Seguridad</h1>
	
	<input id="form_id" type="hidden" name="form_id" value="<s:property value='seguridad.id'/>">
	<table class="table-edit">
	<tr>
		<th>Hotel:</th>
		<td><s:property value="seguridad.hotel_name"/></td>
	</tr>
	<tr>
		<th>Idioma:</th>
		<td><s:property value="seguridad.lang"/></td>
	</tr>
	<tr>
		<th>Texto Seguridad:</th>
		<td><textarea cols="60" rows="8" name="form_security" id="form_security" value=""><s:property value='seguridad.description'/></textarea></td>
	</tr>
	<tr>
		<th></th>
		<td class="td-edit-unique"><div id="button_send">Modificar</div></td>
	</tr>
	</table>
	
	<script type="text/javascript">
	var url = "<s:url value='/backend/seguridad/modify'/>";
	$('#button_send').click(function(){
		$.ajax({
			  method: "POST",
			  url: url,
			  data: { form_id: $('#form_id').val(), 
				  	  form_security: $('#form_security').val(),
				  	}
			})
			  .done(function( msg ) {
			    if (msg.status === "ok"){
			    	$('.table-edit').after("<div class='edit-success'>! Se han modificado correctamente los datos</div>");
			    }
			  });
	});
	</script>
</body>
</html>