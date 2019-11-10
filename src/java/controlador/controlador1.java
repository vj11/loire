/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import modelo.persona;
import modelo.personaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 
 */
public class controlador1 extends HttpServlet {
    
    
    String listar="adminU.jsp";
    String add="registro.jsp";
    String edit="administradorusuario.jsp";
    String dele="administradorusuario.jsp";
    personaDAO dao=new personaDAO();
    persona p=new persona();
   
    int idpersona, rol_idRol, tipodoc_idTipoDoc;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
         else if(action.equalsIgnoreCase("edit")){
            acceso=edit;
        }
          else if(action.equalsIgnoreCase("dele")){
            acceso=dele;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            
            String Dni=request.getParameter("Dni");
            String nombres=request.getParameter("nombres");
            String apellidos=request.getParameter("apellidos");
            String direccion=request.getParameter("direccion");
            String telefono=request.getParameter("telefono");
            String correoElectronico=request.getParameter("correoElectronico");
            String nombreUsuario=request.getParameter("nombreUsuario");
            String contrasenaUsuario=request.getParameter("contrasenaUsuario");
            rol_idRol=Integer.parseInt(request.getParameter("rol_idRol"));
            tipodoc_idTipoDoc=Integer.parseInt(request.getParameter("tipodoc_idTipoDoc"));
            
            p.setDni(Dni);
            p.setNombres(nombres);
            p.setApellidos(apellidos);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setCorreoElectronico(correoElectronico);
            p.setNombreUsuario(nombreUsuario);
            p.setContrasenaUsuario(contrasenaUsuario);
            p.setRol_idRol(rol_idRol);
            p.setTipodoc_idTipoDoc(tipodoc_idTipoDoc);
            
            
            dao.add(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idpersona",request.getParameter("idpersona"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            idpersona=Integer.parseInt(request.getParameter("idpersona"));
            String Dni=request.getParameter("Dni");
            String nombres=request.getParameter("nombres");
            String apellidos=request.getParameter("apellidos");
            String direccion=request.getParameter("direccion");
            String telefono=request.getParameter("telefono");
            String correoElectronico=request.getParameter("correoElectronico");
            String nombreUsuario=request.getParameter("nombreUsuario");
            String contrasenaUsuario=request.getParameter("contrasenaUsuario");
            rol_idRol=Integer.parseInt(request.getParameter("rol_idRol"));
            tipodoc_idTipoDoc=Integer.parseInt(request.getParameter("tipodoc_idTipoDoc"));
            p.setIdPersona(idpersona);
            p.setDni(Dni);
            p.setNombres(nombres);
            p.setApellidos(apellidos);
            p.setDireccion(direccion);
            p.setTelefono(telefono);
            p.setCorreoElectronico(correoElectronico);
            p.setNombreUsuario(nombreUsuario);
            p.setContrasenaUsuario(contrasenaUsuario);
            p.setRol_idRol(rol_idRol);
            p.setTipodoc_idTipoDoc(tipodoc_idTipoDoc);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            idpersona=Integer.parseInt(request.getParameter("idpersona"));
            p.setIdPersona(idpersona);
            dao.eliminar(idpersona);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


