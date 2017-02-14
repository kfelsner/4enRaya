/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4enraya;

import javax.swing.JOptionPane;

/**
 *
 * @author kfelsner
 */
public class Partida {

    //--------Declaraciones--------//
    private enum simbolos {
        X, O
    };
    private static int seguidas = 0;
    private final int COLMAX = 8;
    private final int FILAMAX = 7;
    private char fichaAct;
    private int[][] direcciones = {{0, 1}, {1, 0}, {-1, 1}, {1, 1}};
    static boolean victoria = false;

    //--------Metodos--------//
    //Permite colocar una ficha dentro den tablero.
    public void colocarSimbolo(int x, char simbolo) {
        int y = 6;
        while ((Tablero.tablero[y][x] == 'O')
                || (Tablero.tablero[y][x] == 'X')) {
            if (y == -1) {
                break;
            } else {
                y--;
            }
        }
        //Sigue dando error cuando alcanza la parte superior del programa, sale del array.
        if (!(y < 0)) {
            Tablero.tablero[y][x] = simbolo;
            if (comprobarTodo(x, y, simbolo)) {
                JOptionPane.showMessageDialog(null, "El ganador es: " + simbolo);
                victoria = true;
            }
        }
    }

    // Comprueba si la ficha está dentro del tablero.
    public boolean dentro(int x, int y) {
        return !((y < 0) || (y >= FILAMAX) || (x < 0) || (x >= COLMAX));
    }

    //Comprueba si hay 4 fichas en cada una de las direcciones.
    public boolean comprobarTodo(int xIni, int yIni, char ficha) {
        seguidas = 0;
        fichaAct = ficha;
        if (dentro(xIni, yIni)) {
            for (int o = 0; o < direcciones.length; o++) {
                for (int k = -3; k <= 3; k++) {
                    if (dentro(xIni + k * direcciones[o][1], yIni + k * direcciones[o][0])) {
                        if ((Tablero.tablero[yIni + k * direcciones[o][0]][xIni + k * direcciones[o][1]]) == fichaAct) {
                            seguidas++;
                        } else {
                            seguidas = 0;
                        }
                        if (seguidas == 4) {
                            return true;
                        }
                    }
                }
                seguidas = 0;
            }
        }
        return false;
    }
}
