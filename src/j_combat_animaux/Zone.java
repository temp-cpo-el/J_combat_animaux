/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;

/**
 *
 * @author Moi
 */
public class Zone {

    /**
     * Définition de zone autour des rivières xd= x du debut de zone yf= y de la
     * fin de zone
     *
     */
    private int xd;
    private int xf;
    private int yd;
    private int yf;//coordonnées qui constitueront la zone

    private int x, y;//les témoins pour savoir si on est dans la zone ou pas.
    //private int a;// 0=rivière haute 1= rivière basse 2=autre
    //il n'y a que deux rivières, donc on peut se permettre d'utiliser un boolean

    public Zone(int xd, int xf, int yd, int yf) {
        this.xd = xd;
        this.xf = xf;
        this.yd = yd;
        this.yf = yf;
        //this.a = a;
    }

    public boolean Inside(int x, int y) {
        if (x >= xd && x <= xf && y >= yd && y <= yf) {
            System.out.println("dans la rivière");
            return true;
        }
        
        return false;
    }
}
