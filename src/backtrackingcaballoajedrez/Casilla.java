package backtrackingcaballoajedrez;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: Constructor de la casilla que situa los caballos.
 *
 */
public class Casilla {

    private Rectangle2D.Float Rectangulo;
    private Color Color;
    public boolean ocupada, visitada;
    private Caballo caballo;

    /**
     * Constructor de Casilla, sin caballo asignado y sin ser visitada ni ocupada
     */
    public Casilla(Rectangle2D.Float r, Color color) {
        this.Rectangulo = r;
        this.Color = color;
        this.caballo = null;
        this.ocupada = false;
        this.visitada = false;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.Color);
        g2d.fill(this.Rectangulo);
        if (ocupada == true) {
            this.caballo.paintComponent(g, this.Rectangulo.x, this.Rectangulo.y);
        }
    }

    /**
     * Pone a true el atributo ocupada
     * @param c El caballo que le corresponde
     */
    void setCaballo(Caballo c) {
        this.caballo = c;
        this.ocupada = true;
    }

    /**
     * Pone a false el atributo ocupada
     */
    void removeCaballo() {
        this.caballo = null;
        this.ocupada = false;
    }
    
    /**
     * 
     * @param visitada Booleano que indica si la casilla ha sido visitada
     */
    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }
}
