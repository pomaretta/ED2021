/*

    Project     ED21
        
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-04

    DESCRIPTION
    
*/

import Estanteria.Estanteria;
import Estanteria.Libro;

/**
 * @author Carlos Pomares
 */

public class EstanteriaTest {

    public static void main(String[] args) {
        Estanteria libreria = new Estanteria();
        Libro l1 = new Libro("Los Mil Viajes", "Antonio Machete",6.5f);
        Libro l2 = new Libro("Los Mil Viajes", "Antonio Machete",9.5f);

        try {
            libreria.afegirLlibre(l1);
            libreria.afegirLlibre(l2);
            libreria.veureTop();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
