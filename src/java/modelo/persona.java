/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class persona {
    int idpersona;
    String user;
    String password;
    String rol;
    String Dni;
    String nombres;
    String apellidos;
    String direccion;
    String telefono;
    String correoElectronico;
    String nombreUsuario;
    String contrasenaUsuario;
    int rol_idRol;
    int tipodoc_idTipoDoc;
    public persona(int idpersona, String Dni, String nombres, String apellidos,
            String direccion, String telefono,
            String correoElectronico,String nombreUsuario, 
            String contrasenaUsuario, int rol_idRol, int tipodoc_idTipoDoc){
        this.idpersona = idpersona;
        this.Dni = Dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.rol_idRol = rol_idRol;
        this.tipodoc_idTipoDoc = tipodoc_idTipoDoc;
    }

   
    public int getIdPersona() {
        return idpersona;
    }

    public void setIdPersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contraseñaUsuario) {
        this.contrasenaUsuario = contraseñaUsuario;
    }

    public int getRol_idRol() {
        return rol_idRol;
    }

    public void setRol_idRol(int rol_idRol) {
        this.rol_idRol = rol_idRol;
    }

    public int getTipodoc_idTipoDoc() {
        return tipodoc_idTipoDoc;
    }

    public void setTipodoc_idTipoDoc(int tipodoc_idTipoDoc) {
        this.tipodoc_idTipoDoc = tipodoc_idTipoDoc;
    }
    
    public persona (){
    }
    public persona(String user,String password,String rol){
        
        this.user=user;
        this.password=password;
        this.rol=rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public String getrol() {
        return rol;
    }

    public void setrol(String rol) {
        this.rol = rol;
    }

   

}

    