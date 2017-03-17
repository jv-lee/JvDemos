package com.jv.builder.module;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2017/3/17.
 */

public class Progremer extends TechManager {
    private Product product;
    private InnerProduct innerProduct = new InnerProduct();

    @Override
    public TechManager setAppName(@NonNull String appName) {
        innerProduct.setAppName(appName);
        return this;
    }

    @Override
    public TechManager setAppFunction(@NonNull String appFunction) {
        innerProduct.setAppFunction(appFunction);
        return this;
    }

    @Override
    public TechManager setAppSystem(int appSystem) {
        innerProduct.setAppSystem(appSystem);
        return this;
    }

    private class InnerProduct {
        private String appName;
        private String appFunction;
        private int appSystem;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getAppFunction() {
            return appFunction;
        }

        public void setAppFunction(String appFunction) {
            this.appFunction = appFunction;
        }

        public int getAppSystem() {
            return appSystem;
        }

        public void setAppSystem(int appSystem) {
            this.appSystem = appSystem;
        }
    }

    @Override
    public Product build() {
        product = new Product();
        product.setAppName(innerProduct.getAppName());
        product.setAppFunction(innerProduct.getAppFunction());
        product.setAppSystem(innerProduct.getAppSystem());
        return product;
    }
}
