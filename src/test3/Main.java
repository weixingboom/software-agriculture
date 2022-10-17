package test3;

public class Main {
    public static void main(String[] args) {
        KWICSubject kwicSubject = new KWICSubject();
        Input input = new Input("D:\\学校学习\\software-architecture-teaching-software-master\\materires\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "D:\\学校学习\\software-architecture-teaching-software-master\\materires\\output.txt");

        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        kwicSubject.startKWIC();
    }
}
