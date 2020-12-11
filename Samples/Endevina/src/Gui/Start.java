package Gui;

/*

    Project     ED21
    Package     Gui    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-10

    DESCRIPTION
    
*/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * @author Carlos Pomares
 */

public class Start extends JFrame {
    private JTextField numberOfTries;
    private JButton startGame;
    private JPanel mainPanel;

    private MainScreen game;

    public Start(){
        super("Adivinator");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame(e);
            }
        });

    }

    private void startGame(ActionEvent e){
        try {
            game = new MainScreen(Integer.parseInt(this.numberOfTries.getText()));
            game.setSize(600,400);
            game.setResizable(false);
            this.setVisible(false);
            game.setVisible(true);
        } catch (Exception error){
            JOptionPane.showMessageDialog(this,error.getMessage());
        }

    }

    private void closeWindow(JFrame frame){
        this.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
    }

}
