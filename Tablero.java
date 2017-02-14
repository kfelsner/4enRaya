/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4enraya;



/**
 *
 * @author kfelsner
 */
public class Tablero {
    
    //--------Declaraciones--------//
    public static char tablero [][] = new char [7][8];
    //--------Metodos--------//
    
    public void crearTablero() {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                
                tablero[y][x] = '~';
            }
        }
    }
    
    public void verTablero() {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 8; x++) {
                
                System.out.print(tablero[y][x] + " ");
            }
            System.out.println();
        }
    }   
}
