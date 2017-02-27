package personal.buqx.andoridnatureview;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity {

    private EUTabLayout mTabLayout;
    private List<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        ViewPager pager = (ViewPager) findViewById(R.id.main_viewpager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), this, mTitles));

        mTabLayout = (EUTabLayout) findViewById(R.id.main_tablayout);
        mTabLayout.setupWithViewPager(pager, false);

        // 如果需要addTab，必须放在setupWithViewPager之后，否则无效.
        // 在源码里可以看到setupWhitViewPager时会remove所有的tab
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
//            mTabLayout.getTabAt(i).setText("test" + i);
//             setIcon添加的图标在标题上方
//            mTabLayout.getTabAt(i).setIcon(R.drawable.tab_icon);

            View tabView = LayoutInflater.from(this).inflate(R.layout.tab_item, null);
            TextView textView = (TextView) tabView.findViewById(R.id.tab_text);
            textView.setText("test" + i);
            QBadgeView badgeView = new QBadgeView(MainActivity.this);
            badgeView.bindTarget(textView);
            badgeView.setBadgeNumber(i + 10);
            badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
            mTabLayout.getTabAt(i).setCustomView(tabView);

//            Drawable icon = ContextCompat.getDrawable(this,R.drawable.tab_icon);
//            mTabLayout.setTabImage(i,icon);
        }
        mTabLayout.setIndicatorMargin(15, 15);
        mTabLayout.getTabAt(1).getCustomView();

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView().findViewById(R.id.tab_text);
                QBadgeView badgeView = new QBadgeView(MainActivity.this);
                badgeView.bindTarget(view);
                badgeView.setBadgeNumber(20);
                badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initData() {
        mTitles = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            String title = "TAB" + i;
            mTitles.add(title);
        }
    }

}
