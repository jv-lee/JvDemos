package com.app.mt.wxapi.wxpay;

import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;

import android.util.Log;
import android.util.Xml;

public class WXOther {
	
	/**
	 * 生成产品信息
	 * @return
	 */
	public static String genProductArgs()
	{
		
		StringBuffer xml = new StringBuffer();

		try 
		{
			
			xml.append("</xml>");
            List<NameValuePair> packageParams = new LinkedList<NameValuePair>();
			packageParams.add(new BasicNameValuePair("appid", Constants.APP_ID));
			//TODO 接口留出
			packageParams.add(new BasicNameValuePair("body", Constants.WXITEMNAME));
			packageParams.add(new BasicNameValuePair("mch_id", Constants.MCH_ID));
			
			packageParams.add(new BasicNameValuePair("nonce_str", genGameid(WXPayManager._gameid)));
			
			packageParams.add(new BasicNameValuePair("notify_url", Constants.WECHAT_NOTIFY_URL));
			if(WXPayManager.orderid != null)
			{
				packageParams.add(new BasicNameValuePair("out_trade_no",WXPayManager.orderid ));
			}
			else
			{
				packageParams.add(new BasicNameValuePair("out_trade_no",genOutTradNo()));
			}
			packageParams.add(new BasicNameValuePair("spbill_create_ip","127.0.0.1"));
			packageParams.add(new BasicNameValuePair("total_fee", WXPayManager.wxprice));
			packageParams.add(new BasicNameValuePair("trade_type", "APP"));


			String sign = genPackageSign(packageParams);
			packageParams.add(new BasicNameValuePair("sign", sign));
		    String xmlstring = xmlToStr(packageParams);
		    //更改编码防止中文商品名无法支付
		    return new String(xmlstring.toString().getBytes(), "ISO8859-1");

		}
		catch (Exception e) 
		{
			return null;
		}
		
	}
	public static String genGameid(String gameid)
	{
		Random random = new Random();
		String str = MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
		String result = gameid + str.substring(0, 27);
		//System.out.println("result " + result);
		return result;
	}
	
	/**
	 * 生成随机数
	 * @return
	 */
	public static String genNonceStr() 
	{
		Random random = new Random();
		return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
	}
	/**
	 * 生成随机数
	 * @return
	 */
	private static String genOutTradNo() {
		Random random = new Random();
		return MD5.getMessageDigest(String.valueOf(random.nextInt(10000)).getBytes());
		
		
//		String str = "qwertyuiopasdfghjklzxcvbnm123456";
//		System.out.println(str);
//		return str;
	}
	
	/**
	 * 生成包签名
	 * @param params
	 * @return
	 */
	private static String genPackageSign(List<NameValuePair> params) 
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < params.size(); i++) 
		{
			sb.append(params.get(i).getName());
			sb.append('=');
			sb.append(params.get(i).getValue());
			sb.append('&');
		}
		sb.append("key=");
		sb.append(Constants.API_KEY);
		String packageSign = MD5.getMessageDigest(sb.toString().getBytes()).toUpperCase();
		Log.e("orion",packageSign);
		return packageSign;
	}
	/**
	 * 转换成XML
	 * @param params
	 * @return
	 */
	private static String xmlToStr(List<NameValuePair> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		for (int i = 0; i < params.size(); i++) {
			sb.append("<"+params.get(i).getName()+">");


			sb.append(params.get(i).getValue());
			sb.append("</"+params.get(i).getName()+">");
		}
		sb.append("</xml>");

		Log.e("orion",sb.toString());
		return sb.toString();
	}
	
	
	/**
	 * 解析成map
	 * @param content
	 * @return
	 */
	public static Map<String,String> decodeXml(String content) {

		try {
			Map<String, String> xml = new HashMap<String, String>();
			XmlPullParser parser = Xml.newPullParser();
			parser.setInput(new StringReader(content));
			int event = parser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {

				String nodeName=parser.getName();
				switch (event) {
					case XmlPullParser.START_DOCUMENT:

						break;
					case XmlPullParser.START_TAG:

						if("xml".equals(nodeName)==false){
							//实例化student对象
							xml.put(nodeName,parser.nextText());
						}
						break;
					case XmlPullParser.END_TAG:
						break;
				}
				event = parser.next();
			}

			return xml;
		} catch (Exception e) {
			Log.e("orion",e.toString());
		}
		return null;

	}
	
	/**
	 * 订单日期
	 * @return
	 */
	public static long genTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}
}
