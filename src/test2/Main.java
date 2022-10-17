package test2;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("D:\\学校学习\\software-architecture-teaching-software-master\\materires\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt");

    }
}
