package org.jay.materialdesign.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.jay.materialdesign.R;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.BehaviorActivity;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.CoordinatorActivity21;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.CoordinatorActivity22;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ComponentFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.btn01)
    Button mBtn01;
    @BindView(R.id.btn02)
    Button mBtn02;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private MainActivity mMainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    public ComponentFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_component, container, false);
        unbinder = ButterKnife.bind(this, view);
        mMainActivity.iniToolbar(mToolbar);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn01, R.id.btn02, R.id.btn03})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn01:
                startActivity(new Intent(getActivity(), CoordinatorActivity21.class));
                break;
            case R.id.btn02:
                startActivity(new Intent(getActivity(), CoordinatorActivity22.class));
                break;
            case R.id.btn03:
                startActivity(new Intent(getActivity(), BehaviorActivity.class));
                break;
        }
    }
}
