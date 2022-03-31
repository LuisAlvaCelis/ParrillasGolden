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
    }else{
        request.setAttribute("console", "<div class=\"console\">"
                + "<img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\">"
                + "<h1 class=\"label-h1\">¡Acceso denegado!</h1>"
                + "<h3 class=\"label-h3\">No se pudo acceder a la sección debido a que no ha iniciado sesión.</h3>"
                + "<a href=\"choose?acjsp=5\" class=\"components-button\">Iniciar sesión</a>"
                + "<a href=\"choose?acjsp=1\" class=\"components-button\">Volver al inicio</a>"
                + "</div>");
        UtilCode.openNewJSP(request, response, "console.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
        <title>Restaurante | Contáctanos</title>
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
                    <a class="tab tablinks"href="choose?acjsp=3"><li ><i class="fas fa-qrcode"></i>Acerca de nosotros</li></a>
                    <a class="tab tablinks active"href="choose?acjsp=4"><li><i class="fas fa-qrcode"></i>Contáctanos</li></a>
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
        <!--Contact us-->
        <div id="5" class="tabcontent">
            <div class="contact-system-container" id="contact-container">
                <h1>Redes sociales</h1>
                <div class="contact-system-social-container">
                    <a target="_blank" href="https://web.facebook.com/parrillasgolden"><i class="fab fa-facebook-f"></i></a>
                    <a target="_blank" href="https://api.whatsapp.com/send?phone=51980797361"><i class="fab fa-whatsapp"></i></a>
                </div>
                <h4>O envíanos un mensaje directo</h4>
                <div class="contact-system-form-container">
                    <form action="sm" class="contact-form" method="post" name="contact us">
                        <input name="txtDNI" type="hidden" value="<%=dni%>">
                        <input class="input-text" name="txtAffair" type="text" placeholder="Asunto" required="required" autocomplete="off">
                        <textarea rows="4" class="input-text-area" name="txtMessageArea" placeholder="Mensaje" maxlength="300" required="required"></textarea>
                        <button class="button-editing" name="acjsp" value="contact-us">Enviar mensaje</button>
                    </form>
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
