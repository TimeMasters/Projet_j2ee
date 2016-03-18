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
@WebServlet(name = "AjoutNote", urlPatterns = {"/AjoutNote"})
public class AjoutNoteBD extends HttpServlet 
{
    Connection conn = null;
    PreparedStatement stmt = null;
    int notes[];
    HttpSession session;
    
    public AjoutNoteBD(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            session = request.getSession();
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tpjees4","root","");
            stmt = conn.prepareStatement("INSERT INTO vote (maths, physique, chimie) VALUES (?, ?, ?)");
            notes = new int[3];
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    public void ajouteNotes()
    {
        try {
            stmt.setString(1, session.getAttribute("math").toString());
            stmt.setString(2, session.getAttribute("physique").toString());
            stmt.setString(3, session.getAttribute("chimie").toString());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
    private void ajoutSession(HttpServletRequest request, HttpServletResponse response)
    {
        if (request.getParameter("maths") != null)
            {
                session.setAttribute("math", request.getParameter("maths"));
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
                AjoutNoteBD addBD = new AjoutNoteBD(request, response);
                addBD.ajouteNotes();
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
