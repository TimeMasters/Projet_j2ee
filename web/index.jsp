<%-- 
    Document   : index
    Created on : 18 mars 2016, 09:18:58
    Author     : sahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de connexion</title>
    </head>
    <body>
        <h1>Connectez vous pour noter les matières </h1>
        <hr/>
        <form name="auth" action="Controleur_login">
                
                User : <input type="text" name="login"  />
                Mot de passe : <input type="text" name="mdp"  /><br/>
                <td><input type="submit" value="Valider" name="Valider" /></td>
                <td><input type="reset" value="Annuler" name="Annuler" /></td>
        </form>
    </body>
</html>
