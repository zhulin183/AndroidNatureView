package personal.buqx.andoridnatureview;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        ViewPager pager = (ViewPager) findViewById(R.id.main_viewpager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), this, mTitles));

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        tabLayout.setupWithViewPager(pager);
    }

    private void initData() {
        mTitles = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            String title = "TAB" + i;
            mTitles.add(title);
        }
    }

}
