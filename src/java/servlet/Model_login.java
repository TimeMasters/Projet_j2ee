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
    
    private String userAutorise;
    private String mdpAutorise;
        public void verifier_auth(HttpServletRequest request, HttpServletResponse response)
        {
            response.setContentType("text/html;charset=UTF-8");
            String user = request.getParameter("user");
            String mdp = request.getParameter("mdp");
            
            
            userAutorise = "user";
            mdpAutorise ="user";          
            request.setAttribute("resultat",userAutorise);
            request.setAttribute("resultat", mdpAutorise);
            
        }
}
