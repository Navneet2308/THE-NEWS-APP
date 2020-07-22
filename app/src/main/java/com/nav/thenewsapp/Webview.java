package com.nav.thenewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Webview extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
      webView=findViewById(R.id.web);
      progressBar=findViewById(R.id.progress);

        progressBar.setVisibility(View.VISIBLE);

        url = getIntent().getExtras().getString("url","");

        if (url.equals("") || url.equals(null))
        {
            Toast.makeText(this, "News not found", Toast.LENGTH_SHORT).show();
        }
        else {
            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageFinished(WebView view, String url) {

                        progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(Webview.this, "Error:" + description, Toast.LENGTH_SHORT).show();

                }
            });
            webView.loadUrl(url);
        }
    }
}
