/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;

/**
 *
 * @author ELOISE
 */
public class Zone {

    /**
     * Définition de zones autour des rivières 
     * xd=x du debut de zone 
     * yf= y fin de zone
     *
     */
    private int xd;
    private int xf;
    private int yd;
    private int yf;//coordonnées qui constitueront la zone

    private int x, y;//les témoins pour savoir si on est dans la zone ou pas.

    public Zone(int xd, int xf, int yd, int yf) {
        this.xd = xd;
        this.xf = xf;
        this.yd = yd;
        this.yf = yf;
    }

    public boolean Inside(int x, int y) {
        if (x >= xd && x <= xf && y >= yd && y <= yf) {
            System.out.println("dans la rivière");
            return true;
        }

        return false;
    }
}
