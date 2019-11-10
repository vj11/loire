
package modelo;

public class ruta {
    int idRuta,idValServicio,idVehiculo,idConductor, estado;
    String Vehiculo,Conductor;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    String direccion,fecha;
    String conductor,vehiculo;

    public ruta(int idconductor, int idvehiculo, int idservicio, String direccion,String date) {
       this.idConductor = idconductor;
       this.direccion = direccion;
       this.idVehiculo = idvehiculo;
       this.idValServicio = idservicio;
       this.fecha = date;
       
    }

    public ruta(String direccion, String date, int idconductor, int idservicio, int idvehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public ruta() {
    }

    public ruta(int idRuta, int idValServicio, int idVehiculo, int idConductor, String direccion, String fecha, String vehiculo, String conductor) {
        this.idRuta = idRuta;
        this.idValServicio = idValServicio;
        this.idVehiculo = idVehiculo;
        this.idConductor = idConductor;
        this.direccion = direccion;
        this.fecha = fecha;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public int getIdValServicio() {
        return idValServicio;
    }

    public void setIdValServicio(int idValServicio) {
        this.idValServicio = idValServicio;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    
}
