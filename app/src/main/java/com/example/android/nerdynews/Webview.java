package com.example.android.nerdynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview=findViewById(R.id.webView);


        Intent intent=getIntent();
//      url i.e. stored in the on click event of any news(during setting news adapter)
        String url=intent.getStringExtra("url");
        webview.setWebViewClient(new WebViewClient());
//      loading the input url
        webview.loadUrl(url);


    }
}