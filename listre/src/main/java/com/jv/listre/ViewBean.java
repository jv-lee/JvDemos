package com.jv.listre;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/12/8.
 */

public class ViewBean {
    private TextView tv_clickEt, tv_num;
    private EditText et_num;
    private Button btn_delete;
    private boolean hasSelect = false;

    public ViewBean() {
    }

    public ViewBean(TextView tv_clickEt, TextView tv_num, EditText et_num, Button btn_delete) {
        this.tv_clickEt = tv_clickEt;
        this.tv_num = tv_num;
        this.et_num = et_num;
        this.btn_delete = btn_delete;
    }

    public ViewBean(TextView tv_clickEt, TextView tv_num, EditText et_num, Button btn_delete, boolean hasSelect) {
        this.tv_clickEt = tv_clickEt;
        this.tv_num = tv_num;
        this.et_num = et_num;
        this.btn_delete = btn_delete;
        this.hasSelect = hasSelect;
    }

    public boolean isHasSelect() {
        return hasSelect;
    }

    public void setHasSelect(boolean hasSelect) {
        this.hasSelect = hasSelect;
    }

    public TextView getTv_clickEt() {
        return tv_clickEt;
    }

    public void setTv_clickEt(TextView tv_clickEt) {
        this.tv_clickEt = tv_clickEt;
    }

    public TextView getTv_num() {
        return tv_num;
    }

    public void setTv_num(TextView tv_num) {
        this.tv_num = tv_num;
    }

    public EditText getEt_num() {
        return et_num;
    }

    public void setEt_num(EditText et_num) {
        this.et_num = et_num;
    }

    public Button getBtn_delete() {
        return btn_delete;
    }

    public void setBtn_delete(Button btn_delete) {
        this.btn_delete = btn_delete;
    }
}
