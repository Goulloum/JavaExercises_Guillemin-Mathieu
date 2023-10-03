package Feuille3;

public class exercice3 {
    public static void main(String[] args) {
        Integer count = 0;
        Integer start = 1;
        Integer end = 50;

        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                count += i;
            }
        }

        System.out.println("La somme des nombres pairs entre " + start + " et " + end + " est: " + count);
    }
}
