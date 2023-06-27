package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class SellerActivity extends AppCompatActivity {

    Button btnAddProduct, btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        btnAddProduct=(Button) findViewById(R.id.btnAddSeller);
        btnBack=(Button) findViewById(R.id.btnBacktoHome) ;


        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SellerActivity.this, ActivityAddForSeller.class));

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SellerActivity.this, HomeFragment.class));

            }
        });

    }
}