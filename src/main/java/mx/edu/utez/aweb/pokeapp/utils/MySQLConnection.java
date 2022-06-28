package mx.edu.utez.aweb.pokeapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public Connection getConnection(){
        final String DBNAME = "pokemon",
                USERNAME = "root",
                PASSWORD = "root",
                TIMEZONE = "America/Mexico_City",
                USESSL = "false",
                PUBLICKEY = "true";
        String dataSource = String.format("jdbc:mysql://localhost:3306/%s?user=%s"+
                "&password=%s&serverTimezone=%s&useSSL=%sallowPublicKeyRetrieval=%s",
                DBNAME,USERNAME,PASSWORD,TIMEZONE,USESSL,PUBLICKEY);
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch (SQLException e){
            System.out.println(this.getClass().getCanonicalName()+ "->"+e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conn = new MySQLConnection().getConnection();
        if (conn != null){
            try{
                System.out.println("Conexion exitosa");
                conn.close();
            }catch (SQLException e){
            }
        }else{
            System.out.println("Conexion fallida");
        }
    }
}
