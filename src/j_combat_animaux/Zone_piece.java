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
public class Zone_piece {

    //definition d'une zone sur la piece pour detecter les "attaque"
    private int xpd;
    private int xpf;
    private int ypd;
    private int ypf;//limites de la zone

    private int x, y;

    public Zone_piece(int xpd, int xpf, int ypd, int ypf) {
        this.xpd = xpd;
        this.xpf = xpf;
        this.ypd = ypd;
        this.ypf = ypf;

    }

    public boolean Insided(int x, int y) {
        if (x >= xpd && x <= xpf && y >= ypd && y <= ypf) {
            System.out.println("duel de piece");
            return true;
        } else {
            return false;
        }

    }

}
