/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4enraya;

import java.util.Scanner;

/**
 *
 * @author kfelsner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaraciones
        
        Tablero tablero = new Tablero();
        Partida jugador = new Partida();
        Scanner sc = new Scanner(System.in);
        int colmn = 0;
        
        //=======GAME==========
        tablero.crearTablero();
        System.out.println("Comienza la partida");
        tablero.verTablero();
        
        while (!(Partida.victoria)) {
            for (int k = 0; !Partida.victoria ; k++) {
                switch (k % 2) {
                    case 0:
                        System.out.print("¿Jugador 1, donde quiere colocar su ficha? --> ");
                        colmn = sc.nextInt();
                        jugador.colocarSimbolo(colmn, 'X');
                        tablero.verTablero();
                        break;

                    case 1:
                        System.out.print("¿Jugador 2, donde quiere colocar su ficha? --> ");
                        colmn = sc.nextInt();
                        jugador.colocarSimbolo(colmn, 'O');
                        tablero.verTablero();
                        break;
                }
            }
        }
    }
}
