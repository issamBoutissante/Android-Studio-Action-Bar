package com.test.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView=findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://www.google.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_action_bar,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.newItem:
                newItem();
                return true;
            case R.id.save:
                saveItem();
                return true;
            case R.id.close:
                closeApp();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void newItem(){
        Toast.makeText(this,"you clicked new Item",Toast.LENGTH_SHORT);
    }
    private void saveItem(){
        Toast.makeText(this,"you clicked save Item",Toast.LENGTH_SHORT);
    }
    private void closeApp(){
        Toast.makeText(this,"you closed the App",Toast.LENGTH_SHORT);
        finish();
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
            return;
        }
        super.onBackPressed();
    }
}