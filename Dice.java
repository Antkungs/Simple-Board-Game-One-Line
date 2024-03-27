package lab7_simpleboardgame;
import java.util.Random;

public class Dice {
    
    public static int diceRandom(){
        Random rd = new Random();
        int dice = rd.nextInt(6) +1;
        return dice;
    }
}
