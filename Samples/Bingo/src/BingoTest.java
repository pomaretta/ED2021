import Bingo.Bingo;
import Bingo.Player;

import java.util.ArrayList;

public class BingoTest {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        Bingo bingo = new Bingo(2);
        bingo.startGame();
        long stopTime = System.nanoTime();

        System.out.print("Player 0: ");
        showLetter(bingo.players[0].getLetter());

        System.out.print("\nPlayer 1: ");
        showLetter(bingo.players[1].getLetter());

        System.out.println("\nTime to resolve: " + ((double)(stopTime - startTime) / 1000000));

    }

    public static void showLetter(ArrayList<Integer> letter){
        for(Integer x : letter){
            System.out.print(x + " ");
        }
    }

}
