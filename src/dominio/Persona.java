package dominio;

import java.io.Serializable;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class Persona implements Serializable {

    private String nombre;
    private String ci;
    private String mail;

    public Persona(String nombre, String ci, String mail) {
        this.nombre = nombre;
        this.ci = ci;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getCi().equals(((Persona) obj).getCi());
    }
}
