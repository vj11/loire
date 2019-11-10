<%-- 
    Document   : factura
    Created on : 05-nov-2019, 2:16:01
    Author     : sakur
--%>

<%@page import="modelo.Cliente"%>
<%@page import="modelo.ClienteDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="net.sf.jasperreports.engine.JRException"%>
<%@page import="net.sf.jasperreports.engine.JasperExportManager"%>
<%@page import="net.sf.jasperreports.engine.JasperReport"%>
<%@page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@page import="modelo.conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>JSP Page</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    </head>
    <body>
        <% ClienteDAO dao=new ClienteDAO();
                    int id=Integer.parseInt(request.getParameter("idcliente"));
                    Cliente per=(Cliente)dao.listar(id);%>
        <h1>Factura</h1>
        <p>En el siguiente se presenta una factura del cliente <%=per.getRazonsocial()%></p>
        
        <table>
            <thead class=" text-primary">
            <th>Razón Social</th>
            <th>Nit</th>
            <th>Iva</th>
            <th>Valor Unitario</th>
            <th>Valor Total</th>
        </thead>
        <tr>
                        <td><%=per.getRazonsocial()%></td>
                        <td><%=per.getNit()%></td>
                        <td><%=per.getIva()%></td>
                        <td><%=per.getValoruni()%></td>
                        <td><%=per.getCosto()%></td>
                    </tr>
        </table>
    </body>
</html>
