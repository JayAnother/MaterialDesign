package org.jay.materialdesign.materialdesign;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jay.materialdesign.MainActivity;
import org.jay.materialdesign.R;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.CardContentFragment;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.ListContentFragment;
import org.jay.materialdesign.materialdesign.CoordinatorLayout.TileContentFragment;

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
        initFragment(new ListContentFragment(), "List");
        initFragment(new TileContentFragment(), "Tile");
        initFragment(new CardContentFragment(), "Card");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        mMainActivity.iniToolbar(mToolbar);
        setupViewPager(mViewpager);
        return view;
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
