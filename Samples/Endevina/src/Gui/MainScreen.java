package Gui;

/*

    Project     ED21
    Package     Gui    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-10

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

import Endevinador.Endevinador;
import Random.RandomNumber;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainScreen extends JFrame {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel leftPanel;

    private JTextField numberField;
    private JButton checkNumberButton;

    private JLabel successLabel;

    private JPanel rightPanel;

    private JList insertedNumbersList;
    private JLabel hiddenNumberLabel;
    private JLabel numberOfTriesLabel;
    private JLabel hintLabel;

    private ArrayList<Integer> introducedNumbersArray;
    private DefaultListModel introducedNumbersModel;
    private boolean success = false;
    private int actualTries = 0;
    private int maximumTries = 0;
    private int hiddenNumber;
    private boolean gameType;

    public MainScreen(int maximumTries,boolean gameType){
        super("Adivina el número");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        this.maximumTries = maximumTries;
        this.gameType = gameType;
        startGame();

        checkNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkNumber(e);
            }
        });

    }

    public void setTries(int numberOfTries){
        this.actualTries = numberOfTries;
    }

    private void startGame(){
        this.actualTries = this.maximumTries;
        this.introducedNumbersArray = new ArrayList<>();
        this.introducedNumbersModel = new DefaultListModel();
        this.insertedNumbersList.setModel(introducedNumbersModel);

        this.introducedNumbersArray.clear();
        this.introducedNumbersModel.removeAllElements();
        refreshList();

        this.hiddenNumberLabel.setText("**");

        if(gameType){
            this.hiddenNumber = RandomNumber.generateNumber(99);
        } else {
            this.hiddenNumber = RandomNumber.generateNumber(9);
        }

        this.numberOfTriesLabel.setText(Integer.toString(this.maximumTries));

        // System.out.println("GAME TYPE: " + gameType + " HIDDEN NUMBER: " + hiddenNumber);

    }

    private void checkNumber(ActionEvent e){

        int number;
        int optionPanel;

        try {
            number = Integer.parseInt(numberField.getText());

            if(Endevinador.checkNumber(number,this.hiddenNumber)){
                success = true;
                this.hiddenNumberLabel.setText(Integer.toString(this.hiddenNumber));
                String message = String.format("Winner.\nHidden number: %d\nNew game?",this.hiddenNumber);
                System.out.println();
                optionPanel = JOptionPane.showConfirmDialog(this,message);
                switch (optionPanel){
                    case 0 -> startGame();
                    case 1,2 -> this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
                }
            } else if(this.actualTries == 0){
                String msg = String.format("Game over, no tries remaining.\nHidden number: " + this.hiddenNumber + "\nNew game?");
                optionPanel = JOptionPane.showConfirmDialog(this,msg);
                switch (optionPanel){
                    case 0 -> startGame();
                    case 1,2 -> this.dispatchEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
                }
            } else {
                this.actualTries--;
                this.numberOfTriesLabel.setText(Integer.toString(this.actualTries));
                this.hintLabel.setText(generateHint(number,this.hiddenNumber));
                this.introducedNumbersArray.add(number);
                refreshList();
            }
        } catch (Exception error){
            JOptionPane.showMessageDialog(this,"Error: " + error.getMessage());
        }


    }

    private void refreshList(){
        this.introducedNumbersModel.removeAllElements();
        for(Integer number : introducedNumbersArray){
            this.introducedNumbersModel.addElement(number);
        }
    }

    private String generateHint(int userNumber, int hiddenNumber){
        return (Endevinador.generateHint(userNumber,hiddenNumber)) ? "Número más alto" : "Número más bajo";
    }

}
