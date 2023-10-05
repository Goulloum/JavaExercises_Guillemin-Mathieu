package Feuille5;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class exercice1 {
    public static void main(String[] args) {
        Instant start = Instant.now();
        GenerateArray.generate(5000, 500);
        ArrayList<Integer> list = GenerateArray.getList();
        // System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        // System.out.println(list);
        System.out.println(timeElapsed + " ms");

    }
}
