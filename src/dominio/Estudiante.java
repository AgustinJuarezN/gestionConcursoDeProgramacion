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
public class Estudiante extends Persona {
    
    private String numero;
    private String semestre;
    
    public Estudiante(String nombre, String ci, String mail,String numero,String semestre) {
        super(nombre, ci, mail);
        this.numero = numero;
        this.semestre = semestre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
}
