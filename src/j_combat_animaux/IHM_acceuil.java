/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author annag
 */
public class IHM_acceuil extends javax.swing.JFrame {

    private File fichierAcceuil = new File("src/images/acceuil0.jpg");
    private BufferedImage imageAcceuil;
    /**
     * Creates new form IHM_acceuil
     */
    public IHM_acceuil() {
        initComponents();
        setBounds(0, 0, 972,640);
         jPanelacceuil.setFocusable(true);//on peut appliquer des actions sur le JPanel lui-même (cliquer, récup des coordonnées par rapport au Jpanel,ect..)
        try {
            imageAcceuil = ImageIO.read(fichierAcceuil);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierAcceuil inutilisable");
        }
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
        jPanelacceuil = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imageAcceuil,0,0, null);
            }
        }

        ;
        jButtonjouer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonjouer.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        jButtonjouer.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jButtonjouer.setText("JOUER");
        jButtonjouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonjouerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabel1.setText("Bienvenue \ndans \nLe jeu de la jungle!");

        javax.swing.GroupLayout jPanelacceuilLayout = new javax.swing.GroupLayout(jPanelacceuil);
        jPanelacceuil.setLayout(jPanelacceuilLayout);
        jPanelacceuilLayout.setHorizontalGroup(
            jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelacceuilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jButtonjouer, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelacceuilLayout.setVerticalGroup(
            jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelacceuilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(jButtonjouer, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelacceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelacceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonjouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonjouerActionPerformed
      IHM_plateau ihm1= new IHM_plateau();
        ihm1.setVisible(true);
        setVisible(false);//ferme l'ihm d'acceuil
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonjouerActionPerformed

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
            java.util.logging.Logger.getLogger(IHM_acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_acceuil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonjouer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelacceuil;
    // End of variables declaration//GEN-END:variables
}
