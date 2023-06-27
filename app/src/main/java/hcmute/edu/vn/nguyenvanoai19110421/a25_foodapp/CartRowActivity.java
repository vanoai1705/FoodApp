package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;

public class CartRowActivity extends AppCompatActivity {

    TextView txtTitle;
    ImageView imgInCart;
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_row);

//        Intent fintent = getIntent();
//        int pid=fintent.getIntExtra("Id",1);
//        //Toast.makeText(this, String.valueOf(pid), Toast.LENGTH_SHORT).show();
//
//        database=MainActivity.database;
//
//        ProductModel product=database.getProductToCarrt(pid);
//
//        txtTitle=(TextView) findViewById(R.id.txt_titleTopDetail);
//        imgInCart=(ImageView) findViewById(R.id.img_foodTopDetailOrder);
//
//
//
//        txtTitle.setText(product.getTen());
//
//        byte[] Hinh=product.getHinh();
//        Bitmap bitmap= BitmapFactory.decodeByteArray(Hinh,0,Hinh.length);
//        imgInCart.setImageBitmap(bitmap);
    }
}