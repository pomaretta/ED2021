package Cinema;

/*

    Project     ED21
    Package     Cinema    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-01-18

    DESCRIPTION
    
*/

import Personas.Persona;

import java.util.ArrayList;

/**
 * @author Carlos Pomares
 */

public class Cinema extends Thread {

    private Persona[] asientos;

    private int zoneAge;
    private int zoneTicket;

    // STATISTICS
    public long nanotime;

    public Cinema(){

        this.asientos = new Persona[72];
        generateZone();
        llenarCine();
        //showSeats();

    }

    private void llenarCine(){

        long startTime = System.nanoTime();
        cinemaRuntime();
        long stopTime = System.nanoTime();

        this.nanotime = (stopTime - startTime);

    }

    private void generateZone(){
        this.zoneAge = (int)(Math.random() * 100 + 1);
        this.zoneTicket = (int)(Math.random() * 50 + 1);
    }

    private void cinemaRuntime(){

        try {
            while(!isFilled()){
                Persona person = new Persona();

                if(checkRequeriments(person)){
                    putPerson(person);
                    printSeats();
                    sleep(2000);
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void putPerson(Persona person){
        int seat = (int)(Math.random() * 72);
        if(this.asientos[seat] == null){
            this.asientos[seat] = person;
        } else {
            putPerson(person);
        }
    }

    private boolean checkRequeriments(Persona person){
        return (person.getDinero() >= this.zoneTicket) && (person.getEdad() >= this.zoneAge);
    }

    private boolean isFilled(){
        int falseCounter = 0;
        for(int index = 0; index < this.asientos.length; index++){
            if(asientos[index] == null){
                falseCounter++;
            }
        }
        return falseCounter == 0;
    }

    private void showSeats(){
        for (int i = 0; i < this.asientos.length; i++) {
            System.out.println("PERSONA " + i + ":" + " " + this.asientos[i].getEdad() + " " + this.asientos[i].getDinero());
        }
    }

    private void printSeats(){

        for(int index = 0; index < this.asientos.length; index++){

            if(this.asientos[index] == null){
                System.out.print("0");
            } else {
                System.out.print("1");
            }

            if(index / 8 == 0){
                System.out.print("\n");
            }
        }

    }

}
