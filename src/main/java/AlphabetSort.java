import java.util.Arrays;

/**
 * Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом.
 * Необходимо каждую последовательность символов упорядочить по возрастанию и вывести слова в нижнем регистре
 */
public class AlphabetSort {
    public static void main(String[] args) {
        String inputString = "Hello wOrLd i caNnot coDE in Java";
        String[] words = inputString.toLowerCase().split(" ");

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            words[i] = new String(chars);
        }

        String result = String.join(" ", words);
        System.out.println("Результат: " + result);
    }
}