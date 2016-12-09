package xaccp.ljw.jvdemo.bean;

/**
 * Created by jv on 2016/10/31.
 */

public class Bean {

    private String name;
    private String title;
    private int type;

    public Bean() {
    }

    public Bean(String name, String title, int type) {
        this.name = name;
        this.title = title;
        this.type = type;
    }

    public Bean(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
