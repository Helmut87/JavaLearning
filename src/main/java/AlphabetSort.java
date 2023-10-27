import java.util.Arrays;

/**
 * Задана строка, состоящая из букв английского алфавита, разделенных одним пробелом.
 * Необходимо каждую последовательность символов упорядочить по возрастанию и вывести слова в нижнем регистре
 */
public class AlphabetSort {
    public static void main(String[] args) {
        String input = "hello world apple banana";
        String[] words = input.split(" ");

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            Arrays.sort(chars);
            words[i] = new String(chars).toLowerCase();
        }

        String result = String.join(" ", words);
        System.out.println(result);
    }
}