package dominio;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class Estudiante extends Persona {

    private String numero;
    private String semestre;

    public Estudiante(String nombre, String ci, String mail, String numero, String semestre) {
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
