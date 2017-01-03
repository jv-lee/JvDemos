package com.test.searchstartactivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView mTvSearchBg, mTvSearchText;
    private FrameLayout mFlContent;
    private ImageView mIvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();

        mTvSearchBg.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mTvSearchBg.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                performEnterAnimation();
            }
        });

    }

    private void initViews() {
        mTvSearchBg = (TextView) findViewById(R.id.tv_search_bg);
        mTvSearchText = (TextView) findViewById(R.id.tv_search);
        mFlContent = (FrameLayout) findViewById(R.id.fl_bg);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performExitAnimation();
            }
        });
    }


    private void performEnterAnimation() {
        float originY = getIntent().getIntExtra("y", 0);

        int location[] = new int[2];
        mTvSearchBg.getLocationOnScreen(location);

        final float translateY = originY - (float) location[1];

        //放到前一个页面的位置
        mTvSearchBg.setY(mTvSearchBg.getY() + translateY);
        mTvSearchText.setY(mTvSearchBg.getY() + (mTvSearchBg.getHeight() - mTvSearchText.getHeight()) / 2);
        final ValueAnimator translateVa = ValueAnimator.ofFloat(mTvSearchBg.getY(), mTvSearchBg.getY() - 100);
        translateVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mTvSearchBg.setY((Float) valueAnimator.getAnimatedValue());

                mIvBack.setY(mTvSearchBg.getY() + (mTvSearchBg.getHeight() - mIvBack.getHeight()) / 2);
                mTvSearchText.setY(mTvSearchBg.getY() + (mTvSearchBg.getHeight() - mTvSearchText.getHeight()) / 2);
            }
        });

        ValueAnimator scaleVa = ValueAnimator.ofFloat(1, 0.8f);
        scaleVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mTvSearchBg.setScaleX((Float) valueAnimator.getAnimatedValue());
            }
        });

        ValueAnimator alphaVa = ValueAnimator.ofFloat(0, 1f);
        alphaVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mFlContent.setAlpha((Float) valueAnimator.getAnimatedValue());
                mTvSearchText.setAlpha((Float) valueAnimator.getAnimatedValue());
                mIvBack.setAlpha((Float) valueAnimator.getAnimatedValue());
            }
        });

        alphaVa.setDuration(500);
        translateVa.setDuration(500);
        scaleVa.setDuration(500);

        alphaVa.start();
        translateVa.start();
        scaleVa.start();

    }


    @Override
    public void onBackPressed() {
        performExitAnimation();
    }

    private void performExitAnimation() {
        float originY = getIntent().getIntExtra("y", 0);

        int location[] = new int[2];
        mTvSearchBg.getLocationOnScreen(location);

        final float translateY = originY - (float) location[1];


        final ValueAnimator translateVa = ValueAnimator.ofFloat(mTvSearchBg.getY(), mTvSearchBg.getY() + translateY);
        translateVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mTvSearchBg.setY((Float) valueAnimator.getAnimatedValue());
                mIvBack.setY(mTvSearchBg.getY() + (mTvSearchBg.getHeight() - mIvBack.getHeight()) / 2);
                mTvSearchText.setY(mTvSearchBg.getY() + (mTvSearchBg.getHeight() - mTvSearchText.getHeight()) / 2);
            }
        });
        translateVa.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                finish();
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        ValueAnimator scaleVa = ValueAnimator.ofFloat(0.8f, 1f);
        scaleVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mTvSearchBg.setScaleX((Float) valueAnimator.getAnimatedValue());
            }
        });

        ValueAnimator alphaVa = ValueAnimator.ofFloat(1, 0f);
        alphaVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mFlContent.setAlpha((Float) valueAnimator.getAnimatedValue());

                mIvBack.setAlpha((Float) valueAnimator.getAnimatedValue());
                mTvSearchText.setAlpha((Float) valueAnimator.getAnimatedValue());
            }
        });


        alphaVa.setDuration(500);
        translateVa.setDuration(500);
        scaleVa.setDuration(500);

        alphaVa.start();
        translateVa.start();
        scaleVa.start();

    }


}

