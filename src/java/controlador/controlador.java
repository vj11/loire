
package controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.inventario;
import modeloDAO.inventarioDAO;


@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class controlador extends HttpServlet {
    inventarioDAO dao=new inventarioDAO();
    inventario p=new inventario();
   
    int id;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String accion=request.getParameter("accion");
        if(accion.equalsIgnoreCase("Editar")){
            try{
                id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modificarInventario.jsp").forward(request, response);
        }else if(accion.equalsIgnoreCase("modify")){
            try{
                id=Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e){
                
            }
            
            request.getRequestDispatcher("/modificarInventarioin.jsp").forward(request, response);
        }
        else if(accion.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.inavilitar(id);
            request.getRequestDispatcher("/listarInventario.jsp").forward(request, response);
        } else if(accion.equalsIgnoreCase("delete")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.inavilitar(id);
            request.getRequestDispatcher("/listarInventarioin.jsp").forward(request, response);
        }
        else if(accion.equalsIgnoreCase("Habilitar")){
            try{
                id=Integer.parseInt(request.getParameter("id"));
                p.setId(id);
                dao.inavilitar(id);
            } catch(NumberFormatException e){
                
            }
            request.getRequestDispatcher("/listarInventario.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       try{ 
        
        /*int idForm = Integer.parseInt(request.getParameter("idform"));
        String tipo = request.getParameter("tipo");
        Float cantidad = Float.parseFloat(request.getParameter("cantidad"));
        String generador = request.getParameter("generador");
        /* prueba del controlador
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=response.getWriter()){
        out.println("id del formulario "+idForm);
        out.println("tipo de residuo "+tipo);
        out.println("cantidad de residuo "+cantidad);s
        out.println("generador de los residuos "+generador);
        }*/
        String accion =request.getParameter("accion");
           switch (accion) {
               case "registrar":
                   int idForm = Integer.parseInt(request.getParameter("idform"));
                    String tipo = request.getParameter("tipo");
                    Float cantidad = Float.parseFloat(request.getParameter("cantidad"));
                    String generador = request.getParameter("generador");
                    
                    
                    inventario inventario=new inventario(idForm, tipo,cantidad, generador);
                    inventarioDAO DAO = new inventarioDAO();
                    DAO.agregarIngreso(idForm, tipo,cantidad, generador);
                    request.getRequestDispatcher("/listarInventario.jsp").forward(request, response);
                   
                   break;
               case "editar":
                   int id = Integer.parseInt(request.getParameter("id"));
                    int idform = Integer.parseInt(request.getParameter("idform"));
                    String Tipo = request.getParameter("tipo");
                    Float Cantidad = Float.parseFloat(request.getParameter("cantidad"));
                    String Generador = request.getParameter("generador");
                   
                   inventario registroin=new inventario(id, idform, Tipo,Cantidad, Generador);
                   inventarioDAO inDAO = new inventarioDAO();
                   inDAO.modificarRegistro(id, idform, Tipo, Cantidad, Generador);
                   request.getRequestDispatcher("/listarInventario.jsp").forward(request, response);
                   
                   break;
               case "eliminar":
                   int Id = Integer.parseInt(request.getParameter("id"));
                   inventarioDAO inDao =new inventarioDAO();
                   inDao.inavilitar(Id);
                   request.getRequestDispatcher("/listarInventario.jsp").forward(request, response);
                   
                   break;
               case "add":
                   int IDFORm = Integer.parseInt(request.getParameter("idform"));
                    String TIPo = request.getParameter("tipo");
                    Float CANTIDad = Float.parseFloat(request.getParameter("cantidad"));
                    String GENERADor = request.getParameter("generador");

                    inventarioDAO DAo = new inventarioDAO();
                    DAo.agregarIngreso(IDFORm, TIPo,CANTIDad, GENERADor);
                    request.getRequestDispatcher("/listarInventarioin.jsp").forward(request, response);
                   
                   break;
               case "edit":
                   int ID = Integer.parseInt(request.getParameter("id"));
                    int IDFORM = Integer.parseInt(request.getParameter("idform"));
                    String TIPO = request.getParameter("tipo");
                    Float CANTIDAD = Float.parseFloat(request.getParameter("cantidad"));
                    String GENERADOR = request.getParameter("generador");
                   
                   inventarioDAO INDAO = new inventarioDAO();
                   INDAO.modificarRegistro(ID, IDFORM, TIPO, CANTIDAD, GENERADOR);
                   request.getRequestDispatcher("/listarInventarioin.jsp").forward(request, response);
                   
                   break;
               default:
           }
        
       }
       catch(NumberFormatException e){
           
       }

    }


}
