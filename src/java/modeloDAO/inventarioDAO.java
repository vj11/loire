
package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.inventario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class inventarioDAO {
    Connection con;
    public inventarioDAO(){
                try {
                        Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loire?useSSL=false&useUnicode=True&useJDBCCompliantTimezoneShift=True&useLegacyDatetimeCode=False&serverTimezone=UTC","root","");
        }
        catch (ClassNotFoundException | SQLException e){
            System.err.println("Error: "+e);
        }
    }
    public Connection getConnection() {
                 return con;
    }
    
    /* prueba de la conexion de BD
        public static void main(String []args){
        inventarioDAO cn=new inventarioDAO();
        Statement st;
        ResultSet rs;
        try{
            st=cn.con.createStatement();
            rs=st.executeQuery("SELECT `idResiduosInventario`, `idFormulario`, `tipoResiduo`, `cantidad`, `generador` FROM `residuosinventario` WHERE 1");
            while (rs.next()){
                System.out.println(rs.getInt("idResiduosInventario")+" "+rs.getString("tipoResiduo"));
            }
            cn.con.close();
        }
        catch(Exception e){
            
        }
    }
        }*/
    inventario res=new inventario();    
    public void agregarIngreso(int idForm, String tipo, Float cantidad,String generador){
        
        inventarioDAO cn=new inventarioDAO();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=cn.con.prepareStatement("INSERT INTO `residuosinventario`( `idFormulario`, `tipoResiduo`, `cantidad`, `generador`, `estado`, `fecha`) VALUES (?,?,?,?,'1',CURRENT_DATE);");
            st.setInt(1, idForm);
            st.setString(2, tipo);
            st.setFloat(3, cantidad);
            st.setString(4, generador);
            
            
            st.execute();
            cn.con.close();
        }
        catch(SQLException e){
            
        }
      /* inventario usu = new inventario();
        
        Connection cn;
        conexion con = new conexion();
        cn = con.getConnection();
        
        try{
            CallableStatement cs;
            cs = cn.prepareCall("{call registrar_in(?,?,?,?)}");
            cs.setInt(1, registro.getIdForm());
            cs.setString(2, registro.getTipo());
            cs.setFloat(3, registro.getCantidad());
            cs.setString(4, registro.getGenerador());
            cs.execute();
            
            int formulario = cs.getInt(1);
            String tipo = cs.getString(2);
            float cantidad = cs.getFloat(3);
            String generador = cs.getString(4);
            
            System.out.println("lo hizo");
            
            
        }catch(Exception e){System.out.println(e);}*/

    }
   public void modificarRegistro (int id,int idform, String Tipo, Float Cantidad,String Generador){
      inventarioDAO cn=new inventarioDAO();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=cn.con.prepareStatement("UPDATE `residuosinventario` SET idFormulario=?,tipoResiduo=?,cantidad=?,generador=? WHERE `residuosinventario`.`idResiduosInventario`=?");
            st.setInt(1, idform);
            st.setString(2, Tipo);
            st.setFloat(3, Cantidad);
            st.setString(4, Generador);
            st.setInt(5, id);
            
            st.execute();
            cn.con.close();
        }
        catch(SQLException e){
            
        }
   }
   public void inavilitar(int id){
        String sql="UPDATE `residuosinventario` SET `estado`=0 WHERE `idResiduosInventario`="+id;
        PreparedStatement st;
        ResultSet rs;
        try {
            inventarioDAO cn=new inventarioDAO();
            con=cn.getConnection();
            st=con.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
        }
   }
       public List listar() {
        ArrayList<inventario>list=new ArrayList<>();
        String sql="SELECT `idResiduosInventario`, `idFormulario`, `tipoResiduo`, `cantidad`, `generador` FROM `residuosinventario` WHERE `estado`= 1";
        try{
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                inventario res=new inventario();
                res.setId(rs.getInt("idResiduosInventario"));
                res.setIdForm(rs.getInt("idFormulario"));
                res.setTipo(rs.getString("tipoResiduo"));
                res.setCantidad(rs.getFloat("cantidad"));
                res.setGenerador(rs.getString("generador"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
    }
       
              public List listarin() {
        ArrayList<inventario>list=new ArrayList<>();
        String sql="SELECT `idFormulario`, `tipoResiduo`, `cantidad`, `generador` FROM `residuosinventario` WHERE `estado`= 0";
        try{
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                inventario res=new inventario();
                res.setIdForm(rs.getInt("idFormulario"));
                res.setTipo(rs.getString("tipoResiduo"));
                res.setCantidad(rs.getFloat("cantidad"));
                res.setGenerador(rs.getString("generador"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
    }
     public ResultSet Meses(){
        rutaDAO cn = new rutaDAO();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=cn.con.prepareStatement("SELECT DISTINCT ELT(MONTH(fecha),'Enero','Febrero','Marzo', 'Abril', 'Mayo', 'Junio', 'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre')from residuosinventario)");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    public List listarGrafico(){
        ArrayList<inventario>list=new ArrayList<>();
        String sql="SELECT `idFormulario`, `tipoResiduo`, `cantidad`, `generador`,(MONTH(fecha)) FROM `residuosinventario` WHERE `estado`= 1 group by (MONTH(fecha)) ORDER BY (MONTH(fecha)) ASC";

        try{
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                inventario res=new inventario();
                res.setTipo(rs.getString("tipoResiduo"));
                res.setCantidad(rs.getFloat("cantidad"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
    }
    public inventario list(int id) {
        String sql="SELECT * FROM `residuosinventario` where idResiduosInventario="+id;
        try {
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                            
                res.setId(rs.getInt("idResiduosInventario"));
                res.setIdForm(rs.getInt("idFormulario"));
                res.setTipo(rs.getString("tipoResiduo"));
                res.setCantidad(rs.getFloat("cantidad"));
                res.setGenerador(rs.getString("generador"));
                
            }
        } catch (SQLException e) {
        }
        return res;
    }
   
     
       
}
