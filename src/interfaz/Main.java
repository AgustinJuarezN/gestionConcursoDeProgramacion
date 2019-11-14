/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.*;
/**
 *
 * @author agustinjuarez
 */
public class Main {
    public static void main(String[] args) {
        Sistema modelo = new Sistema();
        VentanaPrincipal ventana = new VentanaPrincipal(modelo);
        ventana.setVisible(true);
    } 
}
