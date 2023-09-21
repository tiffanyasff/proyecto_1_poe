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

public class VentanaDeJuego {
    private JFrame ventanaJuego;
    private JButton btnUno;
    private JButton btnDos;
    private JButton  btnTres;
    private JButton   btnCuatro;
    
    public VentanaDeJuego(){
        ventanaJuego = new JFrame("Juego");
        ventanaJuego.setSize(700, 400);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        // Etiqueta y campo de texto para ingresar el nombre 
        
        btnUno = new JButton("boton uno");
        panel.add(btnUno);
        
        btnDos = new JButton("boton dos");
        panel.add(btnDos);
        
        
        
        btnTres = new JButton("boton tres");
        panel.add( btnTres);
        
         btnCuatro = new JButton("boton 4");
        panel.add( btnCuatro);
        
        
        ventanaJuego.add(panel);
        ventanaJuego.setVisible(true);
    }
}
