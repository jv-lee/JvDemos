package com.app.mt.wxapi.wxpay;

import java.util.Map;

import android.os.AsyncTask;
import android.util.Log;
public class GetPrepayIdTask extends AsyncTask<Void, Void, Map<String,String>>
{
	public static final String TAG = GetPrepayIdTask.class.getSimpleName();
	
	@Override
	protected void onPreExecute() {
	}

	@Override
	protected Map<String, String> doInBackground(Void... arg0) {
		String url = String.format("https://api.mch.weixin.qq.com/pay/unifiedorder");
		String entity = WXOther.genProductArgs();
		
		Log.i(TAG,"entity = " + entity);
		byte[] buf = Util.httpPost(url, entity);
		
		String content = new String(buf);
		Log.i(TAG,"oriontest = " + content);
		WXPayManager.resultunifiedorder = WXOther.decodeXml(content);
		
		Log.i(TAG,"prepay_id = " + WXPayManager.resultunifiedorder.get("prepay_id"));
		WXPayManager.genPayReq();
		WXPayManager.sendPayReq();
		
		return WXPayManager.resultunifiedorder;
	}
}
