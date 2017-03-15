/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu;

import gui.Principal;

public class CPU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Synchronizer principal = new Synchronizer();
        principal.tick();
        new Principal(principal.getValues(0),
                principal.getValues(1),
                principal.getValues(2),
                principal.getValues(3),
                principal.getValues(4),
                principal.getValues(5),
                principal.getValues(6),
                principal.getValues(7))
                .setVisible(true);

    }

}
