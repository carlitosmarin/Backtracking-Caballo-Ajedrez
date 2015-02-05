package backtrackingcaballoajedrez;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;

/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: Constructor del caballo que recorrera el tablero
 */
public class Caballo {
    
    //Caballo actual
    public static final String Caballo = "./images/caballo.png";
    
    //Caballo posición final
    public static final String CaballoFinal = "./images/caballoFinal.png";
    
    //Caballo posiciones anteriores a la actual
    public static final String CaballoAnterior = "./images/caballoAnterior.png";

    private BufferedImage img;
    
    /**
     * 
     * @param s Indica el tipo de caballo que se creara
     */
    public Caballo(String s) {
        try{
            img= ImageIO.read(new File(s));
        } catch (IOException e){
            System.err.println("Error al abrir la imagen del caballo.");
        }
    }
    
    //Donde se pintara el caballo en la casilla
    void paintComponent(Graphics g, float x, float y) {
        g.drawImage(img, (int)x+25, (int)y+25, null);
    }
}
