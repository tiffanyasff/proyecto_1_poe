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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.Jugador;

public class VentanaPrincipal {
    private JFrame ventana;
    private JTextField campoNombre;
    private JButton btnIniciarJuego;
    private JLabel btnInstrucciones;
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
        etqNombre.setBounds(225, 1, 280, 200);
        etqNombre.setFont(comicSansFont);
        panel.add(etqNombre);

        etqTitulo = new JLabel("Pon a prueba tu capacidad visual ");
        etqTitulo.setBounds(150, -60, 450, 200);
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
        
        
        campoNombre = new JTextField();
        campoNombre.setBounds(270, 150, 180, 40);
        campoNombre.setFont(comicSansFont);
        panel.add(campoNombre);
        
        
        btnIniciarJuego = new JButton("¡Vamos a jugar!");
        btnIniciarJuego.setFont(comicSansFont);
        btnIniciarJuego.setBounds(210, 215, 300, 60);
        btnIniciarJuego.setBackground(new Color(255, 165, 0)); 
        btnIniciarJuego.setForeground(Color.WHITE); 
        panel.add(btnIniciarJuego);
        
        
        
        ImageIcon img = new ImageIcon("img/boton_instrucciones.png");
        btnInstrucciones = new JLabel();
        btnInstrucciones.setBounds(1, 290, 220, 70);
        btnInstrucciones.setIcon(new ImageIcon(img.getImage().getScaledInstance(btnInstrucciones.getWidth(), btnInstrucciones.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnInstrucciones);
        
        btnInstrucciones.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
            
            JOptionPane.showMessageDialog(null, "En este juego desarrollarás tu capacidad visual, consiste en hallar la figura de tamaño correcto.\n\n"
                + "- Para empezar, familiarízate con la ventana, observa que tenemos 4 figuras.\n"
                + "- La figura que está antes de la línea vertical es la figura de muestra, tendrás que guiarte con esa.\n"
                + "- Las otras tres figuras que están después de la línea vertical son las opciones que tendrás disponibles.\n"
                + "- Escoge la figura que sea de igual tamaño que la figura de la muestra.\n"
                + "- Si lo haces de manera correcta, las figuras cambiarán y pasarás de ronda.\n"
                + "- Cuando quieras dejar de jugar, se te mostrará un resumen de tus aciertos y cuántas rondas lograste completar.");
            }
        });
        
        btnIniciarJuego.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                Jugador jugador = new Jugador(campoNombre.getText());
                jugador.getNombre();
                VentanaDeJuego ventanaJuego = new VentanaDeJuego();
                ventana.dispose();
            }
        });
        
        
        

        ventana.add(panel);
        ventana.setVisible(true);
    }
}


