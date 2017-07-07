package com.app.mt.alipay;

import java.util.Map;


import com.alipay.sdk.app.PayTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public class AliPayManager {

	private volatile static AliPayManager mInstance;
	private static Activity mActivity;

	private AliPayManager(){}
	private AliPayManager(Activity context){
		mActivity = context;
	}


	public static AliPayManager getInstance(Activity context) {
		if (mInstance == null) {
			synchronized(AliPayManager.class){
				if (mInstance == null) {
					mInstance = new AliPayManager(context);
				}
			}
		}
		return mInstance;
	}


	@SuppressLint("HandlerLeak")
	private static Handler mHandler = new Handler() {
		@SuppressWarnings("unused")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case SDK_PAY_FLAG: {
				@SuppressWarnings("unchecked")
				PayResult payResult = new PayResult((Map<String, String>) msg.obj);
				/**
				 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
				 */
				String resultInfo = payResult.getResult();// 同步返回需要验证的信息
				String resultStatus = payResult.getResultStatus();
				// 判断resultStatus 为9000则代表支付成功
				if (TextUtils.equals(resultStatus, "9000")) {
					// 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
					Toast.makeText(mActivity, "支付成功", Toast.LENGTH_SHORT).show();
				} else {
					// 该笔订单真实的支付结果，需要依赖服务端的异步通知。
					Toast.makeText(mActivity, "支付失败", Toast.LENGTH_SHORT).show();
				}
				break;
			}
			case SDK_AUTH_FLAG: {
				@SuppressWarnings("unchecked")
				AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
				String resultStatus = authResult.getResultStatus();

				// 判断resultStatus 为“9000”且result_code
				// 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
				if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
					// 获取alipay_open_id，调支付时作为参数extern_token 的value
					// 传入，则支付账户为该授权账户
					Toast.makeText(mActivity,
							"授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT)
							.show();
				} else {
					// 其他状态值则为授权失败
					Toast.makeText(mActivity,
							"授权失败" + String.format("authCode:%s", authResult.getAuthCode()), Toast.LENGTH_SHORT).show();

				}
				break;
			}
			default:
				break;
			}
		};
	};


	/** 支付宝支付业务：入参app_id */
	public static final String APPID = "2016110802641927";
	
	/** 支付宝账户登录授权业务：入参pid值 */
	public static final String PID = "2088521207232266";
	/** 支付宝账户登录授权业务：入参target_id值 */
	public static final String TARGET_ID = "2921148848@qq.com";
	
	/** 商户私钥，pkcs8格式 */
	public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKYlx61QQ8mbM1awgyGnQII5q5P05g1IXbPPe3vtOnsntUFRn28waFt0FA2KywsTVuaJiLMnS/0+qA3uj2KY5EWMgANcy71i9RpWuuq44mQid7AWxFEioHKlH00iAiqADYqrPf3+sMrQ9mFwNwPgyUB7kBdg1MUDbDmBD4eIqznnAgMBAAECgYEAhCFxfcRiVHenyV5Qure/FpF0gRL2zUNquW/c3T5ZDs4SWKLn704JAAn9VJO3S9SSfH6OByPOS9TDY2kAAMJkbh75gECMUcUEwen8wfdSzoqGslv+6UIDL+JVIFpi3D9aKNi4NXUMSVsFHUxGf/V5PKPCh/FLy6e3SALggB9m0BECQQDOpaXlwXhx7b/H9d5INKvJGXxBMoy14gIseE6SRtVQlzNup5MfSSLz3sQERIVp3GkY+tFsHeFydU/uaR9l8XDvAkEAzdQAztEVimc0Ijb/nq8YmYy+IOah+71xV9JRfYmLE7fdGr1lnaG7NblZrj0Gahv1xQzCkzDxgipa+0FAntLWiQJBALVn/WbgnJeHGuCzGltQwa1cThP+CEBzE21uf6sxu3lwApqVSTYhwilL2c/VRzlTYH+pT8cVxB/ylCS66/FWLskCQGkiB8Ob8pe+PVfYpdqk7zjHNfpSM50FV9aW2/72eW559NsKsNPCX4CCizc/fn5Gh9O9v8k1L7bf8Zby7pHxeZkCQHDk6CvbOi3+LQRQeOmvQ9jjsqNgfZR04Mk/mzEN99BtTHFJNGgjzHwI4ZCEWRxlxzXLuKRj+u1pRL1tqzL0DuQ=";
	
	private static final int SDK_PAY_FLAG = 1;
	private static final int SDK_AUTH_FLAG = 2;
	
	
	
	public static void pay(String order, String price , String title,String descript) {

		/**
		 * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
		 * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
		 * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险； 
		 * 
		 * orderInfo的获取必须来自服务端；
		 */
		Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID,order,price,title,descript);
		String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
		String sign = OrderInfoUtil2_0.getSign(params, RSA_PRIVATE);
		final String orderInfo = orderParam + "&" + sign;
		
		Log.i("支付宝完全支付订单号", orderInfo);
		
		Runnable payRunnable = new Runnable() {
			@Override
			public void run() {
				PayTask alipay = new PayTask(mActivity);
				Map<String, String> result = alipay.payV2(orderInfo, true);
				Log.i("msp", result.toString());
				
				Message msg = new Message();
				msg.what = SDK_PAY_FLAG;
				msg.obj = result;
				mHandler.sendMessage(msg);
			}
		};

		Thread payThread = new Thread(payRunnable);
		payThread.start();
	}

}
