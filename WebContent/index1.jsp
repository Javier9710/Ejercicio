<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>ABOGADOS WEB</title>
  <meta >
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Satisfy&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="carpetaplantilla/estilo/loginStyle.css">
  <link rel="shortcut icon" href="../carpetaplantilla/img/icon.png">
  
 <link rel="stylesheet" href="static/alertifyjs/css/alertify.min.css" />
 
<link rel="stylesheet" href="static/alertifyjs/css/themes/default.min.css" />
 
<script src="static/alertifyjs/alertify.min.js"></script>
  

</head>
<body >
  <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="carpetaplantilla/img/zam.png" />
                    <h3>ABOGADOS WEB</h3>
                </div>

                <form id="formLogin" class="col-12" action="AccesoControl" method="post">
                    <div class="form-group" id="user-group">
                        <input type="text" class="form-control" placeholder="Cedula" name="cedula" required="Llena este campo"/>
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" class="form-control" placeholder="Contraseña" name="pass" required="Llena este campo"/>
                    </div>
                    <button type="submit" name="accion" value="ingreso" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                    <div class="form-group"> <a href="WebApp/loginAbogado.jsp" style=" text-decoration: none; " ><u>O inicie sesión como Empleado</u></a> </div>
                </form>
                
                
            </div>
        </div>
    </div>
    
    	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
		

  
	<c:if test="${persona1!=NULL}">
	
	<script type="text/javascript">
	var notification = alertify.notify('Usuario o Contraseña Incorrecta', 'error', 5, function(){  console.log('dismissed'); });
	
	</script>
	
				<%
		HttpSession sesion1 = request.getSession();
		sesion1.getAttribute("persona1");
		sesion1.invalidate();
			
			%>
	
	</c:if>
	
</body>

</html>