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
        <title>Restaurante | Cuenta</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato&display=swap">
        <link rel="stylesheet" href="css/style_pages.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/v4-shims.min.css">
    </head>
        <div class="container-tablinks">
            <nav class="tab-links">
                <ul class="tab-bar">
                    <a class="tab tablinks"href="choose?acjsp=1"><li ><i class="fas fa-qrcode"></i>Inicio</li></a>
                    <a class="tab tablinks"href="choose?acjsp=2"><li ><i class="fas fa-qrcode"></i>Realizar pedidos</li></a>
                    <a class="tab tablinks"href="choose?acjsp=3"><li ><i class="fas fa-qrcode"></i>Acerca de nosotros</li></a>
                    <a class="tab tablinks"href="choose?acjsp=4"><li ><i class="fas fa-qrcode"></i>Contáctanos</li></a>
                    <%
                    if(username==null && mail==null && dni==null){
                    %>
                    <a class="tab tablinks"href="choose?acjsp=5"><li ><i class="fa fa-sign-out"></i>Iniciar sesión</li></a>
                    <%
                    }else{
                    %>
                    <a class="tab tablinks active"href="choose?acjsp=7"><li ><i class="fas fa-qrcode"></i>Cuenta</li></a>
                    <%
                    }
                    %>
                </ul>
            </nav>
        </div>
        <!--Account manager-->
        <div id="8" class="tabcontent">
            <div class="account-manager-system-container" id="account-manager-container">
                <div class="account-manager-system-cart">
                    <h1 class="label-h1">Carrito:</h1>
                    <a href="main?acjsp=cart">Ver carrito</a>
                </div>
                <div class="account-manager-system-logout">
                    <h1 class="label-h1">Cerrar sesión:</h1>
                    <a href="main?acjsp=logout">Aquí</a>
                </div>
                <div class="account-manager-system-list-container">
                    <h1 class="label-h1">Configuración de cuenta</h1>
                    <ul>
                        <li>
                            <a href="main?acjsp=settings_account&txtLastNames=<%=lastnames%>&id=<%=id%>">
                                <div>
                                    <h3>Apellidos</h3>
                                </div>
                                <div>
                                    <span>
                                        <strong><%=lastnames%></strong>
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="main?acjsp=settings_account&txtNames=<%=names%>&id=<%=id%>">
                                <div>
                                    <h3>Nombres</h3>
                                </div>
                                <div>
                                    <span>
                                        <strong><%=names%></strong>
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="main?acjsp=settings_account&txtDNI=<%=dni%>&id=<%=id%>">
                                <div>
                                    <h3>Documento de identidad</h3>
                                </div>
                                <div>
                                    <span>
                                        <strong><%=dni%></strong>
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="main?acjsp=settings_account&txtTelcel=<%=telcel%>&id=<%=id%>">
                                <div>
                                    <h3>Teléfono / Celular</h3>
                                </div>
                                <div>
                                    <span>
                                        <strong><%=telcel%></strong>
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="main?acjsp=settings_account&txtMail=<%=mail%>&id=<%=id%>">
                                <div>
                                    <h3>Correo electrónico</h3>
                                </div>
                                <div>
                                    <span>
                                        <strong><%=mail%></strong>
                                    </span>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="main?acjsp=settings_account&txtUsername=<%=username%>&id=<%=id%>">
                                <div>
                                    <h3>Usuario</h3>
                                </div>
                                <div>
                                    <span>
                                        <strong><%=username%></strong>
                                    </span>
                                </div>
                            </a>
                        </li>
                    </ul>
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
