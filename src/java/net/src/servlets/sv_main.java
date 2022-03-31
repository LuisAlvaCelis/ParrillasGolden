package net.src.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.mvc.model.UserModel;
import net.src.User;
import net.src.UtilCode;

@WebServlet(name = "sv_main", urlPatterns = {"/main"})
public class sv_main extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("acjsp");
        HttpSession hs=request.getSession(true);
        if(action.equalsIgnoreCase("cart")){
            UtilCode.openNewJSP(request, response, "cart.jsp");
        }else if(action.equalsIgnoreCase("reload")){
            int id=Integer.parseInt(request.getParameter("id"));
            UserModel um=new UserModel();
            for(User user:um.getAllUsers()){
                if(user.getID()==id){
                    hs.setAttribute("lastnames",user.getLastnames());
                    hs.setAttribute("names",user.getNames());
                    hs.setAttribute("telcel",user.getTelcel());
                    hs.setAttribute("username",user.getUsername());
                    hs.setAttribute("mail",user.getMail());
                    hs.setAttribute("dni",user.getDni());
                    hs.setAttribute("id", user.getID());
                    UtilCode.openNewJSP(request, response, "index.jsp");
                    break;
                }
            }
        }else if(action.equalsIgnoreCase("settings_account")){
            if(request.getParameter("txtLastNames")!=null){
                String lastnames=request.getParameter("txtLastNames");
                int id=Integer.parseInt(request.getParameter("id"));
                String format="<div class=\"console\">"
                                + "<h1 class=\"label-h1\">Configuración de cuenta</h1>"
                                + "<h3 class=\"label-h3\">Apellido actual: "+lastnames+"</h3>"
                                + "<form action=\"rg\" class=\"update-form\" method=\"post\" name=\"update form\">"
                                    + "<input class=\"input-text\" type=\"hidden\" name=\"txtID\" value=\""+id+"\">\n"
                                    + "<input class=\"input-text\" placeholder=\"Nuevo apellido\" type=\"text\" name=\"txtLastNames\">\n"
                                    + "<button class=\"components-button\" name=\"acjsp\" value=\"update_account\">Cambiar</button>\n"
                                    + "<a href=\"main?acjsp=ini\" class=\"components-button\">Cancelar (Volver al inicio)</a>"
                                + "</form>"
                            + "</div>";
                request.setAttribute("console", format);
                UtilCode.openNewJSP(request, response, "console.jsp");
            }else if(request.getParameter("txtNames")!=null){
                String names=request.getParameter("txtNames");
                int id=Integer.parseInt(request.getParameter("id"));
                String format="<div class=\"console\">"
                                + "<h1 class=\"label-h1\">Configuración de cuenta</h1>"
                                + "<h3 class=\"label-h3\">Nombre actual: "+names+"</h3>"
                                + "<form action=\"rg\" class=\"update-form\" method=\"post\" name=\"update form\">"
                                    + "<input class=\"input-text\" type=\"hidden\" name=\"txtID\" value=\""+id+"\">\n"
                                    + "<input class=\"input-text\" placeholder=\"Nuevo nombre\" type=\"text\" name=\"txtNames\">\n"
                                    + "<button class=\"components-button\" name=\"acjsp\" value=\"update_account\">Cambiar</button>\n"
                                    + "<a href=\"main?acjsp=ini\" class=\"components-button\">Cancelar (Volver al inicio)</a>"
                                + "</form>"
                            + "</div>";
                request.setAttribute("console", format);
                UtilCode.openNewJSP(request, response, "console.jsp");
            }else if(request.getParameter("txtDNI")!=null){
                String dni=request.getParameter("txtDNI");
                int id=Integer.parseInt(request.getParameter("id"));
                String format="<div class=\"console\">"
                                + "<h1 class=\"label-h1\">Configuración de cuenta</h1>"
                                + "<h3 class=\"label-h3\">DNI actual: "+dni+"</h3>"
                                + "<form action=\"rg\" class=\"update-form\" method=\"post\" name=\"update form\">"
                                    + "<input class=\"input-text\" type=\"hidden\" name=\"txtID\" value=\""+id+"\">\n"
                                    + "<input class=\"input-text\" placeholder=\"Nuevo dni\" type=\"text\" name=\"txtDNI\" required=\"required\" autocomplete=\"off\"> \n"
                                    + "<button class=\"components-button\" name=\"acjsp\" value=\"update_account\">Cambiar</button>\n"
                                    + "<a href=\"main?acjsp=ini\" class=\"components-button\">Cancelar (Volver al inicio)</a>"
                                + "</form>"
                            + "</div>";
                request.setAttribute("console", format);
                UtilCode.openNewJSP(request, response, "console.jsp");
            }else if(request.getParameter("txtTelcel")!=null){
                String telcel=request.getParameter("txtTelcel");
                int id=Integer.parseInt(request.getParameter("id"));
                String format="<div class=\"console\">"
                                + "<h1 class=\"label-h1\">Configuración de cuenta</h1>"
                                + "<h3 class=\"label-h3\">Teléfono / Celular actual: "+telcel+"</h3>"
                                + "<form action=\"rg\" class=\"update-form\" method=\"post\" name=\"update form\">"
                                    + "<input class=\"input-text\" type=\"hidden\" name=\"txtID\" value=\""+id+"\">\n"
                                    + "<input class=\"input-text\" placeholder=\"Nuevo teléfono / celular\" type=\"number\" name=\"txtTelcel\"required=\"required\" autocomplete=\"off\">\n"
                                    + "<button class=\"components-button\" name=\"acjsp\" value=\"update_account\">Cambiar</button>\n"
                                    + "<a href=\"main?acjsp=ini\" class=\"components-button\">Cancelar (Volver al inicio)</a>"
                                + "</form>"
                            + "</div>";
                request.setAttribute("console", format);
                UtilCode.openNewJSP(request, response, "console.jsp");
            }else if(request.getParameter("txtMail")!=null){
                String mail=request.getParameter("txtMail");
                int id=Integer.parseInt(request.getParameter("id"));
                String format="<div class=\"console\">"
                                + "<h1 class=\"label-h1\">Configuración de cuenta</h1>"
                                + "<h3 class=\"label-h3\">Correo electrónico actual: "+mail+"</h3>"
                                + "<form action=\"rg\" class=\"update-form\" method=\"post\" name=\"update form\">"
                                    + "<input class=\"input-text\" type=\"hidden\" name=\"txtID\" value=\""+id+"\">\n"
                                    + "<input class=\"input-text\" placeholder=\"Nuevo correo electrónico\" type=\"mail\" name=\"txtMail\"required=\"required\" autocomplete=\"off\">\n"
                                    + "<button class=\"components-button\" name=\"acjsp\" value=\"update_account\">Cambiar</button>\n"
                                    + "<a href=\"main?acjsp=ini\" class=\"components-button\">Cancelar (Volver al inicio)</a>"
                                + "</form>"
                            + "</div>";
                request.setAttribute("console", format);
                UtilCode.openNewJSP(request, response, "console.jsp");
            }else if(request.getParameter("txtUsername")!=null){
                String username=request.getParameter("txtUsername");
                int id=Integer.parseInt(request.getParameter("id"));
                String format="<div class=\"console\">"
                                + "<h1 class=\"label-h1\">Configuración de cuenta</h1>"
                                + "<h3 class=\"label-h3\">Usuario actual: "+username+"</h3>"
                                + "<form action=\"rg\" class=\"update-form\" method=\"post\" name=\"update form\">"
                                    + "<input class=\"input-text\" type=\"hidden\" name=\"txtID\" value=\""+id+"\">\n"
                                    + "<input class=\"input-text\" placeholder=\"Nuevo usuario\" type=\"text\" name=\"txtUsername\"required=\"required\" autocomplete=\"off\">\n"
                                    + "<button class=\"components-button\" name=\"acjsp\" value=\"update_account\">Cambiar</button>\n"
                                    + "<a href=\"main?acjsp=ini\" class=\"components-button\">Cancelar (Volver al inicio)</a>"
                                + "</form>"
                            + "</div>";
                request.setAttribute("console", format);
                UtilCode.openNewJSP(request, response, "console.jsp");
            }
        }else if(action.equalsIgnoreCase("logout")){
            request.getSession().removeAttribute("lastnames");
            request.getSession().removeAttribute("names");
            request.getSession().removeAttribute("mail");
            request.getSession().removeAttribute("telcel");
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("dni");
            hs.invalidate();
            UtilCode.openNewJSP(request, response, "index.jsp");
        }else if(action.equalsIgnoreCase("ini")){
            UtilCode.openNewJSP(request, response, "index.jsp");
        }else if(action.equalsIgnoreCase("fp")){
            hs.setAttribute("access", "fppage");
            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
        }else if(action.equalsIgnoreCase("signin")){
            String account=request.getParameter("txtAccount");
            String password=request.getParameter("txtPassword");
            UserModel mu=new UserModel();
            for(User user: mu.getAllUsers()){
                if(user.getMail().equalsIgnoreCase(account)){
                    if(user.getPassword().equalsIgnoreCase(password)){
                        request.setAttribute("console", null);
                        hs.setAttribute("lastnames",user.getLastnames());
                        hs.setAttribute("names",user.getNames());
                        hs.setAttribute("telcel",user.getTelcel());
                        hs.setAttribute("username",user.getUsername());
                        hs.setAttribute("mail",user.getMail());
                        hs.setAttribute("dni",user.getDni());
                        hs.setAttribute("id", user.getID());
                        UtilCode.openNewJSP(request, response, "index.jsp");
                        break;
                    }else{
                        request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Contraseña erronea!</h1><h3 class=\"label-h3\">La contraseña del usuario denominado '"+account+"' es incorrecta, vuelva a intentarlo</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                        UtilCode.openNewJSP(request, response, "console.jsp");
                        break;
                    }
                }else if(user.getUsername().equalsIgnoreCase(account)){
                    if(user.getPassword().equalsIgnoreCase(password)){
                        request.setAttribute("console", null);
                        UtilCode.openNewJSP(request, response, "index.jsp");
                        break;
                    }else{
                        request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Contraseña erronea!</h1><h3 class=\"label-h3\">La contraseña del usuario denominado '"+account+"' es incorrecta, vuelva a intentarlo</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                        UtilCode.openNewJSP(request, response, "console.jsp");
                        break;
                    }
                }else{
                    request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"40\" height=\"40\"><h1 class=\"label-h1\">¡Cuenta no existente!</h1><h3 class=\"label-h3\">La cuenta ingresada no existe en nuestros registros, vuelva a intentarlo.</h3><a href=\"main?acjsp=ini\" class=\"components-button\">Volver al inicio</a></div>");
                    UtilCode.openNewJSP(request, response, "console.jsp");
                    break;
                }
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
