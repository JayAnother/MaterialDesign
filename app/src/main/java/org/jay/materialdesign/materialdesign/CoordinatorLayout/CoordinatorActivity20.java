package org.jay.materialdesign.materialdesign.CoordinatorLayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.jay.materialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoordinatorActivity20 extends AppCompatActivity {

    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.tab1)
    RadioButton mTab1;
    @BindView(R.id.tab2)
    RadioButton mTab2;
    @BindView(R.id.tab3)
    RadioButton mTab3;
    @BindView(R.id.tab4)
    RadioButton mTab4;
    @BindView(R.id.tab5)
    RadioButton mTab5;
    @BindView(R.id.tabs)
    RadioGroup mTabs;
    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.sort)
    LinearLayout mSort;
    @BindView(R.id.sort_sale)
    TextView mSortSale;
    @BindView(R.id.showTypeImg)
    ImageView mShowTypeImg;
    @BindView(R.id.sortLin)
    LinearLayout mSortLin;
    @BindView(R.id.up_img)
    ImageView mUpImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator20);
        ButterKnife.bind(this);
        mToolBar.setNavigationIcon(R.mipmap.taobao_back);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
