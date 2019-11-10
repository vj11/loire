
package modelo;

import java.sql.ResultSet;
import modelo.persona;
import modelo.personaDAO;
import modelo.conexion;
import java.util.List;


public interface CRUD {
    public List listar();
    public persona list(int idpersona);
    public boolean add(persona per);
    public boolean edit(persona per);
    public boolean eliminar(int idpersona);
    public int validar(persona per);  
    public ResultSet notificacionesAdmin();
}
