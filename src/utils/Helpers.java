package utils;

import dominio.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Agustín Juárez - 236487
 * @author Eduardo Thevenet - 168626
 */
public class Helpers implements Serializable {

    public int covertToNumber(String input) {
        int value = 0;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            System.out.println("Invalid value " + input);
        }

        return value;
    }

    public Sistema recuperarSistema() {
        Sistema sistemaGuardado = new Sistema();
        try {
            FileInputStream archivo = new FileInputStream("Datos");
            ObjectInputStream datos = new ObjectInputStream(archivo);

            sistemaGuardado = (Sistema) datos.readObject();

        } catch (Exception e) {
        }
        return sistemaGuardado;
    }

    public void guardarSistema(Sistema modelo) {
        try {
            FileOutputStream archivo = new FileOutputStream("Datos");
            ObjectOutputStream out = new ObjectOutputStream(archivo);
            out.writeObject(modelo);
            out.close();
        } catch (IOException e) {
        }
    }

    public boolean esNumero(String text) {
        boolean es = true;
        try {
            Integer.parseInt(text);
        } catch (Exception e) {
            es = false;
        }
        return es;
    }

}
