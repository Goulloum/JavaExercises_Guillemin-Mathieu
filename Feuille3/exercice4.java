package Feuille3;

public class exercice4 {
    public static void main(String[] args) {
        Integer count = 0;
        Integer start = 1;
        Integer end = 10;

        for (int i = start; i <= end; i++) {
            count += i * i;
        }
        System.out.println("La somme des carrés entre " + start + " et " + end + " est: " + count);
    }
}
