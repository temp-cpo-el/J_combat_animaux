/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;

/**
 *
 * @author annag
 */
public class zone_piege {
    /**
     * Définition de zone piege
     *
     */
    private final int x1g;
    private final int x2g;
    private final int x3g;
    private final int x4d;
    private final int x5d;
    private final int x6d;

    private final int y1g;
    private final int y2g;
    private final int y3g;
    private final int y4d;
    private final int y5d;
    private final int y6d;//coordonnées qui constitueront la zone de piege

    private int x, y;//les témoins pour savoir si on est dans la zone ou pas.

   

    public zone_piege(int x1g, int y1g, int x2g, int y2g, int x3g, int y3g, int x4d, int y4d, int x5d, int y5d, int x6d, int y6d ) {
        this.x1g = x1g;
        this.x2g = x2g;
        this.x3g = x3g;
        this.x4d = x4d;
        this.x5d = x5d;
        this.x6d = x6d;
        this.y1g = y1g;
        this.y2g = y2g;
        this.y3g = y3g;
        this.y4d = y4d;
        this.y5d = y5d;
        this.y6d = y6d;

    }

    public boolean InsideP(int x, int y) {
        if (x >= x1g && x <= x1g+50 && y >= y1g && y <= y1g+50 || x >= x2g && x <= x2g+50 && y >= y2g && y <= y2g+50 || x >= x3g && x <= x3g+50 && y >= y3g && y <= y3g+50 
                ||  x >= x4d && x <= x4d+50 && y >= y4d && y <= y4d +50|| x >= x5d && x <= x5d+50 && y >= y5d && y <= y5d+50 || x >= x6d && x <= x6d+50 && y >= y6d && y <= y6d+50) {
            System.out.println("dans le piege");
            return true;
        }

        return false;
    }

    
}
