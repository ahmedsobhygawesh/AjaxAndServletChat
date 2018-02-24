<%-- 
    Document   : index
    Created on : Feb 23, 2018, 1:35:27 PM
    Author     : ahmedelgawesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/indexPage.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>

      
  <form action="CheckLogin" method="POST">
    <header>Login</header>
    <label>Username <span>*</span></label>
    <input required type="text" name="rUsr"  />
    <div class="help">At least 1 character</div>
    <label>Password <span>*</span></label>
    <input required type="password" name="rPass"/>
    <div class="help">Use upper and lowercase lettes as well</div>
    <button>Login</button>
</form>
  
        
        <form style="margin-left: 40px" action="CheckLogin" method="GET">
    <header>Registration</header>
    <label>Username <span>*</span></label>
    <input required type="text" name="lUsr"  />
    <div class="help">At least 1 character</div>
    <label>Password <span>*</span></label>
    <input required type="password" name="lPass"/>
    <div class="help">Use upper and lowercase lettes as well</div>
    <button>Register</button>
</form>
        
        
    </body>
</html>
