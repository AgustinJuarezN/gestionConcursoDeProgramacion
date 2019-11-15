/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import utils.ArchivoLectura;
import utils.Helpers;
/**
 *
 * @author agustinjuarez
 */
public final class Sistema implements Serializable {
    
    private  ArrayList<Estudiante> estudiantes;
    private  ArrayList<Docente> docentes;
    private  ArrayList<Equipo> equipos;
    private  ArrayList<Problema> problemas;
    private  ArrayList<String> lenguajes;
    private  transient Helpers helper;
    
    public Sistema() {
        this.estudiantes = new ArrayList<>();
        this.docentes = new ArrayList<>();
        this.equipos = new ArrayList<>();
        this.problemas = new ArrayList<>();
        this.lenguajes = new ArrayList<>();
        this.helper = new Helpers();
        
        this.recuperarSistema();
        
        // DATA EJEMPLO
        
        //EQUIPO
        Equipo equipo = new Equipo("Equipo1",this.estudiantes); // estudiantes viene del archivo serializable (3 estudiantes)
        this.agregarEquipo(equipo);
        
        // DOCENTES
        Docente d1 = new Docente("Docente1","48653479","docente1@gmail.com","2018");
        Docente d2 = new Docente("Docente2","48653474","docente2@gmail.com","2019");
        Docente d3 = new Docente("Docente3","48653472","docente3@gmail.com","2015");
        this.agregarDocente(d1);
        this.agregarDocente(d2);
        this.agregarDocente(d3);
        
        // LENGUAJES
        this.agregarLenguaje("JAVA");
        this.agregarLenguaje("C++");
        this.agregarLenguaje("PYTHON");
        
        //PROBLEMA
        Problema problema = new Problema("Flores","ejemplo flores problema",d1,"C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Obligatorio\\solucionProblemas\\Flores.txt");
        this.agregarProblema(problema);
    }

    public  ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    
    public  ArrayList<Problema> getProblemas() {
        return problemas;
    }
    
    public  Helpers getHelper() {
        return helper;
    }

    public  void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public  ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public  void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }
    
    public  ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    
    public  ArrayList<String> getLenguajes() {
        return lenguajes;
    }  

    private ArrayList<Estudiante> recuperarEstudiante(){
        ArrayList<Estudiante> lsEst = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream("Datos");
            ObjectInputStream datos = new ObjectInputStream(archivo);
            
            while(true){
                Estudiante e1 = (Estudiante)datos.readObject();
                lsEst.add(e1);
            }
            
        } catch (Exception e) {
            System.out.println("No hay mas objetos: " + e.getMessage());
        }
        return lsEst;
    }
    
    public boolean agregarObjeto (Object o, ArrayList<Object> lista) {
        boolean seAgrego = false;
        if(!lista.contains(o)) {
            lista.add(o);
            seAgrego = true;
        }
        return seAgrego;
    }

    public boolean agregarEstudiante(Estudiante e) {
        boolean estudiante = false;
        if (!estudiantes.contains(e)) {
            estudiantes.add((Estudiante) e);
            estudiante = true;
        }
        return estudiante;
    }
    
    public boolean agregarDocente(Docente d) {
        boolean docente = false;
        if (!docentes.contains(d)) {
            docentes.add((Docente) d);
            docente = true;
        }
        return docente;
    }
    
    public boolean agregarEquipo(Equipo eq) {
        boolean seCreo = false;
        if (!equipos.contains(eq)) {
            equipos.add((Equipo) eq);
            seCreo = true;
        }
        return seCreo;
    }
    
    public boolean agregarProblema(Problema pro) {
        boolean seCreo = false;
        if (!problemas.contains(pro)) {
            problemas.add((Problema) pro);
            seCreo = true;
        }
        return seCreo;
    }
    
    public boolean agregarLenguaje(String lang) {
        boolean seCreo = false;
        if (!lenguajes.contains(lang)) {
            lenguajes.add(lang);
            seCreo = true;
        }
        return seCreo;
    }
    
     public Problema getProblemaPorTitulo(String titulo) {
        Problema pro = null;
        for (Problema problema : this.getProblemas()) {
            if (problema.getTitulo().equals(titulo)) {
                pro = problema;
            }
        }
        return pro;
    }

    public Docente getDocentePorCi(String ci) {
        Docente ret = null;
        for (Docente doc : this.getDocentes()) {
            if (doc.getCi().equals(ci)) {
                ret = doc;
            }
        }
        return ret;
    }

    public Estudiante getEstudianteCi(String ci) {
        Estudiante est = null;
        for (Estudiante estudiante : this.getEstudiantes()) {
            if (estudiante.getCi().equals(ci)) {
                est = estudiante;
            }
        }

        return est;
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
    
    public void recuperarSistema(){
        try {
            FileInputStream archivo = new FileInputStream("Datos");
            ObjectInputStream datos = new ObjectInputStream(archivo);

            Sistema sistemaGuardado = (Sistema)datos.readObject();
            System.out.println("encontró el sistema guardado:");
            this.setEstudiantes(sistemaGuardado.getEstudiantes());
            System.out.println(sistemaGuardado);
              
        } catch (Exception e) {
            System.out.println("No hay mas objetos: " + e.getMessage());
        }
    }
    
     @Override
    public String toString() {
        return "Sistema{" + "estudiantes=" + estudiantes + ",\n docentes=" + docentes + ",\n  equipos=" + equipos + ",\n  problemas=" + problemas + ",\n  lenguajes=" + lenguajes + '}';
    }
    
}
