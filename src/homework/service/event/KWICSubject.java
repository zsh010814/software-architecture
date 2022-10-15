package homework.service.event;

/**
 * @Author zsh
 * @Date 2022/10/12 14:17
 * @Description
 **/
public class KWICSubject extends Subject{
    public void startKWIC(){
        for (int i = 0;i<4;i++){
            super.notifyOneObserver(i);
        }
    }
}

