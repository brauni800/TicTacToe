/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase se encarga de encontrar a un jugador
 * ganador del juego.
 * @author Carlos Braulio Betancourt Estrada
 * @version 1.1 15 de Marzo del 2017
 */
public class Play {
    /**
     * Almacena el valor del array que recibe
     * del constructor.
     */
    private final int[][] array;
    /**
     * Almacena el valor del JPanel que recibe
     * del constructor.
     */
    private final JPanel jp;
    /**
     * Almacena el valor del JLabel que recibe
     * del constructor.
     */
    private final JLabel jl1, jl2, jl3, jl4;
    /**
     * Almacena el valor del JButton que recibe
     * del constructor.
     */
    private final JButton jb1, jb2;
    /**
     * Almacena el valor del int turno que recibe
     * del constructor.
     */
    private final int turno;
    /**
     * Constructor.
     * @param array Arreglo que contiene enteros.
     * Este arreglo sirve para llevar un registro de
     * que jugador ocupa una respectiva
     * casilla del TicTacToe.
     * @param jp Panel que indica cuando el juego ha terminado.
     * @param jl1 JLabel de un texto.
     * @param jl2 JLabel donde se indica que jugador gana la partida.
     * @param jl3 JLabel de un texto.
     * @param jl4 JLabel donde se indica el nombre
     * del jugador en turno.
     * @param jb1 JButton que reinicia los parametros del juego.
     * @param jb2 JButton que cierra el juego.
     * @param turno Indica el turno actual.
     * @see Play( int[][], JPanel, JLabel, JLabel
     * , JLabel, JLabel, JButton, JButton, int ).
     */
    public Play(int[][] array, JPanel jp, JLabel jl1
            , JLabel jl2, JLabel jl3, JLabel jl4
            , JButton jb1, JButton jb2, int turno) {
        this.array = array;
        this.jp = jp;
        this.jl1 = jl1;
        this.jl2 = jl2;
        this.jl3 = jl3;
        this.jl4 = jl4;
        this.jb1 = jb1;
        this.jb2 = jb2;
        this.turno = turno;
    }
    /**
     * Determina al jugador ganador de la partida del juego.
     * @return true si la partida finalizo y false si la partida continua.
     */
    public final boolean whoWin() {
        boolean finish = false;
        int[] r = {1, 2};
        int cont = 0;
        int [][] a = {{this.array[0][0], this.array[1][0], this.array[2][0]}
        , {this.array[0][1], this.array[1][1], this.array[2][1]}
        , {this.array[0][2], this.array[1][2], this.array[2][2]}
        , {this.array[0][0], this.array[1][1], this.array[2][2]}
        , {this.array[2][2], this.array[1][1], this.array[0][0]}
        , {this.array[0][0], this.array[0][1], this.array[0][2]}
        , {this.array[1][0], this.array[1][1], this.array[1][2]}
        , {this.array[2][0], this.array[2][1], this.array[2][2]}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    if (r[i] == a[j][k]) {
                        cont++;
                    }
                    if (cont == 3) {
                        if (i == 0) {
                            this.jl2.setText("El ganador es: Jugador 1");
                        } else {
                            this.jl2.setText("El ganador es: Jugador 2");
                        }
                        mostrarElementos();
                        finish = true;
                        break;
                    }
                }
                cont = 0;
            }
        }
        if (this.turno == 8 && !finish) {
            this.jl2.setText("Empate");
            mostrarElementos();
            finish = true;
        }
        return finish;
    }
    /**
     * Revela las partes ocultas de la ventana.
     * Las partes ocultas son: el JPanel, los JLabel y los JButton.
     */
    private void mostrarElementos() {
        this.jp.setVisible(true);
        this.jl1.setVisible(true);
        this.jl2.setVisible(true);
        this.jb1.setVisible(true);
        this.jb2.setVisible(true);
        this.jl3.setVisible(false);
        this.jl4.setVisible(false);
    }
}
