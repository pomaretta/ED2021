package RandomerUtils;

/*

    Project     ED21
    Package     Endevinador    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-10

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public class Endevinador {
    public static boolean generateHint(int numberIntroduced, int hiddenNumber){
        return numberIntroduced < hiddenNumber;
    }
    public static boolean checkNumber(int playerNumber,int hiddenNumber){ return playerNumber == hiddenNumber; }

}
