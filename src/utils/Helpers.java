/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dominio.*;
import java.util.ArrayList;

/**
 *
 * @author agustinjuarez
 */
public class Helpers {

    Sistema modelo;

    public Helpers(Sistema modelo) {
        this.modelo = modelo;
    }

    public Problema getProblemaPorTitulo(String titulo) {
        Problema pro = null;
        for (Problema problema : this.modelo.getProblemas()) {
            if (problema.getTitulo().equals(titulo)) {
                pro = problema;
            }
        }
        return pro;
    }

    public Docente getDocentePorCi(String ci) {
        Docente ret = null;
        for (Docente doc : this.modelo.getDocentes()) {
            if (doc.getCi().equals(ci)) {
                ret = doc;
            }
        }
        return ret;
    }

    public Estudiante getEstudianteCi(String ci) {
        Estudiante est = null;
        for (Estudiante estudiante : this.modelo.getEstudiantes()) {
            if (estudiante.getCi().equals(ci)) {
                est = estudiante;
            }
        }

        return est;
    }

    public int covertToNumber(String input) {
        int value = 0;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid value " + input);
        }

        return value;
    }

    public boolean lineaErrorDatos(String lineaComparar, String lineaModelo) {
        boolean lineaErrorDatos = false;
        String lineaAComparar = lineaComparar.trim().toLowerCase();
        String lModelo = lineaModelo.trim().toLowerCase();
        for (int i = 0; i < lineaAComparar.length() && !lineaErrorDatos; i++) {
            if (lineaAComparar.charAt(i) != lModelo.charAt(i)) {
                lineaErrorDatos = true;
            }
        }
        return lineaErrorDatos;
    }

    public ArrayList<String> compareArchives(String linkArchivoEquipo, String linkArchivoProblema) {
        ArrayList<String> errorLineas  = new ArrayList<>();
        ArchivoLectura archivoEquipo = new ArchivoLectura(linkArchivoEquipo);
        ArchivoLectura archivoProblema = new ArchivoLectura(linkArchivoProblema);

        boolean hayMasLineasArchEquipo = archivoEquipo.hayMasLineas();
        boolean hayMasLineasArchProblema = archivoProblema.hayMasLineas();

        while (hayMasLineasArchEquipo && hayMasLineasArchProblema) {
            if (!archivoEquipo.linea().equals(archivoProblema.linea())) {

                if (this.lineaErrorDatos(archivoEquipo.linea(), archivoProblema.linea())) {
                    errorLineas.add("d");
                } else {
                    errorLineas.add("f");
                }
            } else {
                errorLineas.add("ok");
            }
            hayMasLineasArchEquipo = archivoEquipo.hayMasLineas();
            hayMasLineasArchProblema = archivoProblema.hayMasLineas();
        }

        archivoEquipo.cerrar();
        archivoProblema.cerrar();
        
        return errorLineas;
    }

}
