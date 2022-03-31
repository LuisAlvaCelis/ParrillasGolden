<%@page import="net.mvc.controller.UserController"%>
<%
    HttpSession hs=request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
        <title>Restaurante | Contraseña olvidada</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato&display=swap">
        <%
        if(hs.getAttribute("access")!=null){
        %>
            <link rel="stylesheet" href="css/style_forgot_password.css">
        <%
        }
        %>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/v4-shims.min.css">
    </head>
    <body>
    <%
        if(hs.getAttribute("access")!=null){
            String option=(String)hs.getAttribute("access");
            if(option.equalsIgnoreCase("fppage")){
            %>
            <div class="container-components">
                <div class="form-container">
                    <a href="main?acjsp=ini" class="components-button"> Volver</a>
                    <form action="fp" method="post" class="form-forgot-password">
                        <h1 class="label-h1">Ingrese cuenta</h1>
                        <input class="input-text" name="txtAccount" type="text" placeholder="Usuario o Correo electrónico" autocomplete="off" required="required" onclick="hiddenConsole()"/>
                        <button name="acjsp" value="next" class="components-button">Siguiente</button>
                        <h1 class="label-h3">Recordatorio: No podrás volver a cambiar su contraseña en 24 horas.</h1>
                        <%
                            if(request.getAttribute("consoleMsg")!=null){
                                out.println(request.getAttribute("consoleMsg"));
                            }
                        %>
                    </form>
                </div>
            </div>
            <%
            }else if(option.equalsIgnoreCase("entercode")){
                String account=(String)hs.getAttribute("accountaccess");
                if(account!=null || !account.equalsIgnoreCase("") || !account.equalsIgnoreCase("null")){
                    %>
                    <div class="container-components">
                       <div class="form-container">
                           <a href="main?acjsp=fp" class="components-button"> Volver</a>
                           <form action="fp" method="post" class="form-forgot-password">
                               <h1 class="label-h1">Código de verificación</h1>
                               <input name="txtAccount" type="hidden" value="<%=account%>"/>
                               <input class="input-text" name="txtCode" type="text" placeholder="Código de verificación" onclick="hiddenConsole()" autocomplete="off" required="required"/>
                               <button name="acjsp" value="verify" class="components-button">Verficar</button>
                               <h1 class="label-h3">Recordatorio: No podrás volver a cambiar su contraseña en 24 horas.</h1>
                               <%
                                   if(request.getAttribute("consoleMsg")!=null){
                                       out.println(request.getAttribute("consoleMsg"));
                                   }
                               %>
                           </form>
                       </div>
                   </div>
                    <%
                }else{
                    %>
                    <h1>Acceso denegado</h1>
                    <%
                }
            }else if(option.equalsIgnoreCase("changepassword")){
                String account=(String)hs.getAttribute("accountaccess");
                if(account!=null || !account.equalsIgnoreCase("") || !account.equalsIgnoreCase("null")){
                    %>
                    <div class="container-components">
                       <div class="form-container">
                           <a href="main?acjsp=ini" class="components-button">Inicio</a>
                           <form action="fp" method="post" class="form-forgot-password">
                               <h1 class="label-h1">Cambio de contraseña de <%=account%></h1>
                               <input name="txtAccount" type="hidden" value="<%=account%>"/>
                               <input class="input-text" id="input-password" name="txtPassword" type="password" placeholder="Nueva contraseña" onclick="hiddenConsole()" required="required" autocomplete="off" onkeyup="viewDataPassword()"/>
                               <input class="input-text" id="input-repeatpassword" name="txtRepeatPassword" type="password" placeholder="Repita contraseña" onclick="hiddenConsole()" required="required" autocomplete="off" onkeyup="viewDataRepeatPassword()"/>
                               <label class="label-checkbox">
                                   <input type="checkbox" id="input-checkbox" onClick="seePassword()">Mostrar contraseña<i></i>
                               </label>
                               <p id="consolePassword"></p>
                               <p id="consoleRepeatPassword"></p>
                               <button name="acjsp" value="cp" class="components-button">Cambiar contraseña</button>
                               <%
                                   if(request.getAttribute("consoleMsg")!=null){
                                       out.println(request.getAttribute("consoleMsg"));
                                   }
                               %>
                           </form>
                       </div>
                   </div>
                   <%
                }else{
                    %>
                    <h1>Acceso denegado</h1>
                    <%
                }
            }
    %>
    <%
        }else{
    %>
            <h1>Error: Acceso denegado</h1>
    <%
        }
    %>
    
    <script src="js/forgot_password.js"></script>
    </body>
</html>
