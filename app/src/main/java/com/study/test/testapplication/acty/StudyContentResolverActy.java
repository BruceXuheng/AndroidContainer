package com.study.test.testapplication.acty;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.study.test.testapplication.R;
import com.study.test.testapplication.database.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class StudyContentResolverActy extends AppCompatActivity {

    ArrayAdapter<String> mAdapter;
    List<String> mContactList = new ArrayList<>();
    private ListView mlistView;
    private Button cbtn;
    private MyDatabaseHelper mdbHepler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_content_resolver_acty);
        mdbHepler= new MyDatabaseHelper(this);
        mlistView = findViewById(R.id.contacts_view);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mContactList);
        mlistView.setAdapter(mAdapter);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
        }else{
            getContent();
        }
        cbtn = findViewById(R.id.cr_btn);
        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("content://com.study.test.testapplication.provider/Book");
                SQLiteDatabase db = mdbHepler.getReadableDatabase();
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                if(cursor != null){
                    while(cursor.moveToNext()){
                        String name = cursor.getString(cursor.getColumnIndex("author"));
                        Log.e("chenxh",name);
                    }
                    cursor.close();
                }else{
                    Toast.makeText(StudyContentResolverActy.this, "cursor is null", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getContent(){
        Cursor cursor = null;
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        if(cursor != null){
            while(cursor.moveToNext()){
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                mContactList.add(displayName + "\n" +number);
                mAdapter.notifyDataSetChanged();

            }

        }
        if(cursor != null){
            cursor.close();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){
            case 1:
                if(permissions.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    getContent();
                }else{
                    Toast.makeText(StudyContentResolverActy.this, "未授权", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }

    }
}
