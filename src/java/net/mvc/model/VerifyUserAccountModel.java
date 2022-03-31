package net.mvc.model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import net.src.ConnectionSQL;
import net.src.VerifyUserAccount;

public class VerifyUserAccountModel extends ConnectionSQL {

    public VerifyUserAccountModel(){
        super();
    }
    
    public VerifyUserAccount getUserAccountByIDorAccount(String idoraccount) {
        VerifyUserAccount vua=new VerifyUserAccount();
        try {
            String url="SELECT * FROM verifyaccount WHERE (id,'',account) LIKE '%"+idoraccount+"%'";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                vua=new VerifyUserAccount(rs.getInt("id"), rs.getString("account"), rs.getString("code"), rs.getString("date"));
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
        return vua;
    }
    
    public ArrayList<VerifyUserAccount> getAllUserVerifiedUsers() {
        ArrayList<VerifyUserAccount> list=new ArrayList<>();
        try {
            String url="SELECT * FROM verifyaccount";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new VerifyUserAccount(rs.getInt("id"), rs.getString("account") , rs.getString("code"), rs.getString("date")));
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
            }
        }
        return list;
    }
}
