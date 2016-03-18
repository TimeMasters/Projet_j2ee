/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
@WebServlet(name = "AjoutNoteBD", urlPatterns = {"/AjoutNoteBD"})
public class AjoutNoteBD extends HttpServlet 
{
    Connection conn = null;
    PreparedStatement stmt = null;
    int notes[];
    HttpSession session;
    
    public AjoutNoteBD() {
    
    }

    public void ajouteNotes(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            session = request.getSession();
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjees4","root","");
            stmt = conn.prepareStatement("INSERT INTO vote (maths, physique, chimie) VALUES (?, ?, ?)");
            notes = new int[3];
            stmt.setString(1, session.getAttribute("maths").toString());
            stmt.setString(2, session.getAttribute("physique").toString());
            stmt.setString(3, session.getAttribute("chimie").toString());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void ajoutSession(HttpServletRequest request, HttpServletResponse response)
    {
        session = request.getSession();
        if (request.getParameter("maths") != null)
            {
                session.setAttribute("maths", request.getParameter("maths"));
            try {
                response.sendRedirect("vote2.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else if (request.getParameter("physique") != null)
            {
                session.setAttribute("physique", request.getParameter("physique"));
            try {
                response.sendRedirect("vote3.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else if (request.getParameter("chimie") != null)
            {
                session.setAttribute("chimie", request.getParameter("chimie"));
                this.ajouteNotes(request,response);
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else
            {
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException ex) {
                Logger.getLogger(AjoutNoteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        ajoutSession(request, response);
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
        ajoutSession(request, response);
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
