package Feuille5;

import java.util.ArrayList;
import java.util.Scanner;

public class exercice3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        GenerateArray.generate(10, 100);
        int cpt = 0;

        while (cpt < 5) {
            System.out.println("Veuillez rentrer un nombre entier");
            String newItem = scan.nextLine();
            try {
                int newItemInt = Integer.parseInt(newItem);
                GenerateArray.addItem(newItemInt);
                cpt++;
            } catch (Exception e) {
                System.out.println("La donnée saisie n'est pas un entier valide ! Recommencez :");
            }
        }

        ArrayList<Integer> list = GenerateArray.getList();
        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j) < list.get(j + 1)) {
                    int temp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list);

    }
}
