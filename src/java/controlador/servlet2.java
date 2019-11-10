
package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ruta;
import modelo.vehiculo;
import modeloDAO.rutaDAO;
import modeloDAO.vehiculoDAO;

@WebServlet(name = "servlet2", urlPatterns = {"/servlet2"})
public class servlet2 extends HttpServlet {

    vehiculoDAO dao=new vehiculoDAO();
    vehiculo p=new vehiculo();
    int id;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Editar")){
            try{
                id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modificarV.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("modify")){
            try{
                id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modificarVin.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setIdvehiculo(id);
            dao.eliminar(id);
            request.getRequestDispatcher("/vehiculo.jsp").forward(request, response);
        } else if(accion.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setIdvehiculo(id);
            dao.eliminar(id);
            request.getRequestDispatcher("/vehiculoin.jsp").forward(request, response);
        }
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String accion =request.getParameter("accion");
            switch (accion) {
                case "registrar":
                   int idconductor = Integer.parseInt(request.getParameter("idconductor"));
                    String tipo = request.getParameter("tipo");
                    String modelo = request.getParameter("modelo");
                    String placa=request.getParameter("placa");
                    
                    vehiculo vehiculo=new vehiculo();
                    vehiculoDAO DAO = new vehiculoDAO();
                    DAO.agendarVehiculo(modelo,placa,tipo,idconductor);
                    request.getRequestDispatcher("/vehiculo.jsp").forward(request, response);
                   
                   break;
               case "editar":
                   int idvehiculo = Integer.parseInt(request.getParameter("idvehiculo"));
                   int estado = Integer.parseInt(request.getParameter("estado"));
                   int idConductor = Integer.parseInt(request.getParameter("idconductor"));
                    String Placa=request.getParameter("placa");
                    String Modelo = request.getParameter("modelo");
                    String Tipo = request.getParameter("tipo");
                    
                    
                   
                   vehiculo registroin=new vehiculo(idvehiculo,estado,idConductor,Placa,Modelo,Tipo);
                   vehiculoDAO inDAO = new vehiculoDAO();
                   inDAO.actualizarVehiculo(idvehiculo,estado,idConductor,Placa,Modelo,Tipo);
                   request.getRequestDispatcher("/vehiculo.jsp").forward(request, response);
                   
                   break;
               case "eliminar":
                   int idVehiculo = Integer.parseInt(request.getParameter("idvehiculo"));
                   vehiculoDAO inDao =new vehiculoDAO();
                   inDao.eliminar(idVehiculo);
                   request.getRequestDispatcher("/vehiculo.jsp").forward(request, response);
                   
                   break;
               case "edit":
                   int IDVEHICULO = Integer.parseInt(request.getParameter("idvehiculo"));
                   int ESTADO = Integer.parseInt(request.getParameter("estado"));
                   int IDCONDUCTOR = Integer.parseInt(request.getParameter("idconductor"));
                    String PLACA=request.getParameter("placa");
                    String MODELO = request.getParameter("modelo");
                    String TIPO = request.getParameter("tipo");
                    
                   vehiculoDAO DAo = new vehiculoDAO();
                   DAo.actualizarVehiculo(IDVEHICULO,ESTADO,IDCONDUCTOR,PLACA,MODELO,TIPO);
                   request.getRequestDispatcher("/vehiculoin.jsp").forward(request, response);
                   
                   break;
               case "add":
                   int IDCONDUCTOr= Integer.parseInt(request.getParameter("idconductor"));
                    String TIPo = request.getParameter("tipo");
                    String MODELo = request.getParameter("modelo");
                    String PLACa=request.getParameter("placa");
                    
                    vehiculoDAO Dao = new vehiculoDAO();
                    Dao.agendarVehiculo(MODELo,PLACa,TIPo,IDCONDUCTOr);
                    request.getRequestDispatcher("/vehiculoin.jsp").forward(request, response);
                   
                   break;
               
               default:
            }
        }catch(Exception e){
            
        }
            
        
    }


}
