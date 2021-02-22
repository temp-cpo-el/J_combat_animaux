/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;



/**
 *
 * @author ELOISE
 * @author ANNA
 */
public class Animal {
    private final String nom;//nom type chat,chien,elephant,tigre...
    private final int x_init;//coordonnnées de début de partie
    private final int y_init;//coordonnnées de début de partie
    private int x,y;
    private final int rang;//rang de l'animal
    private boolean bleu;//0=pion rouge 1=pion bleu
    private String couleur;
    private boolean isSelected;
    
    

    public Animal(String nom, int x_init, int y_init,int x,int y,int rang, boolean bleu,boolean isSelected) {
        
        this.nom = nom;
        this.x_init = x_init;
        this.y_init = y_init;
        this.rang= rang;
        this.bleu = bleu;
         if(!bleu){
             couleur="rouge0";
        }else{
            couleur="bleu0";
        }
    }

    public int getX_init() {
        return x_init;
    }

    public int getY_init() {
        return y_init;
    }

    public int getRang() {
        return rang;
    }

    public String getNom() {
        return nom;
    }

    public String getCouleur() {
        return couleur;
    }
     public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public boolean isBleu() {
        return bleu;
    }

   
    

    
    

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    
    }
}
