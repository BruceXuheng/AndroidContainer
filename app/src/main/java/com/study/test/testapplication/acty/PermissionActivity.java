package com.study.test.testapplication.acty;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.study.test.testapplication.R;

public class PermissionActivity extends AppCompatActivity {

    private Button callBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        init();
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PermissionActivity.this, "Call Phone", Toast.LENGTH_SHORT).show();

//              需要权限的地方 需要判断 如果没有则进行动态获取权限，有就进行事务
                if (ActivityCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions(PermissionActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }else{
                    callPhone();
                }

            }
        });

    }

    private void init() {

        callBtn = findViewById(R.id.make_call);

    }

//  事务方法
    private void callPhone(){
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10010"));
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

//  动态获取
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    callPhone();
                }else{
                    Toast.makeText(PermissionActivity.this, "you need access callphone permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
