package com.leibown.library;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/3/13.
 */

public class TransparentActionBarUtils {

    public static View getTransparentActionBar(Activity activity, int resId) {
        return getTransparentActionBar(activity, resId, null);
    }

    public static View getTransparentActionBar(Activity activity, int resId, View actionBar) {
        LayoutInflater inflater = activity.getLayoutInflater();
        LinearLayout containerView = (LinearLayout) inflater.inflate(R.layout.activity_base, null);


        View contentView = inflater.inflate(resId, null);
        LinearLayout.LayoutParams childParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        contentView.setLayoutParams(childParams);
        containerView.addView(contentView);

        LinearLayout mLlTittleBar = (LinearLayout) containerView.findViewById(R.id.ll_tittle_bar);

        //用来填充Android版本在4.4以上的状态栏
        View statusBar = containerView.findViewById(R.id.status_bar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View decorView = activity.getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            } else {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            //如果Android版本大于4.4，说明状态栏就可以被透明，我们自己的布局就可以放到状态栏之下
            //我们把自定义的ActionBar的高度增高
            int actionBarHeight;
            if (actionBar != null)
                actionBarHeight = DisplayUtil.getBarHeight(activity) + DisplayUtil.dip2px(activity, 58);
            else {
                actionBarHeight = DisplayUtil.getBarHeight(activity);
            }
            ViewGroup.LayoutParams params = mLlTittleBar.getLayoutParams();
            params.height = actionBarHeight;
            mLlTittleBar.requestLayout();
            //把用于填充状态栏的View高度设置成跟状态栏一样的高度
            ViewGroup.LayoutParams params2 = statusBar.getLayoutParams();
            params2.height = DisplayUtil.getBarHeight(activity);
            statusBar.requestLayout();
        }
        if (actionBar != null)
            mLlTittleBar.addView(actionBar);
        mLlTittleBar.setVisibility(View.VISIBLE);
        return containerView;
    }

    public static void setActionBarBackgroudColor(Activity activity, int color) {
        View actionBar = activity.findViewById(R.id.ll_tittle_bar);
        if (actionBar != null)
            actionBar.setBackgroundColor(color);
    }


    public static void setActionBarBackgroudDrawable(Activity activity, int drawableId) {
        View actionBar = activity.findViewById(R.id.ll_tittle_bar);
        if (actionBar != null)
            actionBar.setBackgroundResource(drawableId);
    }

    public static void hideTransparentActionBar(Activity activity) {
        View actionBar = activity.findViewById(R.id.ll_tittle_bar);
        if (actionBar != null)
            actionBar.setVisibility(View.GONE);
    }

    public static void showTransparentActionBar(Activity activity) {
        View actionBar = activity.findViewById(R.id.ll_tittle_bar);
        if (actionBar != null)
            actionBar.setVisibility(View.VISIBLE);
    }
}
