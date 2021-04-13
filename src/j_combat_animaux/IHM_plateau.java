/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 *
 * @author ELOISE
 * @author ANNA
 */
public class IHM_plateau extends javax.swing.JFrame {

    private File fichierplateau = new File("src/images/plateau3.png");//on va chercher le fichier dans le dossier d'images
    private BufferedImage imagePlateau;//la placer en tant que bufferedImage permet de la redessiner à chaque coup
    private File fichierfondplateau = new File("src/images/Fond_plateau_de_jeu0.png");//on va chercher le fichier dans le dossier d'images
    private BufferedImage imageFondPlateau;
    private ImageIcon isoleil = new ImageIcon("src/images/petit_soleil.jpg");//pour afficher le tour du joueur, mais pour l'instant, ça marche, pareille pour les papattes, du coup je les ai pas rajoutées
    private int[] ligne = new int[7];
    private int[] col = new int[9];
    private Zone RH = new Zone(521, 754, 210, 350, 0);//définition des zones de rivières
    private Zone RB = new Zone(521, 754, 500, 640, 1);
    //private Zone CimR= new Zone(244,329,408,496);
    private zone_piege cases_piege = new zone_piege(235, 305, 330, 404, 235, 495, 995, 305, 900, 404, 995, 495);//definition zone piege

    private int x_zonepd = 0;
    private int x_zonepf = 0;
    private int y_zonepd = 0;
    private int y_zonepf = 0;
    // coordonnées de la zone qui entour la piece

    private Animal[] ani = new Animal[16];//j'ai changé la valeur du tableau juste pour les essais
    private int nbani = 0;//servira pour choper l'animal correspondant

    private File[] tab_fich = new File[16];
    private BufferedImage[] image = new BufferedImage[16];
    private int[] x_aff = new int[16];
    private int[] y_aff = new int[16];//coordonnées d'affichage des pieces

    private int[] x_sauv = new int[16];
    private int[] y_sauv = new int[16];//coordonnéers de la sauvegarde
    
    private int[] ligne_sauv=new int[32];

    //pour la mort
    private ArrayList<String> morts = new ArrayList<>();//tableau de mort
    private final int xm = 3, ym = 200;

    //autres éléments utiles au code:
    private int coup;
    private int xtemp, ytemp;//coordonnees de la piece selectionné
    private boolean tour;
    private int compteur_tour = 0;
    private int ligne_proche;
    private int col_proche;
    private int indice = 0;

    boolean option;

    /**
     * Creates new form IHM_plateau
     */
    public IHM_plateau(String JoueurR, String JoueurB, boolean option_de_jeu) {

        initComponents();
        setVariable(option_de_jeu);
        //Définition des lignes du plateau Y
        ligne[0] = 118;
        ligne[1] = 210;
        ligne[2] = 305;
        ligne[3] = 404;
        ligne[4] = 495;
        ligne[5] = 590;
        ligne[6] = 685;
        //Définition des colonnes du plateau X
        col[0] = 235;
        col[1] = 330;
        col[2] = 425;
        col[3] = 520;
        col[4] = 615;
        col[5] = 711;
        col[6] = 805;
        col[7] = 900;
        col[8] = 995;
        /*Définitions de tous les animaux selon leur classe, c'est plus court: */

        Animal a1 = new Animal("rat", 808, 121, 0, 0, 1, 1, true, false);//rat de rang 1 couleur:bleu
        Animal a2 = new Animal("chat", 902, 595, 0, 0, 2, 2, true, false);
        Animal a3 = new Animal("loup", 808, 500, 0, 0, 3, 3, true, false);
        Animal a4 = new Animal("chien", 903, 215, 0, 0, 4, 4, true, false);
        Animal a5 = new Animal("panthère", 808, 312, 0, 0, 5, 5, true, false);
        Animal a6 = new Animal("lion", 997, 121, 0, 0, 6, 6, true, false);
        Animal a7 = new Animal("tigre", 997, 691, 0, 0, 7, 7, true, false);
        Animal a8 = new Animal("elephant", 807, 691, 0, 0, 8, 8, true, false);
        Animal a9 = new Animal("rat", 427, 691, 0, 0, 1, 1, false, false);//rat de rang 1 couleur:rouge
        Animal a10 = new Animal("chat", 333, 215, 0, 0, 2, 2, false, false);
        Animal a11 = new Animal("loup", 428, 310, 0, 0, 3, 3, false, false);
        Animal a12 = new Animal("chien", 333, 596, 0, 0, 4, 4, false, false);
        Animal a13 = new Animal("panthère", 428, 501, 0, 0, 5, 5, false, false);
        Animal a14 = new Animal("lion", 239, 691, 0, 0, 6, 6, false, false);
        Animal a15 = new Animal("tigre", 239, 121, 0, 0, 7, 7, false, false);
        Animal a16 = new Animal("elephant", 427, 121, 0, 0, 8, 8, false, false);

        ajouterAnimal(a1);
        ajouterAnimal(a2);
        ajouterAnimal(a3);
        ajouterAnimal(a4);
        ajouterAnimal(a5);
        ajouterAnimal(a6);
        ajouterAnimal(a7);
        ajouterAnimal(a8);
        ajouterAnimal(a9);
        ajouterAnimal(a10);
        ajouterAnimal(a11);
        ajouterAnimal(a12);
        ajouterAnimal(a13);
        ajouterAnimal(a14);
        ajouterAnimal(a15);
        ajouterAnimal(a16);

        setBounds(0, 0, 1330, 915);     //poser un setBounds(positionné au milieu de l'écran, 524,672);
        jPanel1.setFocusable(true);//on peut appliquer des actions sur le JPanel lui-même (cliquer, récup des coordonnées par rapport au Jpanel,ect..)
        try {
            imagePlateau = ImageIO.read(fichierplateau);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierplateau inutilisable");
        }

        /* Ce qui nous sauvera, parce que tout le reste est dans une fonction autre part!*/
        try {
            imageFondPlateau = ImageIO.read(fichierfondplateau);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierfondplateau inutilisable");
        }
        creation_aff();

        
        afficherAnimaux(ani);

        jLabelJoueurR.setText(JoueurR);
        jLabelJoueurB.setText(JoueurB);

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
                //affichage fond plateau
                g.drawImage(imageFondPlateau,0,0, null);
                //affichage plateau
                g.drawImage(imagePlateau,229,110, null);
                /*//affichage soleil
                if(true){
                    g.drawImage(imagesoleil,12,200,null);
                }
                else{
                    g.drawImage(imagesoleil,1234,200,null);
                }*/
                /*nouveau code du customize code:
                */
                for(int i=0; i<ani.length; i++){
                    if(!morts.contains(""+ani[i].getNom()+ani[i].getCouleur())){
                        g.drawImage(image[i],x_aff[i],y_aff[i],null);
                    }
                    if (ani[i].isIsSelected()){
                        g.setColor(Color.RED);
                        Graphics2D g2 = (Graphics2D) g;
                        g2.setStroke(new BasicStroke(5));
                        g2.drawOval(x_aff[i], y_aff[i]+10, 100, 70);
                        //g.drawOval(x_aff[i], y_aff[i]+10, 100, 70);
                        ani[i].setIsSelected(false);
                    }
                }

            }
        }
        ;
        jButtonRecommencer = new javax.swing.JButton();
        jButtonSauvegarde = new javax.swing.JButton();
        jButtonQuitter = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelJoueurR = new javax.swing.JLabel();
        jLabelJoueurB = new javax.swing.JLabel();
        jLabelsoleilbleu = new javax.swing.JLabel();
        jLabelsoleilrouge = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jButtonRecommencer.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRecommencer.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButtonRecommencer.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRecommencer.setText("Recommencer la Partie");
        jButtonRecommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecommencerActionPerformed(evt);
            }
        });

        jButtonSauvegarde.setBackground(new java.awt.Color(0, 0, 0));
        jButtonSauvegarde.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButtonSauvegarde.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSauvegarde.setText("Sauvegarder la Partie");
        jButtonSauvegarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSauvegardeActionPerformed(evt);
            }
        });

        jButtonQuitter.setBackground(new java.awt.Color(0, 0, 0));
        jButtonQuitter.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jButtonQuitter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonQuitter.setText("QUITTER");
        jButtonQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitterActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/animaux_5_83.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/animaux_1_43.png"))); // NOI18N

        jLabelJoueurR.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelJoueurR.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJoueurR.setText("Joueur Rouge");

        jLabelJoueurB.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabelJoueurB.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJoueurB.setText("Joueur Bleu");

        jLabelsoleilrouge.setBackground(new java.awt.Color(0, 153, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonRecommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSauvegarde, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelJoueurR, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelJoueurB)
                                .addGap(100, 100, 100))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabelsoleilrouge, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelsoleilbleu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJoueurB, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelJoueurR, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelsoleilrouge, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRecommencer, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSauvegarde, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelsoleilbleu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1311, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        xtemp = evt.getX();
        System.out.println("\nx:" + xtemp);
        ytemp = evt.getY();
        System.out.println("y:" + ytemp + "\n");
        tour_du_joueur();
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        //COMMENT JE FAIS POUR ENLEVER CA????
    }//GEN-LAST:event_jPanel1FocusGained


    private void jButtonSauvegardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSauvegardeActionPerformed
        for (int i = 0; i < 16; i++) {
            x_sauv[i] = ani[i].getX();
            y_sauv[i] = ani[i].getY();
            
            System.err.println("x_aff" + i + "=" + x_aff[i]);
            System.err.println("x_sauv" + i + "=" + x_sauv[i]);
            System.err.println("y_aff" + i + "=" + y_aff[i]);
            System.err.println("y_sauv" + i + "=" + y_sauv[i]);
        }
        sauvegarde();


    }//GEN-LAST:event_jButtonSauvegardeActionPerformed

    private void jButtonRecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecommencerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRecommencerActionPerformed

    String pressed;
    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

        /*if (option_deplacement == 1) {
            if (evt.getKeyChar() == KeyEvent.VK_KP_DOWN  && coup > 0) {//fleche vers le bas
                y_aff[indice] -= 95;
            }
            if (evt.getKeyChar() == KeyEvent.VK_KP_UP && coup > 0) {//^|

                y_aff[indice] += 95;
            }
            if (evt.getKeyChar() == KeyEvent.VK_LEFT && coup > 0) {//<-

                x_aff[indice] -= 95;
            }
            if (evt.getKeyChar() == KeyEvent.VK_RIGHT && coup > 0) {//->

                x_aff[indice] += 95;
            }
            
        }*/
        //if (option_deplacement == 2) {
        if (coup > 0 && ani[indice].isBleu() == tour) {
            xtemp = ani[indice].getX();//pour pouvoir les comparer après
            ytemp = ani[indice].getY();//pour pouvoir les comparer après
            if (evt.getKeyChar() == 'z' && coup > 0) {//Z
                y_aff[indice] -= 95;
                pressed = "z";
                ani[indice].setY(y_aff[indice]);
            }
            if (evt.getKeyChar() == 's' && coup > 0) {//S

                y_aff[indice] += 95;
                pressed = "s";
                ani[indice].setY(y_aff[indice]);
            }
            if (evt.getKeyChar() == 'q' && coup > 0) {//Q

                x_aff[indice] -= 95;
                pressed = "q";
                ani[indice].setX(x_aff[indice]);
            }
            if (evt.getKeyChar() == 'd' && coup > 0) {//D

                x_aff[indice] += 95;
                pressed = "d";
                ani[indice].setX(x_aff[indice]);
            } //}
            if (coup == 0) {//fin du coup possible
                coup = 0;
            } else {
                coup--;
            }
            System.out.println(pressed);//ça change rien de le changer de place je suis d'accord
            traitementBornes();
            traitementRivière();
            duel();
            piege();
            jPanel1.repaint();
            //traitementPiege();
            traitementTaniere();
            compteur_tour++;
        }

        System.out.println("variable coup= " + coup);
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jButtonQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitterActionPerformed
        System.exit(0);//à changer pour insérer plusiurs options (redémarrer, quitter, pause, enregistrer, tatati tatata)
    }//GEN-LAST:event_jButtonQuitterActionPerformed

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered

    }//GEN-LAST:event_jPanel1MouseEntered

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
 /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IHM_plateau().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonQuitter;
    private javax.swing.JButton jButtonRecommencer;
    private javax.swing.JButton jButtonSauvegarde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelJoueurB;
    private javax.swing.JLabel jLabelJoueurR;
    private javax.swing.JLabel jLabelsoleilbleu;
    private javax.swing.JLabel jLabelsoleilrouge;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
/* Ajout des toutes les fonctions dont on aura besoin pour faire fonctionner le code :*/

    private void ajouterAnimal(Animal a) {
        ani[nbani] = a;
        nbani++;

    }

    private void creation_aff() {
        for (int i = 0; i < ani.length; i++) {
            tab_fich[i] = new File("src/images/" + ani[i].getNom() + "_" + ani[i].getCouleur() + ".jpg");
        }
    }

    private void afficherAnimaux(Animal[] ani) {
        initComponents();

        System.err.println("option=" + option);

        if (option == true) {
            lecture();
            
            try {
                for (int i = 0; i < ani.length; i++) {
                    ani[i].setX(x_sauv[i]);
                    ani[i].setY(y_sauv[i]);
                    x_aff[i] = ani[i].getX();
                    y_aff[i] = ani[i].getY();
                    System.err.println("x_aff"+i+"="+x_aff[i]);
                    System.err.println("y_aff"+i+"="+y_aff[i]);
                    
                    image[i] = ImageIO.read(tab_fich[i]);
                    

                }
            } catch (IOException ex) {
                System.out.println("affichage des animaux impossible");
            }

        } if(option==false){
            try {
                for (int i = 0; i < ani.length; i++) {
                    ani[i].setX(ani[i].getX_init());
                    ani[i].setY(ani[i].getY_init());
                    x_aff[i] = ani[i].getX();
                    y_aff[i] = ani[i].getY();
                    image[i] = ImageIO.read(tab_fich[i]);

                }
            } catch (IOException ex) {
                System.out.println("affichage des animaux impossible");
            }
        }

    }

    private void tour_du_joueur() {
        if (compteur_tour % 2 == 0) {
            tour = false;//tour des rouges
            System.out.println("Tour des rouges");
            jLabelsoleilrouge.setIcon(isoleil);
            jLabelsoleilbleu.setIcon(null);
        } else {
            tour = true;//tour des bleus
            System.out.println("Tour des bleus");
            jLabelsoleilbleu.setIcon(isoleil);
            jLabelsoleilrouge.setIcon(null);
        }
        coup = 1;//on initialise le nombre de coup possible pour le joueur
        System.out.println("compteur_tour : " + compteur_tour);
        selecAnimaux();

    }

    private void selecAnimaux() {
        /**
         * fonction en plusieurs étapes: 1)chercher la ligne supérieure la pus
         * proche de xtemp séléectionné 2)chercher les points d'origines
         * d'éventuelles images dans une bande partant de cette origine 3)
         * afficher des carrés autour des images correspondantes sur la ligne on
         * verra pour le découpage par carré plus tard, pour l'instant on
         * cherche juste la ligne
         *
         *
         */
        for (int i = 0; i < ligne.length; i++) {

            if (ytemp > ligne[i]) {
                ligne_proche = ligne[i];
            }
            for (int j = 0; j < col.length; j++) {
                if (xtemp > col[j]) {
                    col_proche = col[j];

                }
            }
        }//on a récup la ligne et la colonne la plus proche
        for (int i = 0; i < ani.length; i++) {

            if (ligne_proche < ani[i].getY() && ani[i].getY() < ligne_proche + 20 && col_proche < ani[i].getX() && ani[i].getX() < col_proche + 20 && ani[i].isBleu() && tour) {
                ani[i].setIsSelected(true);//si notre clic correspond aux conditions, le booléen isSelected devient true
                indice = i;//in récupère l'indice correspondant à l'image dans le tableau d'animaux

            }
            if (ligne_proche < ani[i].getY() && ani[i].getY() < ligne_proche + 20 && col_proche < ani[i].getX() && ani[i].getX() < col_proche + 20 && !ani[i].isBleu() && !tour) {
                ani[i].setIsSelected(true);
                indice = i;
            }//on a deux conditions, une pour cahque couleur
        }

        jPanel1.repaint();//on repaint à la fin de selecanimaux pour afficher le cercle

    }

    private void traitementBornes() {
        //taille du panel:1800x1038
        //taille de link:90x90
        // Gauche
        if (x_aff[indice] < 239) {
            x_aff[indice] = 239;
            ani[indice].setX(x_aff[indice]);
        }
        //Droite
        if (x_aff[indice] > 1049) {
            x_aff[indice] = 997;
            ani[indice].setX(x_aff[indice]);
        }
        //Haut
        if (y_aff[indice] < 121) {
            y_aff[indice] = 121;
            ani[indice].setY(y_aff[indice]);
        }
        //BAS
        if (y_aff[indice] > 737) {
            y_aff[indice] = 691;
            ani[indice].setY(y_aff[indice]);
        }
        //condition : if l'animal a pas bougé de place --> rejouer
        if (xtemp == x_aff[indice] && ytemp == y_aff[indice]) {
            coup++;//on lui redonne un coup parce qu'il a fait un mouvement impossible
            compteur_tour--;//à nouveau au tour du joueur de la même couleur
            //ani[indice].setIsSelected(false);
            System.out.println("Encore joueur bleu=" + tour + " de jouer");//la pièce est séléectionnée mais le rond est effacé c'est un peu dommage
        }
    }
    String gagnant;

    private void traitementTaniere() {
        //potion900| 500 + 38x60
        //personnagexLink|yLink + 9x90
        if ((col[8]) < x_aff[indice] && x_aff[indice] < (col[8] + 20)
                && (ligne[3]) < y_aff[indice] && y_aff[indice] < (ligne[3] + 20) && !ani[indice].isBleu() && !tour) {
            //gagnant=JoueurR;
            IHM_victoire ihm1 = new IHM_victoire();
            ihm1.setVisible(true);
        }
        if ((col[0]) < x_aff[indice] && x_aff[indice] < (col[0] + 20)
                && (ligne[3]) < y_aff[indice] && y_aff[indice] < (ligne[3] + 20) && ani[indice].isBleu() && tour) {
            //gagnant=JoueurB;
            IHM_victoire ihm1 = new IHM_victoire();
            ihm1.setVisible(true);
        }

    }

    private void traitementRivière() {

        if (ani[indice].getNom() != "rat") {//dixit pour tous les autres animaux
            if (RH.Inside(ani[indice].getX(), ani[indice].getY()) || RB.Inside(ani[indice].getX(), ani[indice].getY())) {//si leurs coordonnées atterissent dans la rivière
                if (ani[indice].getNom() != "tigre" && ani[indice].getNom() != "lion") {
                    JOptionPane.showMessageDialog(this, "Vous ne pouvez pas traverser la rivière, vous allez vous noyer, faites le tour", "Attention",
                            JOptionPane.INFORMATION_MESSAGE);
                    x_aff[indice] = xtemp;
                    y_aff[indice] = ytemp;
                    ani[indice].setX(xtemp);
                    ani[indice].setY(ytemp);
                    //rajouter le rejouer
                    coup++;
                    compteur_tour--;
                }
                if ((ani[indice].getNom()).equals("lion") || (ani[indice].getNom()).equals("tigre")) {
                    System.out.println("Saut félin");
                    switch (pressed) {
                        case "z":
                            System.out.println("remontée");
                            y_aff[indice] -= (2 * 95);//le z ne fonctionne pas
                            ani[indice].setY(y_aff[indice]);
                            break;
                        case "s":
                            y_aff[indice] += 190;
                            ani[indice].setY(y_aff[indice]);
                            break;
                        case "q":
                            x_aff[indice] -= (3 * 95);
                            ani[indice].setX(x_aff[indice]);//le q non plus, c'est assez frustrant
                            break;
                        case "d":
                            x_aff[indice] += 285;
                            ani[indice].setX(x_aff[indice]);
                            break;
                        default:
                            System.out.println("erreur");
                    }

                }
            }

        }
    }

    private void duel() {
// maintenant il reste juste à faire disparaître les images mangées
        x_zonepd = ani[indice].getX() - 55;
        x_zonepf = ani[indice].getX() + 55;
        y_zonepd = ani[indice].getY() - 55;
        y_zonepf = ani[indice].getY() + 55;

        for (int i = 0; i < ani.length; i++) {
            if (ani[i].getX() >= x_zonepd && ani[i].getX() <= x_zonepf && ani[i].getY() >= y_zonepd && ani[i].getY() <= y_zonepf && i != indice) {
                if (ani[i].isBleu() != ani[indice].isBleu()) {
                    System.out.println("oui!");

                    switch (ani[indice].getRang_partie()) {
                        case 1:
                            if (ani[i].getRang_partie() == 8) {
                                //ani[i]disparait
                                morts.add(ani[i].getNom() + ani[i].getCouleur());//on ajoute l'animal à la liste des morts
                                ani[i].setX(xm);
                                ani[i].setY(ym);//on lui donne les coordonnées des morts
                                System.out.println("la piece " + ani[i].getNom() + " " + ani[i].getCouleur() + " est mangée");
                            } else {
                                int result = JOptionPane.showConfirmDialog(this, "Etes vous vaiment sur de vouloir sacrifier cette pièce?");
                                if (result == 0) {
                                    System.out.println("suicide de la piece " + ani[indice].getNom() + " " + ani[indice].getCouleur());
                                    //ani[indice](disparait)
                                    morts.add(ani[indice].getNom() + ani[indice].getCouleur());
                                    ani[indice].setX(xm);
                                    ani[indice].setY(ym);
                                } else {
                                    x_aff[indice] = xtemp;
                                    y_aff[indice] = ytemp;

                                    coup++;
                                    compteur_tour--;

                                }
                            }
                            break;
                        case 8:
                            if (ani[i].getRang_partie() == 1) {
                                int result = JOptionPane.showConfirmDialog(this, "Etes vous vaiment sur de vouloir sacrifier cette pièce?");
                                if (result == 0) {
                                    System.out.println("suicide de la piece " + ani[indice].getNom() + " " + ani[indice].getCouleur());
                                    //ani[indice](disparait)
                                    morts.add(ani[indice].getNom() + ani[indice].getCouleur());
                                    ani[indice].setX(xm);
                                    ani[indice].setY(ym);
                                } else {
                                    x_aff[indice] = xtemp;
                                    y_aff[indice] = ytemp;

                                    coup++;
                                    compteur_tour--;
                                }
                            } else {
                                //ani[i]disparait
                                morts.add(ani[i].getNom() + ani[i].getCouleur());
                                ani[i].setX(xm);
                                ani[i].setY(ym);
                                System.out.println("la piece " + ani[i].getNom() + " " + ani[i].getCouleur() + " est mangée");
                            }
                            break;
                        default:
                            if (ani[indice].getRang_partie() < ani[i].getRang_partie()) {
                                int result = JOptionPane.showConfirmDialog(this, "Etes vous vaiment sur de vouloir sacrifier cette pièce?");
                                if (result == 0) {
                                    System.out.println("suicide de la piece " + ani[indice].getNom() + " " + ani[indice].getCouleur());
                                    //ani[indice](disparait)
                                    morts.add(ani[indice].getNom() + ani[indice].getCouleur());
                                    ani[indice].setX(xm);
                                    ani[indice].setY(ym);
                                } else {
                                    x_aff[indice] = xtemp;
                                    y_aff[indice] = ytemp;

                                    coup++;
                                    compteur_tour--;

                                }
                            } else {
                                //ani[i]disparait
                                morts.add(ani[i].getNom() + ani[i].getCouleur());
                                ani[i].setX(xm);
                                ani[i].setY(ym);
                                System.out.println("la piece " + ani[i].getNom() + " " + ani[i].getCouleur() + " est mangée");
                            }
                            break;
                    }

                }
            }
        }

    }

    private void piege() {

        if (cases_piege.InsideP(ani[indice].getX(), ani[indice].getY())) {
            ani[indice].setRang_partie(0);
            System.out.println("le rang de " + ani[indice].getNom() + ani[indice].getCouleur() + " est " + ani[indice].getRang_partie());
        } else {
            ani[indice].setRang_partie(ani[indice].getRang());
            System.out.println("le rang de " + ani[indice].getNom() + ani[indice].getCouleur() + " est " + ani[indice].getRang_partie());
        }
    }

    public void setVariable(boolean option_de_jeu) {
        this.option = option_de_jeu;
    }

    public void sauvegarde() {

        PrintWriter fichier_sauvegarde;
        int n = 5;
        try {
            fichier_sauvegarde = new PrintWriter(new BufferedWriter(new FileWriter("src/sauvegarde/fichier_sauvegarde.txt")));
            for (int i = 0; i < 16; i++) {
                fichier_sauvegarde.println(x_sauv[i]);

            }
            for (int i = 0; i < 16; i++) {
                fichier_sauvegarde.println(y_sauv[i]);

            }
            fichier_sauvegarde.close();

        } catch (IOException ex) {
            System.out.println("il y a un probleme");
        }
    }

     public void lecture() {
        BufferedReader lecteurAvecBuffer = null;
        

        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader("src/sauvegarde/fichier_sauvegarde.txt"));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }
        try {
            //while (lecteurAvecBuffer.readLine()!=null)
            for (int i = 0; i < ligne.length; i++) {
                ligne[i] = Integer.parseInt(lecteurAvecBuffer.readLine());
            }
            
                for (int i = 0; i < ligne.length/2; i++) {
                    x_sauv[i] = ligne[i];
                    System.out.println("x_sauv"+i+"="+x_sauv[i]);
                }
                for (int i = 16; i < ligne.length; i++){
                    y_sauv[i-16] = ligne[i];
                    System.out.println("y_sauv"+i+"="+y_sauv[i]);
                }

            }catch (IOException ex) {
            System.out.println("Erreur d'ouverture");
        }
            try {
                lecteurAvecBuffer.close();
            } catch (IOException ex) {
                System.out.println("Erreur d'ouverture");
            }
        }

    }
