package org.jay.materialdesign.materialdesign.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jay.materialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity1 extends AppCompatActivity {

    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.txt00)
    TextView mTxt00;
    @BindView(R.id.txt01)
    TextView mTxt01;
    @BindView(R.id.txt02)
    TextView mTxt02;
    @BindView(R.id.txt03)
    TextView mTxt03;
    @BindView(R.id.txt10)
    TextView mTxt10;
    @BindView(R.id.txt11)
    TextView mTxt11;
    @BindView(R.id.txt12)
    TextView mTxt12;
    @BindView(R.id.txt13)
    TextView mTxt13;
    @BindView(R.id.ll0)
    LinearLayout mLl0;
    @BindView(R.id.p3)
    Button mP3;
    @BindView(R.id.p4)
    Button mP4;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.textView2)
    TextView mTextView2;
    @BindView(R.id.ball)
    ImageView mBall;
    @BindView(R.id.p1)
    Button mP1;
    @BindView(R.id.p2)
    Button mP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Fade());
        getWindow().setReturnTransition(new Slide());
        getWindow().setReenterTransition(new Slide());
        setContentView(R.layout.activity_animation1);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.txt00, R.id.btn, R.id.p4, R.id.p3, R.id.btn2, R.id.p1, R.id.p2})
    public void onViewClicked(View view) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        switch (view.getId()) {
            case R.id.txt00:
                break;
            case R.id.btn:
                break;
            case R.id.p4:
                ObjectAnimator.ofFloat(mTxt00, "scaleX", 0, 1).setDuration(500).start();
                ObjectAnimator.ofFloat(mTxt00, "scaleY", 0, 1).setDuration(500).start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt01, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt01, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(250);
                objectAnimator2.setStartDelay(250);
                objectAnimator.start();
                objectAnimator2.start();


                objectAnimator = ObjectAnimator.ofFloat(mTxt10, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt10, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(250);
                objectAnimator2.setStartDelay(250);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt02, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt02, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(500);
                objectAnimator2.setStartDelay(500);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt11, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt11, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(500);
                objectAnimator2.setStartDelay(500);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt12, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt12, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(750);
                objectAnimator2.setStartDelay(750);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt03, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt03, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(750);
                objectAnimator2.setStartDelay(750);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt13, "scaleX", 0, 1).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt13, "scaleY", 0, 1).setDuration(500);
                objectAnimator.setStartDelay(1000);
                objectAnimator2.setStartDelay(1000);
                objectAnimator.start();
                objectAnimator2.start();
                break;
            case R.id.p3:
                ObjectAnimator.ofFloat(mTxt00, "scaleX", 1, 0).setDuration(500).start();
                ObjectAnimator.ofFloat(mTxt00, "scaleY", 1, 0).setDuration(500).start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt01, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt01, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(250);
                objectAnimator2.setStartDelay(250);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt10, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt10, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(250);
                objectAnimator2.setStartDelay(250);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt02, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt02, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(500);
                objectAnimator2.setStartDelay(500);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt11, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt11, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(500);
                objectAnimator2.setStartDelay(500);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt12, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt12, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(750);
                objectAnimator2.setStartDelay(750);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt03, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt03, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(750);
                objectAnimator2.setStartDelay(750);
                objectAnimator.start();
                objectAnimator2.start();

                objectAnimator = ObjectAnimator.ofFloat(mTxt13, "scaleX", 1, 0).setDuration(500);
                objectAnimator2 = ObjectAnimator.ofFloat(mTxt13, "scaleY", 1, 0).setDuration(500);
                objectAnimator.setStartDelay(1000);
                objectAnimator2.setStartDelay(1000);
                objectAnimator.start();
                objectAnimator2.start();
                break;
            case R.id.btn2:
                mTextView2.setPivotX(0);
                mTextView2.setPivotY(mTextView2.getHeight());
                objectAnimator = ObjectAnimator.ofFloat(mTextView2, "scaleX", 0, 1).setDuration(2000);
                objectAnimator2 = ObjectAnimator.ofFloat(mTextView2, "scaleY", 0, 1).setDuration(2000);
                objectAnimator.start();
                objectAnimator2.start();

                Animator animator = ViewAnimationUtils.createCircularReveal(
                        mTextView2,
                        0,
                        mTextView2.getHeight(),
                        0,
                        mTextView2.getWidth());
                animator.setInterpolator(new LinearInterpolator());
//                animator.setStartDelay(4000);
                animator.setDuration(2000);
                animator.start();
                break;
            case R.id.p1:
                float yf = mBall.getY();
                objectAnimator = ObjectAnimator.ofFloat(mBall, "y", 150F).setDuration(2000);
                objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimator2 = ObjectAnimator.ofFloat(mBall, "y", 150F, yf).setDuration(2000);
                objectAnimator2.setStartDelay(2500);
                objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());
                objectAnimator.start();
                objectAnimator2.start();
                break;
            case R.id.p2:
                float yf2 = mBall.getY();
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mBall, "y", yf2 + 200, 150F).setDuration(2000);
                objectAnimator3.setInterpolator(new DecelerateInterpolator());
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(mBall, "y", 150F, yf2 + 200).setDuration(2000);
                objectAnimator4.setStartDelay(2500);
                objectAnimator4.setInterpolator(new AccelerateInterpolator());
                objectAnimator3.start();
                objectAnimator4.start();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
