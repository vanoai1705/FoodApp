package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter.ViewPagerAdapter;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private BottomNavigationView mBottomNavigationView;

    public static Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager= findViewById(R.id.mainViewPager);
        mBottomNavigationView=findViewById(R.id.bottomBar);

        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.action_favorite).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.action_receipt).setChecked(true);
                        break;
                    case 3:
                        mBottomNavigationView.getMenu().findItem(R.id.action_notification).setChecked(true);
                        break;
                    case 4:
                        mBottomNavigationView.getMenu().findItem(R.id.action_account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.action_favorite:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.action_receipt:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.action_notification:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.action_account:
                        mViewPager.setCurrentItem(4);
                        break;
                }

                return true;
            }
        });
//        database=new Database(this ,"25_FoodApp.sqlite",null,1);
//        database.QueryData("CREATE TABLE IF NOT EXISTS Product(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(100),MoTa VARCHAR(200),Gia VARCHAR(50), HinhAnh BLOD)");
        database=new Database(this ,"25FoodApp.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Product(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(100),MoTa VARCHAR(200),Gia VARCHAR(50), HinhAnh BLOD)");

       // database.QueryData("CREATE TABLE IF NOT EXISTS User(Id INTEGER PRIMARY KEY AUTOINCREMENT, Uname VARCHAR(100),pass VARCHAR(100),Email VARCHAR(50)");


//        database.QueryData("INSERT INTO User VALUES(null, 'admin', '123456', 'abc@gmail.com') ");
//        database.QueryData("INSERT INTO User VALUES(null, 'vanoai', '123456', 'xzy@gmail.com') ");
//        database.QueryData("INSERT INTO User VALUES(null, 'oai', '123456', 'mno@gmail.com') ");


    }







}