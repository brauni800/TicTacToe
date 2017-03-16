/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana;

import modulo.ColocarXO;
import modulo.Play;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

/**
 * Esta clase se encargara de generar la ventana
 * del juego y los metodos principales
 * que haran funcionar el juego del TicTacToe.
 * @author Carlos Braulio Betancourt Estrada
 * @version 1.1 15 de Marzo del 2017
 */
public class Main extends javax.swing.JFrame {
    /**
     * Arreglo que contiene objetos de tipo Main.
     */
    private Main[] arrayMain;
    /**
     * Variable int.
     */
    private int turno, a, b;
    /**
     * Arreglo que contiene enteros.
     * Este arreglo sirve para llevar un registro de
     * que jugador ocupa una respectiva
     * casilla del TicTacToe.
     */
    private int[][] array;
    /**
     * Variable de tipo Boolean.
     * Indica si el juego esta ejecutandose o ha terminado.
     */
    private boolean juegoTerminado;
    /**
     * Variable de tipo JLabel.
     * Se utilizara para almacenar el valor
     * de un JLabel para luego poder
     * relacionarlo con una coordenada.
     */
    private JLabel jl;

    /**
     * Creates new form Main.
     */
    public Main() {
        this.array = new int[3][3];
        this.turno = 0;
        initComponents();
        this.jPanel1.setVisible(false);
        this.jLabel13.setVisible(false);
        this.jLabel14.setVisible(false);
        this.jButton1.setVisible(false);
        this.jButton2.setVisible(false);
        this.juegoTerminado = false;
        arregloMain();
    }
    /**
     * Constructor que relaciona los JLabel
     * con su respectiva posicion en el array.
     * @param jl jLabel que se relaciona con una coordenada
     * @param a coordenada x del array
     * @param b coordenada y del array
     * @see arreglo_con_coordenada( JLabel, int, int )
     */
    public Main(JLabel jl, int a, int b){
        this.jl = jl;
        this.a = a;
        this.b = b;
    }
    /**
     * Metodo que coloca una imagen en un jLabel.
     * @param main Objeto el cual se extraera sus
     * elementos para colocar una imagen en su JLabel
     * y registrar una casilla usada en arrayMain
     * en la coordenada que tenga guardada este objeto.
     * @see colocar_main( main )
     */
    private void colocar(Main main){
        boolean z;
        if (this.juegoTerminado) {
            z = false;
        } else {
            z = verificarIcono(main.jl);
        }
        if (z) {
            execute(main);
            this.arrayMain = extraerMain(main);
            if (!this.juegoTerminado) {
                Main m = turnoIA();
                execute(m);
                this.arrayMain = extraerMain(m);
            }
        }
    }
    /**
     * Crea un nuevo arreglo de objetos de tipo Main
     * excluyendo al Main que recibe como parametro.
     * @param main Elemento que se excluira en el arreglo.
     * @return Main[] - Arreglo conformado de objetos de tipo Main.
     * @see extraer_objeto_main( main )
     */
    private Main[] extraerMain(Main main){
        ArrayList tempList = new ArrayList();
        Main[] temp = null;
        for (int i = 0; i < this.arrayMain.length; i++) {
            if (this.arrayMain[i].a == main.a
                    && this.arrayMain[i].b == main.b) {
                //No hace nada
            } else {
                tempList.add(this.arrayMain[i]);
            }
        }
        temp = new Main[tempList.size()];
        for (int j = 0; j < tempList.size(); j++) {
            temp[j] = (Main) tempList.get(j);
        }
        return temp;
    }
    /**
     * Devuelve un objeto de tipo Main aleatorio
     * del arreglo de objetos de tipo Main arrayMain.
     * @return Main - Objeto de tipo Main.
     * @see devolver_Main_aleatorio()
     */
    private Main turnoIA() {
        Random rnd = new Random();
        int x = rnd.nextInt(this.arrayMain.length);
        Main m = this.arrayMain[x];
        return m;
    }
    /**
     * Metodo que se encarga de ejecutar
     * los metodos adecuados para que
     * funcione el algoritmo del juego.
     * @param main Objeto de tipo Main con el que se trabajara.
     */
    private void execute(Main main){
        int i = setIcon(main.jl);
        this.array[main.a][main.b] = i;
        this.juegoTerminado = verificarGanador();
        cambioTurno(i);
    }
    /**
     * Coloca una imagen en el JLabel correspondiente.
     * @param jl JLabel donde se colocara la imagen.
     * @return int - Numero del jugador que coloco su respectiva imagen.
     */
    private int setIcon(JLabel jl){
        ColocarXO xo = new ColocarXO(this.turno, jl);
        int i = xo.execute();
        this.repaint();
        return i;
    }
    /**
     * Cambia el turno del jugador.
     * @param i Turno actual que sera cambiado.
     * @see cambiar_turno( int )
     */
    private void cambioTurno(int i){
        this.turno++;
        if (i == 2) {
            this.jLabel3.setText("Jugador 1");
        } else {
            this.jLabel3.setText("Jugador 2");
        }
    }
    /**
     * Verifica si un JLabel tiene un icono.
     * @param jLabel JLabel a verificar.
     * @return true si JLabel tiene un icono y false si no tiene.
     * @see verificar_icono( JLabel )
     */
    private boolean verificarIcono(JLabel jLabel){
        if (jLabel.getIcon() == null) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Verifica que jugador gana el juego.
     * @return true si un jugador gana, false si no gana.
     * @see verificar_ganador()
     */
    private boolean verificarGanador() {
        Play play = new Play(this.array, this.jPanel1,
                this.jLabel13, this.jLabel14, this.jLabel2,
                this.jLabel3, this.jButton1, this.jButton2, this.turno);
        return play.whoWin();
    }
    /**
     * Arreglo de objetos de tipo Main.
     * @see arreglo_de_main()
     */
    private void arregloMain() {
        this.arrayMain = new Main[9];
        this.arrayMain[0] = new Main(this.jLabel4, 0, 0);
        this.arrayMain[1] = new Main(this.jLabel5, 0, 1);
        this.arrayMain[2] = new Main(this.jLabel6, 0, 2);
        this.arrayMain[3] = new Main(this.jLabel7, 1, 0);
        this.arrayMain[4] = new Main(this.jLabel8, 1, 1);
        this.arrayMain[5] = new Main(this.jLabel9, 1, 2);
        this.arrayMain[6] = new Main(this.jLabel10, 2, 0);
        this.arrayMain[7] = new Main(this.jLabel11, 2, 1);
        this.arrayMain[8] = new Main(this.jLabel12, 2, 2);
    }
    /**
     * Metodo que reinicia todas las variables del juego
     * a sus valores originales
     * para ser utilizadas nuevamente.
     * @see reiniciar_juego()
     */
    private void resetGame() {
        this.jPanel1.setVisible(false);
        this.jLabel13.setVisible(false);
        this.jLabel14.setVisible(false);
        this.jButton1.setVisible(false);
        this.jButton2.setVisible(false);
        this.jLabel4.setIcon(null);
        this.jLabel5.setIcon(null);
        this.jLabel6.setIcon(null);
        this.jLabel7.setIcon(null);
        this.jLabel8.setIcon(null);
        this.jLabel9.setIcon(null);
        this.jLabel10.setIcon(null);
        this.jLabel11.setIcon(null);
        this.jLabel12.setIcon(null);
        this.jLabel3.setText("Jugador 1");
        this.turno = 0;
        this.array = new int[3][3];
        this.juegoTerminado = false;
        this.jLabel2.setVisible(true);
        this.jLabel3.setVisible(true);
        arregloMain();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setText("El juego ha terminado");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("El ganador es:");

        jButton2.setText("Cerrar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton1.setText("Reiniciar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2)))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 240, 190));

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, 100));

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 100, 100));

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 100));

        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 100, 100));

        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 100, 100));

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, 100));

        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 100, 100));

        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 100, 100));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel3.setText("Jugador 1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 70, 40));

        jLabel2.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jLabel2.setText("Turno:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/board.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 360, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel4, 0, 0));
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel5, 0, 1));
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel6, 0, 2));
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel7, 1, 0));
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel8, 1, 1));
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel9, 1, 2));
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel10, 2, 0));
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel11, 2, 1));
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        colocar(new Main(this.jLabel12, 2, 2));
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        resetGame();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
