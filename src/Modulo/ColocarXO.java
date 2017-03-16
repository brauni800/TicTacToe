/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Esta clase se encargara de colocar una imagen
 * sea O u X, segun corresponda al jugador
 * en turno.
 * @author Carlos Braulio Betancourt Estrada
 * @version 1.1 15 de Marzo del 2017
 */
public class ColocarXO {
    /**
     * Almacena el valor del turno que recibe
     * del constructor.
     */
    private final int turno;
    /**
     * Almacena el valor del JLabel que recibe
     * del constructor.
     */
    private final JLabel jLabel;
    /**
     * Constructor.
     * @param turno numero del turno que se encuentre
     * el juego en ese momento.
     * @param jLabel JLabel dode se colocara la imagen.
     */
    public ColocarXO(int turno, JLabel jLabel) {
        this.turno = turno;
        this.jLabel = jLabel;
    }
    /**
     * Coloca la imagen X en el JLabel.
     * @param jLabel JLabel donde se colocara la imagen.
     */
    private void setX(JLabel jLabel) {
        ImageIcon imagen = new ImageIcon("src/Images/x_image.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
                jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_DEFAULT));
        jLabel.setIcon(icono);
    }
    /**
     * Coloca la imagen O en el JLabel.
     * @param jLabel JLabel donde se colocara la imagen.
     */
    private void setO(JLabel jLabel) {
        ImageIcon imagen = new ImageIcon("src/Images/o_image.png");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
                jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_DEFAULT));
        jLabel.setIcon(icono);
    }
    /**
     * Asigna la imagen correspondiente al respectivo jugador.
     * La imagen O es para el Jugadr 1.
     * La imagen X es para el jugador 2.
     * @return int - el numero del jugador al cual se le
     * asigno una imagen.
     */
    public final int execute() {
        if (this.turno % 2 == 0) {
            setO(this.jLabel);
            return 1;
        } else {
            setX(this.jLabel);
            return 2;
        }
    }
}
