package homework.service.pipe;

import java.io.IOException;

/**
 * @Author zsh
 * @Date 2022/10/12 14:25
 * @Description
 **/
public abstract class Filter {
    protected Pipe input;
    protected Pipe output;

    public Filter(Pipe input, Pipe output) {
        this.input = input;
        this.output = output;
    }
    protected abstract void transform() throws IOException;
}

