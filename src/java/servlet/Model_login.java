/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sahmed
 */
public class Model_login {
    public Model_login(){}
    
    //Variables d'authentification
    private String userAutorise;
    private String mdpAutorise;
    private String userAdmin;
    private String mdpAdmin;
    
    //private int moyenneMaths;
    //private int moyennePhysique;
    //private int moyenneChimie;
    
    
    
    public String verifier(HttpServletRequest request, HttpServletResponse response)
    {
        userAutorise = "user";
        mdpAutorise ="user";   
        userAdmin ="admin";
        mdpAdmin ="admin";
        
        response.setContentType("text/html;charset=UTF-8");
        String login = request.getParameter("login");
        String mdp = request.getParameter("mdp");

        if (login.equals(userAutorise) && mdp.equals(mdpAutorise)){
            request.setAttribute("login",login);
            request.setAttribute("mdp", mdp);
            return "vote1.jsp";
        }
        else if (login.equals(userAdmin) && mdp.equals(mdpAdmin)){
            request.setAttribute("login",login);
            request.setAttribute("mdp", mdp);
            return "bd.jsp";
        }
        else{
            return "error.jsp";
        }
    }
    
    
}
