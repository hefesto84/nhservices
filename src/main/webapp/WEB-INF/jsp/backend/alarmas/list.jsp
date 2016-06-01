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
	<h1 style="text-transform:capitalize;"><s:property value="page"/></h1>
	<table class="table table-striped table-bordered table-hover table-custom">
		<tr>
			<th> Habitación </th>
			<th> Hora </th>
			<th class="table-custom-acciones"> Estado </th>
		</tr>
		<s:iterator value="wakeUpAlarms">
		<tr>
			<td class="table-custom-room"><s:property value="room"/></td>
			<td class="table-custom-alarm"><s:date name="wakeUpTime" format="dd/MM/yyyy HH:mm"/></td>
			<td>
				<s:set name="actived" value="actived"/>
				<s:if test="%{actived==true}">
				   <span>Aviso confirmado</span> 
				</s:if>
				<s:else>
				   <div data-set="true" data-id="<s:property value="id"/>" id="button_settear_alarma">Confirmar aviso</div>
				</s:else>
				<!-- <a href="<s:url value="%{'/backend/'+page+'/edit?id='+id_hotel+'&lang='+lang}"/>">Modificar</a>&nbsp;&nbsp;&nbsp;<span id="list_delete" onclick='deleteList("<s:url value="%{'/backend/'+page+'/delete?id='+id}"/>")'>Eliminar</span> -->
			</td>
		</tr>
		</s:iterator>
	</table>
	
	<script type="text/javascript">
	
		$('[data-set="true"]').click(function(){
			var url = "<s:url value='/backend/alarms/wakeupActivate'/>";
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
		
	</script>
</body>
</html>