package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Khoahoc> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.lvkhoahocid);
        listView.setAdapter(new CustomListAdapter(this,image_details));
        //Khi người dùng click vào các ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object obj = listView.getItemAtPosition(position);
                Khoahoc khoahoc = (Khoahoc) obj;
                Toast.makeText(MainActivity.this, "Selected : " + " " + khoahoc.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<Khoahoc> getListData() {
        List<Khoahoc> list = new ArrayList<Khoahoc>();
        Khoahoc android = new Khoahoc("android","Lập trình Android",6000000);
        Khoahoc WindowsPhone = new Khoahoc("windowsphone","Lập trình Windows Phone",8000000);
        Khoahoc ios =  new Khoahoc("ios","Lập trình IOS",5000000);
        Khoahoc csharp = new Khoahoc("csharp","Lập trình C#",5500000);
        Khoahoc facebook = new Khoahoc("facebook", "Quảng cáo trên Facebook",8500000);
        Khoahoc adwords = new Khoahoc("adwords", "Quảng cáo Google Adwords",9500000);
        list.add(android);
        list.add(WindowsPhone);
        list.add(ios);
        list.add(csharp);
        list.add(facebook);
        list.add(adwords);
        return list;
    }
}