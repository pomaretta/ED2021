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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private JRadioButton nineGameButton;
    private JRadioButton nintyGameButton;

    private MainScreen game;
    private boolean gameType = false;

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

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.nineGameButton);
        buttonGroup.add(this.nintyGameButton);

        this.nineGameButton.setSelected(true);

    }

    private void startGame(ActionEvent e){
        try {

            if(this.nineGameButton.isSelected()){
                this.gameType = false;
            } else if(this.nintyGameButton.isSelected()){
                this.gameType = true;
            }

            game = new MainScreen(Integer.parseInt(this.numberOfTries.getText()),this.gameType);
            game.setSize(600,400);
            game.setLocationRelativeTo(null);
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
