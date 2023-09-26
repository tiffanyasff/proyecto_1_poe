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
    private Icon i ;
    
    public VentanaDeJuego(){
        ventanaJuego = new JFrame("Juego");
        ventanaJuego.setSize(700, 400);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        juego = new JuegoAdivinarFig();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));

        btnUno.setBounds(10, 10, 10, 10);
        im = new ImageIcon("circulo.png");
        i = new ImageIcon(im.getImage().getScaledInstance(btnUno.getWidth(), btnUno.getHeight(),Image.SCALE_DEFAULT));
        btnDos.setIcon(i);
        
        btnUno = new JButton("boton uno");
        panel.add(btnUno);
        btnUno.setEnabled(false);
        
        btnDos = new JButton(im);
        panel.add(btnDos);
        
        
        btnTres = new JButton("boton tres");
        panel.add( btnTres);
        
        btnCuatro = new JButton("boton tres");
        panel.add( btnCuatro);
        
        
        //btnUno.addActionListener(this);
        //btnDos.addActionListener(this);
        //btnTres.addActionListener(this);
        //btnCuatro.addActionListener(this);
        
        ventanaJuego.add(panel);
        ventanaJuego.setVisible(true);
        
        //btnUno.setIcon(cargarImagen("src/img/circulo.png"));
        //btnDos.setIcon(cargarImagen("src/img/circulo.png"));
        //btnTres.setIcon(cargarImagen("src/img/circulo.png"));
        //btnCuatro.setIcon(cargarImagen("src/img/circulo.png"));
        
        
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
