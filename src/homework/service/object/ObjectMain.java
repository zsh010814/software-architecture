package homework.service.object;

public class ObjectMain {
    public static void main(String args) {
        if (args == null) {
            args = "files/input.txt";
        }
        System.out.println(args);
        Input input = new Input();
        input.input(args);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("files/output.txt");
    }
}
