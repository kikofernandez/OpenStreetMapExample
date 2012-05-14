package se.zenithgroup.android;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
	private static final String HTML_ROOT = "file:///android_asset/www/";
	
	private Handler handler = null;
	private WebView webView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        handler = new Handler();
        
        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        loadPage("index.html");
    }
    
    public void loadPage(String in){
    	final String url = HTML_ROOT + in;
    	loadURL(url);
    }
    
    private void loadURL(final String in){
    	handler.post(new Runnable() {
            public void run() {
            	webView.loadUrl(in);
            }
        });
    }
}