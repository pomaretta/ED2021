package Personas;

/*

    Project     ED21
    Package     Personas    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-01-18

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public class Persona {

    private int edad;
    private int dinero;

    public Persona(){
        this.edad = generarEdad();
        this.dinero = generarDinero();
    }

    public int getEdad() {
        return edad;
    }

    public int getDinero() {
        return dinero;
    }

    private int generarEdad(){
        return (int)(Math.random() * 100 + 1);
    }

    private int generarDinero(){
        return (int)(Math.random() * 50 + 1);
    }

}
