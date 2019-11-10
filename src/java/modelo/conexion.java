
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conexion {
    Connection con;
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://node49329-env-9010552.jl.serv.net.mx:3306/loire?useSSL=false&useUnicode=True&useJDBCCompliantTimezoneShift=True&useLegacyDatetimeCode=False&serverTimezone=UTC","root","1Y41vgV955");
        }
        catch (ClassNotFoundException | SQLException e){
            System.err.println("Error: "+e);
        }
    }
    public Connection getConnection() {
                 return con;
    }
    
    /* prueba de la conexion de BD*/
        public static void main(String []args){
        conexion cn=new conexion();
        Statement st;
        ResultSet rs;
        try{
            st=cn.con.createStatement();
            rs=st.executeQuery("SELECT * FROM `persona`");
            while (rs.next()){
                System.out.println(rs.getString("id")+" "+rs.getString("email"));
            }
            cn.con.close();
        }
        catch(SQLException e){
            
        }
    }
        }
