package es.cide;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        DateTimeFormatter dff = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Carlos Pomares Parpal "+ dff.format(now));
    }
}
