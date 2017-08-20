package org.jay.materialdesign.materialdesign.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import org.jay.materialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity3 extends AppCompatActivity {

    public static final int DURATION = 6000;
    @BindView(R.id.avd)
    ImageView mAvd;
    @BindView(R.id.heart)
    CheckBox mHeart;
    @BindView(R.id.example)
    CheckBox mExample;
    @BindView(R.id.ball)
    ImageView ball;
    @BindView(R.id.p1)
    Button mP1;
    @BindView(R.id.p2)
    Button mP2;
    @BindView(R.id.p3)
    Button mP3;
    @BindView(R.id.p4)
    Button mP4;

    private Path sTraversalPath = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setDuration(DURATION));
        getWindow().setExitTransition(new Fade().setDuration(DURATION));
        getWindow().setReturnTransition(new Slide().setDuration(DURATION));
        getWindow().setReenterTransition(new Slide().setDuration(DURATION));
        getWindow().setSharedElementEnterTransition(new ChangeBounds().setInterpolator(new BounceInterpolator()).setDuration(DURATION));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation3);
        ButterKnife.bind(this);

        RectF bounds = new RectF(0, 200, 600, 800);
        sTraversalPath.addArc(bounds,180,-180);
    }

    @OnClick({R.id.avd,R.id.p1, R.id.p2, R.id.p3, R.id.p4})
    public void onViewClicked(View view) {
        Animator animatorX,animatorY,animator;
        PropertyValuesHolder x,y;
        switch (view.getId()) {
            case R.id.p1:
                animator=   ObjectAnimator.ofFloat(ball, View.X, View.Y, sTraversalPath).setDuration(6000);
                animator.setInterpolator(new PathInterpolator(0.4f,0,0.2f,1));
                animator.start();
                break;
            case R.id.p2:
                animatorX=  ObjectAnimator.ofFloat(ball, "x", 0, 600).setDuration(6000);
                animatorY= ObjectAnimator.ofFloat(ball, "y", 800, 200).setDuration(6000);
                animatorX.setInterpolator(new LinearInterpolator());
                animatorY.setInterpolator(new PathInterpolator(0.4f,0,0.2f,1));
                animatorX.start();
                animatorY.start();
                break;
            case R.id.p3:
                animatorX=  ObjectAnimator.ofFloat(ball, "x", 0, 600).setDuration(6000);
                animatorY= ObjectAnimator.ofFloat(ball, "y", 800, 200).setDuration(6000);
                animatorX.setInterpolator(new LinearInterpolator());
                animatorY.setInterpolator(new AccelerateInterpolator());
                animatorX.start();
                animatorY.start();
                break;
            case R.id.p4:
                animatorX=  ObjectAnimator.ofFloat(ball, "x", 0, 600).setDuration(6000);
                animatorY= ObjectAnimator.ofFloat(ball, "y", 800, 200).setDuration(6000);
                animatorX.setInterpolator(new LinearInterpolator());
                animatorY.setInterpolator(new BounceInterpolator());
                animatorX.start();
                animatorY.start();
                break;
            case R.id.avd:
                ( (Animatable)   ((ImageView)view).getDrawable()).start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();

    }
}
