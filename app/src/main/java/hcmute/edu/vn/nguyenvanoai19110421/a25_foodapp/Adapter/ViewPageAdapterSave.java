package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.AllFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.BlogFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.PhotoFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.PlaceFragment;

public class ViewPageAdapterSave extends FragmentStatePagerAdapter {


    public ViewPageAdapterSave(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AllFragment();
            case 1:
                return new PlaceFragment();
            case 2:
                return new PhotoFragment();
            case 3:
                return new BlogFragment();
            default:
                return new AllFragment();

        }

    }

    @Override
    public int getCount() {
        return 4   ;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title="All";
                break;
            case 1:
                title="Place";
                break;
            case 2:
                title="Photo"  ;
                break;
            case 3:
                title="Blog"  ;
                break;
        }
        return title;
    }


}
