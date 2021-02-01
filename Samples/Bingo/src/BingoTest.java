import Bingo.Bingo;
import Bingo.Player;

public class BingoTest {

    public static void main(String[] args) {

        Bingo bingo = new Bingo(2);
        bingo.startGame();

        Player[] jugadores = bingo.getPlayers();

        System.out.println((jugadores[0].isFilled()) ? "Jugador 0 Gana" : (jugadores[1].isFilled()) ? "Jugador 1 Gana" : "Ninguno gana.");

    }

}
