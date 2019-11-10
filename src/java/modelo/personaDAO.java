
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 

public class personaDAO implements CRUD{
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    persona per=new persona();
    
        
    @Override
    public List listar() {
        ArrayList<persona>list=new ArrayList<>();
        String sql="select * from persona";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                persona per=new persona();
                per.setIdPersona(rs.getInt("idpersona"));
                per.setDni(rs.getString("Dni"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreoElectronico(rs.getString("correoElectronico"));
                per.setNombreUsuario(rs.getString("nombreUsuario"));
                per.setContrasenaUsuario(rs.getString("contrasenaUsuario"));
                per.setRol_idRol(rs.getInt("rol_idRol"));
                per.setTipodoc_idTipoDoc(rs.getInt("tipodoc_idTipoDoc"));
                
                
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public persona list(int idPersona) {
        String sql="select * from persona where idpersona="+idPersona;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                per.setIdPersona(rs.getInt("idpersona"));
                per.setDni(rs.getString("Dni"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                per.setCorreoElectronico(rs.getString("correoElectronico"));
                per.setNombreUsuario(rs.getString("nombreUsuario"));
                per.setContrasenaUsuario(rs.getString("contrasenaUsuario"));
                per.setRol_idRol(rs.getInt("rol_idRol"));
                per.setTipodoc_idTipoDoc(rs.getInt("tipodoc_idTipoDoc"));
                
            }
        } catch (Exception e) {
        }
        return per;
    }

    @Override
    public boolean add(persona per) {
       String sql="INSERT INTO `persona`(`Dni`, `nombres`, `apellidos`, `direccion`, `telefono`, `correoElectronico`,`nombreUsuario`,`contrasenaUsuario`, `rol_idRol`, `tipodoc_idTipoDoc`)values('"+per.getDni()+"','"+per.getNombres()+"','"+per.getApellidos()+"','"+per.getDireccion()+"','"+per.getTelefono()+"','"+per.getCorreoElectronico()+"','"+per.getNombreUsuario()+"','"+per.getContrasenaUsuario()+"','"+per.getRol_idRol()+"','"+per.getTipodoc_idTipoDoc()+"');";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(persona per) {
        String sql="update persona set Dni='"+per.getDni()+"',nombres='"+per.getNombres()+"',apellidos='"+per.getApellidos()+"',direccion='"+per.getDireccion()+"',telefono='"+per.getTelefono()+"',correoElectronico='"+per.getCorreoElectronico()+"',nombreUsuario='"+per.getNombreUsuario()+"',contrasenaUsuario='"+per.getContrasenaUsuario()+"',rol_idRol='"+per.getRol_idRol()+"',tipodoc_idTipoDoc='"+per.getTipodoc_idTipoDoc()+"'where idpersona="+per.getIdPersona();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idPersona) {
        String sql="delete from persona where idpersona="+idPersona;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    @Override
    public int validar(persona per){
        int r=0;
        String sql="select*from persona where nombreUsuario=? and contrasenaUsuario=? and rol_idRol=?";
    try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.setString(1, per.getUser());
        ps.setString(2, per.getPassword());
        ps.setString(3, per.getrol());
        rs=ps.executeQuery();
        while (rs.next()){
           r=r+1;
           per.setUser(rs.getString("nombreUsuario"));
           per.setPassword(rs.getString("contrasenaUsuario"));
           per.setrol(rs.getString("rol_idRol"));
           }
        if(r==1){
        return 1;
        }
        else{
        return 0;
        }
    }catch(Exception e){
        return 0;
            }
    } 
    @Override
    public ResultSet notificacionesAdmin() {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            st=cn.con.prepareStatement("SELECT `idnoti`, `TipoNoti`, `idconductor`, `idvehiculo`, `idcliente`, `idservicio`, `idruta`, `descripcion`, `estado`, `estado1` FROM `notificacion` WHERE estado1=1");
            rs=st.executeQuery();
        } catch (SQLException e) {
        }
        return rs;
    }
    
}
