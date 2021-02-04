package Bingo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    private ArrayList<Integer> letter;
    private int maxLetterNumber;
    private int maxNumberInLetter;

    public Player(int maxLetterNumbers, int maxNumber){
        this.maxLetterNumber = maxLetterNumbers;
        this.maxNumberInLetter = maxNumber;
        this.letter = generateLetter();
    }

    public void removeLetterValue(int value){
        if(this.containsValue(this.letter,value)){
            this.letter.remove(this.letter.indexOf(value));
        }
    }

    public boolean isFilled(){
        return this.letter.size() == 0;
    }

    public ArrayList<Integer> getLetter() {
        return letter;
    }

    private ArrayList<Integer> generateLetter(){
        ArrayList<Integer> letter = new ArrayList<Integer>(this.maxLetterNumber);
        for (int i = 0; i < this.maxLetterNumber; i++) {
            letter.add(this.generateValue(letter));
        }
        return letter;
    }

    private int generateValue(ArrayList<Integer> letter){
        int randomNumber = (int)(Math.random() * maxNumberInLetter + 1);
        if(this.containsValue(letter,randomNumber)){
            generateValue(letter);
        }
        return randomNumber;
    }

    private boolean containsValue(ArrayList<Integer> letter,int value){
        boolean flag = false;
        for (Integer number : letter) {
            if(value == number){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private int getValuePosition(int[] letter,int value){
        int flag = -1;
        for (int i = 0; i < letter.length; i++) {
            if(value == letter[i]){
                flag = i;
                break;
            }
        }
        return flag;
    }

}
