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
	
	<h1 style="text-transform:capitalize;">EDIT Idioma</h1>
	
	<input id="form_id" type="hidden" name="form_id" value="<s:property value='idioma.id'/>">
	<table class="table-edit">
		<th>Idioma:</th>
		<td><input type="text" name="form_idioma" id="form_idioma" value="<s:property value='idioma.code'/>"></td>
	</tr>
	<tr>
		<th></th>
		<td class="td-edit-unique"><div id="button_send" class="idioma">Modificar</div></td>
	</tr>
	</table>
	
	<script type="text/javascript">
	var url = "<s:url value='/backend/idiomas/modify'/>";
	$('#button_send').click(function(){
		$.ajax({
			  method: "POST",
			  url: url,
			  data: { form_id: $('#form_id').val(), 
				  	  form_idioma: $('#form_idioma').val(),
				  	}
			})
			  .done(function( msg ) {
			    if (msg.status === "ok"){
			    	$('.table-edit').after("<div class='edit-success'>! Se han modificado correctamente el código de idioma</div>");
			    }
			  });
	});
	</script>
</body>
</html>