public class exercice4 {
    public static void main(String[] args) {
        String str = "Hello world";
        Integer i = 0;
        String result = "";

        while (i < str.length()) {
            result += str.charAt(i);
            result += (str.length() == i - 1) ? "" : " ";
            i++;
        }

        System.out.println(result);
    }
}
