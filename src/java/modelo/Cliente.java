/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 
 */
public class Cliente {
    private int idcliente;
    private int persona_idpersona;
    private String razonsocial;
    private String nit;
    private String direccion;
    private String telefono;
    private String tiposervicio;
    private String fecha;
    private String mensaje;
    private String estado;
    private String email;
    private float costo,iva,valoruni;
    private int idFactura;

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getValoruni() {
        return valoruni;
    }

    public void setValoruni(float valoruni) {
        this.valoruni = valoruni;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getPersona_idpersona() {
        return persona_idpersona;
    }

    public void setPersona_idpersona(int persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente(int idcliente,int persona_idpersona,String razonsocial, String nit, String direccion, 
            String telefono,String tiposervicio, String fecha, String mensaje) {
        this.idcliente = idcliente;
        this.persona_idpersona = persona_idpersona;
        this.razonsocial = razonsocial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tiposervicio = tiposervicio;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idcliente;
    }

    public void setIdCliente(int idcliente) {
        this.idcliente = idcliente;
    } 
    public int getPersona_IdPersona() {
        return persona_idpersona;
    }

    public void setPersona_IdPersona(int persona_idpersona) {
        this.persona_idpersona = persona_idpersona;
    } 
    public String getRazonSocial() {
        return razonsocial;
    }

    public void setRazonSocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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
    public String getTipoServicio() {
        return tiposervicio;
    }

    public void setTipoServicio(String tiposervicio) {
        this.tiposervicio = tiposervicio;
    }
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
