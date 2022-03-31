<%@page import="net.src.Menu"%>
<%@page import="net.mvc.controller.MenuController"%>
<%@page import="net.src.ArticlesCart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
HttpSession hs=request.getSession(true);
ArrayList<ArticlesCart> articles=hs.getAttribute("cart")==null ? null:(ArrayList)hs.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurante | Carrito</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg">
        <link rel="stylesheet" href="css/style_cartt.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/v4-shims.min.css">
    </head>
    <body>
        <header>
            <h1>Carrito</h1>
        </header>
        <section>
            <div class="nav-container">
                <ol class="breadcrumb">
                    <li><a href="main?acjsp=ini">Volver</a></li>
                    <li><b>Inicio</b></li>
                </ol>
            </div>
            <h4 id="console-items-notfound"></h4>
            <%
                if(articles==null || articles.size()==0){
                %>
                    <h4>Error: Menus no encontrados</h4>
            <%
                }else{
            %>
                    <div class="table-cart-container" id="cart-container">
                        <table class="table-cart" id="table-shop">
                            <thead>
                                <tr class="tr-titles">
                                    <th class="image"></th>
                                    <th class="description">Menu</th>
                                    <th class="price">Precio</th>
                                    <th class="quantity">Cantidad</th>
                                    <th class="total">Total</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                MenuController mc=new MenuController();
                                double total=0;
                                if(articles!=null){
                                    for(ArticlesCart ac:articles){
                                        Menu menu=mc.getMenu(ac.getId());
                                        total+=ac.getCant()*menu.getCost();
                                %>
                                <tr>
                                    <td class="cart-img-menu">
                                        <a href="menu-details.jsp?idmenu=<%=menu.getId()%>"><img src="img?id_menu=<%=menu.getId()%>" alt="" width="250" height="150"></a>
                                    </td>
                                    <td class="cart-description-menu">
                                        <h4><%=menu.getName()%></h4>
                                        <p><b>ID: </b> <%=menu.getId()%></p>
                                        <p><b>Categoría: </b><%=menu.getCategory()%></p>
                                        <p><b>Descripción: </b><%=menu.getDescription()%></p>
                                    </td>
                                    <td class="cart-price-menu">
                                        <p>S/. <%=menu.getCost()%></p>
                                    </td>
                                    <td class="cart-quantity-menu">
                                        <p><%=ac.getCant()%></p>
                                    </td>
                                    <td class="cart-total-menu">
                                        <p class="cart-total-price">S/. <%=Math.round(menu.getCost() * ac.getCant()*100.0)/100.0%></p>
                                    </td>
                                    <td class="cart-delete-menu">
                                        <span id="idarticle" style="display: none;"><%=menu.getId()%></span>
                                        <a class="cart-quantity-delete" id="removeitem"><i class="fa fa-times"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                        <div class="operation-container">
                            <!--<div class="choose-option-container">
                                <ul>
                                    <li>
                                        <input type="checkbox">
                                        <label for="Usar código de descuento"></label>
                                    </li>
                                </ul>
                            </div>-->
                            <div class="total-area-container">
                                <ul>
                                    <li>
                                        Sub total
                                        <span id="txt-subtotal">S/. <%=Math.round(total*100.0)/100.0%></span>
                                    </li>
                                    <li>
                                        Costo de envio
                                        <span id="txt-cost-shipping">S/. 3.00</span>
                                    </li>
                                    <li>
                                        Total
                                        <span id="txt-total">S/. <%=Math.round((total+3)*100.0)/100.0%></span>
                                    </li>
                                </ul>
                                <a href="#" class="btn-continue">Comprar</a>
                                <a href="main?acjsp=cart" class="btn-update">Actualizar</a>
                            </div>
                            <div class="purcharse-system-container">
                                <header>
                                    <h1>Seleccione método de pago</h1>
                                </header>
                                <nav class="tab-methods">
                                    <label class="radio-inline">
                                        <input type="radio" name="mov" value="Paypal">
                                        Paypal
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="mov" value="Visa">
                                        Visa
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="mov" value="Contacto directo" checked>
                                        Contacto directo
                                    </label>
                                </nav>
                                <div class="address-container">
                                    <p><h1>Datos</h1></p>
                                    <span>
                                        <h3>Dirección: </h3>
                                        <input type="text" required="required">
                                        <p><b>Advertencia: </b>Atención solo en Lima-Perú de 10am a 7pm</p>
                                    </span>
                                </div>
                            </div>
                        </div>
            <%
                }
            %>
        </section>
        <footer>
            <p>Created by <a href="#" target="_blank" rel="noopener noreferrer">Luis Alva Celis</a></p>
        </footer>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script src="js/script_cart.js"></script>
    </body>
</html>
