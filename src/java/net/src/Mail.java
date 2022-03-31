package net.src;

public class Mail {
    
    private String userMail,passwordMail,destiny,affair,message;

    public Mail(String userMail, String passwordMail, String destiny, String affair, String message) {
        this.userMail = userMail;
        this.passwordMail = passwordMail;
        this.destiny = destiny;
        this.affair = affair;
        this.message = message;
    }

    public Mail() {}
    
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPasswordMail() {
        return passwordMail;
    }

    public void setPasswordMail(String passwordMail) {
        this.passwordMail = passwordMail;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
