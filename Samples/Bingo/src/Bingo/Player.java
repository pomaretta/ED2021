package Bingo;

import java.lang.reflect.Array;

public class Player {

    private int[] letter;
    private int maxLetterNumber;
    private int maxNumberInLetter;

    public Player(int maxLetterNumbers, int maxNumber){
        this.maxLetterNumber = maxLetterNumbers;
        this.maxNumberInLetter = maxNumber;
        this.letter = generateLetter();
    }

    public int[] getLetter() {
        return letter;
    }

    public void removeLetterValue(int value){
        if(this.containsValue(this.letter,value)){
            this.letter[this.getValuePosition(this.letter,value)] = 0;
        }
    }

    public boolean isFilled(){
        int counter = 0;
        for(Integer number : this.letter){
            if(number == 0){
                counter++;
            }
        }
        if(counter == this.maxLetterNumber){
            return true;
        }
        return false;
    }

    private int[] generateLetter(){
        int[] letter = new int[this.maxLetterNumber];
        for (int i = 0; i < this.maxLetterNumber; i++) {
            letter[i] = this.generateValue(letter);
        }
        return letter;
    }

    private int generateValue(int[] letter){
        int randomNumber = (int)(Math.random() * maxNumberInLetter + 1);
        if(this.containsValue(letter,randomNumber)){
            generateValue(letter);
        }
        return randomNumber;
    }

    private boolean containsValue(int[] letter,int value){
        boolean flag = false;
        for (int i = 0; i < letter.length; i++) {
            if(value == letter[i]){
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
