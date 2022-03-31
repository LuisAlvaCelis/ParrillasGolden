package net.src;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilCode {
    
    public static String messageRegister(User user){
        
        String msg="Hola, "+user.getNames()+":\n"
                + "Bienvenido a Parrillas Golden, a continuación daremos detalles de su cuenta.\n\n"
                + "Usuario: "+user.getUsername()+" o su email de registro\n"
                + "Contraseña: "+user.getPassword()+" (Mantener segura)\n\n"
                + "Nota: Podrá modificar los detalles de su cuenta a través del sistema de Configuración de cuenta, que aparecerá al momento de iniciar sesión en la página.\n"
                + "         El cambio de contraseña se dará 1 vez por día, es decir que si ya ha cambiado su contraseña una vez, no podrá volver hacerlo hasta el siguiente día.\n\n"
                + "Gracias por ser parte de la familia de Parrillas Golden\n\n"
                + "Atentamente: El equipo de soporte de Parrillas Golden.";
        return msg;
    }
    
    public static String messageForgotPassword(User user,String code){
        String msg="Hola, "+user.getLastnames()+", "+user.getNames()+"\n"
        + "Recientemente hemos recibido una solicitud de cambio de contraseña de su cuenta "+user.getMail()+".\n"
        + "Si ha sido usted por favor ingrese este código de seguridad en la página\n\n"
        + code+"\n\n"
        + "para continuar con el cambio de ocntraseña.\n\n "
        + "¿No reconoces esta actividad?\n"
        + "Verifique su cuenta en la página web o contactenos\n\n"
        + "Atte: El equipo de soporte de Parrillas Golden";
        return msg;
    }
    
    public static String getCodeVerify(){
        return new BigInteger(50,new SecureRandom()).toString(32).toUpperCase();
    }
    
    public static void openNewJSP(HttpServletRequest request,HttpServletResponse response,String name){
        try {
            request.getRequestDispatcher(name).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
