
package modeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.conexion;
import modelo.vehiculo;

public class vehiculoDAO {
    Connection con;
    
    public vehiculoDAO(){
              try {
                        Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loire?useSSL=false&useUnicode=True&useJDBCCompliantTimezoneShift=True&useLegacyDatetimeCode=False&serverTimezone=UTC","root","");
        }
        catch (ClassNotFoundException | SQLException e){
            System.err.println("Error: "+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
    vehiculo res=new vehiculo();
        public void agendarVehiculo(String modelo,String placa,String tipo,int idconductor){
      conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("INSERT INTO `vehiculo` (`modelo`, `placa`, `tipo`, `idconductor`, `estado`) VALUES (?,?,?,?,'1');");
            st.setString(1, modelo);
            st.setString(2, placa);
            st.setString(3, tipo);
            st.setInt(4, idconductor);
            
            st.execute();
            con.close();
        }   catch (SQLException ex) {  
                Logger.getLogger(rutaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    public void actualizarVehiculo(int Idvehiculo,int estado,int idconductor,String placa,String modelo,String tipo){
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("UPDATE `vehiculo` SET `modelo`=?,`placa`=?,`tipo`=?,`idconductor`=?,`estado`=?  WHERE `vehiculo`.`idvehiculo`=?");
            st.setString(1, modelo);
            st.setString(2, placa);
            st.setString(3, tipo);
            st.setInt(4, idconductor);
            st.setInt(5, estado);
            st.setInt(6, Idvehiculo);
            
            st.execute();
            con.close();
        }
        catch(SQLException e){
            
        }
    }
    public boolean eliminar(int idvehiculo) {
         PreparedStatement st;
        ResultSet rs;
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        try {
            st=con.prepareStatement("UPDATE `vehiculo` SET `estado` = '0' WHERE `idvehiculo` ="+idvehiculo);
            st.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    
    public List listarVehiculo(){
            ArrayList<vehiculo>list=new ArrayList<>();
        String sql="SELECT * FROM `vehiculo` WHERE `estado`=1";
        try{
            conexion cn=new conexion();
        Connection con=cn.getConnection();
            PreparedStatement st;
            ResultSet rs;
            
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                vehiculo res=new vehiculo();
                res.setIdvehiculo(rs.getInt("idvehiculo"));
                res.setModelo(rs.getString("modelo"));
                res.setPlaca(rs.getString("placa"));
                res.setTipo(rs.getString("tipo"));
                res.setIdconductor(rs.getInt("idconductor"));
                res.setEstado(rs.getInt("estado"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
        
    }
    public List listarVehiculoin(){
            ArrayList<vehiculo>list=new ArrayList<>();
        String sql="SELECT `modelo`, `placa`, `tipo`, `idconductor`, `estado` FROM `vehiculo` WHERE `estado`= 0";
        try{
            conexion cn=new conexion();
        Connection con=cn.getConnection();
            PreparedStatement st;
            ResultSet rs;
            
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                vehiculo res=new vehiculo();
                res.setModelo(rs.getString("modelo"));
                res.setPlaca(rs.getString("placa"));
                res.setTipo(rs.getString("tipo"));
                res.setIdconductor(rs.getInt("idconductor"));
                res.setEstado(rs.getInt("estado"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
        
    }
    public ResultSet mostrarConductor(){
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=con.prepareStatement("SELECT idConductor,primerNombre from conductor");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    public vehiculo list(int id) {
        String sql="SELECT * FROM `vehiculo` where idvehiculo="+id;
        try {
            conexion cn=new conexion();
        Connection con=cn.getConnection();
            PreparedStatement st;
            ResultSet rs;
            
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                            
                res.setModelo(rs.getString("modelo"));
                res.setPlaca(rs.getString("placa"));
                res.setTipo(rs.getString("tipo"));
                res.setIdconductor(rs.getInt("idconductor"));
                res.setEstado(rs.getInt("estado"));
                
            }
        } catch (SQLException e) {
        }
        return res;
    }
}
