package homework.service.event;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author zsh
 * @Date 2022/10/12 14:16
 * @Description
 **/
public class Subject {

    //观察者数组
    private List<Observer> vector = new LinkedList<>();


    //增加一个观察者
    public void addObserver(Observer observer) {
        vector.add(observer);
    }

    //删除一个观察者
    public void deleteObserver(Observer observer) {
        vector.remove(observer);
    }

    //通知所有观察者
    public void notifyAllObserver() {
        for(Observer observer : vector) {
            observer.toDo();
        }
    }

    // 通知特定观察者
    public void notifyOneObserver(int i) {
        vector.get(i).toDo();
    }

}

