package org.jay.materialdesign;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private List<Fragment> mFragmentList;
    private MotionFragment mMotionFragment;
    private StyleFragment mStyleFragment;
    private LayoutFragment mLayoutFragment;
    private ComponentFragment mComponentFragment;
    public final static String FRAGMENT_TAG_MOTION = "MotionFragment";
    public final static String FRAGMENT_TAG_STYLE = "StyleFragment";
    public final static String FRAGMENT_TAG_LAYOUT = "LayoutFragment";
    public final static String FRAGMENT_TAG_COMPONENT = "ComponentFragment";
    private String mCurrentFragmentTag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView(toolbar);
        initDate();
    }
    public void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (mMotionFragment != null && !FRAGMENT_TAG_MOTION.equals(mCurrentFragmentTag)) {
            fragmentTransaction.hide(mMotionFragment);
        }
        if (mStyleFragment != null && !FRAGMENT_TAG_STYLE.equals(mCurrentFragmentTag)) {
            fragmentTransaction.hide(mStyleFragment);
        }
        if (mLayoutFragment != null && !FRAGMENT_TAG_LAYOUT.equals(mCurrentFragmentTag)) {
            fragmentTransaction.hide(mLayoutFragment);
        }
        if (mComponentFragment != null && !FRAGMENT_TAG_COMPONENT.equals(mCurrentFragmentTag)) {
            fragmentTransaction.hide(mComponentFragment);
        }
    }
    public void switchFragment(String fragmentTag) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
        switch (fragmentTag) {
            case FRAGMENT_TAG_MOTION:
                if (mMotionFragment == null) {
                    mMotionFragment = new MotionFragment();
                }
                fragment = mMotionFragment;
                break;
            case FRAGMENT_TAG_STYLE:
                if (mStyleFragment == null) {
                    mStyleFragment = new StyleFragment();
                }
                fragment = mStyleFragment;
                break;
            case FRAGMENT_TAG_LAYOUT:
                if (mLayoutFragment == null) {
                    mLayoutFragment = new LayoutFragment();
                }
                fragment = mLayoutFragment;
                break;
            case FRAGMENT_TAG_COMPONENT:
                if (mComponentFragment == null) {
                    mComponentFragment = new ComponentFragment();
                }
                fragment = mComponentFragment;
                break;
        }
//        //切换动画
//        if (animType == AnimationUtil.TYPE_PAGE_IN) {
//            transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
//        }
//        if (animType == AnimationUtil.TYPE_PAGE_OUT) {
//            transaction.setCustomAnimations(R.anim.return_slide_in_left, R.anim.return_slide_out_right);
//        }
        if (!fragment.isAdded()) {
            transaction.add(R.id.fl_container, fragment, fragmentTag);
        } else {
            transaction.show(fragment);
        }
        mCurrentFragmentTag = fragmentTag;
        transaction.commitAllowingStateLoss();
        hideAllFragment(transaction);
    }

    private void initDate() {
        initFragment();
    }

    private void initFragment() {

    }

    private void initView(Toolbar toolbar) {
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_motion:
                switchFragment(FRAGMENT_TAG_MOTION);
                break;
            case R.id.nav_style:
                switchFragment(FRAGMENT_TAG_STYLE);
                break;
            case R.id.nav_layout:
                switchFragment(FRAGMENT_TAG_LAYOUT);
                break;
            case R.id.nav_component:
                switchFragment(FRAGMENT_TAG_COMPONENT);
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
