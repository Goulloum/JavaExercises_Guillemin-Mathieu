package Feuille3;

import java.util.ArrayList;

public class exercice5 {
    public static void main(String[] args) {
        ArrayList<Integer> nbArray = new ArrayList<Integer>();
        // : 75, 80, 90, 95, 85
        nbArray.add(75);
        nbArray.add(80);
        nbArray.add(85);
        nbArray.add(90);
        nbArray.add(95);

        System.out.println("La moyenne de la liste est :" + averageCalc(nbArray));
    }

    private static Integer averageCalc(ArrayList<Integer> numbers) {
        Integer nbElement = numbers.size();
        Integer sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        return sum / nbElement;
    }
}
