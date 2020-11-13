/*

    Project     ED21
        
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-11-12

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

import Calculadora.Calculadora;
import java.util.Scanner;

public class Main {

    // TEST

    // Aplicaciones
    public static Calculadora calculadora;

    public static void main(String[] args) {
        calculadora = new Calculadora(new Scanner(System.in));
    }
}
