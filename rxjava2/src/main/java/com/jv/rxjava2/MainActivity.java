package com.jv.rxjava2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "jv.lee";

    public Bitmap stringtoBitmap(String string) {
        //将字符串转换成Bitmap类型
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        //创建字节数组输出流 ，用来输出读取到的内容
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //创建读取缓存,大小为1024
        byte[] buffer = new byte[1024];
        //每次读取长度
        int len = 0;
        //开始读取输入流中的文件
        while ((len = inputStream.read(buffer)) != -1) { //当等于-1说明没有数据可以读取了
            byteArrayOutputStream.write(buffer, 0, len); // 把读取的内容写入到输出流中
        }
        //把读取到的字节数组转换为字符串
        String result = byteArrayOutputStream.toString();

        //关闭输入流和输出流
        inputStream.close();
        byteArrayOutputStream.close();
        //返回字符串结果
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            ImageView image = (ImageView) findViewById(R.id.iv_image);
            image.setImageBitmap(stringtoBitmap(readStreamToString(getAssets().open("image.txt"))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        rxFunction();
    }

    public void rxSimpleFunction() {

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe:" + d.isDisposed());
                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.i(TAG, "onNext:" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete->");
                    }
                });
    }

    public void rxSimpleFunction2() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                TelephonyManager tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                e.onNext("network:" + tel.getNetworkOperatorName());
                e.onNext("sim:" + tel.getSimOperatorName());
                e.onNext("simNumber:" + tel.getLine1Number());
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                                   if (d.isDisposed()) {
                                       d.dispose();
                                   }
                               }

                               @Override
                               public void onNext(String value) {
                                   Log.d(TAG, value);
                               }

                               @Override
                               public void onError(Throwable e) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }

    public void rxFlatMapFunction() {

        final String[] registerPar = {"jv.lee@foxmail.com", "1234567"};
        Observable.create(new ObservableOnSubscribe<String[]>() {
            @Override
            public void subscribe(ObservableEmitter<String[]> e) throws Exception {
                Log.d(TAG, Thread.currentThread().getName());
                e.onNext(registerPar);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String[]>() {
                    @Override
                    public void accept(String[] strings) throws Exception {
                        Log.d(TAG, Thread.currentThread().getName());
                        if (strings[0].equals("jv.lee@foxmail.com") && strings[1].equals("123456")) {
                            Log.d(TAG, "注册成功");
                        } else {
                            Log.d(TAG, "注册失败");
                        }
                    }
                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<String[], ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(String[] strings) throws Exception {
                        if (strings[0].equals("jv.lee@foxmail.com") && strings[1].equals("123456")) {
                            return Observable.create(new ObservableOnSubscribe<Boolean>() {
                                @Override
                                public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                                    Log.d(TAG, Thread.currentThread().getName());
                                    Log.d(TAG, "onNext true");
                                    e.onNext(true);
                                    e.onComplete();
                                }
                            });
                        } else {
                            return Observable.create(new ObservableOnSubscribe<Boolean>() {
                                @Override
                                public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                                    Log.d(TAG, Thread.currentThread().getName());
                                    Log.d(TAG, "onError ");
                                    e.onError(new Throwable("登陆失败"));
                                }
                            });
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.d(TAG, Thread.currentThread().getName());
                        Log.d(TAG, "登陆成功");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, Thread.currentThread().getName());
                        Log.d(TAG, throwable.getMessage());
                    }
                });
    }

    public void rxFlowableFunction() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                Log.d(TAG, "emit 1");
                e.onNext(1);
                Log.d(TAG, "emit 2");
                e.onNext(2);
                Log.d(TAG, "emit 3");
                e.onNext(3);
                Log.d(TAG, "emit complete");
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe()");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "value:" + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, t.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete()");
            }
        });
    }

    private void rxFunction() {
        rxFlowableFunction();
    }
}
