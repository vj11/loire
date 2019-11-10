
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.manteDAO;
import modelo.manten;


@WebServlet(name = "mantenimiento", urlPatterns = {"/mantenimiento"})
public class mantenimiento extends HttpServlet {
    manteDAO dao=new manteDAO();
    manten p=new manten();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Editar")){
            try{
                int id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modiMante.jsp").forward(request, response);
        } else if(accion.equalsIgnoreCase("modify")){
            try{
                int id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modiMantein.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("eliminar")){
            int id=Integer.parseInt(request.getParameter("id"));
            p.setIdmante(id);
            dao.invalidar(id);
            request.getRequestDispatcher("/mante.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("delete")){
            int id=Integer.parseInt(request.getParameter("id"));
            p.setIdmante(id);
            dao.invalidar(id);
            request.getRequestDispatcher("/mantein.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              try{
            String accion =request.getParameter("accion");
            switch (accion) {
                case "registrar":
                    try{
                       manten ruta=new manten();
                       String fehcain=request.getParameter("fechain");
                    String fechafin=request.getParameter("fechafin");
                    String daños=request.getParameter("danos");
                    String repuestos=request.getParameter("repuestos");
                    String taller=request.getParameter("taller");
                    String mecanico=request.getParameter("mecanico");
                    int costosre=Integer.parseInt(request.getParameter("costosre"));
                    int costosrevi=Integer.parseInt(request.getParameter("costosrevi"));
                    int idsolicitud= Integer.parseInt(request.getParameter("idVehiculo"));
                    
                    
                    manteDAO DAOO = new manteDAO();
                    DAOO.registarMante(fehcain,fechafin,daños,repuestos,taller,mecanico,costosre,costosrevi,idsolicitud);
                    request.getRequestDispatcher("/mante.jsp").forward(request, response);
                    }catch(NumberFormatException e){
                        
                    }
                   break;
               case "editar":
                    try{
                      int idmante = Integer.parseInt(request.getParameter("idmante"));
                   String fehcain=request.getParameter("fechain");
                    String fechafin=request.getParameter("fechafin");
                    String daños=request.getParameter("danos");
                    String repuestos=request.getParameter("repuestos");
                    String taller=request.getParameter("taller");
                    String mecanico=request.getParameter("mecanico");
                    int costosre=Integer.parseInt(request.getParameter("costosre"));
                    int costosrevi=Integer.parseInt(request.getParameter("costosrevi"));
                    int idsolicitud= Integer.parseInt(request.getParameter("idconductor"));
                   String Estado = request.getParameter("estado");
                    
                   manteDAO iDAO = new manteDAO();
                   iDAO.actualizarMante(idmante,fehcain,fechafin,daños,repuestos,taller,mecanico,costosre,costosrevi,idsolicitud,Estado);
                   request.getRequestDispatcher("/mante.jsp").forward(request, response);
                   }catch(NumberFormatException e){
                       
                   }
                   break;
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
               case "add":
                   try{
                       manten ruta=new manten();
                       String fehcain=request.getParameter("fechain");
                    String fechafin=request.getParameter("fechafin");
                    String daños=request.getParameter("danos");
                    String repuestos=request.getParameter("repuestos");
                    String taller=request.getParameter("taller");
                    String mecanico=request.getParameter("mecanico");
                    int costosre=Integer.parseInt(request.getParameter("costosre"));
                    int costosrevi=Integer.parseInt(request.getParameter("costosrevi"));
                    int idsolicitud= Integer.parseInt(request.getParameter("idconductor"));
                    
                    
                    manteDAO DAOO = new manteDAO();
                    DAOO.registarMante(fehcain,fechafin,daños,repuestos,taller,mecanico,costosre,costosrevi,idsolicitud);
                    request.getRequestDispatcher("/mantein.jsp").forward(request, response);
                    }catch(NumberFormatException e){
                        
                    }
                   break;
               case "edit":
                    try{
                      int idmante = Integer.parseInt(request.getParameter("idmante"));
                   String fehcain=request.getParameter("fechain");
                    String fechafin=request.getParameter("fechafin");
                    String daños=request.getParameter("danos");
                    String repuestos=request.getParameter("repuestos");
                    String taller=request.getParameter("taller");
                    String mecanico=request.getParameter("mecanico");
                    int costosre=Integer.parseInt(request.getParameter("costosre"));
                    int costosrevi=Integer.parseInt(request.getParameter("costosrevi"));
                    int idsolicitud= Integer.parseInt(request.getParameter("idconductor"));
                   String Estado = request.getParameter("estado");
                    
                   manteDAO iDAO = new manteDAO();
                   iDAO.actualizarMante(idmante,fehcain,fechafin,daños,repuestos,taller,mecanico,costosre,costosrevi,idsolicitud,Estado);
                   request.getRequestDispatcher("/mantein.jsp").forward(request, response);
                   }catch(NumberFormatException e){
                       
                   }
                   break;
               default:
            }
            
        }catch(NumberFormatException e){
            
        }
    }



}
