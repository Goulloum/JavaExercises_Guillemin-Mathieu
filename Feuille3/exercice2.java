package Feuille3;

public class exercice2 {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Veuillez renseigner le début et la fin de la boucle !");
            System.exit(0);
        }

        Integer start = 0;
        Integer end = 0;

        try {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Veuillez renseigner des valeurs numérique !");
            System.exit(0);
        }

        for (int i = start; i <= end; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                if (i % 3 == 0) {
                    System.out.print("Fizz");
                }
                if (i % 5 == 0) {
                    System.out.print("Buzz");
                }
            } else {
                System.out.print(i);
            }

            System.out.print(" ");
        }
    }
}
