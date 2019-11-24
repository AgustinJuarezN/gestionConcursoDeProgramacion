/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author agustinjuarez
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
    
     public Sistema recuperarSistema(){
        Sistema sistemaGuardado = new Sistema();
        try {
            FileInputStream archivo = new FileInputStream("Datos");
            ObjectInputStream datos = new ObjectInputStream(archivo);

            sistemaGuardado = (Sistema)datos.readObject();
            System.out.println("encontró el sistema guardado");
            System.out.println(sistemaGuardado.getEstudiantes());
              
        } catch (Exception e) {
            System.out.println("No hay mas objetos: " + e.getMessage());
        }
        return sistemaGuardado;
    }
     
     public void guardarSistema(Sistema modelo) {
         try {
            FileOutputStream archivo = new FileOutputStream("Datos");
            ObjectOutputStream out = new ObjectOutputStream(archivo);
            out.writeObject(modelo);
             System.out.println("Sistema al guardar:--->"+modelo);
            out.close();
        } catch (IOException e){
        }           
     }

}
