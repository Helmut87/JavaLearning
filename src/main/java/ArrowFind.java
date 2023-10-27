/**
 * Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘.
 * Требуется найти количество стрел, которые спрятаны в этой последовательности.
 * Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’
 */
public class ArrowFind {
    public static void main(String[] args) {
        String sequence = generateRandomArrowSequence();
        int arrowCount = countArrowsInString(sequence);
        System.out.println("Количество стрел в последовательности: " + arrowCount);
    }

    private static String generateRandomArrowSequence() {
        StringBuilder sb = new StringBuilder();
        int length = 106;
        String[] symbols = {">", "<", "-"};
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * symbols.length);
            sb.append(symbols[randomIndex]);
        }
        System.out.println("Исходная строка: " + sb);
        return sb.toString();
    }

    private static int countArrowsInString(String sequence) {
        int arrowCount = 0;
        int index = 0;

        while (index < sequence.length() - 4) {
            if (sequence.startsWith(">>-->", index) || sequence.startsWith("<--<<", index)) {
                arrowCount++;
                index += 5;
            } else {
                index++;
            }
        }

        return arrowCount;
    }
}
