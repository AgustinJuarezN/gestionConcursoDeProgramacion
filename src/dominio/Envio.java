/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Envio implements Serializable {
    
    private Equipo equipo;
    private Problema problema;
    private int tiempo;
    private String lenguaje;
    private String linkSolucion;
    private String resultado;
    
    public Envio(Equipo equipo, Problema problema, int tiempo, String lenguaje, String linkSolucion, String resultado) {
        this.equipo = equipo;
        this.problema = problema;
        this.tiempo = tiempo;
        this.lenguaje = lenguaje;
        this.linkSolucion = linkSolucion;
        this.resultado = resultado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Problema getProblema() {
        return problema;
    }

    public void setProblema(Problema problema) {
        this.problema = problema;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getLinkSolucion() {
        return linkSolucion;
    }

    public void setLinkSolucion(String linkSolucion) {
        this.linkSolucion = linkSolucion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    @Override
    public String toString() {
        return "Envio{" + "equipo=" + equipo + ", problema=" + problema + ", tiempo=" + tiempo + ", lenguaje=" + lenguaje + ", linkSolucion=" + linkSolucion + ", resultado=" + resultado + '}';
    }
}
