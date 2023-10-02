import java.util.ArrayList;

public class exercice9 {

    public static void main(String[] args) {
        Integer[] numbers = { 21565, 3412, 180,
                1556, 182, 84, 15 };
        ArrayList<String> numbersResult = new ArrayList<String>();

        for (Integer num : numbers) {
            if (num % 3 != 0) {
                numbersResult.add(num.toString());
            }
        }

        System.out.println(String.join(", ", numbersResult));
    }

}
