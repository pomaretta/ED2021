package Random;

/*

    Project     ED21
    Package     Random    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-10

    DESCRIPTION
    
*/

import java.util.Random;

/**
 * @author Carlos Pomares
 */

public class RandomNumber {

    public static int generateNumber(int numberToReach){
        return (int)(Math.random() * (numberToReach + 1));
    }

}