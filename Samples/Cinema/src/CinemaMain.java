/*

    Project     ED21
        
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-01-18

    DESCRIPTION
    
*/

import Cinema.Cinema;

/**
 * @author Carlos Pomares
 */

public class CinemaMain extends Thread {

    public CinemaMain(){
        long counter = 0;

        try {
            for (int i = 0; i < 10; i++) {
                Cinema cine = new Cinema();
                System.out.println(cine.nanotime);
                counter += cine.nanotime;
                System.out.println("WAITING 2 SECONDS.");
                sleep(1000);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("TIEMPO TOTAL NS: " + counter);
        System.out.println("TIEMPO TOTAL MS: " + (counter / 1000000));
        System.out.println("LA MEDIA ES: " + ((counter / 1000000) / 10));

    }

    public static void main(String[] args) {
        CinemaMain main = new CinemaMain();
    }

}
