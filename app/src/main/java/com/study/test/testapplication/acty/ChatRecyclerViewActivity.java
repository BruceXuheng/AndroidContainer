package com.study.test.testapplication.acty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.study.test.testapplication.R;
import com.study.test.testapplication.adapter.MsgChatAdapter;
import com.study.test.testapplication.entry.Msg;

import java.util.ArrayList;
import java.util.List;

public class ChatRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EditText mEditText;
    private Button mSendButton;

    private MsgChatAdapter mMsgChatAdapter;

    private List<Msg> mMsgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_recycler_view);

        initView();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mMsgChatAdapter = new MsgChatAdapter(mMsgList);
        mRecyclerView.setAdapter(mMsgChatAdapter);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String context = mEditText.getText().toString();
                if(!context.equals("")){
                    Msg msg = new Msg(context,Msg.TYPE_SENT);
                    mMsgList.add(msg);
                    mMsgChatAdapter.notifyItemInserted(mMsgList.size()-1);
                    mRecyclerView.scrollToPosition(mMsgList.size()-1);
                    mEditText.setText("");
                }
            }
        });


    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.input_text);
        mSendButton = (Button) findViewById(R.id.send);
        mRecyclerView = (RecyclerView) findViewById(R.id.chat_acty_recycler_view);
        mMsgList.add(new Msg("hello",Msg.TYPE_RECEIVED));
        mMsgList.add(new Msg("hello",Msg.TYPE_SENT));

    }


}
