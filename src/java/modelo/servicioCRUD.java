/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.List;
import modelo.ClienteDAO;
import modelo.Cliente;
import java.util.List;

/**
 *
 
 */
public interface servicioCRUD {
    public List listar();
    public Cliente list(int idcliente);
    public boolean add(Cliente cl);
    public boolean edit(Cliente cl);
    public boolean eliminar(int idcliente);
    public List listarCompletos();
    public Cliente listar(int idcliente);
    public void solicitud(int idcliente, String descripcion, String tipo);
}
