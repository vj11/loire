/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.personaDAO;
import modelo.persona;

/**
 *
 * @author APRENDIZ
 */
public class login extends HttpServlet {

     personaDAO dao=new personaDAO();
   persona p=new persona();
   
   int r;
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if (accion.equals("sign")){
        String user=request.getParameter("txtuser");
        String password=request.getParameter("txtpassword");
        String rol=request.getParameter("txtrol");
        p.setUser(user);
        p.setPassword(password);
        p.setrol(rol);
        r=dao.validar(p);
        if(r==1){
           request.getSession().setAttribute("user",user);
          /* request.getSession().setAttribute("password", password);
           request.getSession().setAttribute("rol", rol);
           request.getRequestDispatcher("Principal.jsp").forward(request, response);*/
            switch (p.getrol()) {
                case "1":
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                case "2":
                    request.getRequestDispatcher("conductorin.jsp").forward(request, response);
                    break;
                case "3":
                    request.getRequestDispatcher("dashboard.jsp").forward(request, response);
                    break;
                default:
            }
        }else{
           request.getRequestDispatcher("loginn.jsp").forward(request, response);
        }
      }else {
           request.getRequestDispatcher("loginn.jsp").forward(request, response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
