<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Vote Maths</title>
    </head>
    <body>
        <h1>Mathématiques</h1>
        <hr/>
        <form action="AjoutNoteBD">
            <fieldset><legend>Donner une note sur 5</legend>
            <select name="maths">
                <option>5</option>
                <option>4</option>
                <option>3</option>
                <option>2</option>
                <option>1</option>
            </select>
                <input type="submit" value="Suite" name="suite" /><br/><br/>
                <input type="button" onclick="history.go(-1);" value="Precedent">
        </form>
            </fieldset>
        
        
    </body>
</html>
