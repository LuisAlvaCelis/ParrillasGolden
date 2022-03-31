package net.src;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQL {
    
    private Connection connection;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/parrillasgolden?allowPublicKeyRetrieval=true&useSSL=false","root","157855");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }
}
