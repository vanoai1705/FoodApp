package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.DraftFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.HistoryFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.OnGoingFragment;

public class ViewPagerAdapterHistory extends FragmentStatePagerAdapter {

    public ViewPagerAdapterHistory(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OnGoingFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new DraftFragment();

            default:
                return new HistoryFragment();

        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {


        String title="";
        switch (position){
            case 0:
                title="OnGoing";
                break;
            case 1:
                title="History";
                break;
            case 2:
                title="Draft"  ;
                break;

        }
        return title;
    }
}
