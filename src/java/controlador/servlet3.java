
package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ruta;
import modeloDAO.rutaDAO;
@WebServlet(name = "servlet3", urlPatterns = {"/servlet3"})
public class servlet3 extends HttpServlet {
    rutaDAO dao=new rutaDAO();
    ruta p=new ruta();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("ruta")){
            try{
                int idconductor=Integer.parseInt(request.getParameter("idconductor"));
                String descripcion="El conductor ya esta disponible";
                String tipo="Solicitud de ruta";
                   rutaDAO Dao =new rutaDAO();
                   Dao.solictudRuta(idconductor, descripcion, tipo);
                   request.getRequestDispatcher("/indexConduc.jsp").forward(request, response);
            } catch(IOException | NumberFormatException | ServletException e){
                
            }
        }else if(accion.equalsIgnoreCase("Editar")){
           try{
                int id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modificarR.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("modify")){
            try{
                int id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modificarRin.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            p.setIdRuta(id);
            dao.eliminar(id);
            request.getRequestDispatcher("/rutas.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("delete")){
            int id=Integer.parseInt(request.getParameter("id"));
            p.setIdRuta(id);
            dao.eliminar(id);
            request.getRequestDispatcher("/rutasin.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      try{
            String accion =request.getParameter("accion");
            switch (accion) {
                case "registrar":
                    try{
                       ruta ruta=new ruta();
                       String direccion=request.getParameter("direccion");
                   SimpleDateFormat in=new SimpleDateFormat("yyyy-mm-dd");
                    String fecha=request.getParameter("fecha");
                    int iddconductor= Integer.parseInt(request.getParameter("idconductor"));
                    int idservicio=Integer.parseInt(request.getParameter("idservicio"));
                    int iddVehiculo=Integer.parseInt(request.getParameter("idVehiculo"));
                    String descripcion="Se agendó una nueva ruta";
                    String tipo="Nueva ruta agendada";
                    
                    
                    rutaDAO DAOO = new rutaDAO();
                    DAOO.agendarRuta(direccion,fecha,iddconductor,idservicio,iddVehiculo,descripcion,tipo);
                    request.getRequestDispatcher("/rutas.jsp").forward(request, response);
                    }catch(NumberFormatException e){
                        
                    }
                   break;
               case "editar":
                    try{
                      int idRuta = Integer.parseInt(request.getParameter("idRuta"));
                   String Direccion=request.getParameter("direccion");
                    String Fecha=request.getParameter("fecha");
                    int Idconductor= Integer.parseInt(request.getParameter("idconductor"));
                    int Idservicio=Integer.parseInt(request.getParameter("idservicio"));
                    int IdVehiculo=Integer.parseInt(request.getParameter("idVehiculo"));
                   int Estado = Integer.parseInt(request.getParameter("estado"));
                    
                   rutaDAO iDAO = new rutaDAO();
                   iDAO.actualizarRuta(idRuta,Direccion,Fecha,Idconductor,Idservicio,IdVehiculo,Estado);
                   request.getRequestDispatcher("/rutas.jsp").forward(request, response);
                   }catch(NumberFormatException e){
                       
                   }
                   break;
               case "eliminar":
                   int idRuta = Integer.parseInt(request.getParameter("idRuta"));
                   rutaDAO inDao =new rutaDAO();
                   inDao.eliminar(idRuta);
                   request.getRequestDispatcher("/rutas.jsp").forward(request, response);
                   break;
               case "add":
                   try{
                       ruta ruta=new ruta();
                       String direccion=request.getParameter("direccion");
                   SimpleDateFormat in=new SimpleDateFormat("yyyy-mm-dd");
                    String fecha=request.getParameter("fecha");
                    int iddconductor= Integer.parseInt(request.getParameter("idconductor"));
                    int idservicio=Integer.parseInt(request.getParameter("idservicio"));
                    int iddVehiculo=Integer.parseInt(request.getParameter("idVehiculo"));
                    String descripcion="Se agendó una nueva ruta";
                    String tipo="Nueva ruta agendada";
                    
                    
                    rutaDAO DAOO = new rutaDAO();
                    DAOO.agendarRuta(direccion,fecha,iddconductor,idservicio,iddVehiculo,tipo,descripcion);
                    request.getRequestDispatcher("/rutasin.jsp").forward(request, response);
                    }catch(NumberFormatException e){
                        
                    }
                   break;
               case "edit":
                   try{
                      int IDRUTA = Integer.parseInt(request.getParameter("idRuta"));
                   String Direccion=request.getParameter("direccion");
                    String Fecha=request.getParameter("fecha");
                    int Idconductor= Integer.parseInt(request.getParameter("idconductor"));
                    int Idservicio=Integer.parseInt(request.getParameter("idservicio"));
                    int IdVehiculo=Integer.parseInt(request.getParameter("idVehiculo"));
                   int Estado = Integer.parseInt(request.getParameter("estado"));
                    
                   rutaDAO iDAO = new rutaDAO();
                   iDAO.actualizarRuta(IDRUTA,Direccion,Fecha,Idconductor,Idservicio,IdVehiculo,Estado);
                   request.getRequestDispatcher("/rutasin.jsp").forward(request, response);
                   }catch(NumberFormatException e){
                       
                   }
                   break;
               default:
            }
            
        }catch(NumberFormatException e){
            
        }
            
        
    }


}
