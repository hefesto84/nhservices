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
	
	<h1 style="text-transform:capitalize;">NEW Seguridad</h1>
	
	<table class="table-new">
	<tr>
		<th>Hotel:</th>
		<td>
			<select id="form_name" name="form_name">
				<option value="" disabled selected>Selecciona el hotel</option>
				<s:iterator value="hoteles">
					<option value="<s:property value='id'/>"><s:property value="name"/></option>
				</s:iterator>
			</select>
		</td>
	</tr>
	<tr class="table-new-extra">
		<th>Idioma:</th>
		<td>	
			<select id="form_lang" name="form_lang">
				<option value="" disabled selected>Selecciona el idioma</option>
			</select>
		</td>
	</tr>
	<tr class="table-new-extra">
		<th>Texto Seguridad:</th>
		<td><textarea cols="60" rows="8" name="form_security" id="form_security" value=""></textarea></td>
	</tr>
	<tr class="table-new-extra">
		<th></th>
		<td class="td-new-unique"><div id="button_send">Guardar</div></td>
	</tr>
	</table>
	
	<div class="edit-error-message">! Ya están añadidos los textos de seguridad para este hotel, puedes editarlos</div>
	
	<script type="text/javascript">
	
	var url = "<s:url value='/backend/seguridad/lang'/>";
	
	$('#form_name').change(function(){
		$('select#form_lang').find('option').remove().end().append('<option value="" disabled>Selecciona el idioma</option>').val('');
		$( "select#form_name option:selected" ).each(function() {
			$.ajax({
				  method: "POST",
				  url: url,
				  data: { id: $(this).val()}
				}).done(function( msg ) {
					if (msg.array.length === 0){
						$('.table-new-extra').hide();
						$('.edit-error-message').show();
					} else {
						$('.edit-error-message').hide();
						for (var i = 0; i < msg.array.length; i++){
							$("#form_lang").append('<option value="'+msg.array[i]+'">'+msg.array[i]+'</option>');
						}
						$('.table-new-extra').show();
					}
				});
				      
		});
	});
	
	$('#button_send').click(function(){
		if(($('#form_lang').val() === '') || ($('#form_lang').val() === null)){
			alert("No has seleccionado el idioma");
		} else if($('#form_security').val() === ''){
			alert("No has escrito ningún canal");
		} else {
			var url_new = "<s:url value='/backend/seguridad/add'/>";
			$.ajax({
				  method: "POST",
				  url: url_new,
				  data: { 
					  	  	form_hotel_id: $('#form_name').val(), 
					  		form_lang: $('#form_lang').val(), 
					  	  	form_security: $('#form_security').val(),
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