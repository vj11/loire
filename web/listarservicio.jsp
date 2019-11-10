<%-- 
    Los servicios en lista , para el administrador
    
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="modelo.ClienteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <title>Administrador</title>
        <link rel="shortcut icon" href="css/img/logo.jpg">
        <script
            src="https://code.jquery.com/jquery-3.4.0.min.js"
            integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/js/sweetalert2.min.css">
        <link href="WEB-INF/miu System2/css/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/crear-usuario.css">
        <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/4.1.3/minty/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Noto+Sans+SC" rel="stylesheet">

        <link href="css/js/sb-admin.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/datatables.min.css">
        <link rel="stylesheet" href="css/datatables.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
        <script type="text/javascript">
                    var tableToExcel = (function() {
                    var uri = 'data:application/vnd.ms-excel;base64,'
                            , template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
                            , base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) }
                    , format = function(s, c) { return s.replace(/{(\w+)}/g, function(m, p) { return c[p]; }) }
          return function(table, name) {
          if (!table.nodeType) table = document.getElementById(table)
          var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
          //window.location.href = uri + base64(format(template, ctx))
              var link = document.createElement("a");
                          link.download = "servicios.xls";
                          link.href = uri + base64(format(template, ctx));
                          link.click();
          }
          })()
        </script>
    </head>
    <body>
        <style>
            @import url('https://fonts.googleapis.com/css?family=Noto+Sans+SC');</style>

        <!--Navegador-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <a class="navbar-brand" href="#">
                <img src="css/img/logo2.jpg" alt="Home" width="90" height="40">
            </a>

            <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#">Administrador Servicios</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--Principal-->
    <!--Barra lateral-->
    <div id="wrapper">
        <ul class="sidebar navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="../index-admin.html">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Menu</span>
                </a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Usuarios</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <h6 class="dropdown-header">Gestión de Servicios:</h6>
                    <a class="dropdown-item nav-item" href="index-clientes.html">Clientes</a>
                    <a class="dropdown-item nav-item" href="index-conductores.html">Conductores</a>
                    <a class="dropdown-item nav-item" href="index-estado.html">Estado de Servicio</a>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">Historial:</h6>
                    <a class="dropdown-item nav-item" href="404.html">Servicios</a>
                    <a class="dropdown-item nav-item" href="blank.html">Mantenimiento</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Solicitudes</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <h6 class="dropdown-header">Solicitudes:</h6>
                    <a class="dropdown-item nav-item" href="index-solicitudMante.html">Mantenimiento</a>
                    <a class="dropdown-item nav-item" href="index-vehiculo.html">Ruta</a>
                    <a class="dropdown-item nav-item" href="index-soliservicios.html">Servicio</a>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">Validaciones:</h6>
                    <a class="dropdown-item nav-item" href="index-validarMante.html">Mantenimiento</a>
                    <a class="dropdown-item nav-item" href="index-rutaSig.html">Ruta</a>
                    <a class="dropdown-item nav-item" href="index-validados.html">Servicios</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Inventario</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <h6 class="dropdown-header">Registrar:</h6>
                    <a class="dropdown-item nav-item" href="index-registrar.html">Residuos Clasificados</a>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">Consultar:</h6>
                    <a class="dropdown-item nav-item" href="index-inventario.html">Inventario</a>
                </div>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="tables.html">
                    <i class="fas fa-fw fa-file"></i>
                    <span>Reportes PDF</span></a>
            </li>
        </ul>
        <div class="col-sm-9" style="text-align: center;margin: 4%; background: #f1f3f6">
            <div class="content-wrapper">
                <div class="container-fluid">
                    <!-- Breadcrumbs-->
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="#">Menu</a>
                        </li>
                        <li class="breadcrumb-item active">Agregar servicio</li>
                    </ol>
                    <div class="container">
                        <h1>Gestión de Servicios</h1>
                        <a class="btn btn-success" href="ServletCliente?accion=add"> Servicios </a>
                        <br>

                        <br>
                        <input type=image src="Excel.gif" width="50" height="36" onclick="tableToExcel('testTable', 'Servicios')" class="btn btn-success" data-toggle="tooltip" title="Exportar a Excel">
                        <div class="main-content">
                            <div class="section__content section__content--p30">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="table-responsive table--no-card m-b-30">
 <table  id="example" class="table table-borderless table-striped table-earning">

                         <thead>
                            <tr>
                            <th class="text-center">No servicio</th>
                            <th class="text-center">id servicio</th>
                            <th class="text-center">Razón Social</th>
                            <th class="text-center">Nit</th>
                            <th class="text-center">Dirección</th>
                            <th class="text-center">Teléfono</th>
                            <th class="text-center">Tipo de Servicio</th>
                            <th class="text-center">Fecha Servicio</th>
                            <th class="text-center">Mensaje</th>
                            <th class="text-center">Estado</th>
                                                            

                            </thead>

                            <% ClienteDAO dao = new ClienteDAO();
                             List<Cliente> list = dao.listar();
                            Iterator<Cliente> iter = list.iterator();
                            Cliente cl = null;
                            while (iter.hasNext()) {
                            cl = iter.next();
                            %>
                              <tbody>
                               <tr>
                             <td class="text-center"><%= cl.getIdCliente()%></td>
                             <td class="text-center"><%= cl.getPersona_IdPersona()%></td>
                             <td class="text-center"><%= cl.getRazonSocial()%></td>
                             <td class="text-center"><%= cl.getNit()%></td>
                             <td class="text-center"><%= cl.getDireccion()%></td>
                             <td class="text-center"><%= cl.getTelefono()%></td>
                             <td class="text-center"><%= cl.getTipoServicio()%></td>
                             <td class="text-center"><%= cl.getFecha()%></td>
                             <td class="text-center"><%= cl.getMensaje()%></td>
                             <td class="text-center"><%= cl.getEstado()%></td>                                                            

                            <td class="text-center">
                   <a class="btn btn-warning" href="ServletCliente?accion=editar&idcliente=<%= cl.getIdCliente()%>">Editar</a>
                                    <br>
                   <td><center><button class="btn btn-danger" onClick="mensaje()"><i class="far fa-trash-alt"></i></button></center></td>

                     <script>
                   function mensaje() {
                     Swal.fire({
                     title: '¿Estas seguro de eliminar este servicio?',
                     text: "¡Esta accion no se puede deshacer!",
                     type: 'warning',
                     showCancelButton: true,
                     confirmButtonColor: '#3085d6',
                     cancelButtonColor: '#d33',
                     confirmButtonText: 'Si, deseo eliminar.'
  
                      }).then((result) => {
                     if (result.value) {
                    location.href="ServletCliente?accion=Eliminar&idcliente=<%= cl.getIdCliente()%>";
                          }
                        })
                       }
                     </script>
                                                    
                     <%}%>
                                                    
  </table>
                                                    
  <p class="lead"><button id="json" class="btn btn-primary">TO JSON</button> <button id="csv" class="btn btn-info">TO CSV</button>  <button id="pdf" class="btn btn-danger">TO PDF</button></p>
  
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.4.1/jspdf.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/2.3.5/jspdf.plugin.autotable.min.js"></script>
<script src="src/tableHTMLExport.js"></script>
<script>
  $('#json').on('click',function(){
    $("#example").tableHTMLExport({type:'json',filename:'sample.json'});
  })
  $('#csv').on('click',function(){
    $("#example").tableHTMLExport({type:'csv',filename:'sample.csv'});
  })
  $('#pdf').on('click',function(){
    $("#example").tableHTMLExport({type:'pdf',filename:'sample.pdf'});
  })
  </script>                                           
        
       
        <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>


        <!-- Core plugin JavaScript-->
   <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        <!-- Page level plugin JavaScript-->
  <script src="vendor/datatables/jquery.dataTables.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->

   <script src="css/js/sb-admin.min.js" type="text/javascript"></script>
        <!-- Demo scripts for this page-->

  <script src="css/js/demo/datatables-demo.js" type="text/javascript"></script>
 </body>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>    
</html>
