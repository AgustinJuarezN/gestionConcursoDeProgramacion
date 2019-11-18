/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.*;
import utils.Helpers;
/**
 *
 * @author agustinjuarez
 */
public class Main {
    public static void main(String[] args) {
        Helpers helper = new Helpers();
        Sistema modelo = helper.recuperarSistema();
        if(modelo == null) {System.out.println("sistema vino null");}
        VentanaPrincipal ventana = new VentanaPrincipal(modelo);
        ventana.setVisible(true);
    } 
}
