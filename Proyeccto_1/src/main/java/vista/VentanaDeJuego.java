/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author USER CT
 */


/*
Pablo Becerrra G. - 2243506 - pablo.becerra@correounivalle.edu.co
Tiffany Torres F. - 2241747 - tiffany.torre@correounivalle.edu.do

Fundamentos de programacion orientada a eventos

*/
import javax.swing.*;
import java.awt.*;
import logica.JuegoAdivinarFig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import modelo.Figura;
import modelo.Jugador;





public class VentanaDeJuego extends JFrame implements ActionListener {
    private JuegoAdivinarFig juego; 
    private JFrame ventanaJuego;
    private Jugador jugador;
    private JLabel lblNombre;
    private JLabel lblNombreJugador;
    private JLabel lblSalir;
    private JLabel etqUno;
    private JLabel etqDos;
    private JLabel etqTres;
    private JLabel etqCuatro;
    private JLabel lblIntentos;
    private JLabel lblFallos;
    private JLabel separador;
    private JPanel panel;
    private JLabel lblRonda;
    private int ronda;
    private ArrayList<Figura> rondas;
    private ArrayList<Integer> opciones = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
    private int tamanoFiguraUno;
    private int tamanoFiguraDos;
    private int tamanoFiguraTres;
    private int tamanoFiguraCuatro;
    Random random = new Random();
    
    public VentanaDeJuego(Jugador jugadorActual){
        ventanaJuego = new JFrame("Juego");
        ventanaJuego.setSize(800, 500);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jugador = jugadorActual; 
        iniciarComponentes();
    }
    
 
    
    public void iniciarComponentes(){
        juego = new JuegoAdivinarFig();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 220));


        
        
        etqUno = new JLabel();
        etqDos = new JLabel();
        etqTres = new JLabel();
        etqCuatro = new JLabel();
        separador = new JLabel();
        lblSalir = new JLabel();
      
        
        //label de el nombre
        lblNombre = new JLabel("Nombre del jugador: " + jugador.getNombre());
        Font comicSansFont = new Font("Comic Sans MS", Font.PLAIN, 16);
        lblNombre.setFont(comicSansFont);
        lblNombre.setBounds(400, 10, 230, 22);
        panel.add(lblNombre);
        
        
        //Label de Intentos
        lblIntentos = new JLabel("Intentos: " + jugador.getIntentos());
        lblIntentos.setFont(comicSansFont);
        lblIntentos.setBounds(200, 420, 120, 22);
        panel.add(lblIntentos);
        
        
        //Label de Fallos
        lblFallos = new JLabel("Fallos: " + jugador.getIntentosFallados());
        lblFallos.setFont(comicSansFont);
        lblFallos.setBounds(400, 420, 120, 22);
        panel.add(lblFallos);
        
        
        // label de la ronda
        lblRonda = new JLabel("Ronda: " + jugador.getRonda());
        lblRonda.setBounds(200, 10, 80, 22);
        lblRonda.setFont(comicSansFont);
        panel.add(lblRonda);
        
        
        // label del boton salir
        lblSalir = new JLabel("salir");
        ImageIcon imagenSalir = new ImageIcon("img/salir.png");
        lblSalir.setBounds(700, 400, 50, 50);
        lblSalir.setIcon(new ImageIcon(imagenSalir.getImage().getScaledInstance(lblSalir.getWidth(), lblSalir.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lblSalir);
        
        
        //escucha de el boton salir 
        lblSalir.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            VentanaPrincipal ventanaP = new VentanaPrincipal();
            ventanaJuego.dispose();
        
            JOptionPane.showMessageDialog(null, 
            "intentos: " + jugador.getIntentos() + "\n" +
            "porcentaje de aciertos: " + jugador.porcentajeAciertos() + "\n" +
            "porcentaje de errores: " + jugador.porcentajeFallo()+ "\n" +
            "rondas: " + jugador.getRonda());
            
        }
        });
      
        // se asigna el arreglo de figuras a "rondas" 
        rondas = juego.obtenerFiguras();
        asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
        
        
        // escucha de la imagen 1
        etqUno.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String textoEtqUno = etqUno.getText();
        }
        });
        
        
        
        // escucha de la imagen 2
        etqDos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {            
           
            if (rondas.get(ronda).validarOpcion(tamanoFiguraDos)){
                reproducirSonidoCorrecto();
                jugador.sumarIntentos();
                jugador.sumarIntentosAcertados();
                jugador.sumarRonda();
                asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
                lblRonda.setText("Ronda: " + jugador.getRonda());
                lblIntentos.setText("Intentos: " + jugador.getIntentos());
                lblFallos.setText("Fallos: " + jugador.getIntentosFallados());
            }else {
                reproducirSonidoIncorrecto();
                jugador.sumarIntentos();
                jugador.sumarIntentosFallados();
                System.out.println("opcion incorrecta");
                lblIntentos.setText("Intentos: " + jugador.getIntentos());
                lblFallos.setText("Fallos: " + jugador.getIntentosFallados());
            }
        }
        });
        
        
        // escucha de la imagen 3
        etqTres.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {            
            
             if (rondas.get(ronda).validarOpcion(tamanoFiguraTres)){
                reproducirSonidoCorrecto();
                jugador.sumarIntentos();
                jugador.sumarIntentosAcertados();
                jugador.sumarRonda();
                asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
                lblRonda.setText("Ronda: " + jugador.getRonda());
                lblIntentos.setText("Intentos: " + jugador.getIntentos());
                lblFallos.setText("Fallos: " + jugador.getIntentosFallados());
            }else {
                reproducirSonidoIncorrecto();
                System.out.println("opcion incorrecta");
                jugador.sumarIntentos();
                jugador.sumarIntentosFallados();
                lblIntentos.setText("Intentos: " + jugador.getIntentos());
                lblFallos.setText("Fallos: " + jugador.getIntentosFallados());
            }
        }
        });
        
        
        // escucha de la imagen 4
        etqCuatro.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {          
                       
             if (rondas.get(ronda).validarOpcion(tamanoFiguraCuatro)){
                reproducirSonidoCorrecto();
                jugador.sumarIntentos();
                jugador.sumarIntentosAcertados();
                jugador.sumarRonda();
                asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
                lblRonda.setText("Ronda: " + jugador.getRonda());
                lblIntentos.setText("Intentos: " + jugador.getIntentos());
                lblFallos.setText("Fallos: " + jugador.getIntentosFallados());
            }else {
                reproducirSonidoIncorrecto();
                System.out.println("opcion incorrecta");
                jugador.sumarIntentos();
                jugador.sumarIntentosFallados();
                lblIntentos.setText("Intentos: " + jugador.getIntentos());
                lblFallos.setText("Fallos: " + jugador.getIntentosFallados());
            }
        }
        });
        
        
        ventanaJuego.add(panel);
        ventanaJuego.setVisible(true);
        
        
    }
    
    
    // en esta funcion se le agregan valores aleatorios entre 1 y 3 sin repetir a las imagenes 2,3 y 4 
    private void asignarValoresAleatorios() {
        ArrayList<Integer> valoresDisponibles = new ArrayList<>(Arrays.asList(1, 2, 3));
               
        int indexDos = random.nextInt(valoresDisponibles.size());
        int valorEtqDos = valoresDisponibles.get(indexDos);
        etqDos.setText(String.valueOf(valorEtqDos));
        valoresDisponibles.remove(indexDos);
        tamanoFiguraDos = valorEtqDos;

        
        int indexTres = random.nextInt(valoresDisponibles.size());
        int valorEtqTres = valoresDisponibles.get(indexTres);
        etqTres.setText(String.valueOf(valorEtqTres));
        valoresDisponibles.remove(indexTres);
        tamanoFiguraTres = valorEtqTres;

        
        int valorEtqCuatro = valoresDisponibles.get(0);
        etqCuatro.setText(String.valueOf(valorEtqCuatro));
        tamanoFiguraCuatro = valorEtqCuatro;
        
        
        ImageIcon imagenSeparador = new ImageIcon("img/separador.png");
        separador = new JLabel();
        separador.setBounds(120, -10, 100, 480);
        separador.setIcon(new ImageIcon(imagenSeparador.getImage().getScaledInstance(separador.getWidth(), separador.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(separador);
                          
    }
    
    
    // en esta funcion recibe un str que es la ruta donde estara almacenado la imagen de la ronda, a las imagenes 2, 3 y 4 se les asignara el tamaño dependiendo el valor que se halla
    // asignado en la funcion asignarValoresAleatorios() 
    public void asignarImg(String ruta){
       
        asignarValoresAleatorios();
        ImageIcon imagen1 = new ImageIcon(ruta);
        etqUno.setBounds(50, 120, 100, 100);
        etqUno.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etqUno.getWidth(), etqUno.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqUno);
        tamanoFiguraUno = rondas.get(ronda).getOpcionCorrecta();
        
        
        // en estos switch case se les asigna el tamaño dependiendo el valor de tamaño que tengan (1, 2 y 3)
        switch (tamanoFiguraUno) {
            case 1 -> etqUno.setBounds(60, 120, 50, 50); 
            case 2 -> etqUno.setBounds(60, 120, 75, 75); 
            case 3 -> etqUno.setBounds(60, 120, 100, 100);
            default -> {
            }
        }
    
        etqUno.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etqUno.getWidth(), etqUno.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqUno);
        
        ImageIcon imagen2 = new ImageIcon(ruta);
        
        switch (tamanoFiguraDos) {
            case 1 -> etqDos.setBounds(230, 120, 50, 50); // Tamaño pequeño
            case 2 -> etqDos.setBounds(230, 120, 75, 75); // Tamaño mediano
            case 3 -> etqDos.setBounds(230, 120, 100, 100); // Tamaño grande
            default -> {
            }
        }
    
        etqDos.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etqDos.getWidth(), etqDos.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqDos);
        
        
        ImageIcon imagen3 = new ImageIcon(ruta);
        
        switch (tamanoFiguraTres) {
          case 1 -> etqTres.setBounds(350, 130, 50, 50); // Tamaño pequeño
          case 2 -> etqTres.setBounds(350, 130, 75, 75); // Tamaño mediano
          case 3 -> etqTres.setBounds(350, 130, 100, 100); // Tamaño grande
          default -> {
            }
        }
        
    
        etqTres.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(etqTres.getWidth(), etqTres.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqTres);
       
       ImageIcon imagen4 = new ImageIcon(ruta);
       
        switch (tamanoFiguraCuatro) {
          case 1 -> etqCuatro.setBounds(480, 120, 50, 50); // Tamaño pequeño
          case 2 -> etqCuatro.setBounds(480, 120, 75, 75); // Tamaño mediano
          case 3 -> etqCuatro.setBounds(480, 120, 100, 100); // Tamaño grande
          default -> {
            }
        }
        
    
        etqCuatro.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(etqCuatro.getWidth(), etqCuatro.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqCuatro);
        

    
    }
    
    
    // esa funcion es la encargada de asignar el indice de la ronda actual, escoje un numero aleatorio entre 0 y 8 (indices de el arreglo de las figuras) y lo retorna a la vez que lo
    // elimina de el arreglo de opciones, si el arreglo esta vacio lo volvera a llenar con los mismos valores, asi, el juego sera infinito y aleatorio hasta que el usuario desee terminarlo
    public int obtenerNumeroAleatorio() {
        if (opciones.isEmpty()) {
            opciones.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
            juego.reiniciarValores();
            rondas = juego.obtenerFiguras();  
        }
        int indiceAleatorio = random.nextInt(opciones.size());
        int numeroAleatorio = opciones.get(indiceAleatorio);
        opciones.remove(indiceAleatorio);
        ronda = numeroAleatorio;
        

        return numeroAleatorio;
    }
    
    
    // funcion que reproduce el sonido de opcion correcra 
    public void reproducirSonidoCorrecto() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/sndRespuestaCorrecta.wav"));            
            Clip clip = AudioSystem.getClip();            
            clip.open(audioInputStream);            
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    // funcion que reproduce el sonido de opcion incorrecta
    public void reproducirSonidoIncorrecto() {
        try {            
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/sndRespuestaIncorrecta.wav"));           
            Clip clip = AudioSystem.getClip();            
            clip.open(audioInputStream);            
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
