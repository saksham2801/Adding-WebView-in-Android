package com.example.sakshamseth.geekview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.sakshamseth.geekview.R.layout.webview;

/**
 * Created by saksham seth on 17-04-2017.
 */

public class WebViewActivity extends Activity{
    WebView webView;
    TextView tv;
    ProgressBar pg;
    public  String urlInterview="http://www.google.com/";
    public String urlFavs="http://www.geeksforgeeks.org/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(webview);
        webView=(WebView)findViewById(R.id.webview1);
        tv=(TextView)findViewById(R.id.web_tv);
        pg=(ProgressBar)findViewById(R.id.web_progressBar);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadsImagesAutomatically(true) ;
        webView.setWebChromeClient(new WebChromeClient(){
            public void onProgressChanged(WebView w,int progress){
                tv.setText("Loading...    GeeksForGeeks");
                pg.setProgress(progress);
                setProgress(progress*100);
                if(progress==100){
                    tv.setText(R.string.app_name);
                }
            }
        });
        webView.setWebViewClient(new OurViewClient());
        FlagSettingForWebView f=new FlagSettingForWebView();
        if(f.flag==0){
            Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show();
        }
        else if(f.flag==1){
        webView.loadUrl(urlFavs);
        f.flag=0;
        }
        else if(f.flag==2){
        webView.loadUrl(urlInterview);
        f.flag=0;
        }
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    public void backToApp(View view){
        finish();
    }
}
