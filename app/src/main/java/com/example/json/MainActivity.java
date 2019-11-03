package com.example.json;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv,lv2;
    ArrayList<String> al,al2;
    ArrayAdapter aa,aa2;
    Button parse;
    String s="{\n" +
            "  \"student\": [\n" +
            "    {\n" +
            "      \"name\": \"kisore\",\n" +
            "      \"age\": 20\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"kisore\",\n" +
            "      \"age\": 20\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"kisore\",\n" +
            "      \"age\": 20\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        al=new ArrayList<>();
        aa=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al);
        try
        {
            JSONObject jb=new JSONObject(s);
            JSONArray ja=jb.getJSONArray("student");
            for(int i=0;i<ja.length();i++)
            {
                JSONObject jbb=ja.getJSONObject(i);
                String name=jbb.getString("name");
                int age=jbb.getInt("age");
                String s1=name +" "+age;
                al.add(s1);
                lv.setAdapter(aa);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
