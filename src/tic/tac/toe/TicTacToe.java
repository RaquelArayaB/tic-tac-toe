/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic.tac.toe;

import javax.swing.JOptionPane;

/**
 *
 * @author rake_
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[][] tablero = {
                             {" "," "," "},
                             {" "," "," "},
                             {" "," "," "}
                             };
        
        boolean EsTurnoX = true;
        String jugada = "X";
        
        for(int i = 0; i < 9; i++){
        
            if(EsTurnoX){
            jugada = "X";
            }else{
            jugada = "O";
            }
            
            String coordenadas = JOptionPane.showInputDialog("Es el turno de: " + jugada);
            String [] indices = coordenadas.split(",");
            
            int fila = Integer.parseInt(indices[0]);
            int columna = Integer.parseInt(indices[1]);
            
            if(tablero[fila][columna].equals(" ")){
                tablero[fila][columna] = jugada;
                EsTurnoX = !EsTurnoX;
                imprimirTablero(tablero, jugada);
                if (haGanado(tablero, jugada)) {
                    System.out.println("¡El jugador " + jugada + " ha ganado!");
                    break;
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Error. Este espacio ya está ocupado!");
                    i--;
            }
            
            if (i == 8) {
                System.out.println("¡Empate!");
            }
        }
        
        
    }
    
    private static void imprimirTablero(String[][] array, String jugada){
         System.out.println("Turno de " + jugada);
         
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(array[row][col]);
                if (col < 2) {
                    System.out.print("  | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("------------");
            }
        }
    }
     private static boolean haGanado(String[][] tablero, String jugador) {
        for (int i = 0; i < 3; i++) {
           
            if ((tablero[i][0].equals(jugador) && tablero[i][1].equals(jugador) && tablero[i][2].equals(jugador)) ||
                (tablero[0][i].equals(jugador) && tablero[1][i].equals(jugador) && tablero[2][i].equals(jugador))) {
                return true;
            }
        }
        return (tablero[0][0].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][2].equals(jugador)) ||
               (tablero[0][2].equals(jugador) && tablero[1][1].equals(jugador) && tablero[2][0].equals(jugador));
    }
}
