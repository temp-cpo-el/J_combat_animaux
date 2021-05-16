/**
 *
 * @author ELOISE
 * @author ANNA
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;


public class IHM_plateau extends javax.swing.JFrame {

    private File fichierplateau = new File("src/images/plateau3.png");//on va chercher le fichier dans le dossier d'images
    private BufferedImage imagePlateau;//la placer en tant que bufferedImage permet de la redessiner 
    private File fichierfondplateau = new File("src/images/Fond_plateau_de_jeu0.png");//on va chercher le fichier dans le dossier d'images
    private BufferedImage imageFondPlateau;
    private ImageIcon isoleil = new ImageIcon("src/images/petit_soleil.png");//pour afficher le tour du joueur à coté de son nom
    private int[] ligne = new int[7];
    private int[] col = new int[9];
    private Zone RH = new Zone(477, 710, 210, 350);//définition des zones de rivières
    private Zone RB = new Zone(477, 710, 500, 640);

    private zone_piege cases_piege = new zone_piege(191, 305, 286, 404, 191, 495, 951, 305, 856, 404, 951, 495);//definition zone piege

    private int x_zonepd = 0;
    private int x_zonepf = 0;
    private int y_zonepd = 0;
    private int y_zonepf = 0;
    // coordonnées de la zone qui entoure la piece

    public Animal[] ani = new Animal[16];
    private int nbani = 0;//servira pour compter les animaux et donner le caractère de la victoire

    private File[] tab_fich = new File[16];
    private BufferedImage[] image = new BufferedImage[16];
    private int[] x_aff = new int[16];
    private int[] y_aff = new int[16];//coordonnées d'affichage des pieces

    private int[] x_sauv = new int[16];
    private int[] y_sauv = new int[16];//coordonnéers de la sauvegarde

    private int[] ligne_sauv = new int[32];

    //pour la mort des pièces
    private ArrayList<String> morts = new ArrayList<>();//tableau de morts
    private JFrame frame_mort = new JFrame();
    private JPanel panel_mort = new JPanel();//jpanel dans lequel dessiner tous les animaux morts
    private final int xm = 3, ym = 200; //coordonnées des images reconnues comme mortes
    private JLabel jmort = new JLabel("Les morts");
    private int nb_mort = 0;

    //autres éléments utiles au code:
    private int coup;//coups restant à jouer
    private int xtemp, ytemp;//coordonnees de la piece selectionnée
    private boolean tour;//définir le tour du joueur
    private int compteur_tour = 0;//combien de tours ont été effectués
    private int ligne_proche;//ligne immédiatement inférieure à la position de la souris
    private int col_proche;//colonne immédiatement inférieure à la position de la sourie
    private int indice = 0;//sert à reconnaître un animal dans le tableau ani[]

    private boolean option = false;//utilisation des coordonnées du jeu ou du fichier_sauvegarde

    public IHM_plateau(String JoueurR, String JoueurB) {

        initComponents();
        frame_mort.setTitle("Les morts");//Création d'une frame pour y mettre l'image des pièces mortes
        //Définition des lignes du plateau Y
        ligne[0] = 118;
        ligne[1] = 210;
        ligne[2] = 305;
        ligne[3] = 404;
        ligne[4] = 495;
        ligne[5] = 590;
        ligne[6] = 685;
        //Définition des colonnes du plateau X
        col[0] = 191;
        col[1] = 286;
        col[2] = 381;
        col[3] = 476;
        col[4] = 571;
        col[5] = 667;
        col[6] = 761;
        col[7] = 856;
        col[8] = 951;

        /*Définitions de tous les animaux selon leur classe*/
        Animal a1 = new Animal("rat", 764, 121, 0, 0, 1, 1, true, false);//rat de rang 1 couleur:bleu
        Animal a2 = new Animal("chat", 858, 595, 0, 0, 2, 2, true, false);
        Animal a3 = new Animal("loup", 764, 500, 0, 0, 3, 3, true, false);
        Animal a4 = new Animal("chien", 859, 215, 0, 0, 4, 4, true, false);
        Animal a5 = new Animal("panthère", 764, 312, 0, 0, 5, 5, true, false);
        Animal a6 = new Animal("lion", 953, 121, 0, 0, 6, 6, true, false);
        Animal a7 = new Animal("tigre", 953, 691, 0, 0, 7, 7, true, false);
        Animal a8 = new Animal("elephant", 763, 691, 0, 0, 8, 8, true, false);
        Animal a9 = new Animal("rat", 383, 691, 0, 0, 1, 1, false, false);//rat de rang 1 couleur:rouge
        Animal a10 = new Animal("chat", 289, 215, 0, 0, 2, 2, false, false);
        Animal a11 = new Animal("loup", 385, 310, 0, 0, 3, 3, false, false);
        Animal a12 = new Animal("chien", 289, 596, 0, 0, 4, 4, false, false);
        Animal a13 = new Animal("panthère", 384, 501, 0, 0, 5, 5, false, false);
        Animal a14 = new Animal("lion", 195, 691, 0, 0, 6, 6, false, false);
        Animal a15 = new Animal("tigre", 195, 121, 0, 0, 7, 7, false, false);
        Animal a16 = new Animal("elephant", 383, 121, 0, 0, 8, 8, false, false);

        ajouterAnimal(a1);//ajout des animaux au tableau ani[]
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

        setBounds(0, 0, 1243, 915);     //changement de la taille de la fenêtre pour correspondre à la taille du plateau
        jPanel1.setFocusable(true);//sert à prendre le clavier en compte
        try {
            imagePlateau = ImageIO.read(fichierplateau);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierplateau inutilisable");
        }

        try {
            imageFondPlateau = ImageIO.read(fichierfondplateau);//utilisation de plateau_de_jeu
        } catch (IOException ex) {
            System.out.println("fichierfondplateau inutilisable");
        }
        creation_aff(); //création des images
        afficherAnimaux(ani);//affichage des images

        jLabelJoueurR.setText(JoueurR);//Attribution des jLabel de joueur
        jLabelJoueurB.setText(JoueurB);
;
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
                g.drawImage(imagePlateau,185,110, null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelJoueurR = new javax.swing.JLabel();
        jLabelJoueurB = new javax.swing.JLabel();
        jLabelsoleilbleu = new javax.swing.JLabel();
        jLabelsoleilrouge = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonNouvelle = new javax.swing.JButton();
        jButtonreprendre = new javax.swing.JButton();
        jButtonsauvegarde = new javax.swing.JButton();
        jButtonquitter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/animaux_5_85.PNG"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/animaux_1_48.PNG"))); // NOI18N

        jLabelJoueurR.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jLabelJoueurR.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJoueurR.setText("Joueur Rouge");
        jLabelJoueurR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelJoueurRMouseClicked(evt);
            }
        });

        jLabelJoueurB.setFont(new java.awt.Font("Maiandra GD", 1, 24)); // NOI18N
        jLabelJoueurB.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJoueurB.setText("Joueur Bleu");

        jLabelsoleilrouge.setBackground(new java.awt.Color(0, 153, 50));

        jToolBar1.setBackground(new java.awt.Color(0, 0, 0));
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(331, 50));
        jToolBar1.setMinimumSize(new java.awt.Dimension(331, 50));

        jButtonNouvelle.setBackground(new java.awt.Color(0, 0, 0));
        jButtonNouvelle.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jButtonNouvelle.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNouvelle.setText("  Nouvelle Partie  ");
        jButtonNouvelle.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray));
        jButtonNouvelle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNouvelle.setNextFocusableComponent(jPanel1);
        jButtonNouvelle.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNouvelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNouvelleActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNouvelle);

        jButtonreprendre.setBackground(new java.awt.Color(0, 0, 0));
        jButtonreprendre.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jButtonreprendre.setForeground(new java.awt.Color(255, 255, 255));
        jButtonreprendre.setText("  Reprendre partie précédente  ");
        jButtonreprendre.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray));
        jButtonreprendre.setFocusable(false);
        jButtonreprendre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonreprendre.setNextFocusableComponent(jPanel1);
        jButtonreprendre.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonreprendre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonreprendreActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonreprendre);

        jButtonsauvegarde.setBackground(new java.awt.Color(0, 0, 0));
        jButtonsauvegarde.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jButtonsauvegarde.setForeground(new java.awt.Color(255, 255, 255));
        jButtonsauvegarde.setText("  Sauvegarder  ");
        jButtonsauvegarde.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray));
        jButtonsauvegarde.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonsauvegarde.setNextFocusableComponent(jPanel1);
        jButtonsauvegarde.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonsauvegarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsauvegardeActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonsauvegarde);

        jButtonquitter.setBackground(new java.awt.Color(0, 0, 0));
        jButtonquitter.setFont(new java.awt.Font("Maiandra GD", 0, 36)); // NOI18N
        jButtonquitter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonquitter.setText("  Quitter  ");
        jButtonquitter.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray));
        jButtonquitter.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButtonquitter.setNextFocusableComponent(jPanel1);
        jButtonquitter.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonquitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonquitterActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonquitter);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabelsoleilrouge, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelsoleilbleu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelJoueurR, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelJoueurB)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel3))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelJoueurR, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelJoueurB, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(217, 217, 217)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelsoleilrouge, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelsoleilbleu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
//Récupération des coordonnées du clic
        xtemp = evt.getX();
        System.out.println("\nx:" + xtemp);
        ytemp = evt.getY();
        System.out.println("y:" + ytemp + "\n");

        tour_du_joueur(); //On définit la couleur qui a le droit d'effectuer des actions
    }//GEN-LAST:event_jPanel1MouseClicked

    private String pressed; //Connaître la valeur de la touche pressée
    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed
        if (coup > 0 && ani[indice].isBleu() == tour) {//Si il reste un coup à jouer et que la couleur de l'animal associé est la bonneest la bonne

            xtemp = ani[indice].getX();//pour pouvoir les comparer après
            ytemp = ani[indice].getY();//pour pouvoir les comparer après
            if (evt.getKeyChar() == 'z' && coup > 0) {//Z
                y_aff[indice] -= 95;//change les paramètres d'affichage
                pressed = "z";
                ani[indice].setY(y_aff[indice]);//on les remplace les anciennes coordonnées avec les nouvelles
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
                System.out.println("coup à 0");
            }
            System.out.println(pressed);
            traitementBornes();//On vérifie si l'animal reste bien dans le plateau
            traitementRivière();//On vérifie le comportement de l'animal par rapport a la rivière
            duel();//On vérifie si son déplacement engage un duel
            piege();//On vérifie si la case est une case piège
            jPanel1.repaint();
            traitementTaniere();//Effectuer le traitement tanière permet de voir le mouvement final avant l'apparition de l'ihm_victoire
            compteur_tour++;//Un tour est passsé
        }

        System.out.println("variable coup= " + coup);
        tour_du_joueur();//grâce à compteur_tour, permet de changer de couleur pouvant agir sur le plateau
    }//GEN-LAST:event_jPanel1KeyPressed

    private void jLabelJoueurRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelJoueurRMouseClicked
        afficherMorts();//Ouvre une fenêtre avec les animaux mangés affichés
    }//GEN-LAST:event_jLabelJoueurRMouseClicked

    private void jButtonNouvelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNouvelleActionPerformed
//on repasse par l'ihm_acceuil pour démarrer une nouvelle partie        
//vider le tableau des morts
        morts.clear();
        nb_mort = 0;
        IHM_acceuil ihm_a = new IHM_acceuil();
        ihm_a.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButtonNouvelleActionPerformed

    private void jButtonreprendreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonreprendreActionPerformed
        //option=true permet de lancer la lecture d'un fichier_sauvegarde dans le prochain afficherAnimaux() 
        option = true;
        afficherAnimaux(ani);
        option = false;
        //On replace les animaux morts dans le ArrayList et la fenêtre correspondante
        for (int i = 0; i < ani.length; i++) {
            if (ani[i].getX() == xm && ani[i].getY() == ym) {
                morts.add(ani[i].getNom() + ani[i].getCouleur());
            }

        }
    }//GEN-LAST:event_jButtonreprendreActionPerformed

    private void jButtonsauvegardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsauvegardeActionPerformed
        for (int i = 0; i < 16; i++) {//enregistrement des coordonées des animaux pour écriture du fichier sauvegarde
            x_sauv[i] = ani[i].getX();
            y_sauv[i] = ani[i].getY();
/*
            System.err.println("x_aff" + i + "=" + x_aff[i]);
            System.err.println("x_sauv" + i + "=" + x_sauv[i]);
            System.err.println("y_aff" + i + "=" + y_aff[i]);
            System.err.println("y_sauv" + i + "=" + y_sauv[i]);
  */      }
        sauvegarde();//écriture du ficher_sauvegarde
    }//GEN-LAST:event_jButtonsauvegardeActionPerformed

    private void jButtonquitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonquitterActionPerformed
            System.exit(0);//quitter le jeu
    }//GEN-LAST:event_jButtonquitterActionPerformed

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
    private javax.swing.JButton jButtonNouvelle;
    private javax.swing.JButton jButtonquitter;
    private javax.swing.JButton jButtonreprendre;
    private javax.swing.JButton jButtonsauvegarde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelJoueurB;
    private javax.swing.JLabel jLabelJoueurR;
    private javax.swing.JLabel jLabelsoleilbleu;
    private javax.swing.JLabel jLabelsoleilrouge;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
/* Ajout des toutes les fonctions dont on aura besoin pour faire fonctionner le code :*/

    private void ajouterAnimal(Animal a) {
        /**
         *ajouterAnimal() permet d'ajouter un animal au tableau ani[]
         * 
         * avec a un Animal précédemment créé
         **/
        ani[nbani] = a;
        nbani++;

    }

    private void creation_aff() {
        /**
        *creation_aff permet de récupérer les images correspondantes au animaux dans le fichier source et de les mettres dans un tableau
        *
        *Cette fonction ne nécessite pas de variable en entrée
        **/
        for (int i = 0; i < ani.length; i++) {
            tab_fich[i] = new File("src/images/" + ani[i].getNom() + "_" + ani[i].getCouleur() + ".jpg");
        }
    }

    private void afficherAnimaux(Animal[] ani) {
       /**
        * permet de lire les images du tableau ani et de les placer pour leur affichage initial
        *Avec ani un tableau composé de Animal
        **/ 
        System.err.println("option=" + option);
        if (option == true) {// on reprend les coordonnées enregistrées
            lecture();//on récupère les valeurs dans le fichier 'fichier_sauvegarde.txt'
            try {
                for (int i = 0; i < ani.length; i++) {
                    ani[i].setX(x_sauv[i]);
                    ani[i].setY(y_sauv[i]);
                    x_aff[i] = ani[i].getX();
                    y_aff[i] = ani[i].getY();
                    image[i] = ImageIO.read(tab_fich[i]);//dessiner les animaux
                }
            } catch (IOException ex) {
                System.out.println("affichage des animaux impossible");
            }

        }
        if (option == false) {//on prend les coordonnées initiales avec le jeu
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
        /**
        *En fonction de la variable compteur_tour, une partie des pions est manipulable et l'autre pas
         **/
        if (compteur_tour % 2 == 0) {
            tour = false;//tour des rouges
            System.out.println("Tour des rouges");
            jLabelJoueurR.setIcon(isoleil);
            jLabelJoueurB.setIcon(null);
        } else {
            tour = true;//tour des bleus
            System.out.println("Tour des bleus");
            jLabelJoueurB.setIcon(isoleil);
            jLabelJoueurR.setIcon(null);
        }
        coup = 1;//on initialise le nombre de coup possible pour le joueur
        System.out.println("compteur_tour : " + compteur_tour);
        System.out.println("coup : " + coup);
        selecAnimaux();

    }

    private void selecAnimaux() {
        /**
         * fonction en plusieurs étapes:
         *1)chercher la ligne immédiatement inférieure à ytemp sélectionné
         *2)chercher la colonne immédiatement inférieure à xtemp selectionné
         *3) trouver l'animal correspondant à ces coordonnées si il existe 
         *4)Récupérer l'indice associé
         *5)Entourer l'animal pour plus de visibilité
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
        }//on a récupère la ligne et la colonne la plus proche
        for (int i = 0; i < ani.length; i++) {

            if (ligne_proche < ani[i].getY() && ani[i].getY() < ligne_proche + 30 && col_proche < ani[i].getX() && ani[i].getX() < col_proche + 30 && ani[i].isBleu() && tour) {
                ani[i].setIsSelected(true);//si notre clic correspond aux conditions, le booléen isSelected devient true
                indice = i;//on récupère l'indice correspondant à l'image dans le tableau d'animaux

            }
            if (ligne_proche < ani[i].getY() && ani[i].getY() < ligne_proche + 30 && col_proche < ani[i].getX() && ani[i].getX() < col_proche + 30 && !ani[i].isBleu() && !tour) {
                ani[i].setIsSelected(true);
                indice = i;
            }//on a deux conditions, une pour cahque couleur
        }
        System.out.println("animal selectionné :" + ani[indice].getNom() + ani[indice].getCouleur());
        jPanel1.repaint();//on repaint à la fin de selecanimaux pour afficher le cercle
    }

    private void traitementBornes() {
        /**
         *Traitement bornes gère les sorties de plateau avant l'affichage des animaux
         * Si le déplacement est impossible, on laisser la pièce à la même place et on redonne un coup au joueur qui vient de faire un mouvement interdit
         * 
         **/
        // Gauche
        if (x_aff[indice] < 195) {
            x_aff[indice] = 195;//correspond à la colonne
            ani[indice].setX(x_aff[indice]);
        }
        //Droite
        if (x_aff[indice] > 1005) {
            x_aff[indice] = 953;
            ani[indice].setX(x_aff[indice]);
        }
        //Haut
        if (y_aff[indice] < 121) {
            y_aff[indice] = 121;//correstpond a la ligne
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
            System.out.println("Encore joueur bleu=" + tour + " de jouer");//la pièce est déjà selectionnée
        }
    }
    private String gagnant;
private int m_bleu=8;
private int m_rouge=8;
        
        
    private void traitementTaniere() {
        /**
         * On cherche à savoir si l'animal a réussi à se placer sur la case tanière
         *On utilise la classe Zone pour encadrer le point d'origine de la pièce, si celle si est bien dans la zone, et qu'elle est de la bonne
         * couleur, la phase victoire est enclenchée
         **/
        
        if((new Zone(col[8],col[8]+20,ligne[3],ligne[3]+20)).Inside(x_aff[indice], y_aff[indice]) && !ani[indice].isBleu() && !tour){   
            gagnant = jLabelJoueurR.getText();
            IHM_victoire ihm1 = new IHM_victoire(gagnant);//on affiche l'IHM_victoire avec le paramètre gagnant
            ihm1.setVisible(true);
        }
        if((new Zone(col[0],col[0]+20,ligne[3],ligne[3]+20)).Inside(x_aff[indice], y_aff[indice]) && ani[indice].isBleu() && tour){
            gagnant = jLabelJoueurB.getText();
            IHM_victoire ihm1 = new IHM_victoire(gagnant);
            setVisible(false);
            ihm1.setVisible(true);
        }
        //Dans le cas où il ne reste plus qu'une couleur sur le plateau, la couleur restante gagne
            if (m_bleu==0){//s'il n'y a plus de bleu, alors rouge gagne
               gagnant = jLabelJoueurR.getText();
            IHM_victoire ihm1 = new IHM_victoire(gagnant);
            ihm1.setVisible(true); 
            }
            if(m_rouge==0){ //s'il n'y a plus de rouge, alors bleu gagne
              gagnant = jLabelJoueurB.getText();
            IHM_victoire ihm1 = new IHM_victoire(gagnant);
            setVisible(false);
            ihm1.setVisible(true);  
            }
        

    }

    private void traitementRivière() {
/**
 *Dans cette méthode, nous allons vérifier si l'animal va se déplacer dans une des zones rivière
 * et si elle en est capable
 * 
 **/
        if (ani[indice].getNom() != "rat") {//dixit pour tous les autres animaux
            if (RH.Inside(ani[indice].getX(), ani[indice].getY()) || RB.Inside(ani[indice].getX(), ani[indice].getY())) {//si leurs coordonnées atterissent dans la rivière
                if (ani[indice].getNom() != "tigre" && ani[indice].getNom() != "lion") {//si ce n'est ni un lion ni un tigre
                    JOptionPane.showMessageDialog(this, "Vous ne pouvez pas traverser la rivière, vous allez vous noyer, faites le tour", "Attention",
                            JOptionPane.INFORMATION_MESSAGE);
                    x_aff[indice] = xtemp;
                    y_aff[indice] = ytemp;//on laisse la pièce à la même place
                    ani[indice].setX(xtemp);
                    ani[indice].setY(ytemp);
                    //On fait rejouer le joueur
                    coup++;
                    compteur_tour--;
                }
                if ((ani[indice].getNom()).equals("lion") || (ani[indice].getNom()).equals("tigre")) {
                    System.out.println("Saut félin");//si c'est un lion ou un tigre
                    switch (pressed) {
                        case "z":
                            System.out.println("remontée");
                            y_aff[indice] -= (2 * 95);
                            ani[indice].setY(y_aff[indice]);
                            break;
                        case "s":
                            y_aff[indice] += 190;
                            ani[indice].setY(y_aff[indice]);
                            break;
                        case "q":
                            x_aff[indice] -= (3 * 95);
                            ani[indice].setX(x_aff[indice]);
                            break;
                        case "d":
                            x_aff[indice] += 285;
                            ani[indice].setX(x_aff[indice]);
                            break;
                        default:
                            System.out.println("erreur");
                            //saut au dessus de la rivière
                    }

                }
            }

        }

    }

    private void duel() {
        /**
         *Lorsque deux animaux se retrouvent sur la même case, nous utilisons duel(), il y a alors deux cas :
         * La couleur des pièces en conflit est la même, on replace la dernière pièce à son emplacement antérieur
         * La couleur des pièces en conflit est différente, on compare leur rang pour savoir qui mange qui
         **/
        //ani[indice]->animal selectionné
        //ani[i]->animal dasn le perimetrede duel de ani[indice]
        x_zonepd = ani[indice].getX() - 40;
        x_zonepf = ani[indice].getX() + 40;
        y_zonepd = ani[indice].getY() - 40;
        y_zonepf = ani[indice].getY() + 40;//zone délimitant les alentours de la pièce ani[indice]

        for (int i = 0; i < ani.length; i++) {//on passe en revu tous les animaux pour voir si l'un d'eu est dans la zone de l'animal sélectionné
            if (new Zone(x_zonepd, x_zonepf, y_zonepd, y_zonepf).Inside(ani[i].getX(), ani[i].getY()) && i != indice) {
                if (ani[i].isBleu() != ani[indice].isBleu()) {//si il sont de couleur opposé a la piece selectionné
                    switch (ani[indice].getRang_partie()) {//suivant le rang de la piece selectionné, comportement different
                        case 1://rat
                            if (RH.Inside(xtemp, ytemp) || RB.Inside(xtemp, ytemp)) {// le rat ne peut pas  vienir de la rivière pour manger un autre animal sinon il se fait manger
                                JOptionPane.showMessageDialog(this, "le rat ne peut pas manger un autre animal en sortant de la rivière");
                                int result = JOptionPane.showConfirmDialog(this, "Etes vous vaiment sur de vouloir sacrifier cette pièce?");
                                if (result == 0) {
                                    System.out.println("suicide de la piece " + ani[indice].getNom() + " " + ani[indice].getCouleur());
                                    //ani[indice](disparait)
                                    morts.add(ani[indice].getNom() + ani[indice].getCouleur());
                                    ani[indice].setX(xm);
                                    ani[indice].setY(ym);
                                } else {
                                    ani[indice].setX(xtemp);
                                    ani[indice].setY(ytemp);
                                    x_aff[indice] = xtemp;
                                    y_aff[indice] = ytemp;

                                    coup++;
                                    compteur_tour--;
                                }
                                break;
                            }
                            if (ani[i].getRang_partie() == 8) {//si l'animal attaqué par le rat est un éléphant
                                //ani[i]disparait
                                morts.add(ani[i].getNom() + ani[i].getCouleur());//on ajoute l'animal à la liste des morts
                                //morts.add(); // Integer.toString(int i)  //String.Valueof(int) 

                                ani[i].setX(xm);
                                ani[i].setY(ym);//on lui donne les coordonnées des morts
                                System.out.println("la piece " + ani[i].getNom() + " " + ani[i].getCouleur() + " est mangée");
                            } else {// si ce n'est pas un elephant le rat ce fait manger
                                int result = JOptionPane.showConfirmDialog(this, "Etes vous vaiment sur de vouloir sacrifier cette pièce?");
                                if (result == 0) {
                                    System.out.println("suicide de la piece " + ani[indice].getNom() + " " + ani[indice].getCouleur());
                                    //ani[indice](disparait)
                                    morts.add(ani[indice].getNom() + ani[indice].getCouleur());
                                    ani[indice].setX(xm);
                                    ani[indice].setY(ym);
                                } else {
                                    ani[indice].setX(xtemp);
                                    ani[indice].setY(ytemp);
                                    x_aff[indice] = xtemp;
                                    y_aff[indice] = ytemp;

                                    coup++;
                                    compteur_tour--;

                                }
                            }
                            break;
                        case 8://l'animal selectionné est un éléphant
                            if (ani[i].getRang_partie() == 1) {// si il tente de manger un rat il va ce faire manger
                                int result = JOptionPane.showConfirmDialog(this, "Etes vous vaiment sur de vouloir sacrifier cette pièce?");
                                if (result == 0) {//reponse OUI
                                    System.out.println("suicide de la piece " + ani[indice].getNom() + " " + ani[indice].getCouleur());
                                    //ani[indice](disparait)
                                    morts.add(ani[indice].getNom() + ani[indice].getCouleur());
                                    ani[indice].setX(xm);
                                    ani[indice].setY(ym);
                                    if (ani[indice].isBleu()){
                                        m_bleu--;
                                    }else{
                                        m_rouge--;
                                    }//comtage des pieces mangées
                                } else {//reponse NON
                                    ani[indice].setX(xtemp);
                                    ani[indice].setY(ytemp);
                                    x_aff[indice] = xtemp;
                                    y_aff[indice] = ytemp;
                                    coup++;
                                    compteur_tour--;
                                }
                            } else {
                                    //ani[indice](disparait)
                                    morts.add(ani[i].getNom() + ani[i].getCouleur());
                                    ani[i].setX(xm);
                                    ani[i].setY(ym);
                                    if (ani[i].isBleu()){
                                        m_bleu--;
                                    }else{
                                        m_rouge--;
                                    }

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
                                    if (ani[indice].isBleu()){
                                        m_bleu--;
                                    }else{
                                        m_rouge--;
                                    }
                                } else {
                                    ani[indice].setX(xtemp);
                                    ani[indice].setY(ytemp);
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
                                if (ani[i].isBleu()){
                                        m_bleu--;
                                    }else{
                                        m_rouge--;
                                    }
                                System.out.println("la piece " + ani[i].getNom() + " " + ani[i].getCouleur() + " est mangée");
                            }
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Vos animaux ne se mangent pas entre eux!");
                    ani[indice].setX(xtemp);
                    ani[indice].setY(ytemp);
                    x_aff[indice] = xtemp;
                    y_aff[indice] = ytemp;
                    coup++;
                    compteur_tour--;
                }
            }
        }
    }

    private void piege() {
/**
 * Cette méthode concerne les cases marrons du plateau, un animal placé sur une de ces cases, vois son rang abaissé à 0 temporairement
 * il peut etre alors manager par n'importe quel autre animal
 **/
        if (cases_piege.InsideP(ani[indice].getX(), ani[indice].getY())) {
            ani[indice].setRang_partie(0);
            System.out.println("le rang de " + ani[indice].getNom() + ani[indice].getCouleur() + " est " + ani[indice].getRang_partie());
        } else {
            ani[indice].setRang_partie(ani[indice].getRang());
            System.out.println("le rang de " + ani[indice].getNom() + ani[indice].getCouleur() + " est " + ani[indice].getRang_partie());
        }
    }

    private void afficherMorts() {
        /**
         * L'image morte est dans un tableau morts
         * on associe un label,
         * on met l'image dans le label 
         * on met le label dans le panel 
         * on affiche le panel
         *
         */
        System.out.println("vous entrez dans le cimetière");
        for (int i = 0; i < ani.length; i++) {
            if (morts.contains(ani[i].getNom() + ani[i].getCouleur())) {
                jmort = new JLabel();
                jmort.setIcon(new ImageIcon(image[i]));
                panel_mort.add(jmort, -1);
            }
        }
        nb_mort = morts.size();
        revalidate();//permet de redessiner tour après tour
        frame_mort.setSize(110, nb_mort * 120);
        repaint();

        frame_mort.setContentPane(panel_mort);//...on insert le panel dans le frame...
        frame_mort.setVisible(true);//...on affiche le frame
        frame_mort.setDefaultCloseOperation(HIDE_ON_CLOSE);// on ferme le frame
        System.out.println("Repaint cimetière");
        }

    public void sauvegarde() {
/**
 *
 * Cette méthode permet d'écrire les coordonées de chaque Animal de ani et les noms des joueurs dans un fichier txt externe
 **/
        PrintWriter fichier_sauvegarde;//création d'un fichier
        try {
            fichier_sauvegarde = new PrintWriter(new BufferedWriter(new FileWriter("src/sauvegarde/fichier_sauvegarde.txt")));//crétation du fichier dans les dossiers de l'ordinateur comme un fichier sur lequel on peut écrire
            for (int i = 0; i < 16; i++) {
                fichier_sauvegarde.println(x_sauv[i]);//On écrit les valeurs des x

            }
            for (int i = 0; i < 16; i++) {
                fichier_sauvegarde.println(y_sauv[i]);//on écrit les valeurs des y

            }
            fichier_sauvegarde.println(jLabelJoueurR.getText());//on commence par rouge
            fichier_sauvegarde.println(jLabelJoueurB.getText());//puis bleu
            fichier_sauvegarde.close();//on ferme le fichier

        } catch (IOException ex) {
            System.out.println("Problème dans la sauvegarde");
        }
        JOptionPane.showMessageDialog(this, "La partie a bien été enregistrée", "Vous pouvez quitter la partie", JOptionPane.INFORMATION_MESSAGE);
    }

    public void lecture() {
        /**
         *Cette méthode permet de récupérer les données écrite grâce à la méthode sauvegarde, dans un fichier externe
         * Ce fichier contenant les coordonnées des animaux et le nom des joueurs
         **/
        System.out.println("debut  de lecture");
        BufferedReader lecteur = null;

        try {
            lecteur = new BufferedReader(new FileReader("src/sauvegarde/fichier_sauvegarde.txt"));
        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
            JOptionPane.showMessageDialog(this, "ERREUR\nLa partie sauvegardée est introuvable,\n La partie va être réinitialisée","sauvegarde introuvable",JOptionPane.INFORMATION_MESSAGE);
            option = false;
            afficherAnimaux(ani);
        }
        try {
            for (int i = 0; i < ligne_sauv.length; i++) {
                ligne_sauv[i] = Integer.parseInt(lecteur.readLine());
            }

            for (int i = 0; i < ligne_sauv.length / 2; i++) {
                x_sauv[i] = ligne_sauv[i];
                System.out.println("x_sauv" + i + "=" + x_sauv[i]);
            }
            for (int i = 16; i < ligne_sauv.length; i++) {
                y_sauv[i - 16] = ligne_sauv[i];
                System.out.println("y_sauv" + i + "=" + y_sauv[i - 16]);
            }

            for (int i = 16; i < ligne_sauv.length; i++) {
                y_sauv[i - 16] = ligne_sauv[i];
                System.out.println("y_sauv" + i + "=" + y_sauv[i - 16]);
            }

            jLabelJoueurR.setText(lecteur.readLine()); //reprendre les noms enregistrés
            jLabelJoueurB.setText(lecteur.readLine());

        } catch (NumberFormatException ex) {
            System.out.println("Erreur de lecture du fichier_sauvegarde");
            JOptionPane.showMessageDialog(this, "ERREUR\nLa partie sauvegardée n'a pu être téléchargée correctement,\n La partie va être réinitialisée");
            option = false;
            afficherAnimaux(ani);
        } catch (IOException ex) {
            System.out.println("Erreur de lecture du fichier_sauvegarde");
        }
        try {
            lecteur.close();
        } catch (IOException ex) {
            System.out.println("Erreur de fermeture du fichier_sauvegarde");
        }
        System.out.println("fin de de lecture");
    }

}
