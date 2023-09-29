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
import logica.JuegoAdivinarFig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.IOException;
import javax.imageio.ImageIO;


public class VentanaDeJuego extends JFrame implements ActionListener {
    private JuegoAdivinarFig juego; 
    private JFrame ventanaJuego;
    private JButton btnUno;
    private JButton btnDos;
    private JButton  btnTres;
    private JButton   btnCuatro;
    private ImageIcon im;
    //private Icon i ;
    
    public VentanaDeJuego(){
        ventanaJuego = new JFrame("Juego");
        ventanaJuego.setSize(700, 400);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        juego = new JuegoAdivinarFig();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        im = new ImageIcon("circulo.png");
        btnUno = new JButton();
        btnUno.setBounds(50, 150, 100, 100);
        panel.add(btnUno);
        btnUno.setEnabled(true);
        
        btnDos = new JButton();
        btnDos.setBounds(220, 150, 100, 100);
        panel.add(btnDos);
        
        
        btnTres = new JButton("boton tres");
        btnTres.setBounds(390, 150, 100, 100);
        panel.add( btnTres);
        
        btnCuatro = new JButton("boton tres");
        btnCuatro.setBounds(560, 150, 100, 100);
        panel.add( btnCuatro);
        
        
        
        ventanaJuego.add(panel);
        ventanaJuego.setVisible(true);
        
        
    }
    
    private void asignarValoresAleatorios() {
        Random random = new Random();
        btnUno.setText(String.valueOf(random.nextInt(3) + 1));
        btnDos.setText(String.valueOf(random.nextInt(3) + 1));
        btnTres.setText(String.valueOf(random.nextInt(3) + 1));
        btnCuatro.setText(String.valueOf(random.nextInt(3) + 1));
    }
    
    private ImageIcon cargarImagen(String nombreArchivo) {
        return new ImageIcon(getClass().getResource(nombreArchivo));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton) e.getSource();

        
        asignarValoresAleatorios();
    }
}
