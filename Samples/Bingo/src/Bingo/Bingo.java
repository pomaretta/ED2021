package Bingo;

public class Bingo {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 99;
    private final int PLAYER_LETTERS = 10;

    private Machine maquina;
    public Player[] players;
    private int playerNumber;

    public Bingo(int playerNumber){
        this.maquina = new Machine(1,99);
        this.playerNumber = playerNumber;
        this.players = generatePlayers();
    }

    public void startGame(){
        while(!this.maquina.isFull()){
            int bingoNumber = this.maquina.getNumber();
            players[0].removeLetterValue(bingoNumber);
            players[1].removeLetterValue(bingoNumber);
            if(players[0].isFilled() || players[1].isFilled()){
                break;
            }
        }
    }

    private Player[] generatePlayers(){
        Player[] output = new Player[this.playerNumber];
        for (int i = 0; i < output.length; i++) {
            output[i] = new Player(this.PLAYER_LETTERS,this.MAX_NUMBER);
        }
        return output;
    }

}
