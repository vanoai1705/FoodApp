package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.NewsFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.OrderFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.SocialFragment;

public class ViewPageAdapterNotify extends FragmentStatePagerAdapter {
    public ViewPageAdapterNotify(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OrderFragment();
            case 1:
                return new SocialFragment();
            case 2:
                return new NewsFragment();

            default:
                return new OrderFragment();

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
                title="Order";
                break;
            case 1:
                title="Social";
                break;
            case 2:
                title="News"  ;
                break;

        }
        return title;
    }
}
