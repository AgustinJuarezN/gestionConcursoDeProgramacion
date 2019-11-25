package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import utils.ArchivoGrabacion;
import utils.ArchivoLectura;
import utils.Helpers;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public final class Sistema extends Observable implements Serializable {

    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Docente> docentes;
    private ArrayList<Equipo> equipos;
    private ArrayList<Problema> problemas;
    private ArrayList<String> lenguajes;
    private ArrayList<Envio> envios;
    private final Helpers helper;

    public Sistema() {
        this.estudiantes = new ArrayList<>();
        this.docentes = new ArrayList<>();
        this.equipos = new ArrayList<>();
        this.problemas = new ArrayList<>();
        this.lenguajes = new ArrayList<>();
        this.envios = new ArrayList<>();
        this.helper = new Helpers();

        // LENGUAJES
        this.agregarLenguaje("JAVA");
        this.agregarLenguaje("C++");
        this.agregarLenguaje("PYTHON");
    }

    public ArrayList<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(ArrayList<Envio> envios) {
        this.envios = envios;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Problema> getProblemas() {
        return problemas;
    }

    public Helpers getHelper() {
        return helper;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public ArrayList<String> getLenguajes() {
        return lenguajes;
    }

    public boolean agregarObjeto(Object o, ArrayList<Object> lista) {
        boolean seAgrego = false;
        if (!lista.contains(o)) {
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
            setChanged();
            notifyObservers();
        }
        return estudiante;
    }

    public boolean agregarDocente(Docente d) {
        boolean docente = false;
        if (!docentes.contains(d)) {
            docentes.add((Docente) d);
            docente = true;
            setChanged();
            notifyObservers();
        }
        return docente;
    }

    public boolean agregarEquipo(Equipo eq) {
        boolean seCreo = false;
        if (!equipos.contains(eq)) {
            equipos.add((Equipo) eq);
            seCreo = true;
            setChanged();
            notifyObservers();
        }
        return seCreo;
    }

    public boolean agregarProblema(Problema pro) {
        boolean seCreo = false;
        if (!problemas.contains(pro)) {
            problemas.add((Problema) pro);
            seCreo = true;
            setChanged();
            notifyObservers();
        }
        return seCreo;
    }

    public boolean agregarEnvio(Envio env) {
        boolean seCreo = false;
        if (!envios.contains(env)) {
            envios.add((Envio) env);
            seCreo = true;
            setChanged();
            notifyObservers();
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

    public Equipo getEquipoPorNombre(String nombre) {
        Equipo eq = null;
        for (Equipo equipo : this.getEquipos()) {
            if (equipo.getNombre().equals(nombre)) {
                eq = equipo;
            }
        }
        return eq;
    }

    public String getLenguajePorIndex(int index) {
        return this.getLenguajes().get(index);
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

    public ArrayList<Estudiante> getEstudiantesSinEquipo() {
        ArrayList<Estudiante> list = new ArrayList<>();
        boolean esta = false;
        for (int i = 0; i < this.getEstudiantes().size(); i++) {
            esta = false;
            Estudiante est = this.getEstudiantes().get(i);
            for (Equipo eq : this.getEquipos()) {
                if (eq.getIntegrantes().contains(est)) {
                    esta = true;
                }
            }
            if (!esta) {
                list.add(est);
            }
        }

        return list;
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
        ArrayList<String> errorLineas = new ArrayList<>();
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

    public boolean equipoResolvioProblema(Equipo eq, Problema pro) {
        boolean resolvio = false;

        for (Envio env : this.getEnvios()) {
            if (env.getEquipo().equals(eq) && env.getProblema().equals(pro)) {
                if (env.getResolvio()) {
                    resolvio = true;
                }
            }
        }

        return resolvio;
    }

    public ArrayList<Envio> getEnviosPorProblemaYEquipo(Equipo eq, Problema pro) {
        ArrayList<Envio> list = new ArrayList<>();
        for (Envio env : this.getEnvios()) {
            if (env.getEquipo().equals(eq) && env.getProblema().equals(pro)) {
                list.add(env);
            }
        }
        return list;
    }

    public int[] infoEquipoPorProblema(Equipo eq, Problema pro) {
        int info[] = new int[4];
        int tiempo = 0;
        int multas = 0;
        int resolvio = 0;
        int intentos = 0;

        //tiempo y si resolvio el problema
        for (Envio env : this.getEnvios()) {
            if (env.getEquipo().equals(eq) && env.getProblema().equals(pro)) {
                intentos++;
                tiempo = +env.getTiempo();
                if (env.getResolvio()) {
                    resolvio = 1;
                }
            }
        }

        //Multas del equipo por ese problema
        for (Problema prob : eq.getMultas()) {
            if (prob.equals(pro)) {
                multas++;
            }
        }

        info[0] = resolvio;
        info[1] = tiempo;
        info[2] = multas;
        info[3] = intentos;
        return info;
    }

    public int menorTiempoEnResolverProblema(Problema p) {
        int menorTiempo = Integer.MAX_VALUE;

        for (Envio env : this.getEnvios()) {
            if (env.getProblema().equals(p) && env.getResolvio()) {
                if (env.getTiempo() < menorTiempo) {
                    menorTiempo = env.getTiempo();
                }
            }
        }

        if (menorTiempo == Integer.MAX_VALUE) {
            menorTiempo = 0;
        }

        return menorTiempo;
    }

    public String[][] getEstadisticas() {
        String[][] estadisticas = new String[this.getProblemas().size()][3];
        int cant;
        for (int i = 0; i < this.getProblemas().size(); i++) {
            Problema p = this.getProblemas().get(i);
            estadisticas[i][0] = p.getTitulo();
            cant = 0;
            for (Envio env : this.getEnvios()) {
                if (env.getProblema().equals(p) && env.getResolvio()) {
                    cant++;
                }
            }
            estadisticas[i][1] = Integer.toString(cant);
            estadisticas[i][2] = Integer.toString(this.menorTiempoEnResolverProblema(p));
        }

        return estadisticas;
    }

    public boolean existeEquipoNombre(String nombre) {
        boolean existe = false;
        for (Equipo eq : this.getEquipos()) {
            if (eq.getNombre().equals(nombre)) {
                existe = true;
            }
        }
        return existe;
    }

    public boolean evitarLinea(int linea) {
        boolean evitar = false;
        ArchivoLectura arch = new ArchivoLectura("Inconsistencias");

        while (arch.hayMasLineas()) {
            if (Character.getNumericValue(arch.linea().charAt(0)) == linea) {
                evitar = true;
            }
        }

        arch.cerrar();
        return evitar;
    }

    public boolean cargaGlobalEnvios(String path) {
        String[] linea;
        boolean seCargo = true;
        ArchivoLectura arch = new ArchivoLectura(path);
        ArchivoGrabacion result = new ArchivoGrabacion("Inconsistencias.txt");
        int countLinea = 0;
        while (arch.hayMasLineas()) {
            countLinea++;
            if (!this.evitarLinea(countLinea)) {
                linea = arch.linea().split("#");
                System.out.println(java.util.Arrays.toString(arch.linea().split("#")));
                if (linea.length == 5) {
                    Equipo eq = this.getEquipoPorNombre(linea[0]);
                    Problema prob = this.getProblemaPorTitulo(linea[2]);
                    if (eq != null && prob != null) {
                        int tiempo = Integer.parseInt(linea[3]);
                        String lenguaje = linea[1].trim();
                        boolean resolvio = linea[4].contains("ok");
                        String descripcion = linea[4];
                        try {
                            this.agregarEnvio(new Envio(eq, prob, tiempo, lenguaje, "", resolvio, descripcion));

                        } catch (Exception e) {
                        }
                    } else {
                        result.grabarLinea(countLinea + " - " + linea[0]);
                    }
                }
            }
        }
        arch.cerrar();
        result.cerrar();
        return seCargo;
    }

    @Override
    public String toString() {
        return "Sistema{" + "estudiantes=" + estudiantes + ",\n docentes=" + docentes + ",\n  equipos=" + equipos + ",\n  problemas=" + problemas + ",\n  lenguajes=" + lenguajes + '}';
    }

}
