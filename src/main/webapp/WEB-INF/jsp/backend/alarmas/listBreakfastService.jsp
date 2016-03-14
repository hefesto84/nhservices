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
		</tr>
		<s:iterator value="breakfastServiceRequests">
		<tr>
			<td><s:date name="nowTime" format="dd/MM/yyyy HH:mm"/></td>
			<td style="text-align: center;"><s:property value="room"/></td>
			<td><s:date name="requestTime" format="dd/MM/yyyy HH:mm"/></td>
			<td>
				<div style="width:70% !important;" data-product="true" data-id="<s:property value="id"/>" id="button_settear_alarma">Ver productos</div>
			</td>
		</tr>
		</s:iterator>
	</table>
	
	<script type="text/javascript">
		
		$('[data-product="true"]').click(function(){
			var url = "<s:url value='/backend/alarms/breakfastserviceProduct'/>";
			window.open(url + "?id="+$(this).attr('data-id'));
		});
		
	</script>
</body>
</html>