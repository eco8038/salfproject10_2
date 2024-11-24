package com.example.project10_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent(); //시스템으로 인텐트를 얻음
        int [] voteResult = intent.getIntArrayExtra("VoteCount");   // 도착한 인텐트에서 득표수 배열값을 꺼냄
        String [] imageName = intent.getStringArrayExtra("ImageName");  // 그림제목 배열을 인텐트에서 꺼냄

        Integer imgFileId[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        TextView tvTop = (TextView)findViewById(R.id.tvTop);
        ImageView ivTop = (ImageView) findViewById(R.id.ivTop);
        int top = 0;
        for(int i=0; i<voteResult.length; i++) {
            if(voteResult[top] < voteResult[i])
                top = 1;
        }
        tvTop.setText(imageName[top]);
        ivTop.setImageResource(imgFileId[top]);

        TextView tv[] = new TextView[9]; // 텍스트뷰 멤버변수 지정
        RatingBar rbar[] = new RatingBar[9]; //레이팅바 멤버변수 지정

        Integer tvID[] = {R.id.tv1,R.id.tv2,R.id.tv3,R.id.tv4,R.id.tv5,
                R.id.tv6,R.id.tv7,R.id.tv8,R.id.tv9};
        Integer rbarID[] = {R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4, R.id.rbar5,
                R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9};

        for(int i=0; i< imageName.length; i++) {  // textView, RatingBar 인스턴스 정의
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for(int i=0; i< imageName.length; i++) {
            tv[i].setText(imageName[i]);    // 그림 제목을 텍스트뷰에 표시
            rbar[i].setRating(voteResult[i]);   // 각 그림별 득표수를 레이팅바에 표시
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);   //돌아가기 버튼
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
