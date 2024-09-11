package lab02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    public static JFrame frame;
    public static JButton[] botones;

    public static void main(String[] args) {
        
        Ejercicio1 ejer1=new Ejercicio1();
        Ejercicio2 ejer2=new Ejercicio2();
        Ejercicio3 ejer3=new Ejercicio3();
        Ejercicio4 ejer4=new Ejercicio4();
        
        // *** AJUSTAR EL TITULO DE LA VENTANA (JFRAME) DEL MENU ***
        String titulo = "Lab02:Algoritmos de ordenomiento  ";

        // *** AJUSTAR LOS MENSAJES QUE HAN DE APARECER EN EL MENU ***
        String opciones[] = {"Ejercicio 1", "Ejercicio 2","Ejercicio 3","Ejercicio 4","salir"};

        final int numop = opciones.length;

        // Crear el marco de la ventana
        frame = new JFrame(titulo);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setSize(400, 50 * numop);
        frame.setLayout(new BorderLayout());

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(numop, 1)); // Disponer los botones en una columna

        // Crear un array de botones
        botones = new JButton[numop];

        // Inicializar los botones y añadir ActionListener
        for (int i = 0; i < numop; i++) {
            final int index = i; // Variable final para usar en el ActionListener
            botones[i] = new JButton(opciones[i]);
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // *** AJUSTAR SEGUN LAS OPCIONES DEL MENU ***
                    switch (index) {
                        case 0:
                            ejer1.ejecutar();
                            break;
                        case 1:
                            ejer2.ejecutar();
                            break;
                        case 2:
                            ejer3.ejecutar();
                            break;
                        case 3:
                            ejer4.ejecutar();
                            break;
                        case 4:
                            System.exit(0);
                            break;
                    }
                    // *** FINAL AJUSTES ***
                }
            });
            // Añadir el botón al panel
            panelBotones.add(botones[i]);
        }

        // Añadir el panel de botones al marco
        frame.add(panelBotones, BorderLayout.CENTER);

        // Mostrar la ventana
        frame.setVisible(true);
    }
}