package com.study.test.testapplication.acty;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.study.test.testapplication.R;
import com.study.test.testapplication.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;


public class NavgationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView mBottomNavigationView;
    private FrameLayout mFrameLayout;
    private HomeFragment fragment;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    private TextView mTextMessage;
    private FrameLayout fl;
    private Fragment[] fragments;
    private int lastShowFragment = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navgation);

        fl = (FrameLayout) findViewById(R.id.main_frame_layout);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.main_navigation_view);
        navigation.setOnNavigationItemSelectedListener(this);

        initFragments();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.recents:
                if (lastShowFragment != 0) {
                    switchFrament(lastShowFragment, 0);
                    lastShowFragment = 0;
                }
                return true;
            case R.id.favourites:
                if (lastShowFragment != 1) {
                    switchFrament(lastShowFragment, 1);
                    lastShowFragment = 1;
                }
                return true;
            case R.id.nearby:
                if (lastShowFragment != 2) {
                    switchFrament(lastShowFragment, 2);
                    lastShowFragment = 2;
                }
                return true;
        }
        return false;
    }
    /**
     * 切换Fragment
     *
     * @param lastIndex 上个显示Fragment的索引
     * @param index     需要显示的Fragment的索引
     */
    public void switchFrament(int lastIndex, int index) {

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.hide(fragments[lastIndex]);

        if (!fragments[index].isAdded()) {

            transaction.add(R.id.main_frame_layout, fragments[index]);
        }

        transaction.show(fragments[index]).commitAllowingStateLoss();
    }
    private void initFragments() {

        HomeFragment one = new HomeFragment();
        HomeFragment one2 = new HomeFragment();
        HomeFragment one3 = new HomeFragment();

        fragments = new Fragment[]{one, one2, one3};
        lastShowFragment = 0;
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame_layout, one)
                .show(one)
                .commit();
    }
}
