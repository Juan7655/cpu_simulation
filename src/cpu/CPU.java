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
        Synchronizer principal = new Synchronizer(1);
        principal.tick();
        new Principal(principal)
                .setVisible(true);

    }

}
