package com.jv.multi.model;

import java.util.Random;

/**
 * Created by Administrator on 2017/2/23.
 */

public class ModelFaker {
    public static BaseModel fake() {
        String type = new Random().nextBoolean() ? "image" : "text";
        if (type.equals("image")) {
            return new ImageModel();
        } else {
            return new TextModel();
        }
    }
}
