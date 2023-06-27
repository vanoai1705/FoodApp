package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Adapter.ListFoodAdapter;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;

public class ActivityResList extends AppCompatActivity {

    private RecyclerView rcvProduct;
    private ListFoodAdapter listFoodAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_list);
        rcvProduct= findViewById(R.id.recycListFood);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvProduct.setLayoutManager(linearLayoutManager);

        listFoodAdapter=new ListFoodAdapter(getListFoods());
        rcvProduct.setAdapter(listFoodAdapter);

        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);

    }
    public static Database database ;
    private List<ProductModel> getListFoods(){
        List<ProductModel> list=new ArrayList<>();
        database=MainActivity.database;
        Intent i=new Intent();
        int sid=i.getIntExtra("storeId",1);
        Toast.makeText(this, String.valueOf(sid), Toast.LENGTH_SHORT).show();
        //int sid=1;
        String sql="Select * From Products where ResId="+sid+"";
        Cursor cursor=database.GetData(sql);
        while (cursor.moveToNext()){
            list.add(new ProductModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4)

            ));
        }
        return list;
    }



}