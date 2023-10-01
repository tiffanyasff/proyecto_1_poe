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
    private JFrame frame;
    private JPanel panel;
    private int ronda = 0;
    private ArrayList<Figura> rondas;
    private int tamanoFiguraDos;
    private int tamanoFiguraTres;
    private int tamanoFiguraCuatro;
    
    
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
        
        frame = new JFrame("Mi Ventana");
        etqUno = new JLabel();
        etqDos = new JLabel();
        etqTres = new JLabel();
        etqCuatro = new JLabel();
        
        asignarImg("ruta");
        
        rondas = juego.obtenerFiguras();
        
        etqUno.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Acción a realizar cuando se hace clic en etqUno
            String textoEtqUno = etqUno.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqUno);
            //asignarValoresAleatorios();
            asignarImg("a");
            
            //aca va a esta la funcion que valida todo y las comparaciones y la funcion que vuelve a poner las figuras y asignar los valores de los botones
        }
        });
        
        etqDos.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {            
            String textoEtqDos = etqDos.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqDos);
            System.out.println(tamanoFiguraTres);
        }
        });
        
        etqTres.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {            
            String textoEtqTres = etqTres.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqTres);
        }
        });
        
        etqCuatro.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {          
            String textoEtqCuatro = etqCuatro.getText();
            JOptionPane.showMessageDialog(frame, "Etiqueta Uno fue clicada. Valor: " + textoEtqCuatro);
        }
        });
        
        
        ventanaJuego.add(panel);
        ventanaJuego.setVisible(true);
        
        
    }
    
    private void asignarValoresAleatorios() {
        ArrayList<Integer> valoresDisponibles = new ArrayList<>(Arrays.asList(1, 2, 3));
        Random random = new Random();

        
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
    }
    
    public void asignarImg(String ruta){
        
        asignarValoresAleatorios();
        ImageIcon imagen1 = new ImageIcon("circulo.png");
        //etqUno = new JLabel();
        etqUno.setBounds(50, 120, 100, 100);
        etqUno.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etqUno.getWidth(), etqUno.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqUno);
       
        //asignarValoresAleatorios();
        /*ImageIcon imagen2 = new ImageIcon("circulo.png");
        etqDos = new JLabel();
        etqDos.setBounds(200, 120, 100, 100);
        etqDos.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etqDos.getWidth(), etqDos.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqDos);*/
        
        ImageIcon imagen2 = new ImageIcon("circulo.png");
        
        //etqDos = new JLabel();
        //etqDos.setBounds(200, 120, 100, 100);
         // Ajusta el tamaño de la etiqueta según el valor de tamanoFigura
        switch (tamanoFiguraDos) {
            case 1:
                etqDos.setBounds(200, 120, 50, 50); // Tamaño pequeño
                break;
            case 2:
                etqDos.setBounds(200, 120, 75, 75); // Tamaño mediano
                break;
            case 3:
                etqDos.setBounds(200, 120, 100, 100); // Tamaño grande
                break;
            default:
                // Puedes manejar un caso por defecto si es necesario
                break;
        }
    
        etqDos.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(etqDos.getWidth(), etqDos.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqDos);
    
        
        /*ImageIcon imagen3 = new ImageIcon("circulo.png");
        etqTres = new JLabel();
        etqTres.setBounds(350, 120, 100, 100);
        etqTres.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(etqTres.getWidth(), etqTres.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqTres);*/
        
        ImageIcon imagen3 = new ImageIcon("circulo.png");
        
        switch (tamanoFiguraTres) {
          case 1:
              etqTres.setBounds(350, 120, 50, 50); // Tamaño pequeño
              break;
          case 2:
              etqTres.setBounds(300, 120, 75, 75); // Tamaño mediano
              break;
          case 3:
              etqTres.setBounds(300, 120, 100, 100); // Tamaño grande
              break;
          default:
              // Puedes manejar un caso por defecto si es necesario
              break;
        }
    
        etqTres.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(etqTres.getWidth(), etqTres.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqTres);
    
        
        
        
       /* ImageIcon imagen4 = new ImageIcon("circulo.png");
        etqCuatro = new JLabel();
        etqCuatro.setBounds(500, 120, 100, 100);
        etqCuatro.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(etqCuatro.getWidth(), etqCuatro.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqCuatro);*/
       
       ImageIcon imagen4 = new ImageIcon("circulo.png");
       
        switch (tamanoFiguraCuatro) {
          case 1:
              etqCuatro.setBounds(500, 120, 50, 50); // Tamaño pequeño
              break;
          case 2:
              etqCuatro.setBounds(500, 120, 75, 75); // Tamaño mediano
              break;
          case 3:
              etqCuatro.setBounds(500, 120, 100, 100); // Tamaño grande
              break;
          default:
              // Puedes manejar un caso por defecto si es necesario
              break;
        }
    
        etqCuatro.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(etqCuatro.getWidth(), etqCuatro.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etqCuatro);
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
   
    
    
}
