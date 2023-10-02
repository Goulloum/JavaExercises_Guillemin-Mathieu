public class exercice6 {

    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Integer i = str.length();

        String res = "";

        while (i > 0) {
            res += str.charAt(i - 1);
            i--;
        }
        System.out.println(res);
    }

}
