package net.src.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.mvc.controller.MailController;
import net.mvc.model.UserModel;
import net.mvc.model.VerifyUserAccountModel;
import net.src.Mail;
import net.src.User;
import net.src.UtilCode;
import net.src.VerifyUserAccount;

@WebServlet(name = "sv_forgot_password", urlPatterns = {"/fp"})
public class sv_forgot_password extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("acjsp");
        HttpSession hs=request.getSession();
        if(action.equalsIgnoreCase("next")){
            String account=request.getParameter("txtAccount");
            UserModel mu=new UserModel();
            for(int i=0;i<mu.getAllUsers().size();i++){
                User user=mu.getAllUsers().get(i);
                if(user.getUsername().equalsIgnoreCase(account)){
                    String validate=mu.getValidateAccountRequest(account);
                    if(validate.equalsIgnoreCase("null")){
                        String code=UtilCode.getCodeVerify();
                        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                        if(mu.insertAccountToVerifyAccount(new VerifyUserAccount(0, account, code, sdf.format(Calendar.getInstance().getTime()))) && MailController.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", user.getMail(), "Parrillas Golden | Cambio de contraseña", UtilCode.messageForgotPassword(user, code))) ){
                            hs.setAttribute("access", "entercode");
                            hs.setAttribute("accountaccess", account);
                            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                        }else{
                            hs.setAttribute("access", "fppage");
                            request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">No se pudo registrar su solicitud, intentelo más tarde.</h3></div>");
                            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                        }
                    }else if(validate.equalsIgnoreCase("falta")){
                        hs.setAttribute("access", "fppage");
                        request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">Solicitud denegada, podrá volver a cambiar su contraseña dentro de 24 horas.</h3></div>");
                        UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                    }else if(validate.equalsIgnoreCase("ok")){
                        if(mu.removeAccountFromVerifyAccount(new VerifyUserAccountModel().getUserAccountByIDorAccount(account))){
                            String code=UtilCode.getCodeVerify();
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                            if(mu.insertAccountToVerifyAccount(new VerifyUserAccount(0, account, code, sdf.format(Calendar.getInstance().getTime()))) && MailController.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", user.getMail(), "Parrillas Golden | Cambio de contraseña", UtilCode.messageForgotPassword(user, code))) ){
                                hs.setAttribute("access", "entercode");
                                hs.setAttribute("accountaccess", account);
                                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                            }else{
                                hs.setAttribute("access", "fppage");
                                request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">No se pudo registrar su solicitud, intentelo más tarde.</h3></div>");
                                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                            }
                        }else{
                            hs.setAttribute("access", "fppage");
                            request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">¡Error inesperado!</h3></div>");
                            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                        }
                    }
                    break;
                }else if(user.getMail().equalsIgnoreCase(account)){
                    String validate=mu.getValidateAccountRequest(account);
                    if(validate.equalsIgnoreCase("null")){
                        String code=UtilCode.getCodeVerify();
                        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                        if(mu.insertAccountToVerifyAccount(new VerifyUserAccount(0, account, code, sdf.format(Calendar.getInstance().getTime()))) && MailController.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", user.getMail(), "Parrillas Golden | Cambio de contraseña", UtilCode.messageForgotPassword(user, code))) ){
                            hs.setAttribute("access", "entercode");
                            hs.setAttribute("accountaccess", account);
                            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                        }else{
                            hs.setAttribute("access", "fppage");
                            request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">No se pudo registrar su solicitud, intentelo más tarde.</h3></div>");
                            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                        }
                    }else if(validate.equalsIgnoreCase("falta")){
                        hs.setAttribute("access", "fppage");
                        request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">Solicitud denegada, podrá volver a cambiar su contraseña dentro de 24 horas.</h3></div>");
                        UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                    }else if(validate.equalsIgnoreCase("ok")){
                        if(mu.removeAccountFromVerifyAccount(new VerifyUserAccountModel().getUserAccountByIDorAccount(account))){
                            String code=UtilCode.getCodeVerify();
                            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                            if(mu.insertAccountToVerifyAccount(new VerifyUserAccount(0, account, code, sdf.format(Calendar.getInstance().getTime()))) && MailController.getInstance().sendMail(new Mail("luisalvacelis@gmail.com", "umawztlqhlkixqbr", user.getMail(), "Parrillas Golden | Cambio de contraseña", UtilCode.messageForgotPassword(user, code))) ){
                                hs.setAttribute("access", "entercode");
                                hs.setAttribute("accountaccess", account);
                                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                            }else{
                                hs.setAttribute("access", "fppage");
                                request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">No se pudo registrar su solicitud, intentelo más tarde.</h3></div>");
                                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                            }
                        }else{
                            hs.setAttribute("access", "fppage");
                            request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\" src=\"img/error32x32.png\" width=\"32\" height=\"32\"><h3 class=\"label-h3\">¡Error inesperado!</h3></div>");
                            UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                        }
                    }
                    break;
                }
            }
        }else if(action.equalsIgnoreCase("verify")){
            String code=request.getParameter("txtCode");
            String account=request.getParameter("txtAccount");
            UserModel mu=new UserModel();
            if(mu.getAccountByUserOrMail(code,account)){
                hs.setAttribute("access", "changepassword");
                hs.setAttribute("accountaccess", account);
                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
            }else{
                hs.setAttribute("access", "entercode");
                hs.setAttribute("accountaccess", account);
                request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">¡Código incorrecto!</h3></div>");
                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
            }
        }else if(action.equalsIgnoreCase("cp")){
            String account=request.getParameter("txtAccount");
            String password=request.getParameter("txtPassword");
            String repassword=request.getParameter("txtRepeatPassword");
            UserModel mu=new UserModel();
            if(!password.contains(" ") && !repassword.contains(" ")){
                if(repassword.equalsIgnoreCase(password)){
                    for(int i=0;i<mu.getAllUsers().size();i++){
                        User user=mu.getAllUsers().get(i);
                        if(user.getMail().equalsIgnoreCase(account)){
                            user.setPassword(password);
                            if(mu.updateAccountPassword(user)){
                                hs.setAttribute("access", null);
                                hs.setAttribute("accountaccess", null);
                                request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/exito32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">¡Contraseña cambiada con éxito!</h3><a class=\"components-button\" href=\"main?acjsp=ini\">Volver al inicio</a></div>");
                                UtilCode.openNewJSP(request, response, "console.jsp");
                            }else{
                                hs.setAttribute("access", "changepassword");
                                hs.setAttribute("accountaccess", account);
                                request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">No se pudo cambiar la contraseña, intentelo más tarde.</h3></div>");
                                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                            }
                        }else if(user.getUsername().equalsIgnoreCase(account)){
                            user.setPassword(password);
                            if(mu.updateAccountPassword(user)){
                                hs.setAttribute("access", null);
                                hs.setAttribute("accountaccess", null);
                                request.setAttribute("console", "<div class=\"console\"><img class=\"imgError\"src=\"img/exito32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">¡Contraseña cambiada con éxito!</h3><a class=\"components-button\" href=\"main?acjsp=ini\">Volver al inicio</a></div>");
                                UtilCode.openNewJSP(request, response, "console.jsp");
                            }else{
                                hs.setAttribute("access", "changepassword");
                                hs.setAttribute("accountaccess", account);
                                request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">No se pudo cambiar la contraseña, intentelo más tarde.</h3></div>");
                                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                            }
                        }
                    }
                }else{
                    hs.setAttribute("access", "changepassword");
                    hs.setAttribute("accountaccess", account);
                    request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">¡Contraseñas no coinciden!</h3></div>");
                    UtilCode.openNewJSP(request, response, "forgot_password.jsp");
                }
            }else{
                hs.setAttribute("access", "changepassword");
                hs.setAttribute("accountaccess", account);
                request.setAttribute("consoleMsg", "<div class=\"console\"><img class=\"imgError\"src=\"img/error32x32.png\" width=\"32\" height=\"32\"> <h3 class=\"label-h3\">La contraseña no debe contener espacios en blanco.</h3></div>");
                UtilCode.openNewJSP(request, response, "forgot_password.jsp");
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
