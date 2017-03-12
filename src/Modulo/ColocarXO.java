/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author b1796
 */
public class ColocarXO {
    
    private final int turno;
    private final JLabel jLabel;

    public ColocarXO(int turno, JLabel jLabel) {
        this.turno = turno;
        this.jLabel = jLabel;
    }
    
    private void setX(JLabel jLabel){
        ImageIcon imagen = new ImageIcon("src/Images/x_image.png"); 
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
                jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_DEFAULT)); 
        jLabel.setIcon(icono);
    }
    
    private void setO(JLabel jLabel){
        ImageIcon imagen = new ImageIcon("src/Images/o_image.png"); 
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
                jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_DEFAULT)); 
        jLabel.setIcon(icono);
    }
    
    public int execute(){
        if(this.turno % 2 == 0){
            setO(this.jLabel);
            return 1;
        }else{
            setX(this.jLabel);
            return 2;
        }
    }
    
}
