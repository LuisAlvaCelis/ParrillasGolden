package net.src.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.src.UtilCode;

@WebServlet(name = "sv_choose_page", urlPatterns = {"/choose"})
public class sv_choose_page extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("acjsp");
        if(action.equalsIgnoreCase("1")){
            request.setAttribute("console", null);
            UtilCode.openNewJSP(request, response, "index.jsp");
        }else if(action.equalsIgnoreCase("2")){
            UtilCode.openNewJSP(request, response, "make_order.jsp");
        }else if(action.equalsIgnoreCase("3")){
            UtilCode.openNewJSP(request, response, "about_us.jsp");
        }else if(action.equalsIgnoreCase("4")){
            UtilCode.openNewJSP(request, response, "contact_us.jsp");
        }else if(action.equalsIgnoreCase("5")){
            UtilCode.openNewJSP(request, response, "sign_up.jsp");
        }else if(action.equalsIgnoreCase("6")){
            UtilCode.openNewJSP(request, response, "log_in.jsp");
        }else if(action.equalsIgnoreCase("7")){
            UtilCode.openNewJSP(request, response, "account.jsp");
        }else{
            request.setAttribute("console", "<div class=\"console\">"
                    + "<img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\">"
                    + "<h1 class=\"label-h1\">¡Página no encontrada!</h1>"
                    + "<a href=\"choose?acjsp=1\" class=\"components-button\">Volver al inicio</a></div>");
            UtilCode.openNewJSP(request, response, "console.jsp");
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
