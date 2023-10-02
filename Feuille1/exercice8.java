public class exercice8 {

    public static void main(String[] args) {
        String[] colors = { "bleu", "rouge", "jaune" };
        for (String value : colors) {
            String phrase = "";
            switch (value) {
                case "bleu":
                    phrase = "La couleur préférée de Louis est le ";
                    break;
                case "rouge":
                    phrase = "Pour sa peinture, Andrée a utilisé du ";
                    break;
                case "jaune":
                    phrase = "Anis n'a pas de chemise ";
                    break;
                default:
                    System.out.println("Couleur non prise en compte : ");
                    break;

            }
            System.out.println(phrase + value);
        }
    }

}
