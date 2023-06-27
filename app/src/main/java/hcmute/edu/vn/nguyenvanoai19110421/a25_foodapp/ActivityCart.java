package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;
import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model.ProductModel;

public class ActivityCart extends AppCompatActivity {

    public  static Database database;
    TextView txtTitle;
    ImageView imgInCart;
//    ListView lvCart;
//    ArrayList<ProductModel> arrayProduct;
//    ProductAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        Intent fintent = getIntent();
        int pid=fintent.getIntExtra("Id",1);
        //Toast.makeText(this, String.valueOf(pid), Toast.LENGTH_SHORT).show();

        database=MainActivity.database;

        ProductModel product=database.getProductToCart(pid);

        txtTitle=(TextView) findViewById(R.id.txt_titleTopDetail);
        imgInCart=(ImageView) findViewById(R.id.img_foodTopDetailOrder);



        txtTitle.setText(product.getTen());

        byte[] Hinh=product.getHinh();
        Bitmap bitmap= BitmapFactory.decodeByteArray(Hinh,0,Hinh.length);
        imgInCart.setImageBitmap(bitmap);
    }
}