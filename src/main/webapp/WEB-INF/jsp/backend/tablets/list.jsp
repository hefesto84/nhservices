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
		#nueva_tablet{
			width: 15%;
			float: right;
			margin-bottom: -20px;
			background-color: #9d2236;
			color: #FFFFFF;
			padding: 5px;
			text-align: center;
			text-transform: uppercase;
			border-radius: 5px;
		}
		.eliminar{
			color: #337ab7;
		}
		.eliminar:hover{
			text-decoration: underline;
			cursor: pointer;
		}
	</style>
	<a href="<s:url value="/backend/tablets/new"/>"><div id="nueva_tablet">Nueva Tablet</div></a>
	<div style="clear:both;"></div>
	<table class="table table-striped table-bordered table-hover table-custom">
		<tr>
			<th> Tablet </th>
			<th> UUID </th>
			<th> Acciones </th>
		</tr>
		<s:iterator value="tablets">
		<tr>
			<td><s:property value="tablet"/></td>
			<td><s:property value="identificador"/></td>
			<td><a href="<s:url value="%{'/backend/tablets/edit?id='+id+''}"/>">Editar</a>&nbsp;/&nbsp;<span class="eliminar" data-url="<s:url value="%{'/backend/tablets/delete?id='+id+''}"/>">Eliminar</span></td>
		</tr>
		</s:iterator>
	</table>
	
	<script type="text/javascript">
		
		$('.eliminar').click(function(){
			url_del = $(this).attr('data-url');
			
			$.ajax({
				  method: "POST",
				  url: url_del,
				  data: {}
				})
				  .done(function( msg ) {
				    if (msg.status === "ok"){
				    	alert("Se ha eliminado correctamente el registro");
				    	window.location.href = "list";
				    }
				  });
		})
		
	</script>

</body>
</html>