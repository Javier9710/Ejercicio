<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>ABOGADOS WEB</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="../carpetaplantilla/estilo/loginStyle.css">
  <link rel="shortcut icon" href="../carpetaplantilla/img/icon.png">
  
<link rel="stylesheet" href="../static/alertifyjs/css/alertify.min.css" />
 
<link rel="stylesheet" href="../static/alertifyjs/css/themes/default.min.css" />
 
<script src="../static/alertifyjs/alertify.min.js"></script>
</head>
<body >
  <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="../carpetaplantilla/img/user.png" />
                    <h3>ABOGADO</h3>
                </div>

                <form id="formLogin" class="col-12" action="../AbogadoControl" method="get">
                    <div class="form-group" id="user-group">
                        <input type="text" class="form-control" placeholder="Cedula" name="cedula"required="Llena este campo"/>
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" class="form-control" placeholder="Contrase�a" name="pass" required="Llena este campo"/>
                    </div>
                    <button type="submit" name="accion" value="ingreso" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                </form>
                
                
            </div>
        </div>
    </div>
    
    	<c:if test="${abogado!=null}">
	
	<script type="text/javascript">
	var notification = alertify.notify('Usuario o Contrase�a Incorrecta', 'error', 5, function(){  console.log('dismissed'); });
	
	</script>
	
			<%
			HttpSession sesion1 = request.getSession();
		sesion1.getAttribute("abogado");
		sesion1.invalidate();
			
			%>
	
	</c:if>
	
</body>

</html>