
package modelo;

/**
 *
 * @author sakur
 */
public class solicitudMante {
    String descrpcion;
    int conductor,vehiculo;

    public solicitudMante(String descrpcion, int conductor, int vehiculo) {
        this.descrpcion = descrpcion;
        this.conductor = conductor;
        this.vehiculo = vehiculo;
    }

    public solicitudMante() {
    }

    public String getDescrpcion() {
        return descrpcion;
    }

    public void setDescrpcion(String descrpcion) {
        this.descrpcion = descrpcion;
    }

    public int getConductor() {
        return conductor;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
}
