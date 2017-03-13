package com.leibown.transparentactionbarutils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.leibown.library.TransparentActionBarUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View actionBar = View.inflate(this, R.layout.layout_actionbar, null);
        View contentView = TransparentActionBarUtils.getTransparentActionBar(this, R.layout.activity_main, actionBar);
        setContentView(contentView);

//        TransparentActionBarUtils.setActionBarBackgroudColor(this, Color.parseColor("#FF0055"));
        TransparentActionBarUtils.setActionBarBackgroudDrawable(this, R.drawable.bg_nav);
    }
}
