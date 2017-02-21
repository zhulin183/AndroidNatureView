package personal.buqx.andoridnatureview;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Function:
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private List<String> mTitles;

    public ViewPagerAdapter(FragmentManager fm, Context mContext, List<String> mTitles) {
        super(fm);
        this.mContext = mContext;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return TabFragment.createTabFragment(mTitles.get(position));
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
