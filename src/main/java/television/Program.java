package television;

public class Program {
    private String name;
    private int rating;
    private int viewers;

    public Program(String name, int rating, int viewers) {
        this.name = name;
        this.rating = rating;
        this.viewers = viewers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
    }

    // Метод для увеличения числа зрителей
    public void increaseViewers(int amount) {
        viewers += amount;
    }

    // Метод для вывода информации о программе
    public void displayInfo() {
        System.out.println("Название программы: " + name);
        System.out.println("Рейтинг программы: " + rating);
        System.out.println("Число зрителей: " + viewers);
    }
}
