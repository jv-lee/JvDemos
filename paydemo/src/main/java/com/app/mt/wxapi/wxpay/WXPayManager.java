package com.app.mt.wxapi.wxpay;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXPayManager 
{
	static IWXAPI msgApi;
	public static Map<String,String> resultunifiedorder;
	static PayReq req = new PayReq();
	public static String wxprice;
	public static String _gameid = null;
	public static String orderid = null;
	
	public static void init(Context context){
		msgApi = WXAPIFactory.createWXAPI(context,null);
	}
	
	public static void setPayParam(String item,String price,String gameid,String order){
		Constants.WXITEMNAME = item;
		wxprice = price;
		_gameid = gameid;
		orderid = order;
		
	}
	
	public static void pay(){
		GetPrepayIdTask getPrepayId = new GetPrepayIdTask();
		getPrepayId.execute();
	}
	
	
	/**
	 * 生成支付请求
	 */
	public static void genPayReq() {

		req.appId = Constants.APP_ID;
		req.partnerId = Constants.MCH_ID;
		req.prepayId = resultunifiedorder.get("prepay_id");
		req.packageValue = "Sign=WXPay";
		req.nonceStr = WXOther.genNonceStr();
		req.timeStamp = String.valueOf(WXOther.genTimeStamp());


		List<NameValuePair> signParams = new LinkedList<NameValuePair>();
		signParams.add(new BasicNameValuePair("appid", req.appId));
		signParams.add(new BasicNameValuePair("noncestr", req.nonceStr));
		signParams.add(new BasicNameValuePair("package", req.packageValue));
		signParams.add(new BasicNameValuePair("partnerid", req.partnerId));
		signParams.add(new BasicNameValuePair("prepayid", req.prepayId));
		signParams.add(new BasicNameValuePair("timestamp", req.timeStamp));

		req.sign = genAppSign(signParams);
		//System.out.println("req ="  + signParams.toString());
	}
	
	
	
	
	/**
	 * 生成app签名
	 * @param params
	 * @return
	 */
	private static String genAppSign(List<NameValuePair> params) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < params.size(); i++) {
			sb.append(params.get(i).getName());
			sb.append('=');
			sb.append(params.get(i).getValue());
			sb.append('&');
		}
		sb.append("key=");
		sb.append(Constants.API_KEY);
		String appSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
		return appSign;
	}
	
	/**
	 * 调起支付
	 */
	public static void sendPayReq() 
	{
		msgApi.registerApp(Constants.APP_ID);
		msgApi.sendReq(req);
	}
	
	
	public static void oncreate(Context context,Intent intent)
	{
		msgApi = WXAPIFactory.createWXAPI(context, Constants.APP_ID);

		msgApi.handleIntent(intent, (IWXAPIEventHandler) context);
	}
	
	public static void onNewIntent(Activity context,Intent intent)
	{
		context.setIntent(intent);
		msgApi.handleIntent(intent, (IWXAPIEventHandler) context);
	}
	
	public static int onResp(BaseResp resp)
	{
		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
			
		}
		return resp.errCode;
	}
	
}
