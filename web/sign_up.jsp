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
        <title>Restaurante | Registrarse</title>
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
                    <a class="tab tablinks"href="choose?acjsp=2"><li ><i class="fas fa-qrcode"></i>Realizar pedidos</li></a>
                    <a class="tab tablinks"href="choose?acjsp=3"><li ><i class="fas fa-qrcode"></i>Acerca de nosotros</li></a>
                    <a class="tab tablinks"href="choose?acjsp=4"><li ><i class="fas fa-qrcode"></i>Contáctanos</li></a>
                    <%
                    if(username==null && mail==null && dni==null){
                    %>
                    <a class="tab tablinks active"href="choose?acjsp=5"><li ><i class="fas fa-qrcode"></i>Registrarte</li></a>
                    <%
                    }else{
                    %>
                    <a class="tab tablinks"href="choose?acjsp=7"><li ><i class="fas fa-qrcode"></i>Cuenta</li></a>
                    <%
                    }
                    %>
                </ul>
            </nav>
        </div>
        <!--Sign up system-->
        <div id="7" class="tabcontent">
            <div class="signup-system-container" id="signup-container">
                <div class="signup-system-form-container">
                    <form action="rg" class="signup-system-form" method="post" name="sign up">
                        <h1 class="label-h1">Crear cuenta</h1>
                        <input class="input-text" name="txtLastnames" id="txtLastnames" type="text" placeholder="Apellidos" autocomplete="off" required="required"/>
                        <input class="input-text" name="txtNames" id="txtNames" type="text" placeholder="Nombres" autocomplete="off"required="required"/>
                        <input class="input-text" name="txtDNI" id="txtDNI" type="number" placeholder="DNI" autocomplete="off"required="required" onkeyup="viewDataDNI()" onfocus="clearConsole('1')" onfocusout="viewDataDNI()"/>
                        <input class="input-text" name="txtEmail" id="txtEmail" type="email" placeholder="Correo electrónico" autocomplete="off"required="required"/>
                        <input class="input-text" name="txtPassword" id="txtPassword" type="password" placeholder="Contraseña" autocomplete="off"required="required" onkeyup="viewDataPassword()" onfocus="clearConsole('2')" onfocusout="viewDataPassword()"/>
                        <input class="input-text" name="txtRepeatPassword" id="txtRepeatPassword" type="password" placeholder="Repetir contraseña" autocomplete="off"required="required" onkeyup="viewDataRepeatPassword()" onfocus="clearConsole('3')" onfocusout="viewDataRepeatPassword()"/>
                        <label class="label-checkbox">
                            <input type="checkbox" id="input-checkbox" onClick="seePassword()">Mostrar contraseña<i></i>
                        </label>
                        <button name="acjsp" value="signup" class="button-editing">Registrarse</button>
                    </form>
                    <span>¿Ya tienes cuenta? <a class="tablinks" href="choose?acjsp=6">Ingrese aquí</a></span>
                    <h5 id="consoleDNI"></h5>
                    <h5 id="consolePassword"></h5>
                    <h5 id="consoleRepeatPassword"></h5>
                </div>
            </div>
        </div>
        <footer>
            <p>
                Created by <a target="_blank" href="https://twitter.com/alvacelisluis">Luis Alva Celis</a>
            </p>
        </footer>
        <script src="js/index.js"></script>
    </body>
</html>
