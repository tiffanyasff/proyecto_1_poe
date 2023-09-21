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
    
    public VentanaPrincipal(){
        ventana = new JFrame("Juego Preescolar");
        ventana.setSize(700, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        // Etiqueta y campo de texto para ingresar el nombre
        JLabel etiquetaNombre = new JLabel("Nombre del Jugador:");
        etiquetaNombre.setHorizontalAlignment(SwingConstants.CENTER);
        Font fuente = etiquetaNombre.getFont();
        etiquetaNombre.setFont(new Font(fuente.getName(), Font.BOLD, 20)); 
        campoNombre = new JTextField();
        panel.add(etiquetaNombre);
        panel.add(campoNombre);
        
        
        
        btnIniciarJuego = new JButton("Iniciar Juego");
        panel.add(btnIniciarJuego);
        
        
        
        btnInstrucciones = new JButton("Instrucciones de Juego");
        panel.add(btnInstrucciones);
        
        
        ventana.add(panel);
        ventana.setVisible(true);
    }
}
