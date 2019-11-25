package dominio;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class Docente extends Persona {

    private String añoIngreso;

    public Docente(String nombre, String ci, String mail, String añoIngreso) {
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
