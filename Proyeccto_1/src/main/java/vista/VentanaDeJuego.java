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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import modelo.Figura;



public class VentanaDeJuego extends JFrame implements ActionListener {
    private JuegoAdivinarFig juego; 
    private JFrame ventanaJuego;
    private JLabel etqUno;
    private JLabel etqDos;
    private JLabel etqTres;
    private JLabel etqCuatro;
    private JLabel separador;
    private JFrame frame;
    private JPanel panel;
    private int ronda = 0;
    private ArrayList<Figura> rondas;
    private ArrayList<Integer> opciones = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
    private int tamanoFiguraUno;
    private int tamanoFiguraDos;
    private int tamanoFiguraTres;
    private int tamanoFiguraCuatro;
    Random random = new Random();
    
    public VentanaDeJuego(){
        ventanaJuego = new JFrame("Juego");
        ventanaJuego.setSize(700, 400);
        ventanaJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
 
    
    public void iniciarComponentes(){
        juego = new JuegoAdivinarFig();
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);


        
        frame = new JFrame("Mi Ventana");
        etqUno = new JLabel();
        etqDos = new JLabel();
        etqTres = new JLabel();
        etqCuatro = new JLabel();
        separador = new JLabel();
      
        
        rondas = juego.obtenerFiguras();
        asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
        
        etqUno.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String textoEtqUno = etqUno.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqUno);
        }
        });
        
        etqDos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {            
            String textoEtqDos = etqDos.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqDos);
            System.out.println(tamanoFiguraTres);
            
            if (rondas.get(ronda).validarOpcion(tamanoFiguraDos)){
                
                //ronda+=1;
                asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());      
            }else {
                System.out.println("opcion incorrecta");
            }
        }
        });
        
        etqTres.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {            
            String textoEtqTres = etqTres.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqTres);
            
             if (rondas.get(ronda).validarOpcion(tamanoFiguraTres)){
                
                //ronda+=1;
                asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
                  
            }else {
                System.out.println("opcion incorrecta");
            }
        }
        });
        
        etqCuatro.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {          
            String textoEtqCuatro = etqCuatro.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqCuatro);
            
             if (rondas.get(ronda).validarOpcion(tamanoFiguraCuatro)){
                
                //ronda+=1;
                asignarImg(rondas.get(obtenerNumeroAleatorio()).getRutaImg());
                  
            }else {
                System.out.println("opcion incorrecta");
            }
        }
        });
        
        
        ventanaJuego.add(panel);
        ventanaJuego.setVisible(true);
        
        
    }
    
    private void asignarValoresAleatorios() {
        ArrayList<Integer> valoresDisponibles = new ArrayList<>(Arrays.asList(1, 2, 3));
        //Random random = new Random();

        
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
        separador.setBounds(100, -70, 100, 510);
        separador.setIcon(new ImageIcon(imagenSeparador.getImage().getScaledInstance(separador.getWidth(), separador.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(separador);
       
       
    }
    
    
    public void asignarImg(String ruta){
       
        asignarValoresAleatorios();
        ImageIcon imagen1 = new ImageIcon(ruta);
        etqUno.setBounds(50, 120, 100, 100);
        etqUno.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etqUno.getWidth(), etqUno.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqUno);
        tamanoFiguraUno = rondas.get(ronda).getOpcionCorrecta();
        
        switch (tamanoFiguraUno) {
            case 1 -> etqUno.setBounds(50, 120, 50, 50); // Tamaño pequeño
            case 2 -> etqUno.setBounds(50, 120, 75, 75); // Tamaño mediano
            case 3 -> etqUno.setBounds(50, 120, 100, 100); // Tamaño grande
            default -> {
            }
        }
    
        etqUno.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etqUno.getWidth(), etqUno.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqUno);
        
        ImageIcon imagen2 = new ImageIcon(ruta);
        
        switch (tamanoFiguraDos) {
            case 1 -> etqDos.setBounds(200, 120, 50, 50); // Tamaño pequeño
            case 2 -> etqDos.setBounds(200, 120, 75, 75); // Tamaño mediano
            case 3 -> etqDos.setBounds(200, 120, 100, 100); // Tamaño grande
            default -> {
            }
        }
    
        etqDos.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etqDos.getWidth(), etqDos.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqDos);
        
        
        ImageIcon imagen3 = new ImageIcon(ruta);
        
        switch (tamanoFiguraTres) {
          case 1 -> etqTres.setBounds(350, 130, 50, 50); // Tamaño pequeño
          case 2 -> etqTres.setBounds(320, 130, 75, 75); // Tamaño mediano
          case 3 -> etqTres.setBounds(300, 130, 100, 100); // Tamaño grande
          default -> {
            }
        }
        
    
        etqTres.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(etqTres.getWidth(), etqTres.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqTres);
       
       ImageIcon imagen4 = new ImageIcon(ruta);
       
        switch (tamanoFiguraCuatro) {
          case 1 -> etqCuatro.setBounds(440, 120, 50, 50); // Tamaño pequeño
          case 2 -> etqCuatro.setBounds(450, 120, 75, 75); // Tamaño mediano
          case 3 -> etqCuatro.setBounds(450, 120, 100, 100); // Tamaño grande
          default -> {
            }
        }
        // Puedes manejar un caso por defecto si es necesario
    
        etqCuatro.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(etqCuatro.getWidth(), etqCuatro.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqCuatro);
        

    
    }
    
    public int obtenerNumeroAleatorio() {
        if (opciones.isEmpty()) {
            opciones.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
            juego.reiniciarValores();
            rondas = juego.obtenerFiguras();  
        }
        int indiceAleatorio = random.nextInt(opciones.size());
        System.out.println(opciones.size());
        int numeroAleatorio = opciones.get(indiceAleatorio);
        opciones.remove(indiceAleatorio);

        return numeroAleatorio;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
