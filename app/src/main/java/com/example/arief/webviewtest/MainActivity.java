package com.example.arief.webviewtest;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private WebView view;
    private ProgressBar progressBar;
    private TextView tPersentase;
    private String url = "https://sutanlab.js.org/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.web_view);
        progressBar = findViewById(R.id.progress);
        tPersentase = findViewById(R.id.persentase);
        view.getSettings().setJavaScriptEnabled(true);
        view.setWebViewClient(new MyBrowser());
        view.loadUrl(url);
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && view.canGoBack()) {
            view.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public void onLoadResource(WebView view, String url) {
            progressBar.setProgress(view.getProgress());
            tPersentase.setText(String.format("%s%%", String.valueOf(view.getProgress())));
        }
    }
}
