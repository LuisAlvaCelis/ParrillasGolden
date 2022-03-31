package net.src.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.mvc.controller.MailController;
import net.mvc.model.UserModel;
import net.src.Mail;
import net.src.User;
import net.src.UtilCode;
import net.src.dao.UserDAOImplements;
import net.src.dao.UserDAOInterface;

@WebServlet(name = "sv_register", urlPatterns = {"/rg"})
public class sv_register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action=request.getParameter("acjsp");
        if(action.equalsIgnoreCase("update_account")){
            UserDAOInterface userdao=new UserDAOImplements();
            UserModel um=new UserModel();
            if(request.getParameter("txtLastNames")!=null){
                String lastnames=request.getParameter("txtLastNames");
                int id=Integer.parseInt(request.getParameter("txtID"));
                for(int i=0;i<um.getAllUsers().size();i++){
                    User user=um.getAllUsers().get(i);
                    if(user.getID()==id){
                        user.setLastnames(lastnames);
                        if(userdao.updateUser(user)){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Éxito!</h1><h3 class=\"label-h3\">Apellido actualizado con correctamente.</h3><a href=\"main?acjsp=reload&id="+id+"\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error!</h1><h3 class=\"label-h3\">No se pudo actualizar su apellido, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }
                    }
                }
            }else if(request.getParameter("txtNames")!=null){
                String names=request.getParameter("txtNames");
                int id=Integer.parseInt(request.getParameter("txtID"));
                for(int i=0;i<um.getAllUsers().size();i++){
                    User user=um.getAllUsers().get(i);
                    if(user.getID()==id){
                        user.setNames(names);
                        if(userdao.updateUser(user)){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Éxito!</h1><h3 class=\"label-h3\">Nombre actualizado con correctamente.</h3><a href=\"main?acjsp=reload&id="+id+"\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error!</h1><h3 class=\"label-h3\">No se pudo actualizar su nombre, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }
                    }
                }
            }else if(request.getParameter("txtDNI")!=null){
                String dni=request.getParameter("txtDNI");
                int id=Integer.parseInt(request.getParameter("txtID"));
                for(int i=0;i<um.getAllUsers().size();i++){
                    User user=um.getAllUsers().get(i);
                    if(user.getID()==id){
                        user.setDni(dni);
                        if(userdao.updateUser(user)){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Éxito!</h1><h3 class=\"label-h3\">DNI actualizado con correctamente.</h3><a href=\"main?acjsp=reload&id="+id+"\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error!</h1><h3 class=\"label-h3\">No se pudo actualizar su DNI, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }
                    }
                }
            }else if(request.getParameter("txtTelcel")!=null){
                String telcel=request.getParameter("txtTelcel");
                int id=Integer.parseInt(request.getParameter("txtID"));
                for(int i=0;i<um.getAllUsers().size();i++){
                    User user=um.getAllUsers().get(i);
                    if(user.getID()==id){
                        user.setTelcel(telcel);
                        if(userdao.updateUser(user)){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Éxito!</h1><h3 class=\"label-h3\">Teléfono / Celular actualizado con correctamente.</h3><a href=\"main?acjsp=reload&id="+id+"\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error!</h1><h3 class=\"label-h3\">No se pudo actualizar su teléfono / celular, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }
                    }
                }
            }else if(request.getParameter("txtMail")!=null){
                String mail=request.getParameter("txtMail");
                int id=Integer.parseInt(request.getParameter("txtID"));
                for(int i=0;i<um.getAllUsers().size();i++){
                    User user=um.getAllUsers().get(id);
                    if(user.getMail().equalsIgnoreCase(mail)){
                        user.setMail(mail);
                        if(userdao.updateUser(user)){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Éxito!</h1><h3 class=\"label-h3\">Correo electrónico actualizado con correctamente.</h3><a href=\"main?acjsp=reload&id="+id+"\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error!</h1><h3 class=\"label-h3\">No se pudo actualizar su correo electrónico, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }
                    }
                }
            }else if(request.getParameter("txtUsername")!=null){
                String username=request.getParameter("txtUsername");
                int id=Integer.parseInt(request.getParameter("txtID"));
                for(int i=0;i<um.getAllUsers().size();i++){
                    User user=um.getAllUsers().get(i);
                    if(user.getID()==id){
                        user.setUsername(username);
                        if(userdao.updateUser(user)){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Éxito!</h1><h3 class=\"label-h3\">Usuario actualizado con correctamente.</h3><a href=\"main?acjsp=reload&id="+id+"\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error!</h1><h3 class=\"label-h3\">No se pudo actualizar su usuario, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                            break;
                        }
                    }
                }
            }
        }else if(action.equalsIgnoreCase("signup")){
            String lastnames=request.getParameter("txtLastnames");
            String names=request.getParameter("txtNames");
            String dni=request.getParameter("txtDNI");
            String email=request.getParameter("txtEmail");
            String password=request.getParameter("txtPassword");
            String repeatpassword=request.getParameter("txtRepeatPassword");
            User user=new User(0,1, dni, lastnames, names, email, "null", UtilCode.getCodeVerify(), password);
            UserDAOInterface dao=new UserDAOImplements();
            if(dni.length()==8){
                if(repeatpassword.equals(password)){
                    if(dao.verifyIfExistsUser(user).equalsIgnoreCase("")){
                        if(dao.registerUser(user) && MailController.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", email, "Parrillas Golden | Registro", UtilCode.messageRegister(user)))){
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/exito32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">¡Registrado con éxito!</h3><a class=\"components-button\" href=\"main?acjsp=ini\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                        }else{
                            request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error inesperado!</h1><h3 class=\"label-h3\">Lo sentimos, no se pudo registrar en estos momentos debido a un error interno, intentelo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                            UtilCode.openNewJSP(request, response, "console.jsp");
                        }
                    }else{
                        request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error inesperado!</h1><h3 class=\"label-h3\">"+dao.verifyIfExistsUser(user)+"</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver</a></div>");
                        UtilCode.openNewJSP(request, response, "console.jsp");
                    }
                }else{
                    request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Contraseñas no coinciden!</h1><h3 class=\"label-h3\">Las contraseñas ingresadas no coinciden, vuelva a intentarlo y este atentoa las alertas de la consola.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver</a></div>");
                    UtilCode.openNewJSP(request, response, "console.jsp");
                }
            }else{
                request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Tamaño del DNI incorrecto!</h1><h3 class=\"label-h3\">El DNI ingresado debe tener exactamente 8 caracteres, vuelva a intentarlo y este atentoa las alertas de la consola.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver</a></div>");
                UtilCode.openNewJSP(request, response, "console.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
