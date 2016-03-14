<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="../js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="../css/main.css">
<script src="../js/bootstrap.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="../js/jquery-ui-datapicker-es.js"></script>
<script src="../js/Chart.min.js"></script>
<title>123Compare.me v.2</title>
</head>
<body  style="margin:1em;">
<style>
	.panel-heading{
		background-color:#9d2236 !important;
		background-image: none !important;
		color: #FFFFFF !important;
	}
	
	.panel-heading a{
		color: #FFFFFF !important;
	}
	
	.panel-info{
		margin-top: -25px !important;
		border: 0px !important;
	}
	
	.controls input{
		background-color: #9d2236 !important;
		border-color: #9d2236 !important;
		background-image: none;
	}
	
	.texto{
		padding: 20px;
		font-size: 20px;
		text-align: center;
	}
</style>
<center><img src="http://static.nh-hotels.net/system/collection/img/logo-NH.png"/></center>
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel-heading" style="background-color:#9d2236 !important; height: 30px;"></div>
            <div class="texto">Se ha confirmado la recepción del mail de solicitud de Breakfast para el día:&nbsp;<b><s:property value="time"/></b></div>
            <div class="panel-heading" style="background-color:#9d2236 !important; height: 30px;"></div>
        </div>
    </div>
</body>

</html>