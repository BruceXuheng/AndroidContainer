package com.study.test.testapplication.acty;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.study.test.testapplication.R;
import com.study.test.testapplication.database.control.OnceDBControl;

public class StudySqliteDBActy extends AppCompatActivity {

    private Button createBtn,insertBtn,updateBtn,tiaozhuan;

    private OnceDBControl mOnceDBControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_sqlite_dbacty);
        init();
        initControl();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(1);

    }

    private void initControl() {

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnceDBControl = new OnceDBControl(StudySqliteDBActy.this);
            }
        });

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnceDBControl.insertMethod();
            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnceDBControl.lookMethod();
            }
        });
        tiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudySqliteDBActy.this,StudyContentResolverActy.class);
                startActivity(intent);
            }
        });

    }

    private void init(){

        createBtn = (Button) findViewById(R.id.create_db_btn);
        insertBtn = (Button) findViewById(R.id.insert_db_btn);
        updateBtn = (Button) findViewById(R.id.update_db_btn);
        tiaozhuan = findViewById(R.id.tiaozhuan_db_btn);
    }


}
