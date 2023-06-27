package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter.ProductAdapter;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static Database database;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

//        List<HomeFoodItem> image_details = getListData();
//        final GridView gridView = findViewById(R.id.gridViewHomeItem);
//        gridView.setAdapter(new CustomGridAdapter(this, image_details));
//
//        // When the user clicks on the GridItem
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                Object o = gridView.getItemAtPosition(position);
//                HomeFoodItem homeFoodItem = (HomeFoodItem) o;
//                Toast.makeText(HomeFragment.this, "Selected :"
//                        + " " + homeFoodItem, Toast.LENGTH_LONG).show();
//            }
//        });
    }


    GridView gvProduct;
    ArrayList<ProductModel> arrayProduct;
    ProductAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        gvProduct= (GridView)  getView().findViewById(R.id.GvProductHome);
        arrayProduct=new ArrayList<>();
        adapter=new ProductAdapter(getActivity(), R.layout.product_rows, arrayProduct);
        gvProduct.setAdapter(adapter);

        gvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = gvProduct.getItemAtPosition(i);
                ProductModel ProductModel = (ProductModel) o;
//                Toast.makeText(getActivity(), "Selected :"
//                        + " " + ProductModel, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getActivity(),ActivityFoodDetail.class);
                startActivity(intent);

            }
        });




        database=new Database(getActivity() ,"25FoodApp.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS Product(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(100),MoTa VARCHAR(200),Gia VARCHAR(50), HinhAnh BLOD)");


        //get data
        Cursor cursor=database.GetData("Select * From Product");
        while (cursor.moveToNext()){
            arrayProduct.add(new ProductModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4)

            ));
        }
        adapter.notifyDataSetChanged();

        super.onActivityCreated(savedInstanceState);
    }



}