package Feuille5;

import java.util.ArrayList;
import java.util.Random;

public class GenerateArray {

    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void generate(int size, int max) {
        if (size > max) {
            throw new Error("Cannot generate enough unique random values");
        }
        Random ran = new Random();
        for (int i = 0; i < size; i++) {
            int randInt = ran.nextInt(max - 1) + 1;
            while (list.contains(randInt)) {
                randInt = ran.nextInt(max - 1) + 1;
            }
            list.add(randInt);
        }
    }

    public static ArrayList<Integer> getList() {
        return list;
    }

}
