package homework.enums;

/**
 * @Author zsh
 * @Date 2022/10/13 14:27
 * @Description
 **/
public enum TypeEnum {
    OBJECT(1,"面向对象"),
    MAIN(2,"主子程序"),
    PIPE(3,"管道"),
    EVENT(4,"事件");

    private Integer value;
    private String status;
    TypeEnum(Integer value, String status){
        this.value = value;
        this.status =status;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
