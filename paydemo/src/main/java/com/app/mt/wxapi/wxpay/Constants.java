package com.app.mt.wxapi.wxpay;

public class Constants {

  //请同时修改  androidmanifest.xml里面，.PayActivityd里的属性<data android:scheme="wxb4ba3c02aa476ea1"/>为新设置的appid
  public static  String APP_ID = "wxb7a6d480e414d945";

  //商户号
  public static final String MCH_ID = "1330802801";

  //API密钥，在商户平台设置
  public static  final String API_KEY = "30A001BF9AC747DAB0C71233457E484E";
  
  public static String WXITEMNAME = "";

  public static final String HOST = "http://www.candle-dream.online";
  public static final String PORT = "8080";
  public static final String WECHAT_NOTIFY_URL = HOST+":"+PORT+"/zhifu/weixinpay";
  
}
