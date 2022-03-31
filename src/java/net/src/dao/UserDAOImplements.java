package net.src.dao;

import java.sql.PreparedStatement;
import net.mvc.model.UserModel;
import net.src.ConnectionSQL;
import net.src.User;

public class UserDAOImplements extends ConnectionSQL implements UserDAOInterface{
    
    public UserDAOImplements(){
        super();
    }

    @Override
    public boolean registerUser(User user) {
        boolean status=false;
        try {
            String url="INSERT INTO register_users(id_rol,dni,lastnames,names,mail,tel_cel,username,password) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement ps=getConnection().prepareStatement(url);
            ps.setInt(1, user.getRol());
            ps.setString(2, user.getDni());
            ps.setString(3, user.getLastnames());
            ps.setString(4, user.getNames());
            ps.setString(5, user.getMail());
            ps.setString(6, user.getTelcel());
            ps.setString(7, user.getUsername());
            ps.setString(8, user.getPassword());
            if(ps.executeUpdate()>0){
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

    @Override
    public boolean updateUser(User user) {
        boolean status=false;
        try {
            String url="UPDATE register_users SET dni='"+user.getDni()+"', lastnames='"+user.getLastnames()+"', names='"+user.getNames()+"', mail='"+user.getMail()+"',tel_cel='"+user.getTelcel()+"',username='"+user.getUsername()+"', password='"+user.getPassword()+"' WHERE id='"+user.getID()+"'";
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

    @Override
    public boolean removeUser(User user) {
        boolean status=false;
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String verifyIfExistsUser(User user) {
        String status="";
        try {
            String dni=user.getDni();
            String mail=user.getMail();
            UserModel mu=new UserModel();
            for(int i=0;i<mu.getAllUsers().size();i++){
                User u=mu.getAllUsers().get(i);
                if(u.getDni().equalsIgnoreCase(dni)){
                    if(u.getMail().equalsIgnoreCase(mail)){
                        status+="Error: DNI y correo electrónico ya han sido registrados anteriormente";
                        break;
                    }else{
                        status+="Error: DNI ya registrado anteriormente";
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    
}
