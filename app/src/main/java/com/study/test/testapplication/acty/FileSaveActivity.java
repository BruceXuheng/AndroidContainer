package com.study.test.testapplication.acty;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.study.test.testapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Create by BruceXuheng on 2018/5/29
 * description :
 * 1、文件保存方法 save()
 * 2、SharedPreferences存储
 *      数据存储、获取SP
 *
 **/

public class FileSaveActivity extends AppCompatActivity {

    private EditText mEditText;
    private Button mButton,mReadBtn;
    private Button mSpSave,mSpRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_save);

        init();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = mEditText.getText().toString();
                save(str);
            }
        });
        mReadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = readLoad();
                Toast.makeText(FileSaveActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        mSpSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                editor.putString("name","火锅配麻酱");
                editor.apply();
            }
        });
        mSpRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String name = pref.getString("name","爱你很走心");
                Toast.makeText(FileSaveActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        mEditText = (EditText) findViewById(R.id.edt_file_save);
        mButton = (Button) findViewById(R.id.save_content_file_btn);
        mReadBtn = (Button) findViewById(R.id.read_content_file_btn);

        mSpSave = (Button) findViewById(R.id.save_sp);
        mSpRead = (Button) findViewById(R.id.read_sp);


    }


    private void save(String string) {
        FileOutputStream out = null;
        BufferedWriter writer = null;

        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(string);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String readLoad(){
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();

        try {
            in = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine()) != null){
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }

        return content.toString();
    }

}
