package Bingo;

public class Machine {

    private int[] numbers;

    private int minNumber;
    private int maxNumber;

    public Machine(int minNumber, int maxNumber){
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numbers = generateNumbers();
    }

    public int getNumber(){
        int numberToGet = (int)(Math.random() * maxNumber);
        if(this.numbers[numberToGet] != 0){
            this.numbers[numberToGet] = 0;
        } else {
            getNumber();
        }
        return numberToGet + 1;
    }

    private int[] generateNumbers(){
        int[] output = new int[this.maxNumber];
        for (int i = 0; i < this.maxNumber; i++) {
            output[i] = minNumber + i;
        }
        return output;
    }

    public boolean isFull(){
        int flag = 0;
        for (int i = 0; i < this.numbers.length ; i++) {
            if(this.numbers[i] == 0){
                flag++;
            }
        }
        return flag == this.numbers.length;
    }

}
