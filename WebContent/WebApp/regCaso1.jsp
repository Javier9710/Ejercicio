<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Registro Caso</title>

  <!-- Custom fonts for this template-->
  <link href="../carpetaplantilla/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link rel="shortcut icon" href="../carpetaplantilla/img/icon.png">

  <!-- Custom styles for this template-->
  <link href="../carpetaplantilla/css/sb-admin-2.min.css" rel="stylesheet">
  
<link rel="stylesheet" href="../static/alertifyjs/css/alertify.min.css" />
 
<link rel="stylesheet" href="../static/alertifyjs/css/themes/default.min.css" />
 
<script src="../static/alertifyjs/alertify.min.js"></script>

</head>

<body id="page-top">




  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
   

    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar  static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                
                  <i class="fas fa-search fa-sm"></i>
                 
                  
                </button>
                 &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="inicioAbogado.jsp" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                                        <span class="text">Mis Casos</span>
                                    </a>
                
                
                
              </div>
              
              
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><c:out value="${abogado.persona.nombre}"></c:out></span>
                <img class="img-profile rounded-circle" src="https://raw.githubusercontent.com/Javier9710/Ejercicio/master/img/<c:out value="${abogado.foto}"></c:out>" >
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                
                <a class="dropdown-item" href="misDatos.jsp" >
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Mis Datos
                </a>
                
                <a class="dropdown-item" href="../AccesoControl?accion=cerrar" >
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Cerrar Sesión
                </a>
                
              </div>
            </li>

          </ul>

        </nav>
    </div>


       
        <div class="container-fluid" style="background-image: url(https://www.publicdomainpictures.net/pictures/280000/velka/gradient-yellow-to-blue-background.jpg);"><br>

          <!-- Page Heading -->

          <div class="row justify-content-center align-self-center" >

            <div class="col col-sm-9 col-md-9 col-lg-6 col-xl-6 h-100" style="background-color: #a7c0cd;" style="border-radius: 20px;">
            
            <form method="get" action="../CasoControl" enctype="multipart/form-data">
                  
               <legend class="text-center header" style="color: black;">Registrar Caso</legend>

                <div class="form-group">
                    <input _ngcontent-c0="" class="form-control" name="nombreCaso" placeholder="Nombre Caso" type="text" required>
                </div>

                <div class="form-group">
                    <input _ngcontent-c0="" class="form-control" name="nombreC" placeholder="Nombre Cliente" type="text" required>
                </div>
                
                 <div class="form-group">
                    <input _ngcontent-c0="" class="form-control" name="cedula" placeholder="Cedula Cliente" type="text" required>
                </div>
                
                <div class="form-group">
                    <input _ngcontent-c0="" class="form-control" name="correo" placeholder="Correo Cliente" type="text" required>
                </div>
                
                <div class="form-group">
                    <input _ngcontent-c0="" class="form-control" name="telefono" placeholder="Telefono Cliente" type="text" required>
                </div>
                
                <div class="form-group">
                    <input _ngcontent-c0="" class="form-control" name="direccion" placeholder="Direccion Cliente" type="text" required>
                </div>
                
                <div class="form-group">
                    <select class="form-control" name="tipo" >
                      <option>Tipo Caso</option>
                      <option value="Civil">Civil</option>
                      <option value="Penal">Penal</option>
                      <option value="Familiar">Familiar</option>
                      <option value="Laboral">Laboral</option>
                      <option value="Administrativo">Administrativo</option>
                      <option value="Disciplinario">Disciplinario</option>
                      <option value="Militar">Militar</option>
                   </select>
                </div>
                
                <div class="form-row">
            
                   <div class="col">
                    <label  class="" style="color: black;">Fecha del Caso:</label>
                       <input type="date" class="form-control" placeholder="First name" name="fecha">
                   </div>
                </div><br>

                <div class="form-group">
                    <textarea _ngcontent-c0="" class="form-control" name="informacion" placeholder="Descripcion" type="text" required></textarea>
                </div>
                
                                <div class="form-group">
                    <select class="form-control" name="importancia" >
                      <option>Importancia</option>
                      <option value="Alto">Alto</option>
                      <option value="Medio">Medio</option>
                      <option value="Bajo">Bajo</option>
                   </select>
                </div>
                
                <input type="hidden" name="id" value="<c:out value="${abogado.persona.cedula}"></c:out>">
                
                <div class="form-group">
                  <div class="col-md-12 text-center">
                    <button  type="submit" name="accion" value="registro"  style="width: 40%;" class="btn btn-primary" >Registrar Caso</button>
                  </div>
                </div>
                
                </form>
              
            </div>
          </div><br>
      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white" >
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2020</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  

  <!-- Bootstrap core JavaScript-->
  <script src="../carpetaplantilla/vendor/jquery/jquery.min.js"></script>
  <script src="../carpetaplantilla/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="../carpetaplantilla/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="../carpetaplantilla/js/sb-admin-2.min.js"></script>
  
  
  
  
  

</body>

<c:set var="msg" value="${registroC}"/>
  
    	<c:if test="${msg==1}">
	
	<script type="text/javascript">
	
	alertify.notify('Registro Exitoso', 'success', 5, function(){  console.log('dismissed'); });

	</script>
	<% session.setAttribute("registroC", null); %>
	 
		
	
	</c:if>

</html>
