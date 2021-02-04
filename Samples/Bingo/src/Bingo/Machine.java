package Bingo;

import java.util.ArrayList;

public class Machine {

    private ArrayList<Integer> numbers;

    private int minNumber;
    private int maxNumber;

    public Machine(int minNumber, int maxNumber){
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numbers = generateNumbers();
    }

    public int getNumber(){
        int numberToGet = (int)(Math.random() * maxNumber + minNumber);
        while(!this.numbers.contains(numberToGet)){
            numberToGet = (int)(Math.random() * maxNumber + minNumber);
        }
        this.numbers.remove(this.numbers.indexOf(numberToGet));
        return numberToGet;
    }

    private ArrayList<Integer> generateNumbers(){
        ArrayList<Integer> output = new ArrayList<Integer>(this.maxNumber);
        for (int i = 0; i < this.maxNumber; i++) {
            output.add(minNumber + i);
        }
        return output;
    }

    public boolean isFull(){
        int flag = 0;
        for (int i = 0; i < this.numbers.size() ; i++) {
            if(this.numbers.get(i) == null){
                flag++;
            }
        }
        return flag == this.numbers.size();
    }

}
