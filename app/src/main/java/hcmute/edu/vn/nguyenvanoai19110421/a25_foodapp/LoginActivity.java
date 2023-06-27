package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Database.Database;

public class LoginActivity extends AppCompatActivity {

    Button btnLog;
    EditText edtUsername, edtPass;
    public static Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        btnLog= (Button) findViewById(R.id.btnLoginConfirm);
        edtUsername=(EditText) findViewById(R.id.edtTextUserName);
        edtPass=(EditText) findViewById(R.id.edtTextPassword);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=edtUsername.getText().toString();
                String pass=edtPass.getText().toString();
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Enter your Username and Password", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass=database.checkUsernamePassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                    } else{
                        Toast.makeText(LoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

//        database=new Database(this ,"25_FoodApp.sqlite",null,2);
//        database.QueryData("CREATE TABLE IF NOT EXISTS Product(Id INTEGER PRIMARY KEY AUTOINCREMENT, Ten VARCHAR(100),MoTa VARCHAR(200),Gia VARCHAR(50), HinhAnh BLOD)");
//
//        database.QueryData("CREATE TABLE IF NOT EXISTS User(Idu INTEGER PRIMARY KEY AUTOINCREMENT, Username VARCHAR(100),Password VARCHAR(50),Email VARCHAR(50)");


//        database.QueryData("INSERT INTO User VALUES(null, 'admin', '123456', 'abc@gmail.com') ");
//        database.QueryData("INSERT INTO User VALUES(null, 'vanoai', '123456', 'xzy@gmail.com') ");
//        database.QueryData("INSERT INTO User VALUES(null, 'oai', '123456', 'mno@gmail.com') ");


    }

}