

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;

public class ServletCliente extends HttpServlet {

    String listar="listarservicio.jsp";
    String listarC="serviciosCompletos.jsp";
    String add="Principal.jsp";
    String edit="editarservicio.jsp";
    String dele="editarservicio.jsp";
    ClienteDAO dao=new ClienteDAO();
    Cliente c=new Cliente();
   
    
    int tiposervicio,idcliente,persona_idpersona;
    String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCliente at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("listarC")){
            acceso=listarC;
            
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
            idcliente=Integer.parseInt(request.getParameter("idcliente"));
            persona_idpersona=Integer.parseInt(request.getParameter("persona_idpersona"));
            String razonsocial=request.getParameter("razonsocial");
            String nit=request.getParameter("nit");
            String direccion=request.getParameter("direccion");
            String telefono=request.getParameter("telefono");
            String tiposervicio=request.getParameter("tiposervicio");
            String fecha=request.getParameter("fecha");
            String mensaje=request.getParameter("mensaje");
            
            c.setIdCliente(idcliente);
            c.setPersona_IdPersona(persona_idpersona);
            c.setRazonSocial(razonsocial);
            c.setNit(nit);
            c.setDireccion(direccion);
            c.setTelefono(telefono);
            c.setTipoServicio(tiposervicio);
            c.setFecha(fecha);
            c.setMensaje(mensaje);
            
            dao.add(c);
            acceso=listar;
    }
        else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idcliente", request.getParameter("idcliente"));
            acceso = edit;
        }else if (action.equalsIgnoreCase("modify")) {
            request.setAttribute("idcliente", request.getParameter("idcliente"));
            request.getRequestDispatcher("/editarServicioin.jsp").forward(request, response);
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            idcliente=Integer.parseInt(request.getParameter("idcliente"));
            persona_idpersona=Integer.parseInt(request.getParameter("persona_idpersona"));
            String razonsocial=request.getParameter("razonsocial");
            String nit=request.getParameter("nit");
            String direccion=request.getParameter("direccion");
            String telefono=request.getParameter("telefono");
            String tiposervicio=request.getParameter("tiposervicio");
            String fecha=request.getParameter("fecha");
            String mensaje=request.getParameter("mensaje");
            
            c.setIdCliente(idcliente);
            c.setPersona_IdPersona(persona_idpersona);
            c.setRazonSocial(razonsocial);
            c.setNit(nit);
            c.setDireccion(direccion);
            c.setTelefono(telefono);
            c.setTipoServicio(tiposervicio);
            c.setFecha(fecha);
            c.setMensaje(mensaje);
            dao.edit(c);
            
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("Eliminar")){
            idcliente=Integer.parseInt(request.getParameter("idcliente"));
            c.setIdCliente(idcliente);
            dao.eliminar(idcliente);
            acceso=listar;
        }
        else if (action.equalsIgnoreCase("Generar")){
            try{
                request.setAttribute("idcliente", request.getParameter("idcliente"));
            request.getRequestDispatcher("/factura.jsp").forward(request, response);
            } catch(NumberFormatException e){
                
            }
            
            acceso=listarC;
        } /*else if(action.equalsIgnoreCase("Generaracta")){
            idcliente=Integer.parseInt(request.getParameter("idcliente"));
            email=request.getParameter("email");
            c.setIdCliente(idcliente);
            try {
                DAO.pruebax();
            } catch (JRException ex) {
                Logger.getLogger(ServletCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            acceso=listarC;
        }*/
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         /* try{
            String accion =request.getParameter("accion");
        switch (accion) {
            case "enviar":
                   try{
                       int conductor=Integer.parseInt(request.getParameter("conductor"));
                       int vehiculo=Integer.parseInt(request.getParameter("vehiculo"));
                       String descripcion=request.getParameter("descripcion");
                       String tipo="Mantenimiento";
                       
                       manteDAO iDAO = new manteDAO();
                       iDAO.solicitud(conductor, vehiculo, descripcion,tipo);
                       
                   } catch (NumberFormatException e){
                       
                   }
                    request.getRequestDispatcher("/indexConduc.jsp").forward(request, response);
                   break;
            default:
                throw new AssertionError();
        }
          }catch(Exception e){
              
          }*/
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
