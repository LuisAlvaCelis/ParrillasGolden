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

@WebServlet(name = "sv_send_message", urlPatterns = {"/sm"})
public class sv_send_message extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("acjsp");
        if(action.equalsIgnoreCase("contact-us")){
            String affair=request.getParameter("txtAffair");
            String msg=request.getParameter("txtMessageArea");
            String dni=request.getParameter("txtDNI");
            if(!dni.equalsIgnoreCase("null")){
                User user=new UserModel().getUserByDNI(dni);
                affair=affair+" | Parrillas Golden Web";
                msg=user.getLastnames()+" "+user.getNames()+" - identificado con el DNI: "+user.getDni()+"\n"
                        + "Dice lo siguiente:\n\n"+msg;
                if(MailController.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", "luisalvacelis@gmail.com", affair, msg))){
                    request.setAttribute("console", "<div class=\"console\"><img class=\"imgSucess\" src=\"img/exito32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Mensaje enviado con éxito!</h1><h3 class=\"label-h3\">Gracias por ponerse en contacto con nosotros, en breves atenderemos su mensaje.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                    UtilCode.openNewJSP(request, response, "console.jsp");
                }else{
                    request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Error inesperado!</h1><h3 class=\"label-h3\">No se pudo registrar la solicitud de envio de mensaje, vuelva a intentarlo más tarde.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                    UtilCode.openNewJSP(request, response, "console.jsp");
                }
            }else{
                request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Cuenta no encontrada!</h1><h3 class=\"label-h3\">Nota: Para acceder al envio de mensaje tiene que estar registrado y logueado en el sistema, vuelva a intentarlo.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
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
