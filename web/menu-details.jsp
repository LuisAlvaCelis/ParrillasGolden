<%@page import="net.src.Menu"%>
<%@page import="net.mvc.controller.MenuController"%>
<%@page import="net.src.UtilCode"%>
<%
    HttpSession hs=request.getSession(true);
    String lastnames=null,names=null,telcel=null,username=null,mail=null,dni=null,id=null,idmenu=null;;
    MenuController mc=new MenuController();
    if(hs.getAttribute("mail")!=null && hs.getAttribute("username")!=null && hs.getAttribute("dni")!=null){
        lastnames=hs.getAttribute("lastnames").toString();
        names=hs.getAttribute("names").toString();
        telcel=hs.getAttribute("telcel").toString();
        username=hs.getAttribute("username").toString();
        mail=hs.getAttribute("mail").toString();
        dni=hs.getAttribute("dni").toString();
        id=hs.getAttribute("id").toString();
        if(request.getAttribute("idmenu")!=null){
            idmenu=request.getAttribute("idmenu").toString();
        }else{
            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Acceso denegado!</h1><h3 class=\"label-h3\">ID del menú no encontrado.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
            UtilCode.openNewJSP(request, response, "console.jsp");
        }
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurante | Menu Detalles</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg">
        <link rel="stylesheet" href="css/style_menu_detail.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/v4-shims.min.css">
    </head>
    <body>
        <section>
            <header>
                <h1>Menu Detalle</h1>
            </header>
            <div class="menu-container">
                <div class="img-menu-container">
                    <img src="img?id_menu=<%=idmenu%>">
                </div>
                <div class="menu-information-container">
                <%
                    Menu menu=null;
                    if(idmenu!=null){
                        menu=new MenuController().getMenu(Integer.parseInt(idmenu));
                %>
                        <h2><%=menu.getName()%></h2>
                        <p>ID: <%=menu.getId()%></p>
                        <p>Categoría: <%=menu.getCategory()%></p>
                        <form action="cart" method="GET">
                            <span>
                                <span>PEN S/.<%=menu.getCost()%></span>
                                <label>Cantidad</label>
                                <input type="hidden" value="<%=menu.getId()%>" name="txtIDMenu">
                                <a class="cart-quantity-up" id="quantity-sum" >+</a>
                                <input type="number" value="1" id="txtCantMenu" name="txtCantMenu" onfocusout="checkDatCantFocusOut()" required="required" onkey ="checkDataCant()">
                                <a class="cart-quantity-down" id="quantity-res">-</a>
                                <button name="acjsp" value="addcart" type="submit">
                                    <i class="fa fa-shopping-cart"></i>
                                    Añadir a carrito
                                </button>
                            </span>
                        </form>
                        <p>
                            <b>Disponibilidad: </b>
                            <%
                            if(menu.isStatus()){
                            %>
                                Disponible
                            <%
                            }else{
                            %>
                                No disponible
                            <%
                            }
                            %>
                        </p>
                        <p>
                            <b>Descripción:</b>
                            <%=menu.getDescription()%>
                        </p>
                <%
                    }
                %>
                </div>
            </div>
                <a class="return-button" href="javascript:window.history.go(-1)">Volver</a>
        </section>
        <footer>
            <p>Created by <a href="#" target="_blank" rel="noopener noreferrer">Luis Alva Celis</a></p>
        </footer>
        <script src="js/menu_detail.js"></script>
    </body>
</html>
