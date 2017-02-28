package com.example.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.listview.entity.News;
import com.example.listview.util.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private ArrayList<News> mData = null;
    private CustomAdapter<News> customAdapter = null;
    private ListView newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        init();
    }

    private void init() {
        //创建数据集
        mData = new ArrayList<News>();
        mData.add(new News(R.drawable.news_pic_1, "韩专家：应基于国家利益慎重决定部署‘萨德’", "环球网", "2880"));
        mData.add(new News(R.drawable.news_pic_2, "日本高官参拜靖国神社 声称‘是去汇报工作’", "中国新闻网", "4000"));
        mData.add(new News(R.drawable.news_pic_3, "接近国土部人士：住房土地到期续费是肯定的", "21世纪经济报道", "1万"));
        mData.add(new News(R.drawable.news_pic_4, "武汉郑州入选国家中心城市 合肥长沙缘何落选", "21世纪经济报道", "8632"));
        mData.add(new News(R.drawable.news_pic_5, "台国办：‘台独’‘以武拒统’注定会失败", "中国台湾网", "1.5万"));
        mData.add(new News(R.drawable.news_pic_6, "以色列回应安理会决议：暂停与12国外交工作关系", "环球网", "1235"));

        //初始化Adapter,绑定数据
        customAdapter = new CustomAdapter<News>(mData, R.layout.list_news) {
            @Override
            public void bindView(ViewHolder holder, News obj) {
                holder.setImageResource(R.id.newsImg, obj.getNewsImgId());
                holder.setText(R.id.newsTitle, obj.getNewsTitle());
                holder.setText(R.id.newsFrom, obj.getNewsFrom());
                holder.setText(R.id.commentCount, obj.getNewsCommCount());
            }
        };

        //设置Adepter
        newsList = (ListView) findViewById(R.id.newslist);
        newsList.setAdapter(customAdapter);
    }
}
