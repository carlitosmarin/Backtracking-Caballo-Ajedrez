package backtrackingcaballoajedrez;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: main que crea el ajedrez y ejecuta el algoritmo del backtraking.
 *
 */
public class Backtracking {
    
    public static int dimensiones, tamSoluciones, contBoton = 0;
    public static MyDialog mydialog;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) throws Exception {
        boolean acepta = false;
        do {
            mydialog = new MyDialog(null, true);
            if(!mydialog.jtDimensiones.getText().equals("") && !mydialog.jtCaballoX.getText().equals("")
                    && !mydialog.jtCaballoY.getText().equals("")){
                acepta = true;
            } else {
                JOptionPane.showMessageDialog(null, "ERROR: No está insiriendo valores válidos"
                        + " para la ejecución", "Mostrar Recorrido Caballo", JOptionPane.CANCEL_OPTION);
            }
        } while(acepta == false);
        dimensiones = Integer.parseInt(mydialog.jtDimensiones.getText());
        Ajedrez t = new Ajedrez(dimensiones);
        if (Ajedrez.trobat == true) {
            tamSoluciones = Ajedrez.solucionFinal.size() - 2;
            mostrarRecorrido();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: No he encontrado ninguna solución "
                    + "al recorrido", "Mostrar Recorrido Caballo", JOptionPane.CANCEL_OPTION);
        }
    }

    /**
     * En este frame, se podran observar las posiciones del caballo a lo largo del recorrido     
     */
    public static void mostrarRecorrido() {
        JFrame siguiente = new JFrame();
        siguiente.setLayout(new GridLayout(0, 2));
        siguiente.setTitle("Recorrido");
        siguiente.setBounds(dimensiones*100+50, dimensiones*100/2-30, 230, 60);
        final JButton siguienteMovimiento = new JButton("Siguiente");
        siguienteMovimiento.setMnemonic('S');
        siguiente.add(siguienteMovimiento);
        JButton limpiarTablero = new JButton("Inicio");
        limpiarTablero.setMnemonic('I');
        siguiente.add(limpiarTablero);
        siguiente.setVisible(true);
        siguiente.setDefaultCloseOperation(EXIT_ON_CLOSE);


        siguienteMovimiento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tamSoluciones == -1) {
                        JOptionPane.showMessageDialog(null, "Recorrido Completado Satisfactoriamente",
                                "Mostrar Recorrido", JOptionPane.CANCEL_OPTION);
                    } else {
                        EstadoCaballo ecn = (EstadoCaballo) Ajedrez.solucionFinal.get(tamSoluciones);
                        if (tamSoluciones == 0) {
                            Ajedrez.tablero.Mover(Caballo.CaballoFinal, Ajedrez.Xini, Ajedrez.Yini, ecn.posX, ecn.posY);
                        } else {
                            Ajedrez.tablero.Mover(Caballo.Caballo, Ajedrez.Xini, Ajedrez.Yini, ecn.posX, ecn.posY);
                        }
                        Ajedrez.Xini = ecn.posX;
                        Ajedrez.Yini = ecn.posY;
                        tamSoluciones--;
                        contBoton++;
                        siguienteMovimiento.setText("Siguiente (" + contBoton + ")");
                    }

                } catch (Exception error) {
                    System.err.println("Error: " + error.getMessage());
                }
            }
        });

        limpiarTablero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Ajedrez.tablero.Limpiar();
                    tamSoluciones = Ajedrez.solucionFinal.size() - 1;
                    EstadoCaballo ecn = (EstadoCaballo) Ajedrez.solucionFinal.get(tamSoluciones);
                    Ajedrez.tablero.Poner(Caballo.Caballo, ecn.posX, ecn.posY);
                    siguienteMovimiento.setText("Siguiente");
                    contBoton = -1;
                } catch (Exception error) {
                    System.err.println("Error: " + error.getMessage());
                }
            }
        });
    }
}