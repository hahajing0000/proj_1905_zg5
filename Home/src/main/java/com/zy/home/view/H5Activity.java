package com.zy.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.zy.home.R;

public class H5Activity extends AppCompatActivity {
    private WebView wvH5Test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);

        wvH5Test = (WebView) findViewById(R.id.wv_h5_test);

        initWebViewAndLoadUrl(wvH5Test);
    }

    private void initWebViewAndLoadUrl(WebView wvH5Test) {
        wvH5Test.loadUrl("file:android_asset/test.html");

        WebSettings settings = wvH5Test.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
//        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccess(true);

        wvH5Test.addJavascriptInterface(this,"MyAndroid");

//        wvH5Test.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//
//                return super.shouldOverrideUrlLoading(view, request);
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//
//                view.loadUrl("javascript:androidCallJavascript('我是Java内容')");
//
//                super.onPageFinished(view, url);
//            }
//
//            @Override
//            public void onLoadResource(WebView view, String url) {
//                super.onLoadResource(view, url);
//            }
//        });

        wvH5Test.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Toast.makeText(H5Activity.this, message, Toast.LENGTH_SHORT).show();
                result.cancel();
                return true;//super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });


    }

    @JavascriptInterface
    public void method1(){
        Toast.makeText(this, "JS Call Android", Toast.LENGTH_SHORT).show();
    }

    @JavascriptInterface
    public int plus(String a,String b){
        return Integer.parseInt(a)+Integer.parseInt(b);
    }
}