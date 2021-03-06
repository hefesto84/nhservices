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
	
	<h1 style="text-transform:capitalize;">EDIT Hotel</h1>
	
	<input id="form_id" type="hidden" name="form_id" value="<s:property value='hotel.id'/>">
	<table class="table-edit">
	<tr>
		<th>Nombre:</th>
		<td><input type="text" name="form_name" id="form_name" value="<s:property value='hotel.name'/>"></td>
	</tr>
	<tr>
		<th></th>
		<td class="td-edit-unique"><div id="button_send" class="idioma">Modificar</div></td>
	</tr>
	</table>
	
	<script type="text/javascript">
	var url = "<s:url value='/backend/hoteles/modify'/>";
	$('#button_send').click(function(){
		$.ajax({
			  method: "POST",
			  url: url,
			  data: { form_id: $('#form_id').val(), 
				  	  form_name: $('#form_name').val(),
				  	}
			})
			  .done(function( msg ) {
			    if (msg.status === "ok"){
			    	$('.table-edit').after("<div class='edit-success'>! Se han modificado correctamente el nombre del hotel</div>");
			    }
			  });
	});
	</script>
</body>
</html>