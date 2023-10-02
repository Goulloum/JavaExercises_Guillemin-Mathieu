package Feuille3;

public class tree {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Renseignez une taille pour le sapin !");
            System.exit(0);

        }
        // DERNIER NIVEAU 7, 13, 21, 31
        // BASES 1, 5, 11, 17, 25
        Integer height = Integer.parseInt(args[0]);
        Integer maxWidth = ((4 + height) * 2) + 1 + (4 * height) + ((height - 1) * 2);

        for (int i = 0; i < height; i++) {
            // for (int j = 0; j < 4 + i; j++) {
            // String row = "";
            // for (int k = 1; k <= 4 + i - j; k++) {
            // row += " ";
            // }
            // for (int k = 1; k <= (2 * j) + 1; k++) {
            // row += "*";
            // }
            // System.out.println(row);
            // }

            for (int j = 0; j < 4 + i; j++) {
                String row = "";
                Integer rowWidth = (j * 2) + 1 + (4 * i) + ((i - 1) * 2);
                for (int k = 1; k <= (maxWidth - rowWidth) / 2; k++) {
                    row += " ";
                }
                for (int k = 1; k <= rowWidth; k++) {
                    row += "*";
                }
                System.out.println(row);
            }

        }

        for (int i = 1; i <= height; i++) {
            String row = "";
            for (int j = 1; j <= (maxWidth - height) / 2; j++) {
                row += " ";
            }
            for (int j = 1; j <= height; j++) {
                row += "|";
            }
            System.out.println(row);
        }
    }
}
