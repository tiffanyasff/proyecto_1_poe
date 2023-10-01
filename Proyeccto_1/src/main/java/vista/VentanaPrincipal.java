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

public class VentanaPrincipal {
    private JFrame ventana;
    private JTextField campoNombre;
    private JButton btnIniciarJuego;
    private JButton btnInstrucciones;
    private JLabel etqNombre;   
    private JPanel panel;
    
    
    
    public VentanaPrincipal(){
        ventana = new JFrame("Juego Preescolar");
        ventana.setSize(700, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);
        
        
        etqNombre = new JLabel("Nombre del jugador: ");
        etqNombre.setBounds(50, 50, 280, 200);
        panel.add(etqNombre);
        
        ventana.add(panel);
        ventana.setVisible(true);
    }
}
