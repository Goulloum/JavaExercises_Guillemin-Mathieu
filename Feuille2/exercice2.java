package Feuille2;

import java.util.ArrayList;

public class exercice2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Argument nul, fin du processus !");
            System.exit(0);
        }

        ArrayList<String> tab = new ArrayList<String>();
        // kiwi, pomme, poire, litchi et rhubarbe.
        tab.add("kiwi");
        tab.add("pomme");
        tab.add("poire");
        tab.add("litchi");
        tab.add("rhubarbe");

        Integer findIndex = findFruit(tab, args[0]);
        if (findIndex == -1) {
            System.out.println(args[0] + " n'est pas dans le tableau");
        } else {
            System.out.println("Le fruit " + args[0] + " est à l'index " + findIndex);
        }
    }

    private static Integer findFruit(ArrayList<String> fruits, String str) {

        for (int i = 0; i < fruits.size(); i++) {
            if (fruits.get(i).toLowerCase().equals(str.toLowerCase())) {
                return i;
            }
        }

        return -1;
    }
}
