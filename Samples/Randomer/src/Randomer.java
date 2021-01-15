/*

    Project     ED21
        
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-10

    DESCRIPTION
    
*/

import RandomerGUI.ModeScreen;

/**
 * @author Carlos Pomares
 */

public class Randomer {
    public static void main(String[] args) {

        // GUI Initialization
        ModeScreen screen = new ModeScreen();
        screen.setSize(400,300);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);

        // CONSOLE Initialization
        // RandomerConsole juego = new RandomerConsole();

    }
}
