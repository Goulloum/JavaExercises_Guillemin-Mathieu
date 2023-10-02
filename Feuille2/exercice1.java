package Feuille2;

import java.util.ArrayList;

public class exercice1 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        // 14, 887, 58, 713, 179, 512, 786 et 29
        nums.add(14);
        nums.add(887);
        nums.add(58);
        nums.add(713);
        nums.add(179);
        nums.add(512);
        nums.add(786);
        nums.add(29);

        System.out.println("Contenu du stock :" + sum(nums));
    }

    private static Integer sum(ArrayList<Integer> stock) {
        Integer sum = 0;
        for (Integer item : stock) {
            sum += item;
        }

        return sum;
    }

}
