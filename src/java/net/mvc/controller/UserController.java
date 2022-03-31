package net.mvc.controller;

import net.mvc.model.UserModel;
import net.src.User;

public class UserController {
    
    private static UserController instance;
    private static boolean status=false;
    private static String msg="";
    
    public UserController(String msg,boolean status){
        this.msg=msg;
        this.status=status;
    }
    public UserController(){
    }
    
    public static UserController getInstance(){
        if(instance==null){
            instance=new UserController();
        }
        return instance;
    }
    
    
    public String getConsoleMsg(){
        if(status){
            return msg;
        }else{
            return "";
        }
    }
    
    /*public String getUsers(){
        ModelUser mu=new ModelUser();
        String htmlcode="";
        for(User user:mu.getAllUsers()){
            htmlcode+="";
        }
        return htmlcode;
    }
    */
    public User getUser(String dni){
        return new UserModel().getUserByDNI(dni);
    }
}
