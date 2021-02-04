package es.cide;

/*

    Project     ED21
    Package     es.cide    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-03

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public class Jugador {

    Cartulina[] cartulinas= new Cartulina[2];

    public Jugador(){

        cartulinas[0] = new Cartulina();
        cartulinas[1] = new Cartulina();

    }

    public void showLetter(int[] letter){
        for(int number: letter){
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) {

        Jugador j = new Jugador();

        j.showLetter(j.cartulinas[0].getLetter());
        System.out.println("\n");
        j.showLetter(j.cartulinas[1].getLetter());

    }

}
