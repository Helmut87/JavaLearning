import java.util.Scanner;

/**
 * Для введенной с клавиатуры буквы английского алфавита нужно вывести слевастоящую букву
 * на стандартной клавиатуре. При этом клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a»,
 * а слева от «a» буква «p», также соседними считаются буквы «l» и буква «z», а буква «m» с буквой «q»
 */
public class KeyboardSymbolShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву английского алфавита: ");
        char inputChar = scanner.next().charAt(0);
        char resultChar = findLeftNeighbor(inputChar);

        if (resultChar != 0) {
            System.out.println("Буква слева от введенной: " + resultChar);
        } else {
            System.out.println("Такой буквы на клавиатуре нет!");
        }
    }

    private static char findLeftNeighbor(char inputChar) {
        String keyboardLayout = "qwertyuiopasdfghjklzxcvbnm";
        int index = keyboardLayout.indexOf(inputChar);

        if (index != -1) {
            if (index > 0) {
                return keyboardLayout.charAt(index - 1);
            }
        }
        return 0; // 0 означает, что такой буквы нет
    }
}