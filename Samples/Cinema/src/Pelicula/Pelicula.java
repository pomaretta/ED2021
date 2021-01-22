package Pelicula;

/*

    Project     ED21
    Package     Pelicula    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-01-22

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public class Pelicula {

    private String zoneTitle;
    private int zoneAge;
    private int zoneTicket;

    public Pelicula(){
        this.zoneTitle = generateTitle();
        this.zoneAge = generateAge();
        this.zoneTicket = generateTicket();
    }

    public String getZoneTitle() {
        return zoneTitle;
    }

    public int getZoneAge() {
        return zoneAge;
    }

    public int getZoneTicket() {
        return zoneTicket;
    }

    private String generateTitle(){
        String[] titles = new String[]{
                "Black Hawk Derribado",
                "Avengers: End Game",
                "Avatar",
                "SpiderMan 3",
                "Man in Black"
        };
        return titles[(int)(Math.random() * 5)];
    }

    private int generateTicket(){
        return (int)(Math.random() * 50 + 1);
    }

    private int generateAge(){
        return (int)(Math.random() * 100 + 1);
    }

}