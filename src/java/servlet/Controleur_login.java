/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author sahmed
 */
@WebServlet(name = "Controleur_login", urlPatterns = {"/Controleur_login"})
public class Controleur_login extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        Model_login model = new Model_login();
        if (model.verifier(request,response))
        {
            View_login vue = new View_login();
            vue.afficher(request,response);
        }
        else{
                        
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        service(request,response);
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
    {
        service(request,response);
    }
    
    
    
    
    
}
