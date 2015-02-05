package backtrackingcaballoajedrez;

import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @Autor: Carlos Marin Fernandez
 * @Fecha: 26-ene-2015
 * @Descripcion: Definicion del tablero e implementacion de este.
 * Dada una posicion inicial del caballo, se ejecuta el metodo assajar_moviment,
 * el que se encarga de analizar la posibilidad de recorrer todas las casillas
 * sin repetir visitas.
 *
 */
public class Ajedrez extends JFrame {

    /**
     * @param Tablero Objeto tipo Panel en el que realizaremos los calculos
     * sobre los movimientos del caballo
     * @param int Xini, Yini Enteros que indican la posicion inicial del caballo
     * @param final int DIMENSIONES Muestra las dimensiones del tablero
     * @param ArrayList solucionFinal Lista en la que guardaremos los estados
     * que consideremos validos para el recorrido
     * @param boolean trobat Para utilizar en el 'main' como control del posible
     * recorrido del caballo
     */
    public static Tablero tablero;
    public static int Xini = 0, Yini = 0, DIMENSIONES, NUMFILAS;
    public static ArrayList solucionFinal;
    public static boolean trobat = false;

    /**
     * Constructor de la clase Ajedrez (frame)
     */
    public Ajedrez(int dimension) throws Exception {
        super("Movimientos Caballo");
        this.setSize(100 * dimension + 1, 100 * dimension + 23);
        DIMENSIONES = dimension * dimension;
        NUMFILAS = dimension;
        solucionFinal = new ArrayList();
        tablero = new Tablero(dimension);
        Xini = Integer.parseInt(Backtracking.mydialog.jtCaballoX.getText());
        Yini = Integer.parseInt(Backtracking.mydialog.jtCaballoY.getText());
        this.add(tablero);
        tablero.Poner(Caballo.Caballo, Xini, Yini);
        tablero.t[Xini][Yini].setVisitada(true);
        assajar_moviment(new EstadoCaballo(Xini, Yini, 0));
        solucionFinal.add(new EstadoCaballo(Xini, Yini, 0));
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Metodo assajar_moviment: Dado un estado inicial, calcula la validez de
     * los 8 posibles estados siguientes del movimiento del caballo. Segun esa
     * validez y usando la recursividad, mas concretamente el metodo del
     * backtracking, obtendremos un posible estado final y sus estados
     * anteriores almacenados en una lista.
     */
    public boolean assajar_moviment(EstadoCaballo ec) throws Exception {
        final int xf = ec.posX, yf = ec.posY, nf = ec.saltosCompletados;
        EstadoCaballo ec1 = new EstadoCaballo(xf, yf, nf);
        ArrayList validos = new ArrayList();
        //Posibles estados validos para el siguiente movimiento
        if (esValido(ec1.operador1(ec1))) {
            validos.add(ec1);
        }
        EstadoCaballo ec2 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec2.operador2(ec2))) {
            validos.add(ec2);
        }
        EstadoCaballo ec3 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec3.operador3(ec3))) {
            validos.add(ec3);
        }
        EstadoCaballo ec4 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec4.operador4(ec4))) {
            validos.add(ec4);
        }
        EstadoCaballo ec5 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec5.operador5(ec5))) {
            validos.add(ec5);
        }
        EstadoCaballo ec6 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec6.operador6(ec6))) {
            validos.add(ec6);
        }
        EstadoCaballo ec7 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec7.operador7(ec7))) {
            validos.add(ec7);
        }
        EstadoCaballo ec8 = new EstadoCaballo(xf, yf, nf);
        if (esValido(ec8.operador8(ec8))) {
            validos.add(ec8);
        }
        
        //Backtracking 
        while (ec.saltosCompletados < DIMENSIONES - 1 && validos.size() > 0) {
            for (int i = 0; i < validos.size(); i++) {
                EstadoCaballo posibleEC = (EstadoCaballo) validos.get(i);
                //Si la casilla del nuevo estado no esta visitada
                if (!tablero.t[posibleEC.posX][posibleEC.posY].visitada) {
                    tablero.t[posibleEC.posX][posibleEC.posY].setVisitada(true);
                    if (ec.saltosCompletados < DIMENSIONES - 1) {
                        //Recursividad Backtracking
                        if (!assajar_moviment(posibleEC)) {
                            tablero.t[posibleEC.posX][posibleEC.posY].setVisitada(false);
                            validos.remove(i);
                        } else {
                            solucionFinal.add(validos.get(i));
                            ec.saltosCompletados = DIMENSIONES - 1;
                            validos.clear();
                            break;
                        }
                    }
                }
            }
        }

        if (ec.saltosCompletados == DIMENSIONES - 1) {
            trobat = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve verdadero si la nueva posicion del posibleEC es apta: 
     *  · Esta dentro del tablero
     *  · No ha sido visitada anteriormente
     */
    public boolean esValido(EstadoCaballo ec) {
        if (ec.posX >= NUMFILAS || ec.posY >= NUMFILAS || ec.posX < 0 || ec.posY < 0) {
            return false;
        } else {
            if (tablero.t[ec.posX][ec.posY].visitada == true) {
                return false;
            } else {
                return true;
            }
        }
    }
}
