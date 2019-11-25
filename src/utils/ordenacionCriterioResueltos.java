package utils;

import dominio.Equipo;
import java.util.*;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class ordenacionCriterioResueltos implements Comparator<Equipo> {

    @Override
    public int compare(Equipo eq1, Equipo eq2) {
        return eq2.getEjerciciosResueltos() - eq1.getEjerciciosResueltos();
    }

}
