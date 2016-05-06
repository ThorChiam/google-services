package com.google.samples.quickstart.signin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        WebView myWebView = (WebView) findViewById(R.id.form_webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        Log.e("Form","testing...");
        myWebView.loadUrl("https://docs.google.com/forms/d/1naZwsE4Bso5Hn4_1PTZr94lkBlwkJ2h2KnFJoF40ppM/viewform?c=0&w=1");
    }
}
