package com.study.test.testapplication.banner.androidimagesliding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.study.test.testapplication.R;

/**
 * 利用MVP架构，使用AndroidImageSilder轮播第三方框架
 * <p>
 * 功能：首页面轮播
 */
public class BannerActivity extends AppCompatActivity {

    //轮播框架
    private SliderLayout sliderLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setContentView(R.layout.activity_banner);
        sliderLayout = findViewById(R.id.banner_acty_slider);

        initSliderLayout();

    }

    private void initSliderLayout() {
        new Precenter(new IHttpPrecenter() {
            @Override
            public void presnter(String[] str) {
                setBannerView(str);
            }
        }).getPrecenteData();
        sliderLayout.setFocusable(false);
        sliderLayout.setDuration(8000);
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);
    }

    //添加轮播图的View
    private void setBannerView(String[] urls) {
        for (String url : urls) {
            //定义 一个View
            TextSliderView textSliderView = new TextSliderView(BannerActivity.this);
            textSliderView.description("GAme OF")
                    .image(url)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView slider) {
                            //监听事件 处理
                        }
                    });
            //添加到轮播布局中
            sliderLayout.addSlider(textSliderView);
        }
    }


}

/**
 * MVP架构
 */
interface IHttpGet {
    void senddata(String strings);
}

interface IHttpPrecenter {
    void presnter(String[] str);
}

class HttpGetUrls {

    private IHttpGet iHttpGet;

    public HttpGetUrls(IHttpGet iHttpGet) {
        this.iHttpGet = iHttpGet;
    }

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0X0001:
                    iHttpGet.senddata((String) msg.obj);
                    break;
            }
        }
    };

    public void getNet() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0X0001;
                msg.obj = "https://www.baidu.com/img/bd_logo1.png?where=super";
                myHandler.sendMessage(msg);
            }
        }).start();
    }

}


class Precenter {
    private IHttpPrecenter iHttpPrecenter;
    private HttpGetUrls httpGetUrls;

    public Precenter(final IHttpPrecenter iHttpPrecenter) {
        httpGetUrls = new HttpGetUrls(new IHttpGet() {
            @Override
            public void senddata(String strings) {
                String[] args = {strings};
                iHttpPrecenter.presnter(args);
            }
        });
    }

    public void getPrecenteData() {
        httpGetUrls.getNet();
    }
}
