package com.study.test.testapplication.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.study.test.testapplication.R;
import com.study.test.testapplication.db.DaoSession;
import com.study.test.testapplication.greendao.bean.User;

import java.util.List;

public class GreenDaoMainActivity extends AppCompatActivity {

    private DaoSession daoSession;
    private TextView tv;
    private String age="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_main);
        tv = findViewById(R.id.green_dao_acty_tv);

    }


    public void insertUserMessage() {
        User user = new User(null, "name", "sex", "10", "email","123","10");
        daoSession.insert(user);
    }

    public void search() {
        List<User> mlist = daoSession.loadAll(User.class);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mlist.size(); i++) {
            sb.append(mlist.get(i).toString() + "\n");
        }
        tv.setText(sb.toString());
    }


    public void dbOnClick(View view) {
        switch (view.getId()) {
            case R.id.green_insert_btn:
                SQLiteUtils.getInstance().addUser(new User(null, "name", "sex", age, "email","des","10"));
                age = String.valueOf(Integer.valueOf(age)+1);
                break;
            case R.id.green_query_btn:
//                List<User> list = SQLiteUtils.getInstance().selectWhereAge("10");
                List<User> list = SQLiteUtils.getInstance().selectAllContacts();
                StringBuffer sb = new StringBuffer();

                for (User user : list) {
                    sb.append(user.toString()+"\n");
                }
                tv.setText("");
                tv.setText(sb.toString());
                break;
            case R.id.green_update_btn:
                SQLiteUtils.getInstance().updateWhereAgeUser("33",new User(null, "name1221", "sex", "22", "email","des","10"));
                break;
            case R.id.green_delete_btn:
                SQLiteUtils.getInstance().deletewhereAge("12");
                break;
        }
    }
}
