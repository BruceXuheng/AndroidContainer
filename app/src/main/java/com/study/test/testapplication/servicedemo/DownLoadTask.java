package com.study.test.testapplication.servicedemo;

import android.net.sip.SipAudioCall;
import android.os.AsyncTask;
import android.os.Environment;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.ContentHandler;


/**
 * Create by BruceXuheng on 2018/6/14
 * description :
 **/

// 继承的三个泛型  1、String 入参是一个String；2、Integer进度显示单位；3、反馈执行结果；
public class DownLoadTask extends AsyncTask<String,Integer,Integer> {

    public static final int TYPE_SUCESS = 0;
    public static final int TYPE_FAILD = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;

    private DownLoadListener mListener;

    private boolean isCanceled = false;

    private boolean isPaused = false;

    private int lastprogress;

    public DownLoadTask(DownLoadListener listener){
        this.mListener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;

        try {

            long downLoadedLength = 0;
            String downloadurl = params[0];
            String fileName = downloadurl.substring(downloadurl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory+fileName);
            if(file.exists()){
                downLoadedLength = file.length();
            }
            long contentlength = getContentLength(downloadurl);

//            判断文件大小
            if(contentlength == 0){
                return TYPE_FAILD;
            }else if(contentlength == downLoadedLength){
                return TYPE_SUCESS;
            }
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE","bytes="+downLoadedLength+"-")
                    .url(downloadurl).build();
            Response response = client.newCall(request).execute();
            if(response != null){
                is = response.body().byteStream();
                savedFile = new RandomAccessFile(file,"rw");
                savedFile.seek(downLoadedLength);
                byte[] b = new byte[1024];
                int total =0 ;
                int len;
                while((len=is.read(b))!=-1){
                    if(isCanceled){
                        return TYPE_CANCELED;
                    }else if (isPaused){
                        return TYPE_PAUSED;
                    }else{
                        total += len;
                        savedFile.write(b,0,len);
                        int progress = (int) ((total+downLoadedLength)*100/contentlength);
                        publishProgress(progress);
                    }
                }
                return TYPE_SUCESS;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(is !=null){
                 is.close();
                }
                if(savedFile != null){
                    savedFile.close();
                }
                if(isCanceled && file!= null){
                    file.delete();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return TYPE_FAILD;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if(progress>lastprogress){
            mListener.onProgress(progress);
            lastprogress = progress;
        }
    }

    private long getContentLength(String downloadurl) throws IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(downloadurl)
                .build();
        Response response = client.newCall(request).execute();
        if(response != null && response.isSuccessful()){
            long contentLength = response.body().contentLength();
            return  contentLength;
        }
        return 0;

    }

    @Override
    protected void onPostExecute(Integer status) {
        switch (status){
            case TYPE_SUCESS:
                mListener.onSucess();
                break;
            case TYPE_FAILD:
                mListener.onFailed();
                break;
            case TYPE_CANCELED:
                mListener.onCanceled();
                break;
            case TYPE_PAUSED:
                mListener.onPaused();
                break;
            default:
                break;
        }
    }

    public void pauseDownload(){
        isPaused = true;
    }
    public void cancleDownload(){
        isCanceled = true;
    }

}