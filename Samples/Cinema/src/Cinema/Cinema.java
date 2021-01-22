package Cinema;

/*

    Project     ED21
    Package     Cinema    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-01-18

    DESCRIPTION
    
*/

import Pelicula.Pelicula;
import Personas.Persona;
import Utility.ClearConsole;

/**
 * @author Carlos Pomares
 */

public class Cinema extends Thread {

    private Persona[] asientos;
    private Pelicula film;

    private int type;
    private int zoneAge;
    private int zoneTicket;
    private int collectedTickets;

    // STATISTICS
    public long nanotime;
    public int lastPerson = 0;

    public Cinema(String type){
        if(type.equals("view")){
            this.type = 1;
        } else if(type.equals("stats")){
            this.type = -1;
        } else {
            this.type = 0;
        }

        this.asientos = new Persona[72];
        this.film = new Pelicula();
        this.collectedTickets = 0;
        llenarCine();

        if(this.type == -1){

            System.out.printf("\n%-30s %-15s %-15s",
                    "FILM TITLE", "FILM TICKET", "FILM AGE");
            System.out.printf("\n%-30s %-15d %-15d",
                    this.film.getZoneTitle(), this.film.getZoneTicket(), this.film.getZoneAge());

            System.out.printf("\n%-15s %-15s","TIME MS","LAST PERSON");
            System.out.printf("\n%-15f %-15d",((double)this.nanotime / 1000000),this.lastPerson);
        }

    }

    private void llenarCine(){
        long startTime = System.nanoTime();
        cinemaRuntime();
        long stopTime = System.nanoTime();
        this.nanotime = (stopTime - startTime);
    }

    private void cinemaRuntime(){
        try {
            while(!isFilled()){
                Persona person = new Persona();
                if(checkRequirements(person)){
                    if(this.type == -1){
                        if(lastPerson() == 1) {
                            putPerson(person,true);
                        } else {
                            putPerson(person);
                        }
                    } else if(this.type == 1){
                        putPerson(person);
                        printSeats();
                        sleep(1000);
                    } else {
                        putPerson(person);
                    }
                }
            }

            this.collectedTickets = this.film.getZoneTicket() * this.asientos.length;

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

    private void putPerson(Persona person,boolean lastPerson){
        int seat = (int)(Math.random() * 72);
        if(this.asientos[seat] == null){
            this.asientos[seat] = person;
            this.lastPerson++;
        } else {
            if(lastPerson)
                this.lastPerson++;
            putPerson(person,true);
        }
    }

    private boolean checkRequirements(Persona person){
        return (person.getDinero() >= this.film.getZoneTicket()) && (person.getEdad() >= this.film.getZoneAge());
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

    private int lastPerson(){
        int falseCounter = 0;
        for(int index = 0; index < this.asientos.length; index++){
            if(asientos[index] == null){
                falseCounter++;
            }
        }
        return falseCounter;
    }

    private void printSeats() throws Exception {
        int counter = 1;
        ClearConsole.clearScreen();
        System.out.print("\n\n\n");
        for(int index = 1; index <= this.asientos.length; index++){
            if(this.asientos[index - 1] == null){
                System.out.print(" 0 ");
            } else {
                System.out.print(" 1 ");
            }
            if(counter == 9){
                System.out.print("\n");
                counter = 0;
            }
            counter++;
        }
    }

}
