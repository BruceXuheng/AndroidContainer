package com.study.test.testapplication.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Create by BruceXuheng on 2018/6/13
 * description :
 **/

public class DownLoadAsyncTask extends AsyncTask<Void,Integer,Boolean> {

    Context mContext;
    ProgressDialog mProgressDialog = new ProgressDialog(mContext);

    @Override
    protected void onPreExecute() {
//        显示进度对话框
        mProgressDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try{
            while(true){
//                int downloadPercent = doDownload();
//                publishProgress(downloadPercent);
//                if(downloadPercent>=100){
//                   break;
//                }
            }
        }catch (Exception e){

        }
        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mProgressDialog.setMessage(values+"%");
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        mProgressDialog.dismiss();
        if(aBoolean){
            Toast.makeText(mContext, "true", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mContext, "false", Toast.LENGTH_SHORT).show();
        }
    }
}