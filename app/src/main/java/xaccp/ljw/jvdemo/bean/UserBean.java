package xaccp.ljw.jvdemo.bean;

/**
 * Created by Administrator on 2016/11/18.
 */

public class UserBean extends BaseBean{

    private String userName;
    private String password;
    private String sex;
    private String age;
    private String icon;

    public UserBean(){}

    public UserBean(String userName, String password, String sex, String age, String icon) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.icon = icon;
    }

    public UserBean(String code, String msg, String userName, String password, String sex, String age, String icon) {
        super(code, msg);
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.icon = icon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
