package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;

public class ActivityAddForSeller extends AppCompatActivity {

    Button btnConfirm, btnCancel;
    EditText edtName, edtDes, edtPrice;
    ImageButton btnCamera, btnUpload;
    ImageView imageView;
    int REQUEST_CODE_CAMERA = 123;
    int REQUEST_CODE_UPLOAD = 456;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_for_seller);
        AnhXa();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //data image-->byte
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] imageView = byteArray.toByteArray();

                MainActivity.database.INSERT_PRODUCT(
                        edtName.getText().toString().trim(),
                        edtDes.getText().toString().trim(),
                        edtPrice.getText().toString().trim(),
                        imageView

                );
                Toast.makeText(ActivityAddForSeller.this, "Added", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ActivityAddForSeller.this, HomeFragment.class));

            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_CODE_CAMERA);

            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_UPLOAD);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==REQUEST_CODE_CAMERA && resultCode==RESULT_OK && data!=null){
            Bitmap bitmap= (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
        }


        if(requestCode==REQUEST_CODE_UPLOAD && resultCode==RESULT_OK && data!=null){
            Uri uri=data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }

            super.onActivityResult(requestCode, resultCode, data);
    }

    private void AnhXa() {
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        edtName = (EditText) findViewById(R.id.edtNameforSel);
        edtDes = (EditText) findViewById(R.id.edtDesforSel);
        edtPrice = (EditText) findViewById(R.id.edtPriceforSel);
        imageView = (ImageView) findViewById(R.id.imageView);
        btnCamera = (ImageButton) findViewById(R.id.imageBtnCamera);
        btnUpload = (ImageButton) findViewById(R.id.imageBtnUpload);

    }
}
