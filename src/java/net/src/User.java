package net.src;

public class User {
    private int id;
    private int rol;
    private String dni;
    private String lastnames;
    private String names;
    private String telcel;
    private String username;
    private String password;
    private String mail;

    public User(int id,int rol,String dni, String lastnames, String names,String mail, String telcel, String username, String password) {
        this.id=id;
        this.rol=rol;
        this.dni = dni;
        this.lastnames = lastnames;
        this.names = names;
        this.telcel = telcel;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
    
    public User(){}
    
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id=id;
    }
    
    public int getRol(){
        return this.rol;
    }
    
    public void setRol(int rol){
        this.rol=rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getTelcel() {
        return telcel;
    }

    public void setTelcel(String telcel) {
        this.telcel = telcel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
