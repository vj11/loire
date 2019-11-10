
package modelo;

public class vehiculo {
    int idvehiculo,idconductor,estado;
    String tipo,placa,modelo;

    public vehiculo() {
    }

    public vehiculo(int idvehiculo, int idconductor, int estado, String tipo, String placa, String modelo) {
        this.idvehiculo = idvehiculo;
        this.idconductor = idconductor;
        this.estado = estado;
        this.tipo = tipo;
        this.placa = placa;
        this.modelo = modelo;
    }

    public vehiculo(int idvehiculo, String modelo, String placa, String tipo, int idConductor, int estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public int getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(int idconductor) {
        this.idconductor = idconductor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
