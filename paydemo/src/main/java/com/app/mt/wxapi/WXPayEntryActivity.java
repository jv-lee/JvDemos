
package com.app.mt.wxapi;

import com.app.mt.wxapi.wxpay.WXPayManager;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		//请勿修改此段代码
		WXPayManager.oncreate(this, getIntent());
	}

	@Override
	public void onReq(BaseReq req) {
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		//请勿修改此段代码
		WXPayManager.onNewIntent(this, intent);
	}

	@Override
	public void onResp(BaseResp resp) {
		//result仅用作支付结果在UI中展示
		if(resp.errCode == 0){
			Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();

		}else if(resp.errCode == -1){
			Toast.makeText(this, "支付失败", Toast.LENGTH_SHORT).show();

		}else if(resp.errCode == -2){
			Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();

		}
		finish();
	}
	
}
