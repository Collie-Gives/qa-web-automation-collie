package com.reto.util;

import java.util.Random;

public class RandomNumber {
    public static int findNumber() {
        Random random = new Random();
        return random.nextInt(1000);
    }
}
