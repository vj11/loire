/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloDAO.manteDAO;
import modeloDAO.rutaDAO;

/**
 *
 * @author sakur
 */
@WebServlet(name = "masivos", urlPatterns = {"/masivos"})
public class masivos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String accion =request.getParameter("accion");
            switch (accion) {
                case "recordatorio":
                    manteDAO m=new manteDAO();
                    m.recordatorio();
                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
                    break;
                case "animos":
                     rutaDAO r=new rutaDAO();
                    r.animos();
                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
        catch(IOException | ServletException e){
            
        }
    }

}
