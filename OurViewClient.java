package com.example.sakshamseth.geekview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by saksham seth on 17-04-2017.
 */

public class OurViewClient extends WebViewClient {
    public boolean shouldOverrideUrlLoading(WebView v,String url){
        v.loadUrl(url);
        return true;
    }
}
