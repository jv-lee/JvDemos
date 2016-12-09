package xaccp.ljw.jvdemo.fragment;

import android.view.View;

import java.util.Random;

import xaccp.ljw.jvdemo.R;
import xaccp.ljw.jvdemo.view.ScoreTrend;


public class ScoreCureViewFragment extends BaseFragment {

    private ScoreTrend mScoreTrend;
    private int[] score = {500,600,700,650,800,1000};

    public ScoreCureViewFragment(int res) {
        super(res);
    }

    @Override
    protected void initView(View view) {


        mScoreTrend = (ScoreTrend) view.findViewById(R.id.scoreThread);

//        int max = 700;
//        int min = 650;

//        Random random = new Random();
//        for(int i = 0;i<6;i++) {
//            score[i] = random.nextInt(max)  % (max -min +1) +min;
//        }

        mScoreTrend.setMaxScore(1000);
        mScoreTrend.setMinScore(500);
        mScoreTrend.setScore(score);
    }


}
