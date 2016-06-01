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
	<table class="table table-striped table-bordered table-hover table-custom">
		<tr>
		    <th> Hora Solicitud </th>
			<th> Habitación </th>
			<th> Hora Room Service</th>
			<th> Productos </th>
			<th class="table-custom-acciones"> Estado </th>
		</tr>
		<s:iterator value="roomServiceRequests">
		<tr>
			<td><s:date name="nowTime" format="dd/MM/yyyy HH:mm"/></td>
			<td style="text-align: center;"><s:property value="room"/></td>
			<td><s:date name="requestTime" format="dd/MM/yyyy HH:mm"/></td>
			<td>
				<div style="width:70% !important;" data-product="true" data-id="<s:property value="id"/>" id="button_settear_alarma">Ver productos</div>
			</td>
			<td>
				<s:set name="actived" value="actived"/>
				<s:if test="%{actived==true}">
				   <span>Aviso confirmado</span> 
				</s:if>
				<s:else>
				   <div style="width:70% !important;" data-set="true" data-id="<s:property value="id"/>" id="button_settear_alarma">Confirmar aviso</div>
				</s:else>
			</td>
		</tr>
		</s:iterator>
	</table>
	
	<script type="text/javascript">
	
		$('[data-set="true"]').click(function(){
			var url = "<s:url value='/backend/alarms/roomserviceActivate'/>";
			$.ajax({
			  method: "POST",
			  url: url,
			  data: { id: $(this).attr('data-id')}
			}).done(function( msg ) {
			    if (msg.status === "ok"){
			    	alert("Eliminado correctamente");
					location.reload();
			    }
			});
		});
		
		$('[data-product="true"]').click(function(){
			var url = "<s:url value='/backend/alarms/roomserviceProduct'/>";
			window.open(url + "?id="+$(this).attr('data-id'));
		});
		
	</script>
</body>
</html>