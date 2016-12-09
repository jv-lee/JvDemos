package com.jvlee.rxbusdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxTestActivity extends AppCompatActivity {

    private final String TAG = RxTestActivity.class.getSimpleName();

    private TextView mTextView;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_test);

        mTextView = (TextView) findViewById(R.id.tv);
        mImageView = (ImageView) findViewById(R.id.img);

        init();

    }


    private void init() {

        //创建被观察者
        final Observable switcher = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("On");
                subscriber.onNext("Off");
                subscriber.onNext("On");
                subscriber.onNext("Off");
                subscriber.onCompleted();
            }
        });

//        //创建观察者
//        final Subscriber light = new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                mTextView.append("\n结束观察 执行完毕");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                mTextView.append("\n出现错误:" + e);
//            }
//
//            @Override
//            public void onNext(String s) {
//                mTextView.append("\n观察者 观察到需要执行 :" + s);
//            }
//        };
//
//        //被观察者订阅观察者进行执行任务
//        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                switcher.subscribe(light);
//            }
//        });


//        Observable.create(new Observable.OnSubscribe<String>(){
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("On");
//                subscriber.onNext("Off");
//                subscriber.onNext("On");
//                subscriber.onNext("Off");
//                subscriber.onCompleted();
//            }
//        }).subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                mTextView.append("\n结束观察 执行完毕");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                mTextView.append("\n出现错误:" + e);
//            }
//
//            @Override
//            public void onNext(String s) {
//                mTextView.append("\n观察者 观察到需要执行 :" + s);
//            }
//        });

        Observable.just("On", "Off", "On", "Off")
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s != null;
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        mTextView.append("\n结束观察 执行完毕");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTextView.append("\n出现错误:" + e);
                    }

                    @Override
                    public void onNext(String s) {
                        mTextView.append("\n观察者 观察到需要执行 :" + s);
                    }
                });

        String a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "img.png";
        Observable.just(a)
                .subscribeOn(Schedulers.newThread()) //指定了被观察者执行线程环境
                .observeOn(Schedulers.io()) //将接下来的执行环境指定为io线程 observeOn是切换线程修饰符
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        return getBitmap(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()) //将观察者执行环境设置为ui线程
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(RxTestActivity.this, "image load success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxTestActivity.this, "image load error" , Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e+"");
                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        mImageView.setImageBitmap(bitmap);
                    }
                });
    }


    public static Bitmap getBitmap(String path) {
        File file = new File(path);
        if (file == null) return null;
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            return BitmapFactory.decodeStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
