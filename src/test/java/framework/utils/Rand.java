package framework.utils;

import java.util.Random;

public class Rand {
    private static final Random random = new Random();

    public static int getRandomIndex(int arraySize){
        int min = 2;
        int diff  = arraySize - min;
        return random.nextInt(diff + 1);
    }
}
