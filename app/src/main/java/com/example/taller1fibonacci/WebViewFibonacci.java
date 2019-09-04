package com.example.taller1fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewFibonacci extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_fibonacci);

        myWebView = (WebView)findViewById(R.id.webViewWikipedia);
        myWebView.loadUrl("https://en.wikipedia.org/wiki/Fibonacci");
    }
}
