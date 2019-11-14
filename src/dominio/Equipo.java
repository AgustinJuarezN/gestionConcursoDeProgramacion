/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author agustinjuarez
 */
public class Equipo implements Serializable{
    
    private String nombre;
    private ArrayList<Estudiante> integrantes = new ArrayList<>();
    
    public Equipo(String nombre, ArrayList<Estudiante> integrantes) {
        this.nombre = nombre;
        this.integrantes = integrantes;
    }
    
    public boolean agregarIntegrante(Estudiante e) {
        boolean seAgrego = false;
        if (!integrantes.contains(e)) {
            integrantes.add((Estudiante) e);
            seAgrego = true;
        }
        return seAgrego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Estudiante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(ArrayList<Estudiante> integrantes) {
        this.integrantes = integrantes;
    }
    
     @Override
    public String toString() {
        return nombre+" "+integrantes;
    }
}
