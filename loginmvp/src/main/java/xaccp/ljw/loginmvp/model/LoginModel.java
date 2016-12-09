package xaccp.ljw.loginmvp.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64118 on 2016/11/26.
 */

public class LoginModel implements ILoginModel {

    private Map<String, String> map = new HashMap<>();

    @Override
    public boolean onRegister(String username, String password) {
        if (!map.containsKey(username)) {
            map.put(username, password);
            return true;
        }
        return false;
    }

    @Override
    public boolean onLogin(String username, String password) {
        if (password.equals(map.get(username))) {
            return true;
        }
        return false;
    }

}
