<%
    HttpSession hs=request.getSession(true);
    String lastnames=null,names=null,telcel=null,username=null,mail=null,dni=null,id=null;
    if(hs.getAttribute("mail")!=null && hs.getAttribute("username")!=null && hs.getAttribute("dni")!=null){
        lastnames=hs.getAttribute("lastnames").toString();
        names=hs.getAttribute("names").toString();
        telcel=hs.getAttribute("telcel").toString();
        username=hs.getAttribute("username").toString();
        mail=hs.getAttribute("mail").toString();
        dni=hs.getAttribute("dni").toString();
        id=hs.getAttribute("id").toString();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
        <title>Restaurante | Iniciar Sesión</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato&display=swap">
        <link rel="stylesheet" href="css/style_pages.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/v4-shims.min.css">
    </head>
    <body>
        <div class="container-tablinks">
            <nav class="tab-links">
                <ul class="tab-bar">
                    <a class="tab tablinks" href="choose?acjsp=1"><li><i class="fas fa-qrcode"></i>Inicio</li></a>
                    <a class="tab tablinks" href="choose?acjsp=2"><li><i class="fas fa-qrcode"></i>Realizar pedidos</li></a>
                    <a class="tab tablinks" href="choose?acjsp=3"><li><i class="fas fa-qrcode"></i>Acerca de nosotros</li></a>
                    <a class="tab tablinks" href="choose?acjsp=4"><li><i class="fas fa-qrcode"></i>Contáctanos</li></a>
                    <%
                    if(username==null && mail==null && dni==null){
                    %>
                    <a class="tab tablinks active" href="choose?acjsp=6"><li><i class="fas fa-qrcode"></i>Iniciar sesión</li></a>
                    <%
                    }else{
                    %>
                    <a class="tab tablinks" href="choose?acjsp=7"><li><i class="fas fa-qrcode"></i>Cuenta</li></a>
                    <%
                    }
                    %>
                </ul>
            </nav>
        </div>
        <!--Log in system-->
        <div id="6" class="tabcontent">
            <div class="login-system-container" id="login-container">
                <div class="login-system-form-container">
                    <form action="main" class="login-system-form" method="post" name="log in">
                        <h1 class="label-h1">Iniciar sesión</h1>
                        <input class="input-text" name="txtAccount" type="text" placeholder="Usuario o Correo electrónico" required="required"/>
                        <input class="input-text" name="txtPassword" type="password" placeholder="Contraseña" required="required"/>
                        <a href="main?acjsp=fp">¿Olvidaste tu contraseña?</a>
                        <button name="acjsp" value="signin" class="button-editing">Iniciar sesión</button>
                    </form>
                    <span>¿No tienes cuenta? <a class="tablinks" href="choose?acjsp=5">Regístrate aquí</a></span>
                </div>
            </div>
        </div>
        <footer>
            <p>
                Created by <a target="_blank" href="https://twitter.com/alvacelisluis">Luis Alva Celis</a>
            </p>
        </footer>
    </body>
</html>
