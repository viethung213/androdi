package com.example.demowebview;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webview);
        editText=findViewById(R.id.editTextText);
        webView.setWebViewClient(new WebViewClient());
    }

    public void backButton(View view) {
        if(webView.canGoBack()){
            webView.goBack();
        }
    }

    public void forwardButton(View view) {
        if(webView.canGoForward()){
            webView.goForward();
        }
    }

    public void reloadButton(View view) {
        webView.reload();
    }

    public void goButton(View view) {
        String url=editText.getText().toString();
        webView.loadUrl(url);
    }
}