package com.jv.zxing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebActivity extends AppCompatActivity implements OnClickListener {

	private WebView view;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_web);
		view = (WebView) findViewById(R.id.web);
		WebSettings settings = view.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setAllowContentAccess(true);
		settings.setBuiltInZoomControls(true);
		Intent intent = getIntent();
		String url = intent.getStringExtra("url");
		view.setWebViewClient(new webViewClient());
		view.loadUrl(url);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
			view.goBack(); // goBack()��ʾ����WebView����һҳ��
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	// Web��ͼ
	private class webViewClient extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return true;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		default:
			break;
		}
	}

}
