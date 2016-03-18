/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sahmed
 */
public class View_login {
    public void afficher(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            PrintWriter out=response.getWriter();
            out.print("Le prix a payer sera de : "+request.getAttribute("resultat"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
