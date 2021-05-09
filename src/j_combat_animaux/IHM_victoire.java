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
import javax.swing.JOptionPane;

/**
 *
 * @author ELOISE
 * @author ANNA
 */
public class IHM_victoire extends javax.swing.JFrame {
    private File fichiervictoire = new File("src/images/victoire0.jpg");
    private BufferedImage imageVictoire;
    /**
     * Creates new form IHM_victoire
     */
    public IHM_victoire(String nom_vainqueur) {
        initComponents();
        setBounds(0, 0, 985, 600);
        jPanelvictoire.setFocusable(true);//on peut appliquer des actions sur le JPanel lui-même (cliquer, récup des coordonnées par rapport au Jpanel,ect..)
        jLabelNom_du_vinqueur.setText(nom_vainqueur);
        try {
            imageVictoire = ImageIO.read(fichiervictoire);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichiervictoire inutilisable");
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

        jPanelvictoire = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imageVictoire,0,0, null);
            }
        }
        ;
        jLabel1 = new javax.swing.JLabel();
        jLabelNom_du_vinqueur = new javax.swing.JLabel();
        jButtonRecommencer = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Victoire du joueur");

        jLabelNom_du_vinqueur.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabelNom_du_vinqueur.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNom_du_vinqueur.setText("     X");

        jButtonRecommencer.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRecommencer.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonRecommencer.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRecommencer.setText("Nouvelle Partie");
        jButtonRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecommencerActionPerformed(evt);
            }
        });

        jButtonQuitter.setBackground(new java.awt.Color(0, 0, 0));
        jButtonQuitter.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jButtonQuitter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonQuitter.setText("Quitter Jeu de la Junlge");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelvictoireLayout = new javax.swing.GroupLayout(jPanelvictoire);
        jPanelvictoire.setLayout(jPanelvictoireLayout);
        jPanelvictoireLayout.setHorizontalGroup(
            jPanelvictoireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelvictoireLayout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addGroup(jPanelvictoireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelvictoireLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(257, 257, 257))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelvictoireLayout.createSequentialGroup()
                        .addComponent(jButtonRecommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(jButtonQuitter)
                        .addGap(221, 221, 221))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelvictoireLayout.createSequentialGroup()
                        .addComponent(jLabelNom_du_vinqueur, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))))
        );
        jPanelvictoireLayout.setVerticalGroup(
            jPanelvictoireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelvictoireLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelNom_du_vinqueur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanelvictoireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRecommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelvictoire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelvictoire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecommencerActionPerformed
     IHM_acceuil ihm=new IHM_acceuil();
     ihm.setVisible(true);
     setVisible(false);
    }//GEN-LAST:event_jButtonRecommencerActionPerformed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        JOptionPane.showMessageDialog(this, "Merci d'avoir joué ,\n Au revoir!");
        System.exit(0);
    }//GEN-LAST:event_jButtonQuitterActionPerformed

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
            java.util.logging.Logger.getLogger(IHM_victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_victoire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_victoire(String nom_vainqueur).setVisible(true);
}
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRecommencer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNom_du_vinqueur;
    private javax.swing.JPanel jPanelvictoire;
    // End of variables declaration//GEN-END:variables
}
