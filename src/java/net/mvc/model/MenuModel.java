package net.mvc.model;

import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;
import net.src.ConnectionSQL;
import net.src.Menu;

public class MenuModel extends ConnectionSQL{
    
    public MenuModel(){
        super();
    }
    
    public ArrayList<Menu> getAllMenus(){
        ArrayList<Menu> list=new ArrayList<>();
        try {
            String url="SELECT * FROM register_menu";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            while(rs.next()){
                list.add(new Menu(rs.getInt("id_menu"), rs.getString("name"), rs.getString("description"), rs.getString("category"), rs.getDouble("cost"),rs.getBoolean("status")));
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
        return list;
    }
    
    public Menu getMenuByID(int id){
        Menu menu=new Menu();
        try {
            String url="SELECT * FROM register_menu WHERE id_menu='"+id+"'";
            Statement statement=getConnection().createStatement();
            ResultSet rs=statement.executeQuery(url);
            if(rs.next()){
                menu=new Menu(rs.getInt("id_menu"), rs.getString("name"), rs.getString("description"), rs.getString("category"), rs.getDouble("cost"),rs.getBoolean("status"));
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
        return menu;
    }
    
    public static void getImageMenuByID(int id,HttpServletResponse response){
        Connection connection=new ConnectionSQL().getConnection();
        try {
            response.setContentType("image/png");
            OutputStream os=response.getOutputStream();
            String url="SELECT * FROM register_menu WHERE id_menu='"+id+"'";
            PreparedStatement ps=connection.prepareStatement(url);
            ResultSet rs=ps.executeQuery();
            if(rs!=null){
                if(rs.next()){
                    byte[] buffer=rs.getBytes("image");
                    if(buffer!=null){
                        os.write(buffer);
                        os.flush();
                        os.close();
                    }
                }
                rs.close();
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
