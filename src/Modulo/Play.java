/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author b1796
 */
public class Play {

    private final int[][] array;
    private final JPanel jp;
    private final JLabel jl1;
    private final JLabel jl2;
    private final JLabel jl3;
    private final JLabel jl4;
    private final JButton jb1;
    private final JButton jb2;
    private final int turno;

    public Play(int[][] array, JPanel jp, JLabel jl1, JLabel jl2, JLabel jl3, JLabel jl4
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
    
    public boolean whoWin(){
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
        
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < a.length; j++){
                for(int k = 0; k < a[0].length; k++){
                    if(r[i] == a[j][k])
                        cont++;
                    if(cont == 3){
                        if(i == 0)
                            this.jl2.setText("El ganador es: Jugador 1");
                        else
                            this.jl2.setText("El ganador es: Jugador 2");
                        mostrarElementos();
                        finish = true;
                        break;
                    }
                }
                cont = 0;
            }
        }
        if(this.turno == 8){
            this.jl2.setText("Empate");
            mostrarElementos();
            finish = true;
        }
        return finish;
    }
    
    private void mostrarElementos(){
        this.jp.setVisible(true);
        this.jl1.setVisible(true);
        this.jl2.setVisible(true);
        this.jb1.setVisible(true);
        this.jb2.setVisible(true);
        this.jl3.setVisible(false);
        this.jl4.setVisible(false);
    }
    
}
