package homework.service.pipe;

import java.io.File;
import java.io.IOException;

/**
 * @Author zsh
 * @Date 2022/10/12 14:27
 * @Description
 **/
public class PipeMain {
    public static void main(String args) throws IOException {
        if (args == null) {
            args = "files/input.txt";
        }
        File inFile = new File(args);
        File outFile = new File("files/output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}

