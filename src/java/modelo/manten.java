
package modelo;

public class manten {
   int idmante, idconductor,idvehiculo, idsolicitud;

    public int getIdsolicitud() {
        return idsolicitud;
    }

    public void setIdsolicitud(int idsolicitud) {
        this.idsolicitud = idsolicitud;
    }

    public int getIdmante() {
        return idmante;
    }

    public void setIdmante(int idmante) {
        this.idmante = idmante;
    }
   String mecanico,taller,repiestos,danos,fechafin,fechain,estado;
   float valorre,valorrevi,valorto;

    public manten() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public manten(int idconductor, int idvehiculo, String mecanico, String taller, String repiestos, String danos, String fechafin, String fechain, float valorre, float valorrevi, float valorto,String estado) {
        this.idconductor = idconductor;
        this.idvehiculo = idvehiculo;
        this.mecanico = mecanico;
        this.taller = taller;
        this.repiestos = repiestos;
        this.danos = danos;
        this.fechafin = fechafin;
        this.fechain = fechain;
        this.valorre = valorre;
        this.valorrevi = valorrevi;
        this.valorto = valorto;
    }

    public int getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(int idconductor) {
        this.idconductor = idconductor;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getRepiestos() {
        return repiestos;
    }

    public void setRepiestos(String repiestos) {
        this.repiestos = repiestos;
    }

    public String getDanos() {
        return danos;
    }

    public void setDanos(String danos) {
        this.danos = danos;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getFechain() {
        return fechain;
    }

    public void setFechain(String fechain) {
        this.fechain = fechain;
    }

    public float getValorre() {
        return valorre;
    }

    public void setValorre(float valorre) {
        this.valorre = valorre;
    }

    public float getValorrevi() {
        return valorrevi;
    }

    public void setValorrevi(float valorrevi) {
        this.valorrevi = valorrevi;
    }

    public float getValorto() {
        return valorto;
    }

    public void setValorto(float valorto) {
        this.valorto = valorto;
    }
   
   
}
