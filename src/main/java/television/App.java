package television;

public class App {
    public static void main(String[] args) {
        Program newsProgram = new Program("�������", 5, 1000000);
        Program sportsProgram = new Program("���������� ������������", 4, 500000);
        Program movieProgram = new Program("����", 5, 2000000);

        sportsProgram.setRating(5);
        sportsProgram.increaseViewers(100000);

        sportsProgram.displayInfo();

        Television tv = new Television("Sony", 2022, 55, true, true, 1, 50);
        tv.addChannel(new Channel("��-6", 1, newsProgram));
        tv.addChannel(new Channel("���", 2, sportsProgram));
        tv.addChannel(new Channel("������", 3, movieProgram));
        tv.togglePower();
        tv.changeChannel(2);
        System.out.println(tv);

        Television anotherTV = new Television("LG", 2021, 50, true, true, 1, 60);
        anotherTV.addChannel(new Channel("������24", 1, newsProgram));
        anotherTV.addChannel(new Channel("���", 2, sportsProgram));
        anotherTV.addChannel(new Channel("���", 3, movieProgram));
        System.out.println(anotherTV);

        if (tv.equals(anotherTV)) {
            System.out.println("��� ���������� ���������.");
        } else {
            System.out.println("���������� ������.");
        }
    }
}