package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;

public class ActivityFoodDetail extends AppCompatActivity {
    ListView lvTopFood;
    ArrayList<TopOrderItem> arrayTopFoodList;
    Button btnback,btnOrder;
    ImageButton btnadd,btnmin;
    EditText edtQuantity;
    TextView txtToolbar,txtTitle,txtRemainAmount,txtPrice,txtNotionalPrice;
    ImageView imgView;
    ListView lv_indetail;
    ArrayList<ProductModel> arrayProductDetail;
    ListDetailAdapter adapter;

    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        Intent fintent = getIntent();
        int pid=fintent.getIntExtra("Id",1);
        //Toast.makeText(this, String.valueOf(pid), Toast.LENGTH_SHORT).show();

        database=MainActivity.database;

        ProductModel product=database.getProduct(pid);
        txtToolbar=(TextView) findViewById(R.id.txtResNameFoodDetail);
        txtPrice=(TextView) findViewById(R.id.txtPriceDetail) ;

        txtTitle=(TextView) findViewById(R.id.txtNameFoodDetail);

        imgView=(ImageView) findViewById(R.id.imgViewFoodDetail);

        txtTitle.setText(product.getTen());
        txtPrice.setText(product.getGia());
        txtToolbar.setText(product.getTen());

        byte[] Hinh=product.getHinh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(Hinh,0,Hinh.length);
        imgView.setImageBitmap(bitmap);

        btnback=(Button) findViewById(R.id.btnBackFoodDetail);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(ActivityFoodDetail.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnOrder=(Button) findViewById(R.id.btnOrderFoodDetail);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(ActivityFoodDetail.this,ActivityCart.class);
                startActivity(intent2);

            }
        });

        lv_indetail=(ListView) findViewById(R.id.Lv_foodindetail);
        arrayProductDetail=new ArrayList<>();
        adapter=new ListDetailAdapter(this, R.layout.product_rows_for_store, arrayProductDetail);
        lv_indetail.setAdapter(adapter);

        Cursor cursor=database.GetData("Select * From Product Where Id=1");
        while (cursor.moveToNext()){
            arrayProductDetail.add(new ProductModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getBlob(4)

            ));
        }
        adapter.notifyDataSetChanged();



    }
}