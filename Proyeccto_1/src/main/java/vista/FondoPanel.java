/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author USER CT
 */

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class FondoPanel extends JPanel {
    
    private ImageIcon imagen;

    public FondoPanel() {
        // Obtiene la URL de la imagen en la raíz del proyecto
        URL imageURL = getClass().getResource("fondoVentana.jpg");
        
        // Crea un ImageIcon con la URL de la imagen
        imagen = new ImageIcon(imageURL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Dibuja la imagen en el panel
        if (imagen != null) {
            g.drawImage(imagen.getImage(), 0, 0, this);
        }else{
            System.out.println("a");
        }
        
    }
}
