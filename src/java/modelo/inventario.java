
package modelo;

public class inventario {
    int idForm,id,estado,semana,mes;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    String tipo,generador;

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }
    float cantidad;

    public inventario( int id,int idForm, String tipo, float cantidad, String generador) {
        
        this.id = id;
        this.idForm = idForm;
        this.tipo = tipo;
        this.generador = generador;
        this.cantidad = cantidad;
    }

    public inventario(int idForm, String tipo,float cantidad, String generador) {
        this.idForm = idForm;
        this.tipo = tipo;
        this.generador = generador;
        this.cantidad = cantidad;
    }

    public inventario(int id) {
        this.id = id;
    }
   
    
    
    
    public inventario(){
        
    }

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getGenerador() {
        return generador;
    }

    public void setGenerador(String generador) {
        this.generador = generador;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
