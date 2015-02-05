package backtrackingcaballoajedrez;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: Construcor del tablero y metodos para pintarlo.
 *
 */
public class Tablero extends JPanel {

    private final Color casillaNegra = Color.LIGHT_GRAY;
    private final Color casillaBlanca = Color.DARK_GRAY;
    private int CASILLAS = 1;
    private final int MAXIMO = 100;
    private final int DIMENSIONTABLERO = MAXIMO / CASILLAS;
    public Casilla t[][];

    /*
     * Constructor de la clase Tablero
     */
    public Tablero(int n) {
        CASILLAS = n;
        t = new Casilla[CASILLAS][CASILLAS];
        int y = 0;
        for (int i = 0; i < CASILLAS; i++) {
            int x = 0;
            for (int j = 0; j < CASILLAS; j++) {
                Rectangle2D.Float r = new Rectangle2D.Float(x, y, DIMENSIONTABLERO, DIMENSIONTABLERO);
                Color color;
                if ((i % 2 == 1 && j % 2 == 1) || (i % 2 == 0 && j % 2 == 0)) {
                    color = casillaBlanca;
                } else {
                    color = casillaNegra;
                }
                t[i][j] = new Casilla(r, color);
                x += DIMENSIONTABLERO;
            }
            y += DIMENSIONTABLERO;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < CASILLAS; i++) {
            for (int j = 0; j < CASILLAS; j++) {
                t[i][j].paintComponent(g);
            }
        }
    }

    /**
     * 
     * @param s: Indica el tipo de caballo, si normal o de solucion.
     * @param x: Posicion x dentro del tablero
     * @param y: Posicion y dentro del tablero
     */
    void Poner(String s, int x, int y) {
        t[x][y].setCaballo(new Caballo(s));
        this.repaint();
    }

    /**
     * Sustituye el caballo previo, por el de CaballoAnterior y coloca el nuevo en 
     * la posicion siguiente.
     * @param s: Indica el tipo de caballo, si normal o de solucion.
     * @param Xini: Posicion x inicial dentro del tablero
     * @param Yini: Posicion y inicial dentro del tablero
     * @param Xfin: Posicion x final dentro del tablero
     * @param Yfin: Posicion y final dentro del tablero
     */
    void Mover(String s, int Xini, int Yini, int Xfin, int Yfin) {
        t[Xini][Yini].removeCaballo();
        t[Xini][Yini].setCaballo(new Caballo(Caballo.CaballoAnterior));
        t[Xfin][Yfin].setCaballo(new Caballo(s));
        this.repaint();
    }

    /**
     * Elimina todos los caballos del tablero y lo repinta
     */
    void Limpiar() {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t.length; j++) {
                t[i][j].removeCaballo();
            }
        }
        this.repaint();
    }
}
