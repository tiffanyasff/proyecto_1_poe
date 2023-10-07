/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author pablo
 */

/*
Pablo Becerrra G. - 2243506 - pablo.becerra@correounivalle.edu.co
Tiffany Torres F. - 2241747 - tiffany.torre@correounivalle.edu.do

Fundamentos de programacion orientada a eventos

*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
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
        ventana.setSize(700, 440);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        panel = new JPanel();
        panel.setLayout(null);

        Color fondoAzulClaro = new Color(245, 245, 220);
        panel.setBackground(fondoAzulClaro);

       Font comicSansFont = new Font("Comic Sans MS", Font.PLAIN, 28);
       

        // label de el nombre del jugador
        etqNombre = new JLabel("Nombre del jugador: ");
        etqNombre.setBounds(225, 1, 280, 200);
        etqNombre.setFont(comicSansFont);
        panel.add(etqNombre);

        
        // etiqueta para el titulo 
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
        
        
        // campo del el nombre
        campoNombre = new JTextField();
        campoNombre.setBounds(270, 150, 180, 40);
        campoNombre.setFont(comicSansFont);
        panel.add(campoNombre);
        
        
        // boton para iniciae juego
        btnIniciarJuego = new JButton("¡Vamos a jugar!");
        btnIniciarJuego.setFont(comicSansFont);
        btnIniciarJuego.setBounds(210, 215, 300, 60);
        btnIniciarJuego.setBackground(new Color(255, 165, 0)); 
        btnIniciarJuego.setForeground(Color.WHITE); 
        panel.add(btnIniciarJuego);
        
        
        
        // etiqueta para el boton de las instrucciones
        ImageIcon img = new ImageIcon("img/boton_instrucciones.png");
        btnInstrucciones = new JLabel();
        btnInstrucciones.setBounds(10, 315, 70, 70);
        btnInstrucciones.setIcon(new ImageIcon(img.getImage().getScaledInstance(btnInstrucciones.getWidth(), btnInstrucciones.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(btnInstrucciones);
        
        
        // escucha de el boton de instrucciones
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
        
        
        // escucha de el boton de iniciar juego
        btnIniciarJuego.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e) {
                String nombreJugador = campoNombre.getText().trim(); // Obtener el texto del campo de nombre sin espacios en blanco al principio y al final

                if (nombreJugador.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un nombre antes de jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Jugador jugador = new Jugador(nombreJugador);
                    jugador.getNombre();
                    System.out.println(jugador.getNombre());
                    VentanaDeJuego ventanaJuego = new VentanaDeJuego(jugador);
                    ventana.dispose();
                }
            }
        });
        
        
        

        ventana.add(panel);
        ventana.setVisible(true);
    }
}


