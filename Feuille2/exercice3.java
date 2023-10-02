package Feuille2;

import java.util.ArrayList;

public class exercice3 {
    public static void main(String[] args) {

        ArrayList<String> quotations = new ArrayList<String>();
        quotations.add("Quand Paris s’enrhume, l’Europe a froid");
        quotations.add("S'il y a un diamant dans la poitrine, il brille sur le visage");
        quotations.add("La joie de vivre n'est pas un but, mais un devoir");

        for (String quote : quotations) {
            System.out.println(quote + " : " + countVowels(quote));
        }

    }

    private static Integer countVowels(String str) {
        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');

        Integer result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vowels.indexOf(str.charAt(i)) != -1) {
                result++;
            }
        }

        return result;
    }
}
