package homework.service.event;

/**
 * @Author zsh
 * @Date 2022/10/12 14:24
 * @Description
 **/
public class EventMain {
    public static void main(String args) {
        if (args == null) {
            args = "files/input.txt";
        }
        //创建主题
        KWICSubject kwicSubject = new KWICSubject();
        //创建观察者
        Input input = new Input(args);
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), "files/output.txt");

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);
        // 逐步调用各个观察者
        kwicSubject.startKWIC();
    }
}

