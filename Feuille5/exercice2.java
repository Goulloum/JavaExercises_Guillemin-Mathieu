package Feuille5;

import java.util.ArrayList;

public class exercice2 {
    public static void main(String[] args) {

        GenerateArray.generate(10, 100);
        ArrayList<Integer> list = GenerateArray.getList();
        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list);

    }
}
