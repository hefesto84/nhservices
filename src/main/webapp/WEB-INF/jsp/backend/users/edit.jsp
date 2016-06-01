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
		input, select{
			width: 100%;
		}
		#boton_actualizar{
			width: 20%;
			margin: auto;
			margin-top: 30px;
			background-color: #9d2236;
			color: #FFFFFF;
			padding: 5px;
			text-align: center;
			text-transform: uppercase;
		}
	</style>
	<table class="table table-striped table-bordered table-hover table-custom">
		<tr>
			<th> Habitación </th>
			<td><input type="text" id="room" value="<s:property value="user.room"/>"></td>
		</tr>
		<tr>
			<th> Tablet </th>
			<td>
				<select id="tablet">
					<s:iterator value="tablets">
						<option value="<s:property value="id"/>" <s:if test="%{id == user.tablet}">selected</s:if>><s:property value="tablet" /></option>
					</s:iterator>
				</select>
			</td>
		</tr>
		<tr>
			<th> User </th>
			<td><input type="text" id="user" value="<s:property value="user.user"/>"></td>
		</tr>
		<tr>	
			<th> Password </th>
			<td><input type="text" id="password" value="<s:property value="user.password"/>"></td>
		</tr>
		<tr>
			<th> IP Asterisk </th>
			<td><input type="text" id="ip_asterisk" value="<s:property value="user.ip_asterisk"/>"></td>
		</tr>
	</table>
	<div id="boton_actualizar" data-url="<s:url value="%{'/backend/users/update?id='+id+''}"/>">Actualizar</div>
	
	<script type="text/javascript">
	
		$('#boton_actualizar').click(function(){
			if($('#room').val() === ''){
				alert("No has introducido ninguna habitación");
			} else if($('#user').val() === ''){
				alert("No has escrito ningún user");
			} else if($('#password').val() === ''){
				alert("No has escrito ningún password");
			} else if($('#ip_asterisk').val() === ''){
				alert("No has escrito ninguna IP Asterisk");
			} else {
				var url_update = $(this).attr('data-url');
				$.ajax({
					  method: "POST",
					  url: url_update,
					  data: {
						  		room: $('#room').val(),
						  	  	tablet: $('#tablet').val(), 
						  		usuario: $('#user').val(),
						  		password: $('#password').val(),
						  		ip_asterisk: $('#ip_asterisk').val(),
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