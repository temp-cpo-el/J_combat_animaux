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
 * @author ELOISE
 */
public class IHM_plateau extends javax.swing.JFrame {

    private File fichierplateau = new File("src/images/plateau0.png");//on va chercher le fichier dans le dossier d'images
    private BufferedImage imagePlateau;//la placer en tant que bufferedImage permet de la redessiner à chaque coup
    
    //Bon on va y aller comme un bourin mais franchement je suis pas contre une meilleure methode:
    //fichier et image pour tous les bleus:
    private File fichierelephB = new File("src/images/éléphan_bleu0.jpg");
    private BufferedImage imageElephB;
    private File fichierRatB = new File("src/images/rat_bleu0.jpg");
    private BufferedImage imageRatB;
    private File fichierChatB = new File("src/images/chat_bleu0.jpg");
    private BufferedImage imageChatB;
    private File fichierChienB = new File("src/images/chien_bleu0.jpg");
    private BufferedImage imageChienB;
    private File fichierLionB = new File("src/images/lion_bleu0.jpg");
    private BufferedImage imageLionB;
    private File fichierLoupB = new File("src/images/loup_bleu0.jpg");
    private BufferedImage imageLoupB;
    private File fichierPanB = new File("src/images/panthère_bleu0.jpg");
    private BufferedImage imagePanB;
    private File fichierTigreB = new File("src/images/tigre_bleu0.jpg");
    private BufferedImage imageTigreB;

    //fichier et image pour tous les rouges:
    private File fichierelephR = new File("src/images/éléphan_rouge0.jpg");
    private BufferedImage imageElephR;
    private File fichierRatR = new File("src/images/rat_rouge0.jpg");
    private BufferedImage imageRatR;
    private File fichierChatR = new File("src/images/chat_rouge0.jpg");
    private BufferedImage imageChatR;
    private File fichierChienR = new File("src/images/chien_rouge0.jpg");
    private BufferedImage imageChienR;
    private File fichierLionR = new File("src/images/lion_rouge0.jpg");
    private BufferedImage imageLionR;
    private File fichierLoupR = new File("src/images/loup_rouge0.jpg");
    private BufferedImage imageLoupR;
    private File fichierPanR = new File("src/images/panthère_rouge0.jpg");
    private BufferedImage imagePanR;
    private File fichierTigreR = new File("src/images/tigre_rouge0.jpg");
    private BufferedImage imageTigreR;

    /*BufferedImage[]anirouges=new BufferedImage[8];
        File[] fichierrouges=new File[8];*/
    /**
     * Creates new form IHM_plateau
     */
    public IHM_plateau() {
        initComponents();
        setBounds(0, 0, 985, 810);     //poser un setBounds(positionné au milieu de l'écran, 524,672);
        /*//tableau avec les images rouges:
        anirouges[0]=imageChatR;
        anirouges[1]=imageChienR;
        anirouges[2]=imageElephR;
        anirouges[3]=imageLionR;
        anirouges[4]=imageLoupR;
        anirouges[5]=imagePanR;
        anirouges[6]=imageRatR;
        anirouges[7]=imageTigreR;
        //tableau avec les fichiers rouges:
        fichierrouges[0]=fichierChatR;
        fichierrouges[1]=fichierChienR;
        fichierrouges[2]=fichierelephR;
        fichierrouges[3]=fichierLionR;
        fichierrouges[4]=fichierLoupR;
        fichierrouges[5]=fichierPanR;
        fichierrouges[6]=fichierRatR;
        fichierrouges[7]=fichierTigreR;*/
        jPanel1.setFocusable(true);//on peut appliquer des actions sur le JPanel lui-même (cliquer, récup des coordonnées par rapport au Jpanel,ect..)
        try {
            imagePlateau = ImageIO.read(fichierplateau);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierplateau inutilisable");
        }
        try {
            imageElephB = ImageIO.read(fichierelephB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierelepehB inutilisable");
        }
        try {
            imageChatB = ImageIO.read(fichierChatB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierechatR inutilisable");
        }
        try {
            imageChienB = ImageIO.read(fichierChienB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierchienB inutilisable");
        }
        try {
            imageLionB = ImageIO.read(fichierLionB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierlionB inutilisable");
        }
        try {
            imageLoupB = ImageIO.read(fichierLoupB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierloupB inutilisable");
        }
        try {
            imagePanB = ImageIO.read(fichierPanB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierelpanB inutilisable");
        }
        try {
            imageRatB = ImageIO.read(fichierRatB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichieratB inutilisable");
        }
        try {
            imageTigreB = ImageIO.read(fichierTigreB);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichiertigreB inutilisable");
        }
        /*        for (int i = 0; i < anirouges.length; i++) {
            try{
              anirouges[i]=ImageIO.read(fichierrouges[i]);//petite boucles pour afficher les images rouges  
                System.out.println("image "+i+" chargée");
            }catch(IOException ex){
                System.out.println("Tu t'es planté dans ton try des rouges");
            }
            
        }*/
        try {
            imageChatR = ImageIO.read(fichierChatR);
        } catch (IOException ex) {
            System.out.println("BLeh chat");
        }
        try {
            imageTigreR = ImageIO.read(fichierTigreR);
        } catch (IOException ex) {
            System.out.println("BLeh tigre");
        }
        try {
            imageRatR = ImageIO.read(fichierRatR);
        } catch (IOException ex) {
            System.out.println("BLeh rat");
        }
        try {
            imagePanR = ImageIO.read(fichierPanR);
        } catch (IOException ex) {
            System.out.println("BLeh panthère");
        }
        try {
            imageLoupR = ImageIO.read(fichierLoupR);
        } catch (IOException ex) {
            System.out.println("BLeh loup");
        }
        try {
            imageLionR = ImageIO.read(fichierLionR);
        } catch (IOException ex) {
            System.out.println("BLeh lion");
        }
        try {
            imageElephR = ImageIO.read(fichierelephR);
        } catch (IOException ex) {
            System.out.println("BLeh elephant");
        }
        try {
            imageChienR = ImageIO.read(fichierChienR);
        } catch (IOException ex) {
            System.out.println("BLeh chien");
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

        jPanel1 = new javax.swing.JPanel() {
            public void paintComponent(Graphics g){
                //images bleues
                g.drawImage(imagePlateau,0,0, null);
                g.drawImage(imageElephB,x_el_bleu,y_el_bleu,null);//copier/coller pour le reste
                g.drawImage(imageRatB,x_rat_bleu,y_rat_bleu,null);
                g.drawImage(imageChatB,x_chat_bleu,y_chat_bleu,null);
                g.drawImage(imageChienB,x_chien_bleu,y_chien_bleu,null);
                g.drawImage(imageLionB,x_lion_bleu,y_lion_bleu,null);
                g.drawImage(imageLoupB,x_loup_bleu,y_loup_bleu,null);
                g.drawImage(imagePanB,x_pan_bleu,y_pan_bleu,null);
                g.drawImage(imageTigreB,x_tig_bleu,y_tig_bleu,null);
                //image rouges
                g.drawImage(imageElephR,x_el_rou,y_el_rou,null);
                g.drawImage(imageRatR,x_rat_rou,y_rat_rou,null);
                g.drawImage(imageChatR,x_chat_rou,y_chat_rou,null);
                g.drawImage(imageChienR,x_chien_rou,y_chien_rou,null);
                g.drawImage(imageLionR,x_lion_rou,y_lion_rou,null);
                g.drawImage(imageLoupR,x_loup_rou,y_loup_rou,null);
                g.drawImage(imagePanR,x_pan_rou,y_pan_rou,null);
                g.drawImage(imageTigreR,x_tig_rou,y_tig_rou,null);

                //pour afficher les pions faudra leur assigner des cooordonnées
            }
        }
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private int xtemp, ytemp;
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        xtemp = evt.getX();
        System.out.println("x:" + xtemp);
        ytemp = evt.getY();
        System.out.println("y:" + ytemp + "\n");
        
    }//GEN-LAST:event_jPanel1MouseClicked
    private int x_el_rou = 225, y_el_rou = 20, x_rat_rou = 225, y_rat_rou = 644, x_chat_rou = 120, y_chat_rou = 118, x_chien_rou = 120, y_chien_rou = 539, x_lion_rou = 14, y_lion_rou = 644, x_loup_rou = 225, y_loup_rou = 223, x_pan_rou = 225, y_pan_rou = 433, x_tig_rou = 14, y_tig_rou = 14;
    private int x_el_bleu = 642, y_el_bleu = 644, x_rat_bleu = 642, y_rat_bleu = 14, x_chat_bleu = 747, y_chat_bleu = 539, x_chien_bleu = 747, y_chien_bleu = 118, x_lion_bleu = 852, y_lion_bleu = 14, x_loup_bleu = 642, y_loup_bleu = 433, x_pan_bleu = 642, y_pan_bleu = 223, x_tig_bleu = 852, y_tig_bleu = 644;

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
            java.util.logging.Logger.getLogger(IHM_plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IHM_plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IHM_plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IHM_plateau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_plateau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
