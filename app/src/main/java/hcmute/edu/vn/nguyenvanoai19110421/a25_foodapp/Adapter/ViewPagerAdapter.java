package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.AccountFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.FavouriteFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.HomeFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.NotifyFragment;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.ReceiptFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
         switch (position){
             case 0:
                 return new HomeFragment();
             case 1:
                 return new FavouriteFragment();
             case 2:
                 return new ReceiptFragment();
             case 3:
                 return new NotifyFragment();
             case 4:
                 return new AccountFragment();
             default:
                 return new HomeFragment();
         }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
