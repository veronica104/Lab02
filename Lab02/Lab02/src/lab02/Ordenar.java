package lab02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Ordenar {
    public static JFrame frame;
    public static JButton[] botones;

public Ordenar(){
    inicializar();
}
private void inicializar(){
        
        Ejercicio4 ejer4=new Ejercicio4();
        
        // *** AJUSTAR EL TITULO DE LA VENTANA (JFRAME) DEL MENU ***
        String titulo = "Menu de ordenamiento  ";

        // *** AJUSTAR LOS MENSAJES QUE HAN DE APARECER EN EL MENU ***
        String opciones[] = {"Ordenar por Modelo", "Ordenar por kilometraje"};

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
                            new OrdenKilo(ejer4);
                            break;
                        case 1:
                           new OrdenModelo(ejer4);
                            break;
                        case 2:
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
   public void mostrar(){
       SwingUtilities.invokeLater(() -> frame.setVisible(true));
   }
}
