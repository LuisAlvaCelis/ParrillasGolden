<%@page import="net.src.UtilCode"%>
<%@page import="net.mvc.model.UserModel"%>
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
        <title>Restaurante | Acerca de nosotros</title>
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
                    <a class="tab tablinks"href="choose?acjsp=1"><li ><i class="fas fa-qrcode"></i>Inicio</li></a>
                    <a class="tab tablinks"href="choose?acjsp=2"><li ><i class="fas fa-qrcode"></i>Realizar pedidos</li></a>
                    <a class="tab tablinks active"href="choose?acjsp=3"><li ><i class="fas fa-qrcode"></i>Acerca de nosotros</li></a>
                    <a class="tab tablinks"href="choose?acjsp=4"><li ><i class="fas fa-qrcode"></i>Contáctanos</li></a>
                    <%
                    if(username==null && mail==null && dni==null){
                    %>
                    <a class="tab tablinks"href="choose?acjsp=5"><li ><i class="fas fa-qrcode"></i>Registrarte</li></a>
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
        <!--About-->
        <div id="3"class="tabcontent">
            <div class="about-system-container" id="abount-container">
                <h2>Acerca de nosotros</h2>
                <p>Bienvenidos a GOLDEN el mejor lugar para poder comer parrillas 100% natural al mejor precio nunca antes visto, contamos con los protocolos de bioseguridad dictadas por el gobierno Peruano.</p>
                <div class="map-about-container">
                    <h3><i class="fas fa-map-marker-alt"></i>Ubícanos</h3>
                    <a target="_blank" href="https://www.google.com/maps/dir/?api=1&amp;destination=-12.01041%2C-77.05164&amp;fbclid=IwAR0XRYE61jXHSZKk4PN8jv8181EKLJi4orrLChQ-o5ZOHUA6PoFSMHVnh3I">
                        <h4>Los crisantemos 122, AV los ficus Independencia +51 Independencia, Peru</h4>
                    </a>
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
