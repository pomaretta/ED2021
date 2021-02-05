package Estanteria;

/*

    Project     ED21
    Package     Estanteria    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-02-04

    DESCRIPTION
    
*/

import java.util.ArrayList;

/**
 * @author Carlos Pomares
 */

public class Estanteria {

    private final int LIBROS_MAXIMOS = 10;
    private final ArrayList<Libro> libros = new ArrayList<Libro>(this.LIBROS_MAXIMOS);
    private final Libro[] librosSimple = new Libro[this.LIBROS_MAXIMOS];

    public Estanteria(){

    }

    public void afegirLlibre(Libro libro) throws Exception {
        if(this.libros.contains(libro)){
            throw new Exception("Libro ya en la estanteria.");
        }
        this.libros.add(libro);
    }

    public void eliminarLlibre(Libro libro) throws Exception {
        if(!this.libros.contains(libro)){
            throw new Exception("El libro no está en la estanteria.");
        }
        this.libros.remove(libro);
    }

    public void veureTop(){

        System.out.println("-------- TOP --------");

        ArrayList<Libro> orderedList = orderArray(this.libros);
        System.out.printf("%-15s %-15s %-15s",
                "Título","Autor","Calificacion");
        for(Libro libro : orderedList){
            System.out.printf("\n%-15s %-15s %-15f",
                    libro.getTitulo(),libro.getAutor(),libro.getCalificacion());
        }

        System.out.println("\n-------- END --------");

    }

    public void veureEstanteria(){

    }

    private ArrayList<Libro> orderArray(ArrayList<Libro> array){
        ArrayList<Libro> output = array;
        int i, j;
        Libro temp;
        for(i = 0; i < output.size(); i++){
            for(j = 0; j < output.size()-i-1; j++){
                if(Libro.comparate(output.get(j),output.get(j+1)) == -1){
                    temp = output.get(j);
                    output.set(j,output.get(j+1));
                    output.set((j+1),temp);
                }
            }
        }
        return output;
    }

    private Libro[] orderArraySimple(Libro[] array){
        Libro[] output = array;
        int i, j;
        Libro temp;
        for(i = 0; i < output.length; i++){
            for(j = 0; j < output.length-i-1; j++){
                if(Libro.comparate(output[j],output[j+1]) == -1){
                    temp = output[j];
                    output[j] = output[j+1];
                    output[j+1] = temp;
                }
            }
        }
        return output;
    }

}
