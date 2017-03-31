package com.xz.tbswebviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lys.studyrecord.R;
import com.tencent.smtt.sdk.TbsVideo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTBS;
    private Button tbs_test_btn_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnTBS = (Button) findViewById(R.id.tbs_test_btn);
        tbs_test_btn_video = (Button) findViewById(R.id.tbs_test_btn_video);
        btnTBS.setOnClickListener(this);
        tbs_test_btn_video.setOnClickListener(this);
//
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tbs_test_btn:
                //跳转到集成tbsweb页面
                startActivity(new Intent(this, TbsActivity.class));
                break;
            case R.id.tbs_test_btn_video:
                //播放视频， 需要视频格式
                TbsVideo.openVideo(this, Environment.getExternalStorageDirectory() + "**********.mp4");
                break;

        }
    }
}
