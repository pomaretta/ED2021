package RandomerConsole;

/*

    Project     ED21
    Package     RandomerConsole
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-10

    DESCRIPTION
    
*/

import RandomerUtils.Endevinador;
import RandomerUtils.RandomNumber;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Carlos Pomares
 */

public class RandomerConsole {

    final private static ArrayList<String> ERRORS = new ArrayList<>();

    private static Scanner userIn;

    public RandomerConsole(){
        userIn = new Scanner(System.in);
        menuPrincipal();
    }

    private void menuPrincipal(){

        boolean exit = false;
        String[] opcions = new String[]{"99 Numbers","9 Numbers","Exit"};

        while(!exit){
            try {

                showOptions(opcions);

                if(ERRORS.size() != 0) errorBrief();

                System.out.print("\n\tOrder: ");

                switch (Integer.parseInt(userIn.nextLine())){
                    case 1 -> this.startGame(5,99);
                    case 2 -> this.startGame(5,9);
                    case 3 -> exit = true;
                }

            } catch (Exception e){
                ERRORS.add(e.getMessage());
            }
        }

    }

    private void startGame(int numberOfTries,int maximumNumber){

        boolean success = false;
        int userTries = numberOfTries;
        int hiddenNumber = RandomNumber.generateNumber(maximumNumber);
        int userNumber = -1;
        String userHint = "";
        ArrayList<Integer> tries = new ArrayList<>();

        while (userTries > 0 && !success){
            try {

                playerBrief(userNumber,userTries,userHint,"Playing");

                System.out.print("\n\n\t(1) Introducir número");

                System.out.print("\n\tOrder: ");

                // Introducir número, Mostrar pista
                switch (Integer.parseInt(userIn.nextLine())){
                    case 1 -> {
                        System.out.print("\tIntroduce el número: ");
                        userNumber = userIn.nextInt();
                        userTries--;
                        if(Endevinador.checkNumber(userNumber,hiddenNumber)) success = true;
                        tries.add(userNumber);
                        userHint = generateHint(Endevinador.generateHint(userNumber,hiddenNumber));
                    }
                }

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\n\n\tNumbers used: " + tries.toString());
        System.out.println("\tHidden number: " + hiddenNumber);

    }

    private void playerBrief(int playerLastNumber, int playerTries, String hint, String status){

        System.out.print("\n\t------------------ PLAYER BRIEF ------------------\n");

        System.out.printf("\n\t%-15s \t%-20s \t%-10s \t%-30s",
                "Last Number","Remaining tries", "Status","Hint");

        System.out.printf("\n\t%-15d \t%-20d \t%-10s \t%-30s\n",
                playerLastNumber,playerTries,status,hint);


        System.out.print("\n\t--------------------------------------------------\n");

    }

    private void errorBrief(){

        // Si hi ha errors en la conduccio surten
        System.out.print("\t-------------------------- ERRORS --------------------------");

        for (int i = 0; i < ERRORS.size(); i++) {
            System.out.printf("\n\t%-10s %-15s",
                    (i+1), ERRORS.get(i));
        }

        System.out.print("\n\t------------------------------------------------------------\n\n");

    }

    private void showOptions(String[] options){

        int optionNumber = 1;

        System.out.print("\n\t--------------- OPTIONS ---------------\n");

        for(String option : options){
            System.out.printf("\n\t(%d) \t%s",
                    optionNumber,option);
            optionNumber++;
        }

        System.out.print("\n\n\t---------------------------------------\n");

    }



    private String generateHint(boolean polarize){
        return (polarize) ? "Número más alto" : "Número más bajo";
    }

}
