package interfaz;

import dominio.*;
import utils.Helpers;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class Main {

    public static void main(String[] args) {
        Helpers helper = new Helpers();
        Sistema modelo = helper.recuperarSistema();
        VentanaPrincipal ventana = new VentanaPrincipal(modelo);
        ventana.setVisible(true);
    }
}
