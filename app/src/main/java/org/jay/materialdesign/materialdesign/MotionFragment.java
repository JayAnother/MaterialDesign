package org.jay.materialdesign.materialdesign;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import org.jay.materialdesign.MainActivity;
import org.jay.materialdesign.R;
import org.jay.materialdesign.materialdesign.animation.AnimationActivity1;
import org.jay.materialdesign.materialdesign.animation.AnimationActivity2;
import org.jay.materialdesign.materialdesign.animation.AnimationActivity3;
import org.jay.materialdesign.materialdesign.animation.AnimationActivity4;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MotionFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    private MainActivity mMainActivity;

    public MotionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().getWindow().setEnterTransition(new Explode().setInterpolator(new BounceInterpolator()).setDuration(3000));
        getActivity().getWindow().setExitTransition(new Fade().setDuration(3000));
        getActivity().getWindow().setReturnTransition(new Slide().setDuration(3000));
        getActivity().getWindow().setReenterTransition(new Slide().setDuration(3000));
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_motion, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        mMainActivity.setSupportActionBar(toolbar);
        mMainActivity.iniToolbar(toolbar);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(getActivity(), AnimationActivity1.class));

                break;
            case R.id.btn2:
                startActivity(new Intent(getActivity(), AnimationActivity2.class));

                break;
            case R.id.btn3:
                startActivity(new Intent(getActivity(), AnimationActivity3.class));

                break;
            case R.id.btn4:
                startActivity(new Intent(getActivity(), AnimationActivity4.class));

                break;
        }
    }
}
