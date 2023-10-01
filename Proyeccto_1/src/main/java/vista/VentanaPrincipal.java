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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JFrame ventana;
    private JTextField campoNombre;
    private JButton btnIniciarJuego;
    private JButton btnInstrucciones;
    private JLabel etqNombre; 
    private JLabel etqTitulo; 
    private JPanel panel;
    private Color[] rainbowColors = {
            Color.RED, Color.ORANGE, Color.YELLOW,
            Color.GREEN, Color.BLUE, Color.MAGENTA
    };
    private int currentColorIndex = 0;
    
    
    
    public VentanaPrincipal(){
        ventana = new JFrame("Juego Preescolar");
        ventana.setSize(700, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        Color fondoAzulClaro = new Color(173, 216, 230);
        panel.setBackground(fondoAzulClaro);

        Font comicSansFont = new Font("Comic Sans MS", Font.PLAIN, 28);

        etqNombre = new JLabel("Nombre del jugador: ");
        etqNombre.setBounds(250, -20, 280, 200);
        etqNombre.setFont(comicSansFont);
        panel.add(etqNombre);

        etqTitulo = new JLabel("Pon a prueba tu capacidad visual ");
        etqTitulo.setBounds(150, -60, 280, 200);
        etqTitulo.setFont(comicSansFont);
        panel.add(etqTitulo);
        
        Timer rainbowTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                etqTitulo.setForeground(rainbowColors[currentColorIndex]);
                currentColorIndex = (currentColorIndex + 1) % rainbowColors.length;
            }
        });
        rainbowTimer.start();

        ventana.add(panel);
        ventana.setVisible(true);
    }
}


