/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j_combat_animaux;

/**
 *
 * @author Tempel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IHM_acceuil ihm0=new IHM_acceuil();
        ihm0.setVisible(true);
        
        IHM_plateau ihm1= new IHM_plateau();
        ihm1.setVisible(true);
        
        /*IHM_test ihmt= new IHM_test();
        ihmt.setVisible(true);*/
    }
    
}
