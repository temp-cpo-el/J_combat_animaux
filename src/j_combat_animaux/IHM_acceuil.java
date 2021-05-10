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
import javax.swing.JTextField;

/**
 *
 * @author ELOISE
 * @author ANNA
 */
public class IHM_acceuil extends javax.swing.JFrame {

    private File fichierAcceuil = new File("src/images/acceuil0.jpg");
    private BufferedImage imageAcceuil;
    //public boolean option_de_jeu;
    private String JoueurB,JoueurR;

    
    /**
     * Creates new form IHM_acceuil
     */
    public IHM_acceuil() {
        initComponents();
        setBounds(0, 0, 977,708);
         jPanelacceuil.setFocusable(true);//on peut appliquer des actions sur le JPanel lui-même (cliquer, récup des coordonnées par rapport au Jpanel,ect..)
        try {
            imageAcceuil = ImageIO.read(fichierAcceuil);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierAcceuil inutilisable");
        }
       /*
      if (jRadioButtonnouvellepartie.isSelected()){
            option_de_jeu=false;           
        }
        if (jRadioButtonreprendrepartie.isSelected()){
            option_de_jeu=true;
        }*/  
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
        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelacceuil = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(imageAcceuil,0,0, null);
            }
        }

        ;
        jButtonjouer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextJoueurR = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextJoueurB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonjouer.setBackground(new java.awt.Color(0, 0, 0));
        jButtonjouer.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jButtonjouer.setForeground(new java.awt.Color(255, 255, 255));
        jButtonjouer.setText("JOUER");
        jButtonjouer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonjouerActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 1, 36)); // NOI18N
        jLabel1.setText("Bienvenue    ");

        jLabel2.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(9, 9, 0));
        jLabel2.setText("Joueur Rouge");

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(7, 0, 0));
        jLabel3.setText("Joueur Bleu");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("pseudo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("pseudo:");

        jLabel7.setFont(new java.awt.Font("Viner Hand ITC", 1, 24)); // NOI18N
        jLabel7.setText("dans");

        jLabel8.setFont(new java.awt.Font("Viner Hand ITC", 1, 48)); // NOI18N
        jLabel8.setText("Le jeu de la jungle!");

        jButton1.setBackground(new java.awt.Color(0, 51, 0));
        jButton1.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("voir les regles du jeu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelacceuilLayout = new javax.swing.GroupLayout(jPanelacceuil);
        jPanelacceuil.setLayout(jPanelacceuilLayout);
        jPanelacceuilLayout.setHorizontalGroup(
            jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelacceuilLayout.createSequentialGroup()
                .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jLabel1))
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(jLabel7))
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelacceuilLayout.createSequentialGroup()
                                .addComponent(jTextJoueurR, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(jLabel6))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextJoueurB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jLabel8))
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelacceuilLayout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jButtonjouer, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        jPanelacceuilLayout.setVerticalGroup(
            jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelacceuilLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(26, 26, 26)
                .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanelacceuilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextJoueurR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jTextJoueurB, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(56, 56, 56)
                .addComponent(jButtonjouer)
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelacceuil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelacceuil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonjouerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonjouerActionPerformed
        JoueurR=jTextJoueurR.getText();
        JoueurB=jTextJoueurB.getText();
        if (jTextJoueurR.getText().isEmpty()){
            JoueurR= "Joueur Rouge";
        }
         if (jTextJoueurB.getText().isEmpty()){
            JoueurB= "Joueur Bleu";
        }

        System.out.println("Joueur Rouge: "+JoueurR+"\nJoueur Bleu: "+JoueurB);
        
        
       
        /*if (jRadioButtonnouvellepartie.isSelected()){
            option_de_jeu=false;           
        }
        if (jRadioButtonreprendrepartie.isSelected()){
            option_de_jeu=true;
        }*/
        //System.out.println( "option de jeu="+option_de_jeu);
       
      
        //ihm1.setVariable(option_de_jeu);
       /* IHM_plateau ihm1= new IHM_plateau(JoueurR,JoueurB,option_de_jeu);
        ihm1.setVariable(option_de_jeu);*/
        IHM_plateau ihm1= new IHM_plateau(JoueurR,JoueurB);
        ihm1.setVisible(true);
        setVisible(false);//ferme l'ihm d'acceuil {                                                           
        JOptionPane.showMessageDialog(ihm1, "Les rouges commencent\nSélectionner un animal avec la souris puis,\nZ : monter\nS : descendre\nQ : Gauche\nD : droite\nBonne partie!");
        //int np=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonjouerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"            But du jeu  \n Le but du jeu est d'atteindre la tanière adverse avant l'adversaire ( la case blanche du plateau).  "
                + "\n           Comment jouer? \nChaque joueur a 8 sortes d'animaux à sa dispositon:\n-Le rat, le plus faible qui peut se faire manger par tous les autres animaux sauf l'Elephant qu'il peut manger ainsi que le rat de l'autre équipe. Il peut aussi nager dans la rivière (cases bleues). "
                + "\n-Le chat, il peut se faire manger par tout le monde sauf le rat qu'il peut manger ainsi que le chat adverse, il ne peut pas traverser la rivière et doit en faire le tour."
                + "\n-Le Loup peut manger tout le monde sauf le rat et le chat qu'il peut manger ainsi que le loup adverse,il ne peut pas traverser la rivière et doit en faire le tour."
                + "\n    et ainsi de suite pour tous les animaux( Vous pourrez trouver le rang des animaux en haut du plateau de jeu)."
                + "\n il y a une exception pour le tigre et le lion qui peuvent sauter au dessus de la rivière."
                + "\nLorsqu'un animal est sur une case marron alors il peut être mangé par n'importe quel animal."
                + "A vous de jouer!","Regle du jeu",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

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
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_acceuil().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonjouer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelacceuil;
    private javax.swing.JTextField jTextJoueurB;
    private javax.swing.JTextField jTextJoueurR;
    // End of variables declaration//GEN-END:variables
}
