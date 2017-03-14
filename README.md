# TransparentActionBarUtils
透明状态栏的工具类

## 导入方式

首先将它添加到你的根目录build.gradle中（如果已经有了就无需重复添加了）：

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

然后在app目录下的build.gradle中添加：

```java
	dependencies {
	        compile 'com.github.leibown:TransparentActionBarUtils:1.1'
	}
```

使用方法：

```java
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //View actionBar = View.inflate(this, R.layout.layout_actionbar, null);
       //如果要使用图片作为ActionBar的背景图，就必须传入你的ActionBar
       //View contentView = TransparentActionBarUtils.getTransparentActionBar(this, R.layout.activity_main, actionBar);
      
       View contentView = 
         TransparentActionBarUtils.getTransparentActionBar(this, R.layout.activity_main);
      
        setContentView(contentView);
		//设置状态栏颜色
        TransparentActionBarUtils.setActionBarBackgroudColor(this, Color.parseColor("#FF0055"));
      	//设置状态栏背景图片
        TransparentActionBarUtils.setActionBarBackgroudDrawable(this, R.drawable.bg_nav);
    }
}
```