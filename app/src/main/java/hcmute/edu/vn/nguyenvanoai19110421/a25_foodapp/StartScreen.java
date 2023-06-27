package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


public class StartScreen extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        //TextView txtVersion= (TextView) findViewById(R.id.txt_version);
        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(StartScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },5000);
        try{
            PackageInfo packageInfo= getPackageManager().getPackageInfo(getPackageName(),0);
            // txtVersion.setText("version: "+packageInfo.versionName);
        }catch ( PackageManager.NameNotFoundException e){e.printStackTrace();}
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();
    }
}
