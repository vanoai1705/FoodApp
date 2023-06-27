package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_account, container, false);
//        NavigationView navigationView= (NavigationView) view.findViewById(R.id.action_cart);
//        navigationView.setNavigationItemSelectedListener(this);
        // Inflate the layout for this fragment
        return view;
    }
    Button btn;
    NavigationView navigationView;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn=(Button) getView().findViewById(R.id.btnLogOut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
            }
        });


        navigationView=(NavigationView) getView().findViewById(R.id.listacction1_account);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_cash:
                        Intent intent= new Intent(getActivity(),LoginActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_history:
                        Intent intent1= new Intent(getActivity(),LoginActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_bill:
                        Intent intent2= new Intent(getActivity(),LoginActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_cart:
                        Intent intent3= new Intent(getActivity(),ActivityCart.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_seller:
                        Intent intent4= new Intent(getActivity(),SellerActivity.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });
//        navigationView.(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.action_cash:
//                        Intent intent= new Intent(getActivity(),LoginActivity.class);
//                        startActivity(intent);
//                        break;
//                    case R.id.action_history:
//                        Intent intent1= new Intent(getActivity(),LoginActivity.class);
//                        startActivity(intent1);
//                        break;
//                    case R.id.action_bill:
//                        Intent intent2= new Intent(getActivity(),LoginActivity.class);
//                        startActivity(intent2);
//                        break;
//                    case R.id.action_cart:
//                        Intent intent3= new Intent(getActivity(),LoginActivity.class);
//                        startActivity(intent3);
//                        break;
//                    case R.id.action_seller:
//                        Intent intent4= new Intent(getActivity(),LoginActivity.class);
//                        startActivity(intent4);
//                        break;
//                }
//                return true;
//            }
//        });

    }






//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        // Handle navigation view item clicks here.
//        switch (item.getItemId()) {
//
//            case R.id.action_cart: {
//
//                break;
//            }
//        }
//        //close navigation drawer
////        mDrawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
}