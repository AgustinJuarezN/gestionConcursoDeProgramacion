/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import utils.Helpers;
/**
 *
 * @author agustinjuarez
 */
public class Sistema implements Serializable {
    
    private static ArrayList<Estudiante> estudiantes;
    private static ArrayList<Docente> docentes;
    private static ArrayList<Equipo> equipos;
    private static ArrayList<Problema> problemas;
    private static ArrayList<String> lenguajes;
    private Helpers helper;
    
    public Sistema() {

        this.estudiantes = this.recuperarEstudiante();
        this.docentes = this.recuperarDocentes();
        this.equipos = new ArrayList<Equipo>();
        this.problemas = new ArrayList<Problema>();
        this.lenguajes = new ArrayList<String>();
        this.helper = new Helpers(this);
        
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
        Sistema.estudiantes = estudiantes;
    }

    public  ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public  void setDocentes(ArrayList<Docente> docentes) {
        Sistema.docentes = docentes;
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
    
    private ArrayList<Docente> recuperarDocentes(){
        ArrayList<Docente> lsDoc = new ArrayList<>();
        try {
            FileInputStream archivo = new FileInputStream("Datos");
            ObjectInputStream datos = new ObjectInputStream(archivo);
            
            while(true){
                Docente d = (Docente)datos.readObject();
                lsDoc.add(d);
            }
            
        } catch (Exception e) {
            System.out.println("No hay mas objetos: " + e.getMessage());
        }
        return lsDoc;
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
    
}
