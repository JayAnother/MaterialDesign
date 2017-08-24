package org.jay.materialdesign.home;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jay.materialdesign.R;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.CoordinatorFragment13;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.CoordinatorFragment11;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.CoordinatorFragment12;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class LayoutFragment extends Fragment {


    Unbinder unbinder;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    private MainActivity mMainActivity;
    private List<String> mFragmentTitleList = new ArrayList<>();
    private List<Fragment> mFragmentList = new ArrayList<>();
    private int mCurrentIndex;

    public LayoutFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivity = (MainActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment(new CoordinatorFragment11(), "List");
        initFragment(new CoordinatorFragment12(), "Tile");
        initFragment(new CoordinatorFragment13(), "Card");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        mMainActivity.iniToolbar(mToolbar);
        setupViewPager(mViewpager);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrentIndex==0){
                    ((CoordinatorFragment11)mFragmentList.get(mCurrentIndex)).goUp();
                }else if(mCurrentIndex==1){
                    ((CoordinatorFragment12)mFragmentList.get(mCurrentIndex)).goUp();
                }else if(mCurrentIndex==2){
                    ((CoordinatorFragment13)mFragmentList.get(mCurrentIndex)).goUp();
                }
                hideFAB();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
        return view;
    }

    private void hideFAB() {
        mFab.postDelayed(new Runnable() {
            @Override
            public void run() {
                ViewCompat.animate(mFab)
                        .scaleX(0.0f)
                        .scaleY(0.0f)
                        .alpha(0.0f)
                        .setDuration(800)
                        .setInterpolator(new LinearOutSlowInInterpolator())
                        .setListener(new ViewPropertyAnimatorListener() {
                            @Override
                            public void onAnimationStart(View view) {

                            }

                            @Override
                            public void onAnimationEnd(View view) {
                                mFab.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onAnimationCancel(View view) {

                            }
                        })
                        .start();
            }
        }, 500);
    }

    public void initFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(mFragmentList.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentIndex = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTabs.setupWithViewPager(mViewpager);
    }


     class Adapter extends FragmentPagerAdapter {

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }
}
