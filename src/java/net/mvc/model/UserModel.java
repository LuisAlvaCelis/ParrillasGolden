package net.mvc.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import net.src.ConnectionSQL;
import net.src.User;
import net.src.VerifyUserAccount;

public class UserModel extends ConnectionSQL{
    
    public UserModel(){
        super();
    }
    
    public boolean insertAccountToVerifyAccount(VerifyUserAccount vua){
        boolean status=false;
        try {
            String url="INSERT INTO verifyaccount(account,code,date) VALUES(?,?,?)";
            PreparedStatement ps=getConnection().prepareStatement(url);
            ps.setString(1, vua.getAccount());
            ps.setString(2, vua.getCode());
            ps.setString(3, vua.getDate());
            int result=ps.executeUpdate();
            if(result>0){
                status=true;
            }else{
                status=false;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    public boolean removeAccountFromVerifyAccount(VerifyUserAccount vua){
        boolean status=false;
        try {
            String url="DELETE FROM verifyaccount WHERE id='"+vua.getID()+"'";
            PreparedStatement ps=getConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result==1){
                status=true;
            }else{
                status=false;
            }
            ps.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    public boolean updateAccountPassword(User user){
        boolean status=false;
        try {
            String url="UPDATE register_users SET password='"+user.getPassword()+"' WHERE id='"+user.getID()+"'";
            PreparedStatement ps=getConnection().prepareStatement(url);
            int result=ps.executeUpdate();
            if(result==1){
                status=true;
            }else{
                status=false;
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    public boolean getAccountByUserOrMail(String code,String account){
        boolean status=false;
        try {
            String url="SELECT * FROM verifyaccount WHERE code='"+code+"' and account='"+account+"'";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                status=true;
            }else{
                status=false;
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return status;
    }
    
    
    public String getValidateAccountRequest(String account){
        String time="null";
        try {
            String url="SELECT * FROM verifyaccount WHERE account='"+account+"'";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                String datedb=rs.getString("date");
                String daydb=datedb.substring(0,2);
                String monthdb=datedb.substring(3,5);
                String yeardb=datedb.substring(6,10);
                
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                String currentDate=sdf.format(Calendar.getInstance().getTime());
                String daynow=currentDate.substring(0,2);
                String monthnow=currentDate.substring(3,5);
                String yearnow=currentDate.substring(6,10);
                if(Integer.parseInt(daynow)>Integer.parseInt(daydb) && (Integer.parseInt(monthnow)==Integer.parseInt(monthdb) || Integer.parseInt(monthnow)>Integer.parseInt(monthdb)) && (Integer.parseInt(yearnow)==Integer.parseInt(yeardb) || Integer.parseInt(yearnow)>Integer.parseInt(yeardb))){
                    time="ok";
                }else{
                    time="falta";
                }
            }else{
                time="null";
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return time;
    }
    
    public User getUserByDNI(String dni){
        User user=new User();
        try {
            String url="SELECT * FROM register_users WHERE dni='"+dni+"'";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                user=new User(rs.getInt("id"),rs.getInt("id_rol"),rs.getString("dni"), rs.getString("lastnames"), rs.getString("names"), rs.getString("mail"), rs.getString("tel_cel"), rs.getString("username"), rs.getString("password"));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users=new ArrayList<>();
        try {
            String url="SELECT * FROM register_users";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                users.add(new User(rs.getInt("id"),rs.getInt("id_rol"),rs.getString("dni"), rs.getString("lastnames"), rs.getString("names"), rs.getString("mail"), rs.getString("tel_cel"), rs.getString("username"), rs.getString("password")));
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return users;
    }
}
