public class execice5 {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Integer i = 0;
        String res = "";
        while (i < str.length()) {
            res += (i % 2 == 1) ? str.charAt(i) : "";
            i++;
        }

        System.out.println(res);
    }
}
