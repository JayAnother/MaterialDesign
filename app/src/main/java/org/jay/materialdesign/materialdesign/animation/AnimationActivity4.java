package org.jay.materialdesign.materialdesign.animation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import org.jay.materialdesign.R;

public class AnimationActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation4);
    }

    public void btnClick(View view) {
        ImageView imageView = (ImageView) view;
//        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) fab.getDrawable();
//        animatedVectorDrawable.start();

        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    private boolean isTwitterChecked = false;
    public void twitterClick(View view) {
        ImageView imageView = (ImageView) view;
        isTwitterChecked = !isTwitterChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isTwitterChecked ? 1 : -1)};
        imageView.setImageState(stateSet, true);
    }
}
