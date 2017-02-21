package kumpul.akses_merakv2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import kumpul.akses_merakv2.firebase.FireBaseInstaller;


public class MainActivity extends AppCompatActivity {
    List<SubActivity> subActivities = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        viewPager = (ViewPager)findViewById(R.id.view_pager);
//        SwipeAdapter swipeAdapter = new SwipeAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(swipeAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        final TabLayout.Tab test1 = tabLayout.newTab().setText("Member list");
        final TabLayout.Tab test2 = tabLayout.newTab().setText("Checked in");
        final TabLayout.Tab test3 = tabLayout.newTab().setText("Checked out");

        tabLayout.addTab(test1, 0);
        tabLayout.addTab(test2, 1);
        tabLayout.addTab(test3, 2);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this,R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this,R.color.colorAccent));


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        subActivities.add(new FireBaseInstaller());

        install();
    }

    private void install(){
        for (SubActivity sub : subActivities){
            sub.create(this);
        }
    }

    public void onClickStartBtn(View v) {
        Intent intent = new Intent(this, MemberlistActivity.class);
        startActivity(intent);
        finish();
    }
}

