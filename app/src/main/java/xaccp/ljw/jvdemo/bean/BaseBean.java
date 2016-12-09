package xaccp.ljw.jvdemo.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/18.
 */

public class BaseBean implements Serializable{

    protected String code;
    protected String msg;

    public BaseBean() {
    }

    public BaseBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
