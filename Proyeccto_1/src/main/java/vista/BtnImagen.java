/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author pablo
 */



import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BtnImagen extends JButton {
    private BufferedImage imagenFondo;

    public BtnImagen(String rutaImagen) {
        try {
            imagenFondo = ImageIO.read(getClass().getResource(rutaImagen));
        } catch (IOException e) {
            System.out.println("ocurrio un error aca");
            e.printStackTrace();
            
        }

        setPreferredSize(new Dimension(imagenFondo.getWidth(), imagenFondo.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, null);
    }
}
