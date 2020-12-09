<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>ABOGADOS WEB</title>

    <!-- Custom fonts for this template-->
    <link href="../carpetaplantilla/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../carpetaplantilla/css/sb-admin-2.min.css" rel="stylesheet">
    
     <link rel="stylesheet" href="../static/alertifyjs/css/alertify.min.css" />
 
<link rel="stylesheet" href="../static/alertifyjs/css/themes/default.min.css" />
 
<script src="../static/alertifyjs/alertify.min.js"></script>
  

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block ">
                            <img alt="" src="https://www.unir.net/wp-content/uploads/2018/09/675876832.jpg"  width="500"
     height="450">
                            
                            </div>
                            
                            <div class="col-lg-6">
                            
                                <div class="p-5">
                                
                                    <div class="text-center">
                                    <h3>ABOGADOS WEB</h3>
                                        <h1 class="h4 text-gray-900 mb-4">INICIO ABOGADO</h1>
                                    </div>
                                    <form id="formLogin" class="user" action="../AbogadoControl" method="get">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="cedula" aria-describedby=""
                                                placeholder="Cedula" name="cedula" required="Llena este campo">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="Contraseņa" name="pass">
                                        </div>
<div align="center">
                                      <button type="submit" name="accion" value="ingreso" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                                      
                 </div>
                                    </form>
                               <hr>
                               <div align="center">
                                    <a href="../index.jsp" class="btn btn-success " >
                                            Ingresar Como Administrador
                                        </a>
                                   </div>
                                   
             
                                </div>
                                
                            </div>
                             
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../carpetaplantilla/vendor/jquery/jquery.min.js"></script>
    <script src="../carpetaplantilla/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../carpetaplantilla/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../carpetaplantilla/js/sb-admin-2.min.js"></script>
    
    	  <c:set var="msg" value="${abogado}"/>
 
    	<c:if test="${msg!=null}">
	
	<script type="text/javascript">
	
	alertify.notify('Usuario o Contraseņa Incorrecta', 'error', 5, function(){  console.log('dismissed'); });
	
	  
	</script>
	 <% session.setAttribute("abogado", null); %>
		
	
	</c:if>

</body>

</html>