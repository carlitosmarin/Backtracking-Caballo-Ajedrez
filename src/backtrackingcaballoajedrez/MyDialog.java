package backtrackingcaballoajedrez;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.*;
/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: Ventana donde se indican las dimensiones del tablero
 * y la posicion inicial (x,y) del caballo 
 *
 */
public class MyDialog extends javax.swing.JDialog {

    public JTextField jtDimensiones, jtCaballoX, jtCaballoY;

    public MyDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setTitle("Inicializando...                (Cerrar ventana para iniciar)");
        this.setBounds((Backtracking.screenSize.width/2)-240,(Backtracking.screenSize.height/2)-75, 480, 150);
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
    }

    private void initComponents() {
        JPanel Contenido = new JPanel();
        getContentPane().add(Contenido);
        
        //Layout del panel
        Contenido.setLayout(new GridLayout(1, 2));
        JPanel jpLabels = new JPanel(new GridLayout(3, 1));
        jpLabels.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
        JPanel jpTextfields = new JPanel(new GridLayout(3, 1));

        //Panel Izquierda, etiquetas
        JLabel jlDimensiones = new JLabel("Dimensiones del tablero [4..7]: ");
        jpLabels.add(jlDimensiones);
        JLabel jlCaballoX = new JLabel("Posición X del caballo: ");
        jpLabels.add(jlCaballoX);
        JLabel jlCaballoY = new JLabel("Posición Y del caballo: ");
        jpLabels.add(jlCaballoY);

        //Panel Derecha, insercion de datos
        jtDimensiones = new JTextField();
        jpTextfields.add(jtDimensiones);
        jtCaballoX = new JTextField();
        jpTextfields.add(jtCaballoX);
        jtCaballoY = new JTextField();
        jpTextfields.add(jtCaballoY);
        
        Contenido.add(jpLabels);
        Contenido.add(jpTextfields);
    }
}