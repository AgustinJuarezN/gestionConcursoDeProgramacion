/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dominio.Equipo;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class ordenacionCriterioResueltos implements Comparator<Equipo> {

    @Override
    public int compare(Equipo eq1, Equipo eq2) {
        return eq2.getEjerciciosResueltos() - eq1.getEjerciciosResueltos();
    }

}
