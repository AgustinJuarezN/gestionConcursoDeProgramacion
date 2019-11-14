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
public class Problema {
    
    private String titulo;
    private String descripcion;
    private Docente responsable;
    private String link;
    
    public Problema(String titulo, String descripcion, Docente responsable, String link) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.link = link;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Docente getResponsable() {
        return responsable;
    }

    public void setResponsable(Docente responsable) {
        this.responsable = responsable;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
     @Override
    public boolean equals(Object obj) {
        return this.getTitulo().equals(((Problema) obj).getTitulo());
    }
    
    @Override
    public String toString() {
        return titulo;
    }
}
