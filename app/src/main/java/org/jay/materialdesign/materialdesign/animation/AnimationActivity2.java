package org.jay.materialdesign.materialdesign.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import org.jay.materialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity2 extends AppCompatActivity {

    public static final int DURATION = 3000;
    @BindView(R.id.btn)
    Button mBtn;
    @BindView(R.id.p3)
    Button mP3;
    @BindView(R.id.p4)
    Button mP4;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.p1)
    Button mP1;
    @BindView(R.id.p2)
    Button mP2;
    @BindView(R.id.checkbox)
    CheckBox mCheckbox;
    @BindView(R.id.transition)
    Button mTransition;
    @BindView(R.id.sharetransition)
    Button mSharetransition;
    @BindView(R.id.id_container)
    LinearLayout mIdContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode().setInterpolator(new BounceInterpolator()).setDuration(DURATION));
        getWindow().setExitTransition(new Fade().setDuration(DURATION));
        getWindow().setReturnTransition(new Slide().setDuration(DURATION));
        getWindow().setReenterTransition(new Slide().setDuration(DURATION));
        getWindow().setSharedElementReenterTransition(new ChangeTransform().setInterpolator(new BounceInterpolator()).setDuration(DURATION));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn, R.id.p3, R.id.p4, R.id.btn2, R.id.p1, R.id.p2, R.id.transition, R.id.sharetransition})
    public void onViewClicked(View view) {
        Animator animator;
        switch (view.getId()) {
            case R.id.btn:
                break;
            case R.id.p3:
                break;
            case R.id.p4:
                break;
            case R.id.btn2:
                break;
            case R.id.p1:
                animator = ViewAnimationUtils.createCircularReveal(
                        mBtn,
                        mBtn.getWidth() / 2,
                        mBtn.getHeight() / 2,
                        0,
                        mBtn.getWidth());
                animator.setInterpolator(new LinearInterpolator());

                animator.setDuration(6000);
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        super.onAnimationStart(animation);
                        mBtn.setVisibility(View.VISIBLE);
                    }

                });
                animator.start();
                break;
            case R.id.p2:
                animator = ViewAnimationUtils.createCircularReveal(
                        mBtn,
                        mBtn.getWidth() / 2,
                        mBtn.getHeight() / 2,
                        mBtn.getWidth(), 0
                );
                animator.setInterpolator(new LinearInterpolator());

                animator.setDuration(6000);
                animator.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        mBtn.setVisibility(View.GONE);
                    }
                });


                animator.start();
                break;
            case R.id.transition:
                startActivity(new Intent(AnimationActivity2.this, AnimationActivity3.class), ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.sharetransition:
                View sharedView = findViewById(R.id.p1);
                String transitionName = "p1";

                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(AnimationActivity2.this, sharedView, transitionName);

                startActivity(new Intent(AnimationActivity2.this, AnimationActivity3.class), transitionActivityOptions.toBundle());


                //  ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                //          Pair.create(view1, "agreedName1"),
                //          Pair.create(view2, "agreedName2"));
                break;
        }
    }


    @Override
    public void onBackPressed() {
        finishAfterTransition();
        super.onBackPressed();

    }
}
