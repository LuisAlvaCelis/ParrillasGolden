<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset =UTF-8">
        <title>Restaurante | Consola</title>
        <link rel="shortcut icon" type="image/x-icon" href="img/logo.jpg">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Lato&display=swap">
        <%if(request.getAttribute("console")!=null){
        %>
        <link rel="stylesheet" href="css/style_console.css">
        <%}%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/v4-shims.min.css">
    </head>
    <body>
        <div class="container-console">
        <%if(request.getAttribute("console")!=null){
            String console=(String)request.getAttribute("console");
            %>
            <div class="container">
                <%=console%>
            </div>
            <%
        }else{%>
            <h1>Error: Acceso denegado!</h1>
            <a href="main?acjsp=ini" class="components-button"> Volver</a>
        <%}%>
        </div>
    </body>
</html>
