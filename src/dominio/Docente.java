/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author agustinjuarez
 */
public class Docente extends Persona {
    
    public String añoIngreso;
    
    public Docente(String nombre, String ci, String mail,String añoIngreso) {
        super(nombre, ci, mail);
        this.añoIngreso = añoIngreso;
    }

    public String getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(String añoIngreso) {
        this.añoIngreso = añoIngreso;
    }
    
}
