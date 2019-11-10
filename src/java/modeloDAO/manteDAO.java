
package modeloDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
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
import modelo.conexion;
import modelo.manten;
import modelo.vehiculo;

public class manteDAO {
    manten res=new manten();
    
        public void registarMante(String fehcain,String fechafin,String danos,String repuestos,String taller,String mecanico,float costosre,float costosrevi,int idsolicitud){
      conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("INSERT INTO `mantenimiento`(`fechaInicio`, `fechaFin`, `danos`, `repuestos`, `idsolicitud`, `valorRepuestos`, `valorRevision`, `mecanico`, `taller`, `estado`) VALUES (?,?,?,?,?,?,?,?,?,'activo')");
            st.setString(1,fehcain );
            st.setString(2, fechafin);
            st.setString(3, danos);
            st.setString(4, repuestos);
            st.setInt(5, idsolicitud);
            st.setFloat(6, costosre);
            st.setFloat(7, costosrevi);
            st.setString(8, mecanico);
            st.setString(9, taller);
            
            st.execute();
            
            con.close();
        }   catch (SQLException ex) {  
            }  
    }
    public void actualizarMante(int idmante,String fehcain,String fechafin,String danos,String repuestos,String taller,String mecanico,float costosre,float costosrevi,int idsolicitud,String Estado){
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("UPDATE `mantenimiento` SET `fechaInicio`=?,`fechaFin`=?,`repuestos`=?,`idsolicitud`=?,`valorRepuestos`=?,`valorRevision`=?,`mecanico`=?,`taller`=?,`estado`=?,`danos`=? WHERE `mantenimiento`.`idMantenimiento`=?");
            st.setString(1, fehcain);
            st.setString(2, fechafin);
            st.setString(3, repuestos);
            st.setInt(4, idsolicitud);
            st.setFloat(5, costosre);
            st.setFloat(6, costosrevi);
            st.setString(7, mecanico);
            st.setString(8, taller);
            st.setString(9, Estado);
            st.setString(10, danos);
            st.setInt(11, idmante);
            
            st.execute();
            con.close();
        }
        catch(SQLException e){
            
        }
    }
    public List listarMante(){
            ArrayList<manten>list=new ArrayList<>();
        String sql="SELECT `idMantenimiento`, `fechaInicio`, `fechaFin`, `daños`, `repuestos`, `idsolicitud`, `valorRepuestos`, `valorRevision`, `mecanico`, `taller`, `estado` FROM `mantenimiento`";
        try{
            conexion cn=new conexion();
        Connection con=cn.getConnection();
            PreparedStatement st;
            ResultSet rs;
            
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            while (rs.next()){
                manten res=new manten();
                res.setIdmante(rs.getInt("idMantenimiento"));
                res.setDanos(rs.getString("danos"));
                /*res.setIdvehiculo(rs.getInt("idVehiculo"));
                res.setIdconductor(rs.getInt("idConductor"));*/
                res.setRepiestos(rs.getString("repuestos"));
                res.setValorre(rs.getFloat("valorRepuestos"));
                res.setValorrevi(rs.getFloat("valorRevision"));
                res.setTaller(rs.getString("taller"));
                res.setEstado(rs.getString("estado"));
                list.add(res);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
        
    }
    public void invalidar(int id){
        String sql="UPDATE `mantenimiento` SET `estado1`=1 WHERE `idMantenimiento`="+id;
        PreparedStatement st;
        ResultSet rs;
        try {
           conexion cn=new conexion();
        Connection con=cn.getConnection();
            st=con.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
        }
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
    public ResultSet mostrarSolicitud(){
        rutaDAO cn = new rutaDAO();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=cn.con.prepareStatement("SELECT `idSolicitud`, conductor.primerNombre FROM solicitudmante, conductor WHERE solicitudmante.idconductor=conductor.idConductor");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    public ResultSet mostrarVehiculo(){
       conexion cn=new conexion();
        Connection con=cn.getConnection();
        /*String com = "SELECT ";
        ResultSet rs = con.getDatos(com);*/
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=con.prepareStatement("SELECT idvehiculo,placa from vehiculo");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    
    public void solicitud(int conductor, int vehiculo, String descripcion, String tipo){
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("INSERT INTO `notificacion`(`TipoNoti`, `idconductor`, `idvehiculo`, `descripcion`, `estado`, `estado1`)VALUES (?,?,?,?,1,1)");
            st.setString(1, tipo);
            st.setInt(2, conductor);
            st.setInt(3, vehiculo);
            st.setString(4, descripcion);
            
            st.execute();
            con.close();
        } catch(SQLException e){
            
        }
    }
    
 public void enviarCorreo(){
        Date fechaHoraDate=null;
        Timer timer = new Timer();
        Calendar cal=Calendar.getInstance();
        fechaHoraDate=cal.getTime();
        TimerTask tarea=new TimerTask() {
            @Override
            public void run() {
                /*PreparedStatement ps;
        ResultSet rs;
        conexion conn = new conexion();
        Connection con1 = conn.getConnection();
        String sql="SELECT  * FROM `persona`";
        String[] correos_destinos=null;
            try {
                ps = con1.prepareStatement(sql);
                rs = ps.executeQuery();
                ResultSetMetaData rd = rs.getMetaData();
                int filas = rd.getColumnCount();
                correos_destinos = new String[filas + 1];
                int indice = 0;
                while (rs.next()) {
                    correos_destinos[indice]= rs.getString("email");
                    indice++;
                }
                
            }catch (SQLException e){
                
            } */  try {
                Properties props=new Properties();
                props.setProperty("mail.smtp.host","smtp.gmail.com");
                props.setProperty("mail.smtp.starttls.enable", "true");
                props.setProperty("mail.smtp.port", "587");
                props.setProperty("mail.smtp.auth", "true");
                
                Session session=Session.getDefaultInstance(props);
        
        String correoRemitente="vjvalencia2000@gmail.com";
        String passRemitente="porticalle13*";
        String correoReceptor= "vjvalencia89@misena.edu.co";
        String asunto="Mandar a Mantenimento el vehiculo";
        String mensaje="Hola<br>Los vehiculos deben ser revisado mensualmente <br>ATTE: MIU SYSTEM</b>";
                
        MimeMessage message=new MimeMessage(session);
        message.setFrom(new InternetAddress(correoRemitente));
        
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
        message.setSubject(asunto);
        message.setText(mensaje, "ISO-8859-1","html");
        
        Transport t=session.getTransport("smtp");
        t.connect(correoRemitente, passRemitente);
        t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        t.close();
                
            } catch (AddressException ex) {
                Logger.getLogger(manteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(manteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        };
           timer.schedule(tarea, fechaHoraDate,36000000);

        }
 public manten list(int id) {
        String sql="SELECT * FROM `mantenimiento` where idMantenimiento="+id;
        try {
            conexion cn=new conexion();
        Connection con=cn.getConnection();
            PreparedStatement st;
            ResultSet rs;
            
            st=con.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                            
                res.setIdmante(rs.getInt("idMantenimiento"));
                res.setFechain(rs.getString("fechaInicio"));
                res.setFechafin(rs.getString("fechaFin"));
                res.setDanos(rs.getString("danos"));
                 res.setRepiestos(rs.getString("repuestos"));
                res.setValorre(rs.getFloat("valorRepuestos"));
                res.setValorrevi(rs.getFloat("valorRevision"));
                res.setIdsolicitud(rs.getInt("idsolicitud"));
                res.setTaller(rs.getString("taller"));
                res.setMecanico(rs.getString("mecanico"));
                res.setEstado(rs.getString("estado"));
                
            }
        } catch (SQLException e) {
        }
        return res;
    }
    public void recordatorio(){
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
        adjunto.setDataHandler(new DataHandler(new FileDataSource("F:\\programacion\\intentox\\web\\img\\reporta.png")));
        adjunto.setFileName("recodatorio.png");
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
            Logger.getLogger(manteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(manteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet notificacionSolicictudMante() {
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
