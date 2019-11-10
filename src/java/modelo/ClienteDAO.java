
package modelo;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
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


public class ClienteDAO implements servicioCRUD {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cl=new Cliente();
    
    @Override
    public List listar() {
       ArrayList<Cliente>list=new ArrayList<>();
        String sql="SELECT *FROM cliente";
         try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl=new Cliente();
                cl.setIdCliente(rs.getInt("idcliente"));
                cl.setPersona_IdPersona(rs.getInt("persona_idpersona"));
                cl.setRazonSocial(rs.getString("razonsocial"));
                cl.setNit(rs.getString("nit"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setTipoServicio(rs.getString("tiposervicio"));
                cl.setFecha(rs.getString("fecha"));
                cl.setMensaje(rs.getString("mensaje"));  
                cl.setEstado(rs.getString("estado"));
                                
                list.add(cl);
            }
        } catch (Exception e) {
        }
        return list;
    }

  
    @Override
    public Cliente list(int idCliente) {
        String sql="SELECT * FROM cliente WHERE idcliente="+idCliente;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){ 
                cl.setIdCliente(rs.getInt("idcliente"));
                cl.setPersona_IdPersona(rs.getInt("persona_idpersona"));
                cl.setRazonSocial(rs.getString("razonsocial"));
                cl.setNit(rs.getString("nit"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setTipoServicio(rs.getString("tiposervicio"));
                cl.setFecha(rs.getString("fecha"));
                cl.setMensaje(rs.getString("mensaje")); 
                
            } 
        }
             catch (Exception e) {
        }
        return cl;
    }

    @Override
    public boolean add(Cliente cl) {
        String sql="INSERT INTO `cliente`(`idcliente`,`persona_idpersona`,`razonsocial`, `nit`, `direccion`, `telefono`, `tiposervicio`,`fecha`,`mensaje`)values('"+cl.getIdCliente()+"','"+cl.getPersona_IdPersona()+"','"+cl.getRazonSocial()+"','"+cl.getNit()+"','"+cl.getDireccion()+"','"+cl.getTelefono()+"','"+cl.getTipoServicio()+"','"+cl.getFecha()+"','"+cl.getMensaje()+"');";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }
    @Override
    public boolean edit(Cliente cl) {
        String sql="update cliente set razonsocial='"+cl.getRazonSocial()+"',nit='"+cl.getNit()+"',direccion='"+cl.getDireccion()+"',telefono='"+cl.getTelefono()+"',tiposervicio='"+cl.getTipoServicio()+"',fecha='"+cl.getFecha()+"',mensaje='"+cl.getMensaje()+"'where razonsocial="+cl.getRazonSocial();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

   
    @Override
    public boolean eliminar(int idCliente) {
       {
        String sql="delete from cliente where idcliente="+idCliente;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    }

    @Override
    public List listarCompletos() {
         ArrayList<Cliente>list=new ArrayList<>();
        String sql="SELECT `idcliente`, `persona_idpersona`, `razonsocial`, `nit`, cliente.direccion, cliente.telefono, `tiposervicio`, `fecha`, `mensaje`, `estado`, persona.email FROM persona, cliente WHERE estado='completado' and persona_idpersona=persona.idpersona";

        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Cliente cl=new Cliente();
                cl.setIdCliente(rs.getInt("idcliente"));
                cl.setPersona_IdPersona(rs.getInt("persona_idpersona"));
                cl.setRazonSocial(rs.getString("razonsocial"));
                cl.setNit(rs.getString("nit"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setTipoServicio(rs.getString("tiposervicio"));
                cl.setFecha(rs.getString("fecha"));
                cl.setMensaje(rs.getString("mensaje"));  
                cl.setEstado(rs.getString("estado"));
                cl.setEmail(rs.getString("persona.email"));
                
                list.add(cl);
            }
        }
        catch (SQLException e) {
            
        }
        return list;
    }

    @Override
    public Cliente listar(int id) {
        String sql="SELECT loire.factura.`idFactura`, loire.factura.valoruni, loire.factura.iva, loire.factura.costo, loire.cliente.razonsocial, loire.cliente.nit FROM loire.factura INNER JOIN loire.cliente ON loire.factura.`idCliente` = loire.cliente.idcliente where factura.idcliente="+id;
        try {
            PreparedStatement st;
            ResultSet rs;
            
            st=cn.con.prepareStatement(sql);
            rs=st.executeQuery();
            while(rs.next()){
                            
                cl.setIdFactura(rs.getInt("idFactura"));
                cl.setValoruni(rs.getFloat("valoruni"));
                cl.setIva(rs.getFloat("iva"));
                cl.setCosto(rs.getFloat("costo"));
                cl.setRazonsocial(rs.getString("razonsocial"));
                cl.setNit(rs.getString("nit"));
                
            }
        } catch (SQLException e) {
        }
        return cl;
    }

    @Override
    public void solicitud(int idcliente, String descripcion, String tipo){
        conexion cn=new conexion();
        Connection con=cn.getConnection();
        PreparedStatement st;
        ResultSet rs;
        try{
            st=con.prepareStatement("INSERT INTO `notificacion`(`TipoNoti`, `idcliente`, `descripcion`, `estado`, `estado1`)VALUES (?,?,?,1,1)");
            st.setString(1, tipo);
            st.setInt(2, idcliente);
            st.setString(3, descripcion);
            
            st.execute();
            con.close();
        } catch(SQLException e){
            
        }
    }
        
    }
    
