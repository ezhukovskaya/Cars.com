package framework.utils;

import java.util.Random;

public class Rand {
    private static final Random random = new Random();

    public static int getRandomIndex(int arraySize){
        int min = 1;
        int diff  = arraySize - min;
        int randomIndex = random.nextInt(diff + 1);
        randomIndex+=min;
        return randomIndex;
    }
}
