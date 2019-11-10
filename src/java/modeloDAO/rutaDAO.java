
package modeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import modelo.conductor;
import modelo.conexion;
import modelo.ruta;

public class rutaDAO {
        Connection con;
    
    public rutaDAO(){
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
    
    ruta res=new ruta();
    
    public void agendarRuta(String direccion, String fecha,int idconductor,int idservicio,int idvehiculo, String descripcion, String tipo){
      rutaDAO cn=new rutaDAO();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=cn.con.prepareStatement("INSERT INTO `ruta`(`id_Validacion_Servicios`, `fechaRuta`, `Direccion`, `idVehiculo`, `idConductor`, `estado`) VALUES (?,?,?,?,?,'1')");
            st.setInt(1, idservicio);
            st.setString(2, fecha);
            st.setString(3, direccion);
            st.setInt(4, idvehiculo);
            st.setInt(5, idconductor);
            
            st.execute();
            st=cn.con.prepareStatement("INSERT INTO `notificacion`(`TipoNoti`, `idconductor`, `idvehiculo`, `descripcion`, `estado`, `estado1`) VALUES (?,?,?,?,1,1)");
            st.setString(1, tipo);
            st.setInt(2, idconductor);
            st.setInt(3, idvehiculo);
            st.setString(4, descripcion);
            st.execute();
            cn.con.close();
        }   catch (SQLException ex) {  
                Logger.getLogger(rutaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }  
    }
    public void actualizarRuta(int idRuta, String Direccion, String Fecha, int Idconductor, int Idservicio, int IdVehiculo, int Estado){
        inventarioDAO cn=new inventarioDAO();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=cn.con.prepareStatement("UPDATE `ruta` SET `id_Validacion_Servicios`=?,`fechaRuta`=?,`Direccion`=?,`idVehiculo`=?,`idConductor`=?,`estado`=? WHERE `ruta`.`idRuta`=?");
            st.setInt(1, Idservicio);
            st.setString(2, Fecha);
            st.setString(3, Direccion);
            st.setInt(4, IdVehiculo);
            st.setInt(5, Idconductor);
            st.setInt(6, Estado);
            st.setInt(7, idRuta);
            
            st.execute();
            cn.con.close();
        }
        catch(SQLException e){
            
        }
    }
    public boolean eliminar(int idRuta) {
         PreparedStatement st;
        ResultSet rs;
        try {
            st=con.prepareStatement("UPDATE `ruta` SET `estado`=0 WHERE `idRuta`="+idRuta);
            st.executeUpdate();
        } catch (SQLException e) {
        }
        return false;
    }
    public List listarRuta(){
            ArrayList<ruta>list=new ArrayList<>();
        String sql="SELECT `idRuta`, `id_Validacion_Servicios`, `fechaRuta`, `Direccion`, v.placa, c.primerNombre,r.`estado` FROM `ruta` r, vehiculo v, conductor c where r.`idVehiculo`=v.idVehiculo and r.`idConductor`=c.idConductor";
        try{
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                ruta res=new ruta();
                res.setIdRuta(rs.getInt("idRuta"));
                res.setIdValServicio(rs.getInt("id_Validacion_Servicios"));
                res.setVehiculo(rs.getString("v.placa"));
                res.setConductor(rs.getString("c.primerNombre"));
                res.setDireccion(rs.getString("Direccion"));
                res.setFecha(rs.getString("fechaRuta"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
        
    }
    public List listarRutain(){
            ArrayList<ruta>list=new ArrayList<>();
        String sql="SELECT `id_Validacion_Servicios`, `fechaRuta`, `Direccion`, `idVehiculo`, `idConductor`,`estado` FROM `ruta` WHERE `estado`= 0";
        try{
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                ruta res=new ruta();
                res.setIdValServicio(rs.getInt("id_Validacion_Servicios"));
                res.setIdVehiculo(rs.getInt("idVehiculo"));
                res.setIdConductor(rs.getInt("idConductor"));
                res.setDireccion(rs.getString("Direccion"));
                res.setFecha(rs.getString("fechaRuta"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
        
    }
    public ResultSet mostrarConductor(){
        rutaDAO cn = new rutaDAO();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=cn.con.prepareStatement("SELECT idConductor,primerNombre from conductor");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    public ResultSet mostrarServicio(){
        rutaDAO cn = new rutaDAO();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=cn.con.prepareStatement("SELECT `idcliente`,`razonsocial` FROM cliente WHERE tiposervicio='recoleccion' AND estado='en proceso'");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    public ResultSet mostrarVehiculo(){
        rutaDAO cn = new rutaDAO();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=cn.con.prepareStatement("SELECT idvehiculo,placa from vehiculo");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    public void solictudRuta (int idConductor, String descripcion, String tipo){
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("UPDATE conductor SET estado1='activo' WHERE idconductor="+idConductor);
            st.execute();
            st=con.prepareStatement("INSERT INTO `notificacion`(`TipoNoti`, `idconductor`, `descripcion`, `estado`, `estado1`) VALUES (?,?,?,1,1)");
            st.setString(1, tipo);
            st.setInt(2, idConductor);
            st.setString(3, descripcion);
            st.execute();
        } catch(SQLException e){
            
        }
    }
     public ruta list(int id) {
        String sql="SELECT * FROM `ruta` where idRuta="+id;
        try {
            inventarioDAO cn=new inventarioDAO();
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                            
                res.setIdRuta(rs.getInt("idRuta"));
                res.setDireccion(rs.getString("Direccion"));
                res.setFecha(rs.getString("fechaRuta"));
                res.setConductor(rs.getString("idConductor"));
                res.setIdValServicio(rs.getInt("id_Validacion_Servicios"));
                res.setIdVehiculo(rs.getInt("idVehiculo"));
                res.setEstado(rs.getInt("estado"));
                
            }
        } catch (SQLException e) {
        }
        return res;
    }
     public void animos(){
        PreparedStatement ps;
        ResultSet rs;
        rutaDAO conn = new rutaDAO();
        Connection con= conn.getConnection();
        
        String sql="SELECT * FROM `persona`";
        String[] correos_destinos=null;
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rd = rs.getMetaData();
            int filas = rd.getColumnCount();
            correos_destinos = new String[filas + 1];
            int indice = 0;
            
            while (rs.next()) {
                correos_destinos[indice]= rs.getString("email");
                indice++;
            }
            
        } catch (SQLException e){
            
        }
        try {
        Properties props=new Properties();
        props.setProperty("mail.smtp.host","smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session=Session.getDefaultInstance(props);
        
        String correoRemitente="vjvalencia2000@gmail.com";
        String passRemitente="porticalle13*";
        String asunto="mi primer correo";
        String mensaje="Hola<br>este es el contenido de mi primer correo desde <br>java <b>BTS TUS PINCHES PATRONES</b><br>TODOS LOS COREANOS CANTAN BIEN JODER!!";
        MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));
            Address[] receptores=new Address[correos_destinos.length];
            int j = 0;
            while (j< correos_destinos.length){
                receptores[j]=new InternetAddress(correos_destinos[j]);
                j++;
            }
        BodyPart texto=new MimeBodyPart();
        texto.setContent(mensaje,"text/html");
        
        BodyPart adjunto=new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource("F:\\programacion\\intentox\\web\\img\\animoConductor.png")));
        adjunto.setFileName("como_estas.png");
        MimeMultipart miltiparte=new MimeMultipart();
        miltiparte.addBodyPart(texto);
        miltiparte.addBodyPart(adjunto);
        

        
        message.addRecipients(Message.RecipientType.TO, receptores);
            message.setSubject(asunto);
            message.setContent(miltiparte);
            
            Transport t=session.getTransport("smtp");
            t.connect(correoRemitente, passRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
        
        } catch (AddressException ex) {
            Logger.getLogger(rutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(rutaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public ResultSet notificacionAgendamientoRuta() {
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=con.prepareStatement("");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }

  
}
