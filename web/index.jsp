
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP index Page</title>
    </head>
    <body>
        <h1>TP noté JEE</h1>
        <h2>Ahmed Sahim & Goodwin Jean-Paul</h2>
        <hr />
        <h3>Page de connexion</h3>
        <fieldset>
            <legend>Autenthification</legend>
             <form action="Controleur_login" method="post">
            <p>Login : <input type="text" name="login" value="" size="10" /></p>
            
            <p>Mot de passe : <input type="password" name="mdp" value="" size="10" /></p>
            
            <p> <input type="submit" value="Valider" name="ok" /></p>
        </form>
        <hr />
        
        <p>Indice : Pour commencer à voter : Login : user , Mot de passe : user</p>
        <p>Indice : Pour aller sur la base de donnée et voir les resultats : Login : admin , Mot de passe : admin</p>
        </fieldset>
       
    </body>
</html>
