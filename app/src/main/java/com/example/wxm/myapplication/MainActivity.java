package com.example.wxm.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //声明两个数组，用于往map中添加键值
    int[] imageld = new int[] {R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img03a,R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,
            R.drawable.img03a};
    String[] title = new String[]{"保密设置","安全","系统设置","上网","我的文档",
            "GPS","我的音乐","E-mail","保密设置","安全","系统设置","上网","我的文档",
            "GPS","我的音乐","E-mail"};
    //创建了一个由Map组成的list数组
    List<Map<String ,Object>> listItems   = new ArrayList<Map<String ,Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listview1);
        //简单适配器，用于指定listView能有个更适合的格式
        /*
        * SimpleAdapter(content,data,resourse,from,to)
        * content 表示上下文，一般用this即可
        * data 表示数据源，是由<List<Map<String,Object>> data>,由Map所组成的list数据源，每一个Map都会对应
        * 列表中的一行，每一个Map的键值必须是包含在from中指定的键
        * resourse 列表中的布局ID
        * from Map中的键名
        * to 绑定视图中的ID，与from形成对应关系*/
        SimpleAdapter adapter = new SimpleAdapter(this,listItems, R.layout.activity_list_with_picture,
                new String[]{"title","image"},
                new int[]{R.id.title,R.id.image});
        //将适配器添加到视图中
        listView.setAdapter(adapter);

        for(int i = 0;i < imageld.length;i++)
        {
            Map<String ,Object> map = new HashMap<String, Object>();
            map.put("image",imageld[i]);
            map.put("title",title[i]);
            listItems.add(map);
        }
        //对列表视图中的每一项进行监听
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = listView.getItemAtPosition(i) +"";
                Toast.makeText(MainActivity.this,"i="+i+"text="+text,Toast.LENGTH_SHORT).show();
            }
        });
    }

}
