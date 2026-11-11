/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Geovanny_Callizo
 */


import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImagenUtil {

    public static void mostrarImagen(
            byte[] datos, JLabel etiqueta,
            int ancho, int alto) {

        if (datos == null || datos.length == 0) {
            etiqueta.setIcon(null);
            etiqueta.setText("Sin imagen");
            return;
        }

        ImageIcon icono = new ImageIcon(datos);

        Image imagen = icono.getImage()
                .getScaledInstance(
                        ancho, alto, Image.SCALE_SMOOTH);

        etiqueta.setIcon(new ImageIcon(imagen));
        etiqueta.setText("");
    }
}